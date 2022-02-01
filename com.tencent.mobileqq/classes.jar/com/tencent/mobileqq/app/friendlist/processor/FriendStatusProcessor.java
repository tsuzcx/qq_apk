package com.tencent.mobileqq.app.friendlist.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;

@KeepClassConstructor
public class FriendStatusProcessor
  extends BaseFriendProcessor
{
  public FriendStatusProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13578, 18);
    if (!paramSnsUpdateItem.bytes_value.has()) {
      paramString.a(null);
    } else {
      paramString.a(paramSnsUpdateItem.bytes_value.get().toByteArray());
    }
    FriendsStatusUtil.a(paramQQAppInterface, paramString, paramExtensionInfo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, boolean paramBoolean, Map<String, Boolean> paramMap)
  {
    boolean bool = TextUtils.isEmpty(paramSnsUpdateItem.bytes_value.get().toStringUtf8()) ^ true;
    if (!paramBoolean)
    {
      paramSnsUpdateItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13581, 21);
      if (bool) {
        paramString = new byte[1];
      } else {
        paramString = null;
      }
      paramSnsUpdateItem.a(paramString);
      FriendsStatusUtil.a(paramQQAppInterface, paramSnsUpdateItem, paramExtensionInfo);
      return;
    }
    if (paramString != null) {
      paramMap.put(paramString, Boolean.valueOf(bool));
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    String str = new String(paramSnsUpdateItem.bytes_value.get().toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.DontDisturbFriendProces", 2, new Object[] { "updateDontDisturb, friend.uin=", paramString, " setTime=", str });
    }
    paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13579, 19);
    paramString.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
    FriendsStatusUtil.a(paramQQAppInterface, paramString, paramExtensionInfo);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13580, 21);
    if (paramSnsUpdateItem.bytes_value.has())
    {
      localUpdateFriendStatusItem.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
      FriendsStatusUtil.a(paramQQAppInterface, localUpdateFriendStatusItem, paramExtensionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.DontDisturbFriendProces", 2, new Object[] { "updateRingId: invoked. UPDATE_SNS_TYPE_RING_ID uin:", paramString });
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toByteArray();
    FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13582, 21);
    localUpdateFriendStatusItem.b(paramSnsUpdateItem);
    FriendsStatusUtil.a(paramQQAppInterface, localUpdateFriendStatusItem, paramExtensionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.DontDisturbFriendProces", 2, new Object[] { "updateNotificationSetting: invoked. inc update notification switch::preview & vibrate", " uinStr: ", paramString });
    }
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.DontDisturbFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (Pair)paramList.next();
      ExtensionInfo localExtensionInfo = (ExtensionInfo)((Pair)localObject1).first;
      Object localObject2 = parseSnsUpdateBuffer(((FriendInfo)((Pair)localObject1).second).vecRing);
      if ((localObject2 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.has()))
      {
        localObject1 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject2).uint64_uin.get());
        localObject2 = ((Oidb_0x5d0.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject2).next();
          int i = localSnsUpdateItem.uint32_update_sns_type.get();
          if (i == 13580) {
            c(paramExtRspData, (String)localObject1, localExtensionInfo, localSnsUpdateItem);
          } else if (i == 13582) {
            d(paramExtRspData, (String)localObject1, localExtensionInfo, localSnsUpdateItem);
          } else if (i == 13578) {
            a(paramExtRspData, (String)localObject1, localExtensionInfo, localSnsUpdateItem);
          } else if (i == 13579) {
            b(paramExtRspData, (String)localObject1, localExtensionInfo, localSnsUpdateItem);
          } else if (i == 13581) {
            a(paramExtRspData, (String)localObject1, localExtensionInfo, localSnsUpdateItem, true, localHashMap);
          }
        }
      }
    }
    if (localHashMap.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "friendlist size", Integer.valueOf(localHashMap.size()) });
      }
      FriendsStatusUtil.a(localHashMap, paramExtRspData);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("tag_hidden_chat", 2, "friendlist size 0");
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.DontDisturbFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    Object localObject = parseSnsUpdateBuffer(paramFriendInfo.vecRing);
    if ((localObject != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject).rpt_msg_sns_update_item.has()))
    {
      paramFriendInfo = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject).uint64_uin.get());
      localObject = ((Oidb_0x5d0.SnsUpateBuffer)localObject).rpt_msg_sns_update_item.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject).next();
        int i = localSnsUpdateItem.uint32_update_sns_type.get();
        if (i == 13580) {
          c(paramExtRspData, paramFriendInfo, paramExtensionInfo, localSnsUpdateItem);
        } else if (i == 13582) {
          d(paramExtRspData, paramFriendInfo, paramExtensionInfo, localSnsUpdateItem);
        } else if (i == 13578) {
          a(paramExtRspData, paramFriendInfo, paramExtensionInfo, localSnsUpdateItem);
        } else if (i == 13579) {
          b(paramExtRspData, paramFriendInfo, paramExtensionInfo, localSnsUpdateItem);
        } else if (i == 13581) {
          a(paramExtRspData, paramFriendInfo, paramExtensionInfo, localSnsUpdateItem, false, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.FriendStatusProcessor
 * JD-Core Version:    0.7.0.1
 */