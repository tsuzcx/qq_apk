package com.tencent.mobileqq.app.friendlist.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
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
import java.util.List<Landroid.util.Pair<Lcom.tencent.mobileqq.data.ExtensionInfo;Lfriendlist.FriendInfo;>;>;
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
    if (paramInt != 13572) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSpecialCareZoneSwitch| itemVal: ");
      localStringBuilder.append(paramString);
      QLog.d("IMCore.friend.SpecialCareFriendProces", 2, localStringBuilder.toString());
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramSpecialCareInfo.qzoneSwitch = 0;
        return;
      }
      paramSpecialCareInfo.qzoneSwitch = 1;
      return;
    }
    catch (Exception paramSpecialCareInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareZoneSwitch initSpecialCareInfo|exception = ", paramSpecialCareInfo);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SpecialCareInfo paramSpecialCareInfo, String paramString1, String paramString2, Set<String> paramSet, List<String> paramList1, List<String> paramList2)
  {
    if (paramInt != 13573) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSpecialCareGlobalSwitch| uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", type: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramString2);
      QLog.d("IMCore.friend.SpecialCareFriendProces", 2, localStringBuilder.toString());
    }
    try
    {
      if (TextUtils.isEmpty(paramString2))
      {
        paramSpecialCareInfo.globalSwitch = 0;
        if ((paramSet != null) && (paramSet.contains(paramString1))) {
          paramList1.add(paramString1);
        }
        if ((paramList2 != null) && (QvipSpecialCareUtil.b(paramString1, paramQQAppInterface))) {
          paramList2.add(paramString1);
        }
      }
      else
      {
        paramSpecialCareInfo.globalSwitch = 1;
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareGlobalSwitch initSpecialCareInfo|exception = ", paramQQAppInterface);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SpecialCareInfo paramSpecialCareInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString1, String paramString2)
  {
    if (paramInt != 13568) {
      return;
    }
    paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toStringUtf8();
    QvipSpecialCareUtil.a(paramString2, paramSnsUpdateItem, paramQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("updateSpecialCareSoundSingle| soundStr: ");
      paramQQAppInterface.append(paramSnsUpdateItem);
      QLog.d("IMCore.friend.SpecialCareFriendProces", 2, paramQQAppInterface.toString());
    }
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        paramSpecialCareInfo.specialRingSwitch = 0;
      }
      else if (Pattern.compile("[0-9]*").matcher(paramString1).matches())
      {
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString1);
        paramSpecialCareInfo.specialRingSwitch = 1;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundSingle initSpecialCareInfo|exception = ", paramQQAppInterface);
      }
      paramSpecialCareInfo.specialRingSwitch = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.SpecialCareFriendProces", 2, new Object[] { "updateSpecialCareSoundSingle: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " specialCareInfo: ", paramSpecialCareInfo });
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString1, String paramString2, Set<String> paramSet, List<String> paramList1, List<String> paramList2, Map<String, Integer> paramMap, List<String> paramList3, SpecialCareInfo paramSpecialCareInfo)
  {
    if (paramInt != 13568) {
      return;
    }
    paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toStringUtf8();
    if ((paramSnsUpdateItem != null) && (paramSnsUpdateItem.length() != 0))
    {
      try
      {
        paramInt = Integer.parseInt(paramSnsUpdateItem);
        paramList1.add(paramString1);
        paramMap.put(paramString1, Integer.valueOf(paramInt));
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label179;
        }
      }
      paramSnsUpdateItem = new StringBuilder();
      paramSnsUpdateItem.append("updateSpecialCareSoundBatch dealWithRespSound|exception = ");
      paramSnsUpdateItem.append(paramQQAppInterface.toString());
      QLog.i("IMCore.friend.SpecialCareFriendProces", 2, paramSnsUpdateItem.toString());
    }
    else
    {
      if ((paramSet != null) && (paramSet.contains(paramString1))) {
        paramList2.add(paramString1);
      }
      if (QvipSpecialCareUtil.b(paramString1, paramQQAppInterface)) {
        paramList3.add(paramString1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.SpecialCareFriendProces", 2, new Object[] { "updateSpecialCareSoundBatch: invoked. should turn off sound", " uinStr: ", paramString1 });
      }
    }
    try
    {
      label179:
      if (TextUtils.isEmpty(paramString2))
      {
        paramSpecialCareInfo.specialRingSwitch = 0;
      }
      else if (Pattern.compile("[0-9]*").matcher(paramString2).matches())
      {
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString2);
        paramSpecialCareInfo.specialRingSwitch = 1;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch initSpecialCareInfo|exception = ", paramQQAppInterface);
      }
      paramSpecialCareInfo.specialRingSwitch = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.SpecialCareFriendProces", 2, new Object[] { "updateSpecialCareSoundBatch: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " info: ", paramSpecialCareInfo, " info.friendRingId: ", Integer.valueOf(paramSpecialCareInfo.friendRingId), " info.uin: ", paramSpecialCareInfo.uin });
    }
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    paramExtRspData = this;
    if (!(paramExtRspData.mApp instanceof QQAppInterface))
    {
      QLog.d("IMCore.friend.SpecialCareFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramExtRspData.mApp;
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject1 = new ArrayList();
    paramExtRspData = QvipSpecialCareUtil.a(localQQAppInterface);
    Iterator localIterator = paramList.iterator();
    paramList = (List<Pair<ExtensionInfo, FriendInfo>>)localObject5;
    Object localObject7;
    for (;;)
    {
      localObject7 = this;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject5 = (Pair)localIterator.next();
      Object localObject6 = (ExtensionInfo)((Pair)localObject5).first;
      Object localObject8 = (FriendInfo)((Pair)localObject5).second;
      localObject5 = String.valueOf(((FriendInfo)localObject8).friendUin);
      localObject6 = localObject5;
      localObject8 = ((SpecialCareProcessor)localObject7).parseSnsUpdateBuffer(((FriendInfo)localObject8).vecRing);
      Object localObject9;
      Object localObject10;
      Object localObject11;
      if ((localObject8 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject8).rpt_msg_sns_update_item.has()))
      {
        localObject7 = new SpecialCareInfo();
        ((SpecialCareInfo)localObject7).uin = ((String)localObject6);
        ((SpecialCareInfo)localObject7).dateTime = paramLong;
        localObject8 = ((Oidb_0x5d0.SnsUpateBuffer)localObject8).rpt_msg_sns_update_item.get().iterator();
        localObject5 = localObject3;
        localObject3 = paramList;
        paramList = (List<Pair<ExtensionInfo, FriendInfo>>)localObject7;
        while (((Iterator)localObject8).hasNext())
        {
          localObject7 = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject8).next();
          if ((localObject7 != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject7).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject7).bytes_value.has()))
          {
            int i = ((Oidb_0x5d0.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
            localObject9 = ((Oidb_0x5d0.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8();
            if (i == 13568) {
              a(localQQAppInterface, i, (Oidb_0x5d0.SnsUpdateItem)localObject7, (String)localObject6, (String)localObject9, paramExtRspData, (List)localObject4, (List)localObject3, (Map)localObject2, (List)localObject1, paramList);
            }
            for (;;)
            {
              break;
              localObject7 = paramList;
              if (i == 13573)
              {
                a(localQQAppInterface, i, (SpecialCareInfo)localObject7, (String)localObject6, (String)localObject9, null, null, null);
              }
              else if (i == 13572)
              {
                paramList = (List<Pair<ExtensionInfo, FriendInfo>>)localObject7;
                a(i, paramList, (String)localObject9);
              }
            }
          }
        }
        localObject6 = paramExtRspData;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject5;
        localObject10 = localObject4;
        localObject11 = localObject3;
        localObject5 = localObject9;
        localObject4 = localObject6;
        localObject3 = localObject7;
        localObject2 = localObject11;
        localObject1 = localObject8;
        paramExtRspData = localObject10;
        if (paramList.globalSwitch != 0)
        {
          ((List)localObject9).add(paramList);
          localObject5 = localObject9;
          localObject4 = localObject6;
          localObject3 = localObject7;
          localObject2 = localObject11;
          localObject1 = localObject8;
          paramExtRspData = localObject10;
        }
      }
      else
      {
        localObject7 = paramExtRspData;
        localObject8 = localObject1;
        localObject9 = localObject2;
        localObject10 = localObject3;
        localObject11 = localObject4;
        if ((localObject7 != null) && (((Set)localObject7).contains(localObject6))) {
          paramList.add(localObject6);
        }
        localObject6 = localObject5;
        localObject5 = localObject10;
        localObject4 = localObject7;
        localObject3 = localObject8;
        localObject2 = paramList;
        localObject1 = localObject9;
        paramExtRspData = localObject11;
        if (QvipSpecialCareUtil.b((String)localObject6, localQQAppInterface))
        {
          ((List)localObject8).add(localObject6);
          paramExtRspData = localObject11;
          localObject1 = localObject9;
          localObject2 = paramList;
          localObject3 = localObject8;
          localObject4 = localObject7;
          localObject5 = localObject10;
        }
      }
      localObject6 = localObject4;
      paramList = (List<Pair<ExtensionInfo, FriendInfo>>)localObject2;
      localObject2 = localObject1;
      localObject4 = paramExtRspData;
      paramExtRspData = (ExtRspData)localObject6;
      localObject1 = localObject3;
      localObject3 = localObject5;
    }
    ((FriendsManager)((SpecialCareProcessor)localObject7).mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a((List)localObject3, paramLong, paramBoolean);
    QvipSpecialCareUtil.a((List)localObject4, localQQAppInterface);
    QvipSpecialCareUtil.b(paramList, localQQAppInterface);
    QvipSpecialCareUtil.a((Map)localObject2, localQQAppInterface);
    QvipSpecialCareUtil.c((List)localObject1, localQQAppInterface);
  }
  
  public void onGetFriendListFinish(boolean paramBoolean, ArrayList<String> paramArrayList, ExtRspData paramExtRspData)
  {
    paramArrayList = (QQAppInterface)this.mApp;
    ((FriendListHandler)paramArrayList.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).deleteStrangerInfo((FriendsManager)paramArrayList.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.SpecialCareFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramExtensionInfo = (QQAppInterface)this.mApp;
    paramExtRspData = String.valueOf(paramFriendInfo.friendUin);
    Object localObject = parseSnsUpdateBuffer(paramFriendInfo.vecRing);
    if ((localObject != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject).rpt_msg_sns_update_item.has()))
    {
      paramFriendInfo = new SpecialCareInfo();
      paramFriendInfo.uin = paramExtRspData;
      paramFriendInfo.dateTime = 0L;
      localObject = ((Oidb_0x5d0.SnsUpateBuffer)localObject).rpt_msg_sns_update_item.get().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject).next();
      if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
      {
        int i = localSnsUpdateItem.uint32_update_sns_type.get();
        String str = localSnsUpdateItem.bytes_value.get().toStringUtf8();
        if (i == 13568)
        {
          a(paramExtensionInfo, i, paramFriendInfo, localSnsUpdateItem, str, paramExtRspData);
        }
        else if (i == 13573)
        {
          a(paramExtensionInfo, i, paramFriendInfo, paramExtRspData, str, null, null, null);
        }
        else if (i == 13572)
        {
          a(i, paramFriendInfo, str);
          continue;
          if (QvipSpecialCareUtil.a(paramExtRspData, paramExtensionInfo)) {
            QvipSpecialCareUtil.b(paramExtRspData, paramExtensionInfo);
          }
          if (QvipSpecialCareUtil.b(paramExtRspData, paramExtensionInfo)) {
            QvipSpecialCareUtil.c(paramExtRspData, paramExtensionInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.SpecialCareProcessor
 * JD-Core Version:    0.7.0.1
 */