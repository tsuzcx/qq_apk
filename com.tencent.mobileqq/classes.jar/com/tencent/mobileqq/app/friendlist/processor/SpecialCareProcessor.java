package com.tencent.mobileqq.app.friendlist.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;

@KeepClassConstructor
public class SpecialCareProcessor
  extends BaseFriendProcessor
{
  public SpecialCareProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private static void a(int paramInt, SpecialCareInfo paramSpecialCareInfo, String paramString)
  {
    if (paramInt != 13572) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareZoneSwitch| itemVal: " + paramString);
      }
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        paramSpecialCareInfo.qzoneSwitch = 0;
        return;
      }
      catch (Exception paramSpecialCareInfo) {}
    } while (!QLog.isColorLevel());
    QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareZoneSwitch initSpecialCareInfo|exception = ", paramSpecialCareInfo);
    return;
    paramSpecialCareInfo.qzoneSwitch = 1;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SpecialCareInfo paramSpecialCareInfo, String paramString1, String paramString2, Set<String> paramSet, List<String> paramList1, List<String> paramList2)
  {
    if (paramInt != 13573) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareGlobalSwitch| uin: " + paramString1 + ", type: " + paramInt + ", value: " + paramString2);
        }
        try
        {
          if (!TextUtils.isEmpty(paramString2)) {
            break label136;
          }
          paramSpecialCareInfo.globalSwitch = 0;
          if ((paramSet != null) && (paramSet.contains(paramString1))) {
            paramList1.add(paramString1);
          }
          if ((paramList2 != null) && (QvipSpecialCareManager.b(paramString1, paramQQAppInterface)))
          {
            paramList2.add(paramString1);
            return;
          }
        }
        catch (Exception paramQQAppInterface) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareGlobalSwitch initSpecialCareInfo|exception = ", paramQQAppInterface);
    return;
    label136:
    paramSpecialCareInfo.globalSwitch = 1;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SpecialCareInfo paramSpecialCareInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString1, String paramString2)
  {
    if (paramInt != 13568) {}
    for (;;)
    {
      return;
      paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toStringUtf8();
      QvipSpecialCareManager.a(paramString2, paramSnsUpdateItem, paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundSingle| soundStr: " + paramSnsUpdateItem);
      }
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("IMCore.friend.SpecialCareFriendProces", 2, new Object[] { "updateSpecialCareSoundSingle: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " specialCareInfo: ", paramSpecialCareInfo });
          return;
          if (Pattern.compile("[0-9]*").matcher(paramString1).matches())
          {
            paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString1);
            paramSpecialCareInfo.specialRingSwitch = 1;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundSingle initSpecialCareInfo|exception = ", paramQQAppInterface);
          }
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString1, String paramString2, Set<String> paramSet, List<String> paramList1, List<String> paramList2, Map<String, Integer> paramMap, List<String> paramList3, SpecialCareInfo paramSpecialCareInfo)
  {
    if (paramInt != 13568) {}
    for (;;)
    {
      return;
      paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toStringUtf8();
      if ((paramSnsUpdateItem == null) || (paramSnsUpdateItem.length() == 0))
      {
        if ((paramSet != null) && (paramSet.contains(paramString1))) {
          paramList2.add(paramString1);
        }
        if (QvipSpecialCareManager.b(paramString1, paramQQAppInterface)) {
          paramList3.add(paramString1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.friend.SpecialCareFriendProces", 2, new Object[] { "updateSpecialCareSoundBatch: invoked. should turn off sound", " uinStr: ", paramString1 });
        }
      }
      try
      {
        label102:
        if (TextUtils.isEmpty(paramString2)) {
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
        while (QLog.isColorLevel())
        {
          for (;;)
          {
            QLog.d("IMCore.friend.SpecialCareFriendProces", 2, new Object[] { "updateSpecialCareSoundBatch: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " info: ", paramSpecialCareInfo, " info.friendRingId: ", Integer.valueOf(paramSpecialCareInfo.friendRingId), " info.uin: ", paramSpecialCareInfo.uin });
            return;
            try
            {
              paramInt = Integer.parseInt(paramSnsUpdateItem);
              paramList1.add(paramString1);
              paramMap.put(paramString1, Integer.valueOf(paramInt));
            }
            catch (Exception paramQQAppInterface) {}
          }
          if (!QLog.isColorLevel()) {
            break label102;
          }
          QLog.i("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch dealWithRespSound|exception = " + paramQQAppInterface.toString());
          break label102;
          if (Pattern.compile("[0-9]*").matcher(paramString2).matches())
          {
            paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString2);
            paramSpecialCareInfo.specialRingSwitch = 1;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch initSpecialCareInfo|exception = ", paramQQAppInterface);
          }
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
      }
    }
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.d("IMCore.friend.SpecialCareFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList4 = new ArrayList();
    Set localSet = QvipSpecialCareManager.a(paramExtRspData);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (Pair)paramList.next();
      Object localObject2 = (ExtensionInfo)((Pair)localObject1).first;
      localObject2 = (FriendInfo)((Pair)localObject1).second;
      localObject1 = String.valueOf(((FriendInfo)localObject2).friendUin);
      Object localObject3 = parseSnsUpdateBuffer(((FriendInfo)localObject2).vecRing);
      if ((localObject3 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.has()))
      {
        localObject2 = new SpecialCareInfo();
        ((SpecialCareInfo)localObject2).uin = ((String)localObject1);
        ((SpecialCareInfo)localObject2).dateTime = paramLong;
        localObject3 = ((Oidb_0x5d0.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject3).next();
          if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
          {
            int i = localSnsUpdateItem.uint32_update_sns_type.get();
            String str = localSnsUpdateItem.bytes_value.get().toStringUtf8();
            if (i == 13568) {
              a(paramExtRspData, i, localSnsUpdateItem, (String)localObject1, str, localSet, localArrayList1, localArrayList3, localHashMap, localArrayList4, (SpecialCareInfo)localObject2);
            } else if (i == 13573) {
              a(paramExtRspData, i, (SpecialCareInfo)localObject2, (String)localObject1, str, null, null, null);
            } else if (i == 13572) {
              a(i, (SpecialCareInfo)localObject2, str);
            }
          }
        }
        if (((SpecialCareInfo)localObject2).globalSwitch != 0) {
          localArrayList2.add(localObject2);
        }
      }
      else
      {
        if ((localSet != null) && (localSet.contains(localObject1))) {
          localArrayList3.add(localObject1);
        }
        if (QvipSpecialCareManager.b((String)localObject1, paramExtRspData)) {
          localArrayList4.add(localObject1);
        }
      }
    }
    ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localArrayList2, paramLong, paramBoolean);
    QvipSpecialCareManager.a(localArrayList1, paramExtRspData);
    QvipSpecialCareManager.b(localArrayList3, paramExtRspData);
    QvipSpecialCareManager.a(localHashMap, paramExtRspData);
    QvipSpecialCareManager.c(localArrayList4, paramExtRspData);
  }
  
  public void onGetFriendListFinish(boolean paramBoolean, ArrayList<String> paramArrayList, ExtRspData paramExtRspData)
  {
    paramArrayList = (QQAppInterface)this.mApp;
    ((FriendListHandler)paramArrayList.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).deleteStrangerInfo((FriendsManager)paramArrayList.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.SpecialCareFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
    }
    do
    {
      for (;;)
      {
        return;
        paramExtensionInfo = (QQAppInterface)this.mApp;
        paramExtRspData = String.valueOf(paramFriendInfo.friendUin);
        Object localObject = parseSnsUpdateBuffer(paramFriendInfo.vecRing);
        if ((localObject == null) || (!((Oidb_0x5d0.SnsUpateBuffer)localObject).rpt_msg_sns_update_item.has())) {
          break;
        }
        paramFriendInfo = new SpecialCareInfo();
        paramFriendInfo.uin = paramExtRspData;
        paramFriendInfo.dateTime = 0L;
        localObject = ((Oidb_0x5d0.SnsUpateBuffer)localObject).rpt_msg_sns_update_item.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject).next();
          if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
          {
            int i = localSnsUpdateItem.uint32_update_sns_type.get();
            String str = localSnsUpdateItem.bytes_value.get().toStringUtf8();
            if (i == 13568) {
              a(paramExtensionInfo, i, paramFriendInfo, localSnsUpdateItem, str, paramExtRspData);
            } else if (i == 13573) {
              a(paramExtensionInfo, i, paramFriendInfo, paramExtRspData, str, null, null, null);
            } else if (i == 13572) {
              a(i, paramFriendInfo, str);
            }
          }
        }
      }
      if (QvipSpecialCareManager.a(paramExtRspData, paramExtensionInfo)) {
        QvipSpecialCareManager.b(paramExtRspData, paramExtensionInfo);
      }
    } while (!QvipSpecialCareManager.b(paramExtRspData, paramExtensionInfo));
    QvipSpecialCareManager.c(paramExtRspData, paramExtensionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.SpecialCareProcessor
 * JD-Core Version:    0.7.0.1
 */