package com.tencent.mobileqq.app;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.profile.ShoppingPhotoItemInfo;
import com.tencent.mobileqq.profilecard.observer.ICardObserver;
import com.tencent.qidian.data.BmqqAccountType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class CardObserver
  implements ICardObserver
{
  private void onUpdate_onAnonymousSettingMeRedPoint(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 111) {
      return;
    }
    boolean bool = false;
    if ((paramObject instanceof Boolean)) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    onAnonymousSettingMeRedPoint(paramBoolean, bool);
  }
  
  private void onUpdate_onCardInBlackList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    onCardInBlackList(paramBoolean, ((Bundle)paramObject).getString("uin"));
  }
  
  private void onUpdate_onCardLabelUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 52) {
      return;
    }
    onCardLabelUpdate(paramBoolean, paramObject);
  }
  
  private void onUpdate_onDeletePortrait(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 12) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (Object[])paramObject;
      paramObject = (Bundle)localObject[0];
      localObject = (Card)localObject[1];
      paramObject.getString("uin");
      onDeletePortrait(paramBoolean, (Card)localObject, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
      return;
    }
    Object localObject = (Object[])paramObject;
    paramObject = (Bundle)localObject[0];
    localObject = (Card)localObject[1];
    paramObject.getString("uin");
    onDeletePortrait(paramBoolean, (Card)localObject, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
  }
  
  private void onUpdate_onFavoritorsList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 42) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject = (Object[])paramObject;
      paramObject = (Card)localObject[0];
      Bundle localBundle = (Bundle)localObject[1];
      localObject = (ArrayList)localObject[2];
      String str = localBundle.getString("uin");
      long l = localBundle.getLong("nextMid");
      onFavoritorsList(true, str, (ArrayList)localObject, localBundle.getLong("startMid"), l, localBundle.getByteArray("strCookie"), paramObject);
      return;
    }
    onFavoritorsList(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, -1L, -1L, null, null);
  }
  
  private void onUpdate_onForceUpdateNearbyProfile(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 62) {
      return;
    }
    onForceUpdateNearbyProfile(paramBoolean, (NearbyPeopleCard)paramObject);
  }
  
  private void onUpdate_onGetAccountType(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 87) {
      return;
    }
    onGetAccountType(paramBoolean, (BmqqAccountType)paramObject);
  }
  
  private void onUpdate_onGetAllowActivateFriend(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 58) {
      return;
    }
    onGetAllowActivateFriend(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetAllowSeeLoginDays(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 44) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2)
      {
        onGetAllowSeeLoginDays(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1]);
        return;
      }
      onGetAllowSeeLoginDays(false, false, null);
      return;
    }
    onGetAllowSeeLoginDays(false, false, null);
  }
  
  private void onUpdate_onGetAllowStrangerInviteToGroupSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 93) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      onGetAllowStrangerInviteToGroupSwitch(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
      return;
    }
    onGetAllowStrangerInviteToGroupSwitch(false, false, false);
  }
  
  private void onUpdate_onGetAutoReplyList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 95) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetAutoReplyList(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue());
    }
  }
  
  private void onUpdate_onGetBabyQSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 73) {
      return;
    }
    onGetBabyQSwitch(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetCalReactiveDays(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 70) {
      return;
    }
    onGetCalReactiveDays(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 33) {
      return;
    }
    paramObject = (Bundle)paramObject;
    String str = paramObject.getString("uin");
    long l1 = paramObject.getLong("uCloseNeighborVote", 0L);
    long l2 = paramObject.getLong("uColseTimeEntityManager", 0L);
    boolean bool2 = true;
    boolean bool1;
    if (l1 == 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (l2 != 0L) {
      bool2 = false;
    }
    onGetCardSwitch(paramBoolean, str, bool1, bool2);
  }
  
  private void onUpdate_onGetCareBarEnable(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 101) {
      return;
    }
    paramObject = new CardObserver.1(this, paramBoolean, paramObject);
    ThreadManager.getUIHandler().post(paramObject);
  }
  
  private void onUpdate_onGetCommonSwitchFromDetailInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 83) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetCommonSwitchFromDetailInfo(paramBoolean, (short[])paramObject[0], (Map)paramObject[1]);
    }
  }
  
  private void onUpdate_onGetConnectionsSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 108) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2) {
        onGetConnectionsSwitch(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
      }
    }
  }
  
  private void onUpdate_onGetEducationList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 99) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2) {
        onGetEducationList(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
      }
    }
  }
  
  private void onUpdate_onGetHelloLiveMessageState(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 86) {
      return;
    }
    onGetHelloLiveMessageState(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
  }
  
  private void onUpdate_onGetHiddenSession(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 104) {
      return;
    }
    onGetHiddenSession(paramBoolean);
  }
  
  private void onUpdate_onGetKplCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 88) {
      return;
    }
    onGetKplCard(paramBoolean, paramObject);
  }
  
  private void onUpdate_onGetLocationDescription(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 43) {
      return;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Card)paramObject;
      onGetLocationDescription(true, paramObject.uin, paramObject);
    }
  }
  
  private void onUpdate_onGetMedal(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 75) {
      return;
    }
    onGetMedal(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetNearbyMyTabCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 65) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      onGetNearbyMyTabCard(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
      return;
    }
    onGetNearbyMyTabCard(false, null);
  }
  
  private void onUpdate_onGetNotDisturb(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 96) {
      return;
    }
    paramObject = (String[])paramObject;
    if ((paramObject != null) && (paramObject.length == 2)) {
      onGetNotDisturb(paramBoolean, paramObject[0], paramObject[1]);
    }
  }
  
  private void onUpdate_onGetNotifyOnLikeRankingList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 77) {
      return;
    }
    onGetNotifyOnLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetPCActiveState(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 54) {
      return;
    }
    onGetPCActiveState(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
  }
  
  private void onUpdate_onGetPartakeLikeRankingList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 81) {
      return;
    }
    onGetPartakeLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetPhoneNumSearchable(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 38) {
      return;
    }
    onGetPhoneNumSearchable(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onGetPrettyOwnerFlag(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 107) {
      return;
    }
    onGetPrettyOwnerFlag(paramBoolean, paramObject);
  }
  
  private void onUpdate_onGetQZoneCover(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 40) {
      return;
    }
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      onGetQZoneCover(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
    }
  }
  
  private void onUpdate_onGetSignInInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 82) {
      return;
    }
    onGetSignInInfo(paramBoolean);
  }
  
  private void onUpdate_onGetTroopHonorSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 110) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object))) {
      onGetTroopHonorSwitch(paramBoolean, ((Boolean)paramObject).booleanValue());
    }
  }
  
  private void onUpdate_onGetWholePeopleVoteLebaSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 89) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetWholePeopleVoteLebaSwitch(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
    }
  }
  
  private void onUpdate_onGreetingRecv(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 29) {
      return;
    }
    onGreetingRecv(paramBoolean, ((Bundle)paramObject).getString("uin"));
  }
  
  private void onUpdate_onGreetingSent(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 22) {
      return;
    }
    onGreetingSent(paramBoolean, ((Bundle)paramObject).getString("uin"));
  }
  
  private void onUpdate_onImpeach(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 23) {
      return;
    }
    onImpeach(paramBoolean, ((Bundle)paramObject).getString("uin"));
  }
  
  private void onUpdate_onIsQiDianExt(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 68) {
      return;
    }
    onGetAccountType(paramBoolean, (BmqqAccountType)paramObject);
  }
  
  private void onUpdate_onLabelLikeSet(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 53) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        onLabelLikeSet(paramBoolean, (Card)paramObject[0], ((Long)paramObject[1]).longValue());
      }
    }
    else if ((paramObject instanceof Card)) {
      onLabelLikeSet(paramBoolean, (Card)paramObject, -1L);
    }
  }
  
  private void onUpdate_onMedalChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 51) {
      return;
    }
    onMedalChange(paramBoolean, (Card)paramObject);
  }
  
  private void onUpdate_onNearByProfileSymbolGet(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 56) {
      return;
    }
    onNearByProfileSymbolGet(paramBoolean, ((Integer)paramObject).intValue());
  }
  
  private void onUpdate_onNewVotePush(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 28) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject = (Object[])paramObject;
      paramObject = (Card)localObject[0];
      localObject = (Bundle)localObject[1];
      ((Bundle)localObject).getString("uin");
      paramInt = ((Bundle)localObject).getInt("newVoteCount");
      onNewVotePush(paramBoolean, ((Bundle)localObject).getString("voteeUin"), paramInt, paramObject);
    }
  }
  
  private void onUpdate_onReqApplyUploadVoice(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 36) {
      return;
    }
    onReqApplyUploadVoice(paramBoolean, ((Bundle)paramObject).getString("pttcenter_selfuin"));
  }
  
  private void onUpdate_onReqFavoriteResult(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 32) {
      return;
    }
    if ((paramObject instanceof Bundle))
    {
      paramObject = (Bundle)paramObject;
      if (paramObject.getInt("favoriteSource") == 43)
      {
        onReqFavoriteResultRank(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"), paramObject.getInt("toplist_type"), paramObject.getInt("iCount", 0));
        return;
      }
      onReqFavoriteResult(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"), paramObject.getInt("iCount", 0), paramObject.getInt("from", 0));
    }
  }
  
  private void onUpdate_onReqLikeRankingListResult(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 76) {
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      List localList = (List)paramObject[0];
      paramInt = ((Integer)paramObject[1]).intValue();
      paramBoolean = ((Boolean)paramObject[2]).booleanValue();
      onReqLikeRankingListResult(true, (String)paramObject[3], localList, paramInt, paramBoolean);
      return;
    }
    onReqLikeRankingListResult(false, (String)paramObject, null, 0, false);
  }
  
  private void onUpdate_onSetAllowActivateFriend(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 57) {
      return;
    }
    onSetAllowActivateFriend(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onSetAllowSeeLoginDays(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 45) {
      return;
    }
    onSetAllowSeeLoginDays(paramBoolean);
  }
  
  private void onUpdate_onSetAutoReplyList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 97) {
      return;
    }
    onSetAutoReplyList(paramBoolean);
  }
  
  private void onUpdate_onSetBabyQSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 72) {
      return;
    }
    onSetBabyQSwitch(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onSetCalReactiveDays(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 71) {
      return;
    }
    onSetCalReactiveDays(paramBoolean);
  }
  
  private void onUpdate_onSetCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 34) {
      return;
    }
    paramObject = (Bundle)paramObject;
    onSetCardSwitch(paramBoolean, paramObject.getString("uin"), paramObject.getBoolean("modify_switch_for_near_people"), paramObject.getBoolean("target_switch"));
  }
  
  private void onUpdate_onSetCardTemplateReturn(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 41) {
      return;
    }
    onSetCardTemplateReturn(paramBoolean, paramObject);
  }
  
  private void onUpdate_onSetCareBarEnable(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 100) {
      return;
    }
    onSetCareBarEnable(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
  }
  
  private void onUpdate_onSetCommonSwitchFromDetailInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 84) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onSetCommonSwitchFromDetailInfo(paramBoolean, ((Short)paramObject[0]).shortValue(), ((Short)paramObject[1]).shortValue());
    }
  }
  
  private void onUpdate_onSetConnectionsSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 109) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2) {
        onSetConnectionsSwitch(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
      }
    }
  }
  
  private void onUpdate_onSetEmotionRecSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 102) {
      return;
    }
    onSetEmotionRecSwitch(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
  }
  
  private void onUpdate_onSetHelloLiveMessageState(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 85) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onSetHelloLiveMessageState(paramBoolean, Boolean.parseBoolean(paramObject[0].toString()), paramObject[1].toString(), paramObject[2].toString());
    }
  }
  
  private void onUpdate_onSetHiddenSession(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 105) {
      return;
    }
    if (paramObject == null) {
      paramInt = 0;
    } else {
      paramInt = ((Integer)paramObject).intValue();
    }
    onSetHiddenSession(paramBoolean, paramInt);
  }
  
  private void onUpdate_onSetMedal(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 74) {
      return;
    }
    onSetMedal(paramBoolean);
  }
  
  private void onUpdate_onSetNick(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 92) {
      return;
    }
    onSetNick(paramBoolean, (String)paramObject);
  }
  
  private void onUpdate_onSetNotDisturb(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 94) {
      return;
    }
    paramObject = (String[])paramObject;
    if ((paramObject != null) && (paramObject.length == 2)) {
      onSetNotDisturb(paramBoolean, paramObject[0], paramObject[1]);
    }
  }
  
  private void onUpdate_onSetNotifyOnLikeRankingList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 78) {
      return;
    }
    onSetNotifyOnLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onSetPCActiveState(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 55) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onSetPCActiveState(paramBoolean, Boolean.parseBoolean(paramObject[0].toString()), paramObject[1].toString(), paramObject[2].toString());
    }
  }
  
  private void onUpdate_onSetPartakeLikeRankingList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 80) {
      return;
    }
    onSetPartakeLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onSetPhoneNumSearchable(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 39) {
      return;
    }
    onSetPhoneNumSearchable(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onSetPrettyOwnerFlag(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 106) {
      return;
    }
    onSetPrettyOwnerFlag(paramBoolean, paramObject);
  }
  
  private void onUpdate_onSetPttAutoToTxtSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 103) {
      return;
    }
    onSetPttAutoToTxtSwitch(paramBoolean, paramObject);
  }
  
  private void onUpdate_onSetShowPushNotice(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 90) {
      return;
    }
    onSetShowPushNotice(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onSetSubaccountDisplayThirdQQ(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 79) {
      return;
    }
    onSetSubaccountDisplayThirdQQ(paramBoolean);
  }
  
  private void onUpdate_onTransferVoice(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 37) {
      return;
    }
    paramObject = (Bundle)paramObject;
    String str = paramObject.getString("pttcenter_selfuin");
    paramInt = paramObject.getInt("pttcenter_voice_optype");
    onTransferVoice(paramBoolean, str, paramObject.getString("pttcenter_filekey"), paramInt);
  }
  
  private void onUpdate_onUpdateAvatar(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 8) {
      return;
    }
    paramObject = (Bundle)paramObject;
    onUpdateAvatar(paramBoolean, paramObject.getString("uin"), paramObject.getInt("result"));
  }
  
  private void onUpdate_onUpdateCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 3) {
      return;
    }
    if (paramBoolean)
    {
      onUpdateCard(paramBoolean, (Card)paramObject);
      return;
    }
    onUpdateCard(paramBoolean, null);
  }
  
  private void onUpdate_onUpdateSetCallTabVisible(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 59) {
      return;
    }
    onUpdateSetCallTabVisible(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_onUploadQZonePhotoWall(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 69) {
      return;
    }
    if (paramObject != null) {
      onUploadQZonePhotoWall(paramBoolean, paramObject);
    }
  }
  
  private void onUpdate_onVoiceManager(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 35) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onVoiceManager(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (Card)paramObject[2]);
    }
  }
  
  private void onUpdate_onVoterList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 6) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject = (Object[])paramObject;
      paramObject = (Card)localObject[0];
      Bundle localBundle = (Bundle)localObject[1];
      ArrayList localArrayList1 = (ArrayList)localObject[2];
      ArrayList localArrayList2 = (ArrayList)localObject[3];
      paramInt = ((Integer)localObject[4]).intValue();
      int i = ((Integer)localObject[5]).intValue();
      int j = ((Integer)localObject[6]).intValue();
      int k = ((Integer)localObject[7]).intValue();
      int m = ((Integer)localObject[8]).intValue();
      localObject = localBundle.getString("uin");
      long l = localBundle.getLong("nextMid");
      onVoterList(true, (String)localObject, localArrayList1, localArrayList2, paramInt, i, j, k, m, localBundle.getLong("startMid"), l, localBundle.getByteArray("strCookie"), paramObject);
      return;
    }
    onVoterList(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, null, -1, -1, -1, -1, -1, -1L, -1L, null, null);
  }
  
  private void onupdateOnreqdelvoterecord(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 91) {
      return;
    }
    paramObject = (Object[])paramObject;
    onReqDelVoteRecord(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
  }
  
  protected void onAnonymousSettingMeRedPoint(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onCardInBlackList(boolean paramBoolean, String paramString) {}
  
  protected void onCardLabelUpdate(boolean paramBoolean, Object paramObject) {}
  
  protected void onDeletePortrait(boolean paramBoolean, Card paramCard, int paramInt, byte[] paramArrayOfByte) {}
  
  protected void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void onForceUpdateNearbyProfile(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  protected void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onGetAutoReplyList(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onGetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap) {}
  
  protected void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<SchoolInfo> paramArrayList) {}
  
  protected void onGetHelloLiveMessageState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetHiddenSession(boolean paramBoolean) {}
  
  protected void onGetKplCard(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onGetMedal(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetNearbyMyTabCard(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void onGetNotDisturb(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPCActiveState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  protected void onGetShoppingInfo(boolean paramBoolean, String paramString, List<ShoppingPhotoItemInfo> paramList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onGetSignInInfo(boolean paramBoolean) {}
  
  protected void onGetTroopHonorSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetWholePeopleVoteLebaSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onGreetingRecv(boolean paramBoolean, String paramString) {}
  
  protected void onGreetingSent(boolean paramBoolean, String paramString) {}
  
  protected void onImpeach(boolean paramBoolean, String paramString) {}
  
  protected void onLabelLikeSet(boolean paramBoolean, Card paramCard, long paramLong) {}
  
  protected void onMedalChange(boolean paramBoolean, Card paramCard) {}
  
  protected void onNearByProfileSymbolGet(boolean paramBoolean, int paramInt) {}
  
  protected void onNewVotePush(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onReqApplyUploadVoice(boolean paramBoolean, String paramString) {}
  
  protected void onReqDelVoteRecord(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt) {}
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void onReqFavoriteResultRank(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void onReqLikeRankingListResult(boolean paramBoolean1, String paramString, List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean2) {}
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean) {}
  
  protected void onSetAutoReplyList(boolean paramBoolean) {}
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetCalReactiveDays(boolean paramBoolean) {}
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetHelloLiveMessageState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2) {}
  
  protected void onSetHiddenSession(boolean paramBoolean, int paramInt) {}
  
  protected void onSetMedal(boolean paramBoolean) {}
  
  protected void onSetNick(boolean paramBoolean, String paramString) {}
  
  protected void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onSetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2) {}
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetShowPushNotice(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSubaccountDisplayThirdQQ(boolean paramBoolean) {}
  
  protected void onTransferVoice(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_onCardLabelUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_onLabelLikeSet(paramInt, paramBoolean, paramObject);
    onUpdate_onVoiceManager(paramInt, paramBoolean, paramObject);
    onUpdate_onCardInBlackList(paramInt, paramBoolean, paramObject);
    onUpdate_onUpdateCard(paramInt, paramBoolean, paramObject);
    onUpdate_onReqFavoriteResult(paramInt, paramBoolean, paramObject);
    onUpdate_onVoterList(paramInt, paramBoolean, paramObject);
    onUpdate_onFavoritorsList(paramInt, paramBoolean, paramObject);
    onupdateOnreqdelvoterecord(paramInt, paramBoolean, paramObject);
    onUpdate_onReqLikeRankingListResult(paramInt, paramBoolean, paramObject);
    onUpdate_onUpdateAvatar(paramInt, paramBoolean, paramObject);
    onUpdate_onDeletePortrait(paramInt, paramBoolean, paramObject);
    onUpdate_onGreetingSent(paramInt, paramBoolean, paramObject);
    onUpdate_onGreetingRecv(paramInt, paramBoolean, paramObject);
    onUpdate_onGetLocationDescription(paramInt, paramBoolean, paramObject);
    onUpdate_onImpeach(paramInt, paramBoolean, paramObject);
    onUpdate_onSetCardTemplateReturn(paramInt, paramBoolean, paramObject);
    onUpdate_onNewVotePush(paramInt, paramBoolean, paramObject);
    onUpdate_onSetCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onGetCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onReqApplyUploadVoice(paramInt, paramBoolean, paramObject);
    onUpdate_onTransferVoice(paramInt, paramBoolean, paramObject);
    onUpdate_onGetPhoneNumSearchable(paramInt, paramBoolean, paramObject);
    onUpdate_onSetPhoneNumSearchable(paramInt, paramBoolean, paramObject);
    onUpdate_onGetQZoneCover(paramInt, paramBoolean, paramObject);
    onUpdate_onUploadQZonePhotoWall(paramInt, paramBoolean, paramObject);
    onUpdate_onGetPCActiveState(paramInt, paramBoolean, paramObject);
    onUpdate_onSetPCActiveState(paramInt, paramBoolean, paramObject);
    onUpdate_onSetHelloLiveMessageState(paramInt, paramBoolean, paramObject);
    onUpdate_onGetHelloLiveMessageState(paramInt, paramBoolean, paramObject);
    onUpdate_onGetAllowSeeLoginDays(paramInt, paramBoolean, paramObject);
    onUpdate_onSetAllowSeeLoginDays(paramInt, paramBoolean, paramObject);
    onUpdate_onGetNotifyOnLikeRankingList(paramInt, paramBoolean, paramObject);
    onUpdate_onSetNotifyOnLikeRankingList(paramInt, paramBoolean, paramObject);
    onUpdate_onSetPartakeLikeRankingList(paramInt, paramBoolean, paramObject);
    onUpdate_onGetPartakeLikeRankingList(paramInt, paramBoolean, paramObject);
    onUpdate_onGetCalReactiveDays(paramInt, paramBoolean, paramObject);
    onUpdate_onSetCalReactiveDays(paramInt, paramBoolean, paramObject);
    onUpdate_onNearByProfileSymbolGet(paramInt, paramBoolean, paramObject);
    onUpdate_onGetAllowActivateFriend(paramInt, paramBoolean, paramObject);
    onUpdate_onSetAllowActivateFriend(paramInt, paramBoolean, paramObject);
    onUpdate_onGetNotDisturb(paramInt, paramBoolean, paramObject);
    onUpdate_onSetNotDisturb(paramInt, paramBoolean, paramObject);
    onUpdate_onGetHiddenSession(paramInt, paramBoolean, paramObject);
    onUpdate_onSetHiddenSession(paramInt, paramBoolean, paramObject);
    onUpdate_onGetBabyQSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onSetBabyQSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onUpdateSetCallTabVisible(paramInt, paramBoolean, paramObject);
    onUpdate_onForceUpdateNearbyProfile(paramInt, paramBoolean, paramObject);
    onUpdate_onSetMedal(paramInt, paramBoolean, paramObject);
    onUpdate_onGetMedal(paramInt, paramBoolean, paramObject);
    onUpdate_onGetNearbyMyTabCard(paramInt, paramBoolean, paramObject);
    onUpdate_onIsQiDianExt(paramInt, paramBoolean, paramObject);
    onUpdate_onSetSubaccountDisplayThirdQQ(paramInt, paramBoolean, paramObject);
    onUpdate_onGetSignInInfo(paramInt, paramBoolean, paramObject);
    onUpdate_onGetAccountType(paramInt, paramBoolean, paramObject);
    onUpdate_onGetKplCard(paramInt, paramBoolean, paramObject);
    onUpdate_onGetCommonSwitchFromDetailInfo(paramInt, paramBoolean, paramObject);
    onUpdate_onSetCommonSwitchFromDetailInfo(paramInt, paramBoolean, paramObject);
    onUpdate_onGetWholePeopleVoteLebaSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onMedalChange(paramInt, paramBoolean, paramObject);
    onUpdate_onSetShowPushNotice(paramInt, paramBoolean, paramObject);
    onUpdate_onSetNick(paramInt, paramBoolean, paramObject);
    onUpdate_onGetAllowStrangerInviteToGroupSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onGetAutoReplyList(paramInt, paramBoolean, paramObject);
    onUpdate_onSetAutoReplyList(paramInt, paramBoolean, paramObject);
    onUpdate_onGetEducationList(paramInt, paramBoolean, paramObject);
    onUpdate_onSetCareBarEnable(paramInt, paramBoolean, paramObject);
    onUpdate_onGetCareBarEnable(paramInt, paramBoolean, paramObject);
    onUpdate_onSetEmotionRecSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onSetPttAutoToTxtSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onGetPrettyOwnerFlag(paramInt, paramBoolean, paramObject);
    onUpdate_onSetPrettyOwnerFlag(paramInt, paramBoolean, paramObject);
    onUpdate_onGetConnectionsSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onSetConnectionsSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onGetTroopHonorSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_onAnonymousSettingMeRedPoint(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onUpdateCard(boolean paramBoolean, Card paramCard) {}
  
  protected void onUpdateSetCallTabVisible(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUploadQZonePhotoWall(boolean paramBoolean, Object paramObject) {}
  
  protected void onVisitorList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte) {}
  
  protected void onVoiceManager(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onVoterList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void reqShoppingInfo(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardObserver
 * JD-Core Version:    0.7.0.1
 */