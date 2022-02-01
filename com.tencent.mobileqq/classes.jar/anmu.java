import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;

public class anmu
  implements anil
{
  public static final String ADD_DIRECT = "addDirect";
  public static final int ERROR_INVITE_BAD_USERS = 9;
  public static final int ERROR_INVITE_FRIENDS_FORBIDDEN = 7;
  public static final int ERROR_INVITE_FRIENDS_FREQUENT = 1;
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList) {}
  
  public void onAddBatchQIMFriend(boolean paramBoolean, List<Long> paramList) {}
  
  public void onAddBatchTroopFrd(boolean paramBoolean, String paramString, ArrayList<cmd0x777.AddFrdInfo> paramArrayList) {}
  
  protected void onAddFriend(String paramString) {}
  
  protected void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString) {}
  
  protected void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2) {}
  
  public void onConversationRecommendTypeChange(int paramInt) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelMultiDeResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject) {}
  
  public void onGetFriendsHasBindPhone(boolean paramBoolean, int paramInt, List<String> paramList) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting) {}
  
  public void onGetHeadInfoEmpty(boolean paramBoolean, int paramInt, List<String> paramList) {}
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetMultiDevResult(boolean paramBoolean, List<SvcDevLoginInfo> paramList1, List<SvcDevLoginInfo> paramList2) {}
  
  protected void onGetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp) {}
  
  protected void onGetPushRecommend(boolean paramBoolean) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<amgn> paramArrayList) {}
  
  protected void onGetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetSpecialCareRecommend(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet) {}
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGroupDataInited() {}
  
  protected void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject) {}
  
  protected void onInfoOpenId(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList) {}
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList) {}
  
  protected void onMayknowStateChanged(boolean paramBoolean) {}
  
  protected void onPullIpad() {}
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onRecommendTroopJoinedOrDeleted(String paramString) {}
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong) {}
  
  protected void onReqRecheckInHotReactive(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onSearchFriendResult(boolean paramBoolean, byte paramByte1, String paramString1, long paramLong, byte paramByte2, byte paramByte3, short paramShort, String paramString2) {}
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<bbmx> paramList) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onSetBothDongtaiPermissions(boolean paramBoolean) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void onSetGeneralSettingsC2CRoaming(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettings(boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  protected void onSetGenralSettingsALLRing(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsALLVibrate(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsTroopRing(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsTroopVibrate(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetMessageNotification(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetMessageRaoam(boolean paramBoolean) {}
  
  protected void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean) {}
  
  protected void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSpecialCareRing(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void onSuspiciousClear(boolean paramBoolean, int paramInt) {}
  
  public void onSuspiciousDel(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void onSuspiciousGetList(boolean paramBoolean, int paramInt, ArrayList<SysSuspiciousMsg> paramArrayList, byte[] paramArrayOfByte, Object paramObject) {}
  
  public void onSuspiciousGetUnreadNum(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void onSuspiciousSendReadReport(boolean paramBoolean, int paramInt) {}
  
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
                                                          onGetStoreFace(paramBoolean, (HashSet)paramObject);
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
                                                          onSearchFriendResult(paramBoolean, ((Integer)paramObject[0]).intValue(), paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Long)paramObject[5]).longValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7]);
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
                                                  if ((paramObject instanceof Bundle))
                                                  {
                                                    onGetMayKnowRecommend(paramBoolean, (Bundle)paramObject);
                                                    return;
                                                  }
                                                  onGetMayKnowRecommend(paramBoolean, null);
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
                                                  onHideConversationMayKnowRecommend(paramBoolean, paramObject);
                                                  return;
                                                  paramObject = (Object[])paramObject;
                                                  if ((paramObject != null) && (paramObject.length == 3))
                                                  {
                                                    onReqRecheckInHotReactive(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
                                                    return;
                                                  }
                                                  onReqRecheckInHotReactive(false, "", "", 0);
                                                  return;
                                                  paramObject = (Object[])paramObject;
                                                  if ((paramObject != null) && (paramObject.length == 3))
                                                  {
                                                    onReqLastChatTime(paramBoolean, (String)paramObject[0], (String)paramObject[1], Long.valueOf(((Long)paramObject[2]).longValue()));
                                                    return;
                                                  }
                                                  onReqLastChatTime(false, "", "", Long.valueOf(0L));
                                                  return;
                                                  paramObject = (Object[])paramObject;
                                                } while ((paramObject == null) || (paramObject.length != 1));
                                                onRecommendTroopJoinedOrDeleted((String)paramObject[0]);
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
                                                onSetHiddenChatSwitch(paramBoolean, (Object[])paramObject);
                                                return;
                                                onSetMessageNotification(paramBoolean, (Object[])paramObject);
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
                                        return;
                                        if ((paramObject instanceof Bundle))
                                        {
                                          onMayKnowEntryStateChanged(paramBoolean, (Bundle)paramObject);
                                          return;
                                        }
                                        onMayKnowEntryStateChanged(paramBoolean, null);
                                        return;
                                        if ((paramObject instanceof List)) {
                                          try
                                          {
                                            onMayKnowListPushAdd(paramBoolean, (List)paramObject);
                                            return;
                                          }
                                          catch (Throwable paramObject)
                                          {
                                            onMayKnowListPushAdd(paramBoolean, null);
                                            return;
                                          }
                                        }
                                        onMayKnowListPushAdd(paramBoolean, null);
                                        return;
                                        if ((paramObject instanceof List)) {
                                          try
                                          {
                                            onMayKnowListPushDel(paramBoolean, (List)paramObject);
                                            return;
                                          }
                                          catch (Throwable paramObject)
                                          {
                                            onMayKnowListPushDel(paramBoolean, null);
                                            return;
                                          }
                                        }
                                        onMayKnowListPushDel(paramBoolean, null);
                                        return;
                                        onAddFriendSecCheck(paramBoolean, (Bundle)paramObject);
                                        return;
                                      } while (!(paramObject instanceof Object[]));
                                      paramObject = (Object[])paramObject;
                                      onGetFriendsHasBindPhone(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
                                      return;
                                    } while (!(paramObject instanceof Object[]));
                                    onConversationRecommendTypeChange(((Integer)((Object[])(Object[])paramObject)[0]).intValue());
                                    return;
                                  } while (!(paramObject instanceof Object[]));
                                  paramObject = (Object[])paramObject;
                                } while (paramObject.length <= 1);
                                onSuspiciousGetUnreadNum(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
                                return;
                              } while (!(paramObject instanceof Object[]));
                              paramObject = (Object[])paramObject;
                            } while (paramObject.length <= 3);
                            onSuspiciousGetList(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (byte[])paramObject[2], paramObject[3]);
                            return;
                          } while (!(paramObject instanceof Object[]));
                          paramObject = (Object[])paramObject;
                        } while (paramObject.length <= 1);
                        onSuspiciousDel(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
                        return;
                      } while (!(paramObject instanceof Object[]));
                      paramObject = (Object[])paramObject;
                    } while (paramObject.length <= 0);
                    onSuspiciousClear(paramBoolean, ((Integer)paramObject[0]).intValue());
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                } while (paramObject.length <= 0);
                onSuspiciousSendReadReport(paramBoolean, ((Integer)paramObject[0]).intValue());
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
            } while (paramObject.length <= 1);
            onAgreeSuspiciousMsg(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
        } while (paramObject.length <= 2);
        onGetConnectionsPerson(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length <= 1);
    onGetHeadInfoEmpty(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle) {}
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap) {}
  
  protected void onUpdateCircleRichStatus(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean) {}
  
  protected void onUpdateFriendInfoFinished(ArrayList paramArrayList, boolean paramBoolean) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Shield", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " isSetOrClear:" + paramBoolean1 + " isSuc:" + paramBoolean2 + " isPush:" + paramBoolean3 + " errMsg:" + paramString);
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onUpdateGetVideoAbility(boolean paramBoolean) {}
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2) {}
  
  protected void onUpdateOlympicTorchList(boolean paramBoolean) {}
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onUpdateRecentList() {}
  
  protected void onUpdateRecommGatherFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateServerAuthDeviceList(boolean paramBoolean) {}
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList) {}
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map<String, RichStatus> paramMap) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateTroopHeadDownloadUrl(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anmu
 * JD-Core Version:    0.7.0.1
 */