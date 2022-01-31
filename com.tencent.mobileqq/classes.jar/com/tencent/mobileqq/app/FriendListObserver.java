package com.tencent.mobileqq.app;

import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendListObserver
  implements BusinessObserver
{
  public static final String ADD_DIRECT = "addDirect";
  public static final int ERROR_INVITE_BAD_USERS = 9;
  public static final int ERROR_INVITE_FRIENDS_FORBIDDEN = 7;
  public static final int ERROR_INVITE_FRIENDS_FREQUENT = 1;
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void onAddBatchQIMFriend(boolean paramBoolean, List paramList) {}
  
  public void onAddBatchTroopFrd(boolean paramBoolean, String paramString, ArrayList paramArrayList) {}
  
  public void onAddFriend(String paramString) {}
  
  public void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  public void onAddReqStatesChanged(boolean paramBoolean, String paramString) {}
  
  public void onCancelMayKnowRecommend(boolean paramBoolean, String paramString) {}
  
  public void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2) {}
  
  public void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelMultiDeResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  public void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  public void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onGetFriendNickBatch(boolean paramBoolean, Object paramObject) {}
  
  public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetHeadInfo(boolean paramBoolean, Setting paramSetting) {}
  
  public void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  public void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  public void onGetMayKnowRecommend(boolean paramBoolean) {}
  
  protected void onGetMultiDevResult(boolean paramBoolean, List paramList1, List paramList2) {}
  
  protected void onGetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp) {}
  
  public void onGetPushRecommend(boolean paramBoolean) {}
  
  public void onGetRecommendDeviceList(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void onGetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetSigZanInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetSpecialCareRecommend(boolean paramBoolean, Object paramObject) {}
  
  public void onGetStoreFace(boolean paramBoolean, String paramString) {}
  
  public void onGetStrangerInfo(boolean paramBoolean, Object paramObject) {}
  
  public void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGroupDataInited() {}
  
  public void onInfoOpenId(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onMayknowStateChanged(boolean paramBoolean) {}
  
  public void onPullIpad() {}
  
  public void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  public void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onSearchFriendResult(boolean paramBoolean, byte paramByte1, String paramString1, long paramLong, byte paramByte2, byte paramByte3, short paramShort, String paramString2) {}
  
  public void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong) {}
  
  public void onSetAsNormalContacts(boolean paramBoolean, List paramList) {}
  
  public void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List paramList) {}
  
  protected void onSetBothDongtaiPermissions(boolean paramBoolean) {}
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  public void onSetGeneralSettingsC2CRoaming(boolean paramBoolean, Map paramMap) {}
  
  protected void onSetGenralSettings(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void onSetGenralSettingsALLRing(boolean paramBoolean, Map paramMap) {}
  
  protected void onSetGenralSettingsALLVibrate(boolean paramBoolean, Map paramMap) {}
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap) {}
  
  protected void onSetGenralSettingsTroopRing(boolean paramBoolean, Map paramMap) {}
  
  protected void onSetGenralSettingsTroopVibrate(boolean paramBoolean, Map paramMap) {}
  
  public void onSetMessageRaoam(boolean paramBoolean) {}
  
  public void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onSetSelfSignatureResult(boolean paramBoolean) {}
  
  public void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSpecialCareRing(boolean paramBoolean, Map paramMap) {}
  
  public void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (paramBoolean)
                    {
                      onUpdateFriendList(paramBoolean, ((Boolean)paramObject).booleanValue());
                      return;
                    }
                    onUpdateFriendList(paramBoolean, false);
                    return;
                    if (paramBoolean) {}
                    for (bool1 = ((Boolean)paramObject).booleanValue();; bool1 = true)
                    {
                      onUpdateLastLoginInfo(paramBoolean, bool1);
                      return;
                    }
                    onUpdateSignature(paramBoolean, (String[])paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    onUpdateCircleRichStatus(paramBoolean, (String[])paramObject[0], (Bundle)paramObject[1]);
                    return;
                    paramObject = (Object[])paramObject;
                    onUpdateStrangerRichStatus(paramBoolean, (String[])paramObject[0], (Map)paramObject[1]);
                    return;
                    onGetHeadInfo(paramBoolean, (Setting)paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    onStrangerHeadReady(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
                    return;
                    onUpdateCustomHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    onGetStoreFace(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    paramObject = (Object[])paramObject;
                    onUpdateStrangerHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
                    return;
                    paramObject = (Object[])paramObject;
                    onUpdateQCallHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
                    return;
                    onUpdateTroopHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    paramObject = (Bundle)paramObject;
                    onUpdateTroopHeadDownloadUrl(paramBoolean, paramObject.getString("troopUin"), paramObject.getString("url"));
                    return;
                    onUpdateFriendInfo((String)paramObject, paramBoolean);
                    return;
                    onUpdateFriendInfoFinished((ArrayList)paramObject, paramBoolean);
                    return;
                    onUpdateRecentList();
                    return;
                    onUpdateC2ChatStatus(paramBoolean, (HashMap)paramObject);
                    return;
                    if (paramBoolean)
                    {
                      paramObject = (Object[])paramObject;
                      onUpdateMoveGroup((String)paramObject[0], ((Byte)paramObject[1]).byteValue(), ((Byte)paramObject[2]).byteValue());
                      return;
                    }
                    onUpdateMoveGroup(null, (byte)0, (byte)0);
                    return;
                    if (paramBoolean)
                    {
                      paramObject = (Object[])paramObject;
                      onUpdateAnswerAddedFriend(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                      return;
                    }
                    onUpdateAnswerAddedFriend(paramBoolean, "", 0);
                    return;
                    paramObject = (Bundle)paramObject;
                    String str = paramObject.getString("uin");
                    paramInt = paramObject.getInt("resultCode", 1);
                    bool2 = paramObject.getBoolean("addDirect", false);
                    if (paramInt == 0) {
                      bool1 = true;
                    }
                    onUpdateAddFriend(paramBoolean, bool1, bool2, str, paramObject);
                    return;
                    onUpdateAddFriendSetting(paramBoolean, (Bundle)paramObject);
                    return;
                    onUpdateOnlineFriend(paramBoolean, (String[])paramObject);
                    return;
                    onUpdateGetVideoAbility(paramBoolean);
                    return;
                    onUpdateDelFriend(paramBoolean, paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    onSetComment(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Byte)paramObject[2]).byteValue());
                    return;
                    onSetSelfSignatureResult(paramBoolean);
                    return;
                    paramObject = (Bundle)paramObject;
                    str = paramObject.getString("uin");
                    if (paramBoolean)
                    {
                      onGetAutoInfo(true, str, paramObject.getString("nick_name"), paramObject.getInt("group_id", 0));
                      return;
                    }
                    onGetAutoInfo(false, str, "", 0);
                    return;
                    bool1 = bool2;
                    if ((paramObject instanceof Object[]))
                    {
                      paramObject = (Object[])paramObject;
                      bool1 = bool2;
                      if (paramObject.length == 1)
                      {
                        bool1 = bool2;
                        if ((paramObject[0] instanceof Boolean)) {
                          bool1 = ((Boolean)paramObject[0]).booleanValue();
                        }
                      }
                    }
                    onGetGenralSettings(paramBoolean, bool1);
                    return;
                    onSetGenralSettings(paramBoolean, (ArrayList)paramObject);
                    return;
                    onPullIpad();
                    return;
                    onSetGenralSettingsTroopFilter(paramBoolean, (Map)paramObject);
                    return;
                    onSetGenralSettingsTroopRing(paramBoolean, (Map)paramObject);
                    return;
                    onSetGenralSettingsTroopVibrate(paramBoolean, (Map)paramObject);
                    return;
                    onSetGenralSettingsALLRing(paramBoolean, (Map)paramObject);
                    return;
                    onSetGenralSettingsALLVibrate(paramBoolean, (Map)paramObject);
                    return;
                    onSetGeneralSettingsC2CRoaming(paramBoolean, (Map)paramObject);
                    return;
                    onUpdateMobileQQHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    paramObject = (Object[])paramObject;
                    onSearchFriendResult(paramBoolean, ((Integer)paramObject[0]).intValue(), paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Long)paramObject[5]).longValue());
                    return;
                    paramObject = (Object[])paramObject;
                    onCondSearchFriendResult(((Long)paramObject[0]).longValue(), paramBoolean, paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
                    return;
                    if (paramObject == null)
                    {
                      onGetMultiDevResult(false, null, null);
                      return;
                    }
                    paramObject = (Object[])paramObject;
                    onGetMultiDevResult(paramBoolean, (List)paramObject[0], (List)paramObject[1]);
                    return;
                    onGetLoginDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                    onGetHistoryDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                    onGetAuthDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    onDelMultiDeResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                    paramObject = (Object[])paramObject;
                    onDelAuthDevResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                    paramObject = (Object[])paramObject;
                    onDelHistoryDevResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                    paramObject = (Object[])paramObject;
                    onKickOutDevFResult(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                  onUpdateFriendShieldFlag(((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
                  return;
                  if (paramBoolean)
                  {
                    onGetRecommendDeviceList(paramBoolean, (ArrayList)paramObject);
                    return;
                  }
                  onGetRecommendDeviceList(paramBoolean, null);
                  return;
                  onUpdateServerAuthDeviceList(paramBoolean);
                  return;
                } while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof String)));
                onAddFriend((String)paramObject);
                return;
                onGetStrangerInfo(paramBoolean, paramObject);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              paramInt = paramObject.length;
              if (paramInt == 2)
              {
                onGetOnlineInfoByUinOrMobile(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], null);
                return;
              }
            } while (paramInt != 3);
            onGetOnlineInfoByUinOrMobile(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (GetOnlineInfoResp)paramObject[2]);
            return;
            onAddGroupResp(paramBoolean, (GroupActionResp)paramObject);
            return;
            onRenameGroupResp(paramBoolean, (GroupActionResp)paramObject);
            return;
            onDeleteGroupResp(paramBoolean, (GroupActionResp)paramObject);
            return;
            onResortGroupResp(paramBoolean, (GroupActionResp)paramObject);
            return;
            paramObject = (Bundle)paramObject;
            long l = paramObject.getLong("uin");
            int j = paramObject.getInt("safety_flag");
            int i = 146;
            if (paramInt == 72) {
              i = 147;
            }
            onQueryUinSafetyFlag(paramBoolean, l, i, j);
            return;
            onSetVisibilityForNetWorkStatus(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            onGetVisibilityForNetWorkStatus(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            paramObject = (Bundle)paramObject;
            onInfoOpenId(paramBoolean, paramObject.getString("uin"), paramObject.getString("nick_name"));
            return;
            onGetFriendNickBatch(paramBoolean, paramObject);
            return;
            onSetSpecialCareRing(paramBoolean, (Map)paramObject);
            return;
            paramObject = (Object[])paramObject;
            onGetFriendDateNick(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
            return;
            paramObject = (Object[])paramObject;
            onUpdateGatherFriendList(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
            return;
            onSetNotAllowedSeeMyDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            onGetNotAllowedSeeMyDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            onSetShieldHisDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            onGetShieldHisDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            onUpdateRecommGatherFriendList(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            onSetAsUncommonlyUsedContacts(paramBoolean, (List)paramObject);
            return;
            onSetAsNormalContacts(paramBoolean, (List)paramObject);
            return;
            onSetBothDongtaiPermissions(paramBoolean);
            return;
            paramObject = (List)paramObject;
            if ((paramObject != null) && (paramObject.size() == 2))
            {
              onGetBothDongtaiPermissions(paramBoolean, ((Boolean)paramObject.get(0)).booleanValue(), ((Boolean)paramObject.get(1)).booleanValue());
              return;
            }
            onGetBothDongtaiPermissions(false, false, false);
            return;
            onGetMayKnowRecommend(paramBoolean);
            return;
            onGetPushRecommend(paramBoolean);
            return;
            onMayknowStateChanged(paramBoolean);
            return;
            onCancelMayKnowRecommend(paramBoolean, (String)paramObject);
            return;
            if (paramBoolean)
            {
              onGetSpecialCareRecommend(true, paramObject);
              return;
            }
            onGetSpecialCareRecommend(false, null);
            return;
            onGetSigZanInfo(paramBoolean, paramObject);
            return;
            onSetMessageRaoam(paramBoolean);
            return;
            onSetSpecialCareSwitch_global(paramBoolean, (Object[])paramObject);
            return;
            onSetSpecialCareSwitch_specialRing(paramBoolean, (Object[])paramObject);
            return;
            onSetSpecialCareSwitch_qzone(paramBoolean, (Object[])paramObject);
            return;
            onSetSpecialCareSwitchesOfAPerson(paramBoolean, (Object[])paramObject);
            return;
            if (paramBoolean)
            {
              paramObject = (Object[])paramObject;
              onUpdateSpecialCareList(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1]);
              return;
            }
            onUpdateSpecialCareList(false, false, null);
            return;
            onGroupDataInited();
            return;
          } while ((paramObject == null) || (!(paramObject instanceof String)));
          onAddReqStatesChanged(paramBoolean, (String)paramObject);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof Boolean)));
        onUpdateOlympicTorchList(((Boolean)paramObject).booleanValue());
        return;
      } while ((paramObject == null) || (!(paramObject instanceof ArrayList)));
      onUpdateHotFriendLevel(paramBoolean, (ArrayList)paramObject);
      return;
      onAddBatchPhoneFriend(paramBoolean, (ArrayList)paramObject);
      return;
      onAddBatchQIMFriend(paramBoolean, (List)paramObject);
      return;
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    onAddBatchTroopFrd(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1]);
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle) {}
  
  public void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onUpdateC2ChatStatus(boolean paramBoolean, HashMap paramHashMap) {}
  
  protected void onUpdateCircleRichStatus(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString) {}
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean) {}
  
  public void onUpdateFriendInfoFinished(ArrayList paramArrayList, boolean paramBoolean) {}
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Shield", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " isSetOrClear:" + paramBoolean1 + " isSuc:" + paramBoolean2 + " isPush:" + paramBoolean3 + " errMsg:" + paramString);
    }
  }
  
  public void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onUpdateGetVideoAbility(boolean paramBoolean) {}
  
  public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString) {}
  
  public void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2) {}
  
  public void onUpdateOlympicTorchList(boolean paramBoolean) {}
  
  public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  public void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  public void onUpdateRecentList() {}
  
  protected void onUpdateRecommGatherFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateServerAuthDeviceList(boolean paramBoolean) {}
  
  public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString) {}
  
  public void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  public void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map paramMap) {}
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateTroopHeadDownloadUrl(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListObserver
 * JD-Core Version:    0.7.0.1
 */