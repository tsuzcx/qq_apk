package com.tencent.gprosdk;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IGProSdkWrapper$CppProxy
  implements IGProSdkWrapper
{
  private final AtomicBoolean destroyed = new AtomicBoolean(false);
  private final long nativeRef;
  
  private IGProSdkWrapper$CppProxy(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.nativeRef = paramLong;
      return;
    }
    throw new RuntimeException("nativeRef is zero");
  }
  
  public static native IGProSdkWrapper createGProSdkWrapper(IGProSdkListener paramIGProSdkListener);
  
  public static native String getFullAvatarUrl(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public static native byte[] lz4DecompressBuf(byte[] paramArrayOfByte);
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_LoadGuildUserProfileInfo(long paramLong1, long paramLong2, long paramLong3, IGProLoadGuildUserProfileCallback paramIGProLoadGuildUserProfileCallback);
  
  private native void native_addGuild(long paramLong1, long paramLong2, GProSourceId paramGProSourceId, String paramString, IGProResultCallback paramIGProResultCallback);
  
  private native void native_addGuildWithOption(long paramLong1, long paramLong2, GProSourceId paramGProSourceId, String paramString1, String paramString2, String paramString3, IGProResultCallback paramIGProResultCallback);
  
  private native void native_addGuildWithSource(long paramLong1, long paramLong2, GProSourceId paramGProSourceId, String paramString, GProSourceInfo paramGProSourceInfo, IGProResultCallback paramIGProResultCallback);
  
  private native void native_appAuthorization(long paramLong, int paramInt, IGProAppAuthorization paramIGProAppAuthorization);
  
  private native void native_batchFetchAudioChannelSimpleUserList(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, boolean paramBoolean, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback);
  
  private native void native_bindAppRole(long paramLong, int paramInt1, String paramString, int paramInt2, IGProBindAppRole paramIGProBindAppRole);
  
  private native void native_changeChannelCategoryNameWithId(long paramLong1, long paramLong2, long paramLong3, String paramString, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  private native void native_checkSelfRealNameVerified(long paramLong, IGProCheckSelfRealNameVerifiedCallback paramIGProCheckSelfRealNameVerifiedCallback);
  
  private native void native_checkUserBannedSpeakInChannel(long paramLong1, long paramLong2, long paramLong3, long paramLong4, IGProCheckUserBannedSpeakInChannelCallback paramIGProCheckUserBannedSpeakInChannelCallback);
  
  private native void native_clearNoticeRedPoint(long paramLong, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_close(long paramLong);
  
  private native void native_createChannelCategoryWithId(long paramLong1, long paramLong2, String paramString, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  private native void native_createChannelWithId(long paramLong1, long paramLong2, GProChannelCreateInfo paramGProChannelCreateInfo, long paramLong3, IGProCreateChannelCallback paramIGProCreateChannelCallback);
  
  private native void native_customChannelMsgNotifyType(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_dealNotice(long paramLong, String paramString1, String paramString2, IGProDealNoticeCallback paramIGProDealNoticeCallback);
  
  private native void native_destroyGuild(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_enterAudioChannel(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProEnterAudioChannelCallback paramIGProEnterAudioChannelCallback);
  
  private native void native_exitAudioChannel(long paramLong1, long paramLong2, long paramLong3, IGProResultCallback paramIGProResultCallback);
  
  private native void native_fetchAddGuildOption(long paramLong1, long paramLong2, IGProFetchAddGuildOptionCallback paramIGProFetchAddGuildOptionCallback);
  
  private native void native_fetchAppChnnPreInfoList(long paramLong, ArrayList<GProAppChnnPreFetchInfo> paramArrayList, boolean paramBoolean, IGProFetchAppChnnPreInfoListCallback paramIGProFetchAppChnnPreInfoListCallback);
  
  private native void native_fetchAppInfoList(long paramLong, IGProFetchAppInfoListCallback paramIGProFetchAppInfoListCallback);
  
  private native void native_fetchAudioChannelUserList(long paramLong1, long paramLong2, long paramLong3, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback);
  
  private native void native_fetchChannelInfo(long paramLong1, long paramLong2, long paramLong3, IGProFetchChannelInfoCallback paramIGProFetchChannelInfoCallback);
  
  private native void native_fetchChannelList(long paramLong, ArrayList<Long> paramArrayList, IGProFetchChannelListCategoryCallback paramIGProFetchChannelListCategoryCallback);
  
  private native void native_fetchChannelListForGuest(long paramLong, ArrayList<Long> paramArrayList, IGProFetchChannelListForGuestCallback paramIGProFetchChannelListForGuestCallback);
  
  private native void native_fetchChannelMemberList(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, IGProFetchChannelMemberListCallback paramIGProFetchChannelMemberListCallback);
  
  private native void native_fetchEnterChannelPermission(long paramLong1, long paramLong2, long paramLong3, IGProFetchEnterChannelPermissionCallback paramIGProFetchEnterChannelPermissionCallback);
  
  private native void native_fetchGuestGuild(long paramLong1, long paramLong2, IGProFetchGuestGuildCallback paramIGProFetchGuestGuildCallback);
  
  private native void native_fetchGuildInfo(long paramLong1, long paramLong2, IGProFetchGuildInfoCallback paramIGProFetchGuildInfoCallback);
  
  private native void native_fetchGuildInfoByAppIdentity(long paramLong, GProGuildIdentity paramGProGuildIdentity, String paramString1, String paramString2, IGProFetchGuildInfoByAppIdentityCallback paramIGProFetchGuildInfoByAppIdentityCallback);
  
  private native void native_fetchGuildInfoForGuest(long paramLong1, long paramLong2, IGProFetchGuildInfoCallback paramIGProFetchGuildInfoCallback);
  
  private native void native_fetchGuildList(long paramLong, ArrayList<GProGuildReqInfo> paramArrayList, byte[] paramArrayOfByte, IGProFetchGuildListCallback paramIGProFetchGuildListCallback);
  
  private native void native_fetchInviteInfo(long paramLong, String paramString, IGProFetchInviteInfoCallback paramIGProFetchInviteInfoCallback);
  
  private native void native_fetchIsLiveChannelOpen(long paramLong1, long paramLong2, IGProFetchIsLiveChannelOpenCallback paramIGProFetchIsLiveChannelOpenCallback);
  
  private native void native_fetchIsVoiceChannelOpen(long paramLong1, long paramLong2, IGProFetchIsVoiceChannelOpenCallback paramIGProFetchIsVoiceChannelOpenCallback);
  
  private native void native_fetchLiveChannelAnchorList(long paramLong1, long paramLong2, long paramLong3, IGProFetchLiveChannelAnchorListCallback paramIGProFetchLiveChannelAnchorListCallback);
  
  private native void native_fetchLiveChannelBannedUserList(long paramLong1, long paramLong2, long paramLong3, long paramLong4, IGProFetchBannedUserListCallback paramIGProFetchBannedUserListCallback);
  
  private native void native_fetchLiveRoomInfoByChannelIds(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProFetchLiveChannelInfoListCallback paramIGProFetchLiveChannelInfoListCallback);
  
  private native void native_fetchLiveRoomInfoByRoomIds(long paramLong, ArrayList<Long> paramArrayList, IGProFetchLiveChannelInfoListCallback paramIGProFetchLiveChannelInfoListCallback);
  
  private native void native_fetchLiveSecurityTips(long paramLong, IGProFetchLiveSecurityTipsCallback paramIGProFetchLiveSecurityTipsCallback);
  
  private native void native_fetchNoticeRedPoint(long paramLong, ArrayList<Integer> paramArrayList, IGProFetchNoticeRedPointCallback paramIGProFetchNoticeRedPointCallback);
  
  private native void native_fetchRemainAtAllCount(long paramLong1, long paramLong2, IGProFetchRemainAtAllCountCallback paramIGProFetchRemainAtAllCountCallback);
  
  private native void native_fetchShareInfo(long paramLong1, long paramLong2, long paramLong3, IGProFetchShareInfoCallback paramIGProFetchShareInfoCallback);
  
  private native void native_fetchUserInfo(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProGetUserInfoCallback paramIGProGetUserInfoCallback);
  
  private native void native_fetchUserList(long paramLong1, long paramLong2, long paramLong3, IGProGetUserListCallback paramIGProGetUserListCallback);
  
  private native void native_fetchVisibleMemberList(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, IGProFetchVisibleMemberListCallback paramIGProFetchVisibleMemberListCallback);
  
  private native void native_fetchVisibleMemberListByTinyId(long paramLong1, long paramLong2, long paramLong3, ArrayList<Long> paramArrayList, IGProFetchVisibleMemberListByTinyIdCallback paramIGProFetchVisibleMemberListByTinyIdCallback);
  
  private native void native_getAppAuthorizationInfo(long paramLong, int paramInt1, int paramInt2, IGProGetAppAuthorizationInfo paramIGProGetAppAuthorizationInfo);
  
  private native void native_getAppRoleList(long paramLong, int paramInt, IGProGetAppRoleList paramIGProGetAppRoleList);
  
  private native void native_getClientInfoList(long paramLong, int paramInt, IGProGetClientInfoList paramIGProGetClientInfoList);
  
  private native void native_getGuildMemberClientIdentity(long paramLong1, long paramLong2, int paramInt, ArrayList<Long> paramArrayList);
  
  private native void native_getGuildMemberName(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList);
  
  private native void native_getGuildUserAvatarUrl(long paramLong, ArrayList<Long> paramArrayList);
  
  private native void native_getGuildUsersNick(long paramLong, ArrayList<Long> paramArrayList);
  
  private native void native_getMoreNoticeList(long paramLong, int paramInt, IGProGetMoreNoticeListCallback paramIGProGetMoreNoticeListCallback);
  
  private native String native_getUIData(long paramLong, String paramString);
  
  private native void native_getUserList(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, IGProGetUserListCallback paramIGProGetUserListCallback);
  
  private native void native_initGetNoticeList(long paramLong, boolean paramBoolean, IGProInitGetNoticeListCallback paramIGProInitGetNoticeListCallback);
  
  private native void native_initGuildAndChannelListWithId(long paramLong, IGProLoadGuildAndChnListCallback paramIGProLoadGuildAndChnListCallback);
  
  private native void native_kickAudioChannelUsers(long paramLong1, long paramLong2, long paramLong3, ArrayList<Long> paramArrayList, IGProKickChannelMemberCallback paramIGProKickChannelMemberCallback);
  
  private native void native_kickGuildUser(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  private native void native_loadAllMemberList(long paramLong1, long paramLong2, long paramLong3, IGProLoadAllMemberListCallback paramIGProLoadAllMemberListCallback);
  
  private native void native_loadGuildAndChannelListWithId(long paramLong, IGProLoadGuildAndChnListCallback paramIGProLoadGuildAndChnListCallback);
  
  private native void native_loadNextPageMemberList(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, byte[] paramArrayOfByte, IGProLoadNextPageMemberListCallback paramIGProLoadNextPageMemberListCallback);
  
  private native void native_loadSimpleProfiles(long paramLong, int paramInt, IGProLoadGuildUserSimpleProfileCallback paramIGProLoadGuildUserSimpleProfileCallback);
  
  private native void native_loadUserInfo(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProGetUserInfoCallback paramIGProGetUserInfoCallback);
  
  private native void native_loadUserList(long paramLong1, long paramLong2, long paramLong3, IGProGetUserListCallback paramIGProGetUserListCallback);
  
  private native void native_onSendPbReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte);
  
  private native void native_onSendSSOReply(long paramLong1, long paramLong2, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte);
  
  private native boolean native_onServerPushMsg(long paramLong, int paramInt1, int paramInt2, GProMsgRouttingHead paramGProMsgRouttingHead, byte[] paramArrayOfByte);
  
  private native void native_queryApplyAddGuildStatus(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_queryTinyIdByLiveUID(long paramLong, ArrayList<Long> paramArrayList, IGProQueryTinyIdByLiveUIDCallback paramIGProQueryTinyIdByLiveUIDCallback);
  
  private native void native_refreshChannelInfo(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
  
  private native void native_refreshGuildInfo(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void native_refreshGuildList(long paramLong, boolean paramBoolean);
  
  private native void native_refreshGuildUserProfileInfo(long paramLong1, long paramLong2, long paramLong3);
  
  private native void native_removeChannel(long paramLong1, long paramLong2, long paramLong3, IGProResultCallback paramIGProResultCallback);
  
  private native void native_removeChannelCategoryWithId(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  private native void native_removeGuild(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_reportShareInfo(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString, int paramInt2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_requestBeginBroadcast(long paramLong1, long paramLong2, long paramLong3, long paramLong4, IGProResultCallback paramIGProResultCallback);
  
  private native void native_searchChannelMemberFromServer(long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt, long paramLong4, IGProSearchMemberFromServerCallback paramIGProSearchMemberFromServerCallback);
  
  private native void native_searchGuildByShowNumber(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, IGProSearchGuildCallback paramIGProSearchGuildCallback);
  
  private native void native_searchMemberFromServer(long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, IGProSearchMemberFromServerCallback paramIGProSearchMemberFromServerCallback);
  
  private native void native_setAddGuildOption(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setAudioChannelUserLimit(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setChannelBannedSpeak(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setChannelCategoryInfoWithId(long paramLong1, long paramLong2, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  private native void native_setChannelCategoryOrderWithId(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  private native void native_setChannelCategoryWithId(long paramLong1, long paramLong2, long paramLong3, long paramLong4, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  private native void native_setChannelMsgNotifyType(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setChannelName(long paramLong1, long paramLong2, long paramLong3, String paramString, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setChannelSpeakerPerm(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setChannelVisible(long paramLong1, long paramLong2, long paramLong3, int paramInt, ArrayList<Long> paramArrayList, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setChannelVisibleMembers(long paramLong1, long paramLong2, long paramLong3, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setFocusChannel(long paramLong, ArrayList<GProFocusChannelReqInfo> paramArrayList, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setGuildAdmin(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, IGProSetGuildAdminResultCallback paramIGProSetGuildAdminResultCallback);
  
  private native void native_setGuildClientId(long paramLong1, long paramLong2, int paramInt, IGProSetGuildClientIdCallback paramIGProSetGuildClientIdCallback);
  
  private native void native_setGuildMemberName(long paramLong1, long paramLong2, String paramString, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setGuildName(long paramLong1, long paramLong2, String paramString, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setGuildProfile(long paramLong1, long paramLong2, String paramString, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setGuildTop(long paramLong1, long paramLong2, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setLiveChannelAnchorList(long paramLong1, long paramLong2, long paramLong3, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setLiveChannelBannedUser(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setMemberClientIdentityForMsg(long paramLong1, long paramLong2, long paramLong3, GProClientIdentity paramGProClientIdentity, long paramLong4);
  
  private native void native_setMemberNameForMsg(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, long paramLong4);
  
  private native void native_setOnLogin(long paramLong);
  
  private native void native_setSelfTinyId(long paramLong1, long paramLong2);
  
  private native void native_setShowArchive(long paramLong, int paramInt, boolean paramBoolean, IGProSwitchPresenceArchiveCallback paramIGProSwitchPresenceArchiveCallback);
  
  private native void native_setShowPresence(long paramLong, int paramInt, boolean paramBoolean, IGProSwitchPresenceArchiveCallback paramIGProSwitchPresenceArchiveCallback);
  
  private native void native_setUIData(long paramLong, String paramString1, String paramString2);
  
  private native void native_setUserMuteSeatInGuild(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  private native void native_setUserVoicelessToMe(long paramLong1, long paramLong2, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  private native void native_start(long paramLong1, long paramLong2, GProSessionConfig paramGProSessionConfig);
  
  public static native void setSdkLoggerLevel(int paramInt);
  
  public void LoadGuildUserProfileInfo(long paramLong1, long paramLong2, IGProLoadGuildUserProfileCallback paramIGProLoadGuildUserProfileCallback)
  {
    native_LoadGuildUserProfileInfo(this.nativeRef, paramLong1, paramLong2, paramIGProLoadGuildUserProfileCallback);
  }
  
  public void _djinni_private_destroy()
  {
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
  }
  
  public void addGuild(long paramLong, GProSourceId paramGProSourceId, String paramString, IGProResultCallback paramIGProResultCallback)
  {
    native_addGuild(this.nativeRef, paramLong, paramGProSourceId, paramString, paramIGProResultCallback);
  }
  
  public void addGuildWithOption(long paramLong, GProSourceId paramGProSourceId, String paramString1, String paramString2, String paramString3, IGProResultCallback paramIGProResultCallback)
  {
    native_addGuildWithOption(this.nativeRef, paramLong, paramGProSourceId, paramString1, paramString2, paramString3, paramIGProResultCallback);
  }
  
  public void addGuildWithSource(long paramLong, GProSourceId paramGProSourceId, String paramString, GProSourceInfo paramGProSourceInfo, IGProResultCallback paramIGProResultCallback)
  {
    native_addGuildWithSource(this.nativeRef, paramLong, paramGProSourceId, paramString, paramGProSourceInfo, paramIGProResultCallback);
  }
  
  public void appAuthorization(int paramInt, IGProAppAuthorization paramIGProAppAuthorization)
  {
    native_appAuthorization(this.nativeRef, paramInt, paramIGProAppAuthorization);
  }
  
  public void batchFetchAudioChannelSimpleUserList(long paramLong, ArrayList<Long> paramArrayList, boolean paramBoolean, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback)
  {
    native_batchFetchAudioChannelSimpleUserList(this.nativeRef, paramLong, paramArrayList, paramBoolean, paramIGProFetchAudioChannelUserListCallback);
  }
  
  public void bindAppRole(int paramInt1, String paramString, int paramInt2, IGProBindAppRole paramIGProBindAppRole)
  {
    native_bindAppRole(this.nativeRef, paramInt1, paramString, paramInt2, paramIGProBindAppRole);
  }
  
  public void changeChannelCategoryNameWithId(long paramLong1, long paramLong2, String paramString, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback)
  {
    native_changeChannelCategoryNameWithId(this.nativeRef, paramLong1, paramLong2, paramString, paramIGProSetChannelCategoryInfoCallback);
  }
  
  public void checkSelfRealNameVerified(IGProCheckSelfRealNameVerifiedCallback paramIGProCheckSelfRealNameVerifiedCallback)
  {
    native_checkSelfRealNameVerified(this.nativeRef, paramIGProCheckSelfRealNameVerifiedCallback);
  }
  
  public void checkUserBannedSpeakInChannel(long paramLong1, long paramLong2, long paramLong3, IGProCheckUserBannedSpeakInChannelCallback paramIGProCheckUserBannedSpeakInChannelCallback)
  {
    native_checkUserBannedSpeakInChannel(this.nativeRef, paramLong1, paramLong2, paramLong3, paramIGProCheckUserBannedSpeakInChannelCallback);
  }
  
  public void clearNoticeRedPoint(int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_clearNoticeRedPoint(this.nativeRef, paramInt, paramIGProResultCallback);
  }
  
  public void close()
  {
    native_close(this.nativeRef);
  }
  
  public void createChannelCategoryWithId(long paramLong, String paramString, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback)
  {
    native_createChannelCategoryWithId(this.nativeRef, paramLong, paramString, paramIGProSetChannelCategoryInfoCallback);
  }
  
  public void createChannelWithId(long paramLong1, GProChannelCreateInfo paramGProChannelCreateInfo, long paramLong2, IGProCreateChannelCallback paramIGProCreateChannelCallback)
  {
    native_createChannelWithId(this.nativeRef, paramLong1, paramGProChannelCreateInfo, paramLong2, paramIGProCreateChannelCallback);
  }
  
  public void customChannelMsgNotifyType(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_customChannelMsgNotifyType(this.nativeRef, paramLong1, paramLong2, paramInt, paramIGProResultCallback);
  }
  
  public void dealNotice(String paramString1, String paramString2, IGProDealNoticeCallback paramIGProDealNoticeCallback)
  {
    native_dealNotice(this.nativeRef, paramString1, paramString2, paramIGProDealNoticeCallback);
  }
  
  public void destroyGuild(long paramLong, IGProResultCallback paramIGProResultCallback)
  {
    native_destroyGuild(this.nativeRef, paramLong, paramIGProResultCallback);
  }
  
  public void enterAudioChannel(long paramLong1, long paramLong2, int paramInt, IGProEnterAudioChannelCallback paramIGProEnterAudioChannelCallback)
  {
    native_enterAudioChannel(this.nativeRef, paramLong1, paramLong2, paramInt, paramIGProEnterAudioChannelCallback);
  }
  
  public void exitAudioChannel(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback)
  {
    native_exitAudioChannel(this.nativeRef, paramLong1, paramLong2, paramIGProResultCallback);
  }
  
  public void fetchAddGuildOption(long paramLong, IGProFetchAddGuildOptionCallback paramIGProFetchAddGuildOptionCallback)
  {
    native_fetchAddGuildOption(this.nativeRef, paramLong, paramIGProFetchAddGuildOptionCallback);
  }
  
  public void fetchAppChnnPreInfoList(ArrayList<GProAppChnnPreFetchInfo> paramArrayList, boolean paramBoolean, IGProFetchAppChnnPreInfoListCallback paramIGProFetchAppChnnPreInfoListCallback)
  {
    native_fetchAppChnnPreInfoList(this.nativeRef, paramArrayList, paramBoolean, paramIGProFetchAppChnnPreInfoListCallback);
  }
  
  public void fetchAppInfoList(IGProFetchAppInfoListCallback paramIGProFetchAppInfoListCallback)
  {
    native_fetchAppInfoList(this.nativeRef, paramIGProFetchAppInfoListCallback);
  }
  
  public void fetchAudioChannelUserList(long paramLong1, long paramLong2, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback)
  {
    native_fetchAudioChannelUserList(this.nativeRef, paramLong1, paramLong2, paramIGProFetchAudioChannelUserListCallback);
  }
  
  public void fetchChannelInfo(long paramLong1, long paramLong2, IGProFetchChannelInfoCallback paramIGProFetchChannelInfoCallback)
  {
    native_fetchChannelInfo(this.nativeRef, paramLong1, paramLong2, paramIGProFetchChannelInfoCallback);
  }
  
  public void fetchChannelList(ArrayList<Long> paramArrayList, IGProFetchChannelListCategoryCallback paramIGProFetchChannelListCategoryCallback)
  {
    native_fetchChannelList(this.nativeRef, paramArrayList, paramIGProFetchChannelListCategoryCallback);
  }
  
  public void fetchChannelListForGuest(ArrayList<Long> paramArrayList, IGProFetchChannelListForGuestCallback paramIGProFetchChannelListForGuestCallback)
  {
    native_fetchChannelListForGuest(this.nativeRef, paramArrayList, paramIGProFetchChannelListForGuestCallback);
  }
  
  public void fetchChannelMemberList(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProFetchChannelMemberListCallback paramIGProFetchChannelMemberListCallback)
  {
    native_fetchChannelMemberList(this.nativeRef, paramLong1, paramLong2, paramLong3, paramInt, paramIGProFetchChannelMemberListCallback);
  }
  
  public void fetchEnterChannelPermission(long paramLong1, long paramLong2, IGProFetchEnterChannelPermissionCallback paramIGProFetchEnterChannelPermissionCallback)
  {
    native_fetchEnterChannelPermission(this.nativeRef, paramLong1, paramLong2, paramIGProFetchEnterChannelPermissionCallback);
  }
  
  public void fetchGuestGuild(long paramLong, IGProFetchGuestGuildCallback paramIGProFetchGuestGuildCallback)
  {
    native_fetchGuestGuild(this.nativeRef, paramLong, paramIGProFetchGuestGuildCallback);
  }
  
  public void fetchGuildInfo(long paramLong, IGProFetchGuildInfoCallback paramIGProFetchGuildInfoCallback)
  {
    native_fetchGuildInfo(this.nativeRef, paramLong, paramIGProFetchGuildInfoCallback);
  }
  
  public void fetchGuildInfoByAppIdentity(GProGuildIdentity paramGProGuildIdentity, String paramString1, String paramString2, IGProFetchGuildInfoByAppIdentityCallback paramIGProFetchGuildInfoByAppIdentityCallback)
  {
    native_fetchGuildInfoByAppIdentity(this.nativeRef, paramGProGuildIdentity, paramString1, paramString2, paramIGProFetchGuildInfoByAppIdentityCallback);
  }
  
  public void fetchGuildInfoForGuest(long paramLong, IGProFetchGuildInfoCallback paramIGProFetchGuildInfoCallback)
  {
    native_fetchGuildInfoForGuest(this.nativeRef, paramLong, paramIGProFetchGuildInfoCallback);
  }
  
  public void fetchGuildList(ArrayList<GProGuildReqInfo> paramArrayList, byte[] paramArrayOfByte, IGProFetchGuildListCallback paramIGProFetchGuildListCallback)
  {
    native_fetchGuildList(this.nativeRef, paramArrayList, paramArrayOfByte, paramIGProFetchGuildListCallback);
  }
  
  public void fetchInviteInfo(String paramString, IGProFetchInviteInfoCallback paramIGProFetchInviteInfoCallback)
  {
    native_fetchInviteInfo(this.nativeRef, paramString, paramIGProFetchInviteInfoCallback);
  }
  
  public void fetchIsLiveChannelOpen(long paramLong, IGProFetchIsLiveChannelOpenCallback paramIGProFetchIsLiveChannelOpenCallback)
  {
    native_fetchIsLiveChannelOpen(this.nativeRef, paramLong, paramIGProFetchIsLiveChannelOpenCallback);
  }
  
  public void fetchIsVoiceChannelOpen(long paramLong, IGProFetchIsVoiceChannelOpenCallback paramIGProFetchIsVoiceChannelOpenCallback)
  {
    native_fetchIsVoiceChannelOpen(this.nativeRef, paramLong, paramIGProFetchIsVoiceChannelOpenCallback);
  }
  
  public void fetchLiveChannelAnchorList(long paramLong1, long paramLong2, IGProFetchLiveChannelAnchorListCallback paramIGProFetchLiveChannelAnchorListCallback)
  {
    native_fetchLiveChannelAnchorList(this.nativeRef, paramLong1, paramLong2, paramIGProFetchLiveChannelAnchorListCallback);
  }
  
  public void fetchLiveChannelBannedUserList(long paramLong1, long paramLong2, long paramLong3, IGProFetchBannedUserListCallback paramIGProFetchBannedUserListCallback)
  {
    native_fetchLiveChannelBannedUserList(this.nativeRef, paramLong1, paramLong2, paramLong3, paramIGProFetchBannedUserListCallback);
  }
  
  public void fetchLiveRoomInfoByChannelIds(long paramLong, ArrayList<Long> paramArrayList, IGProFetchLiveChannelInfoListCallback paramIGProFetchLiveChannelInfoListCallback)
  {
    native_fetchLiveRoomInfoByChannelIds(this.nativeRef, paramLong, paramArrayList, paramIGProFetchLiveChannelInfoListCallback);
  }
  
  public void fetchLiveRoomInfoByRoomIds(ArrayList<Long> paramArrayList, IGProFetchLiveChannelInfoListCallback paramIGProFetchLiveChannelInfoListCallback)
  {
    native_fetchLiveRoomInfoByRoomIds(this.nativeRef, paramArrayList, paramIGProFetchLiveChannelInfoListCallback);
  }
  
  public void fetchLiveSecurityTips(IGProFetchLiveSecurityTipsCallback paramIGProFetchLiveSecurityTipsCallback)
  {
    native_fetchLiveSecurityTips(this.nativeRef, paramIGProFetchLiveSecurityTipsCallback);
  }
  
  public void fetchNoticeRedPoint(ArrayList<Integer> paramArrayList, IGProFetchNoticeRedPointCallback paramIGProFetchNoticeRedPointCallback)
  {
    native_fetchNoticeRedPoint(this.nativeRef, paramArrayList, paramIGProFetchNoticeRedPointCallback);
  }
  
  public void fetchRemainAtAllCount(long paramLong, IGProFetchRemainAtAllCountCallback paramIGProFetchRemainAtAllCountCallback)
  {
    native_fetchRemainAtAllCount(this.nativeRef, paramLong, paramIGProFetchRemainAtAllCountCallback);
  }
  
  public void fetchShareInfo(long paramLong1, long paramLong2, IGProFetchShareInfoCallback paramIGProFetchShareInfoCallback)
  {
    native_fetchShareInfo(this.nativeRef, paramLong1, paramLong2, paramIGProFetchShareInfoCallback);
  }
  
  public void fetchUserInfo(long paramLong, ArrayList<Long> paramArrayList, IGProGetUserInfoCallback paramIGProGetUserInfoCallback)
  {
    native_fetchUserInfo(this.nativeRef, paramLong, paramArrayList, paramIGProGetUserInfoCallback);
  }
  
  public void fetchUserList(long paramLong1, long paramLong2, IGProGetUserListCallback paramIGProGetUserListCallback)
  {
    native_fetchUserList(this.nativeRef, paramLong1, paramLong2, paramIGProGetUserListCallback);
  }
  
  public void fetchVisibleMemberList(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProFetchVisibleMemberListCallback paramIGProFetchVisibleMemberListCallback)
  {
    native_fetchVisibleMemberList(this.nativeRef, paramLong1, paramLong2, paramLong3, paramInt, paramIGProFetchVisibleMemberListCallback);
  }
  
  public void fetchVisibleMemberListByTinyId(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProFetchVisibleMemberListByTinyIdCallback paramIGProFetchVisibleMemberListByTinyIdCallback)
  {
    native_fetchVisibleMemberListByTinyId(this.nativeRef, paramLong1, paramLong2, paramArrayList, paramIGProFetchVisibleMemberListByTinyIdCallback);
  }
  
  protected void finalize()
  {
    _djinni_private_destroy();
    super.finalize();
  }
  
  public void getAppAuthorizationInfo(int paramInt1, int paramInt2, IGProGetAppAuthorizationInfo paramIGProGetAppAuthorizationInfo)
  {
    native_getAppAuthorizationInfo(this.nativeRef, paramInt1, paramInt2, paramIGProGetAppAuthorizationInfo);
  }
  
  public void getAppRoleList(int paramInt, IGProGetAppRoleList paramIGProGetAppRoleList)
  {
    native_getAppRoleList(this.nativeRef, paramInt, paramIGProGetAppRoleList);
  }
  
  public void getClientInfoList(int paramInt, IGProGetClientInfoList paramIGProGetClientInfoList)
  {
    native_getClientInfoList(this.nativeRef, paramInt, paramIGProGetClientInfoList);
  }
  
  public void getGuildMemberClientIdentity(long paramLong, int paramInt, ArrayList<Long> paramArrayList)
  {
    native_getGuildMemberClientIdentity(this.nativeRef, paramLong, paramInt, paramArrayList);
  }
  
  public void getGuildMemberName(long paramLong, ArrayList<Long> paramArrayList)
  {
    native_getGuildMemberName(this.nativeRef, paramLong, paramArrayList);
  }
  
  public void getGuildUserAvatarUrl(ArrayList<Long> paramArrayList)
  {
    native_getGuildUserAvatarUrl(this.nativeRef, paramArrayList);
  }
  
  public void getGuildUsersNick(ArrayList<Long> paramArrayList)
  {
    native_getGuildUsersNick(this.nativeRef, paramArrayList);
  }
  
  public void getMoreNoticeList(int paramInt, IGProGetMoreNoticeListCallback paramIGProGetMoreNoticeListCallback)
  {
    native_getMoreNoticeList(this.nativeRef, paramInt, paramIGProGetMoreNoticeListCallback);
  }
  
  public String getUIData(String paramString)
  {
    return native_getUIData(this.nativeRef, paramString);
  }
  
  public void getUserList(long paramLong1, long paramLong2, boolean paramBoolean, IGProGetUserListCallback paramIGProGetUserListCallback)
  {
    native_getUserList(this.nativeRef, paramLong1, paramLong2, paramBoolean, paramIGProGetUserListCallback);
  }
  
  public void initGetNoticeList(boolean paramBoolean, IGProInitGetNoticeListCallback paramIGProInitGetNoticeListCallback)
  {
    native_initGetNoticeList(this.nativeRef, paramBoolean, paramIGProInitGetNoticeListCallback);
  }
  
  public void initGuildAndChannelListWithId(IGProLoadGuildAndChnListCallback paramIGProLoadGuildAndChnListCallback)
  {
    native_initGuildAndChannelListWithId(this.nativeRef, paramIGProLoadGuildAndChnListCallback);
  }
  
  public void kickAudioChannelUsers(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProKickChannelMemberCallback paramIGProKickChannelMemberCallback)
  {
    native_kickAudioChannelUsers(this.nativeRef, paramLong1, paramLong2, paramArrayList, paramIGProKickChannelMemberCallback);
  }
  
  public void kickGuildUser(long paramLong, ArrayList<Long> paramArrayList, boolean paramBoolean, IGProResultCallback paramIGProResultCallback)
  {
    native_kickGuildUser(this.nativeRef, paramLong, paramArrayList, paramBoolean, paramIGProResultCallback);
  }
  
  public void loadAllMemberList(long paramLong1, long paramLong2, IGProLoadAllMemberListCallback paramIGProLoadAllMemberListCallback)
  {
    native_loadAllMemberList(this.nativeRef, paramLong1, paramLong2, paramIGProLoadAllMemberListCallback);
  }
  
  public void loadGuildAndChannelListWithId(IGProLoadGuildAndChnListCallback paramIGProLoadGuildAndChnListCallback)
  {
    native_loadGuildAndChannelListWithId(this.nativeRef, paramIGProLoadGuildAndChnListCallback);
  }
  
  public void loadNextPageMemberList(long paramLong1, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte, IGProLoadNextPageMemberListCallback paramIGProLoadNextPageMemberListCallback)
  {
    native_loadNextPageMemberList(this.nativeRef, paramLong1, paramLong2, paramBoolean, paramArrayOfByte, paramIGProLoadNextPageMemberListCallback);
  }
  
  public void loadSimpleProfiles(int paramInt, IGProLoadGuildUserSimpleProfileCallback paramIGProLoadGuildUserSimpleProfileCallback)
  {
    native_loadSimpleProfiles(this.nativeRef, paramInt, paramIGProLoadGuildUserSimpleProfileCallback);
  }
  
  public void loadUserInfo(long paramLong, ArrayList<Long> paramArrayList, IGProGetUserInfoCallback paramIGProGetUserInfoCallback)
  {
    native_loadUserInfo(this.nativeRef, paramLong, paramArrayList, paramIGProGetUserInfoCallback);
  }
  
  public void loadUserList(long paramLong1, long paramLong2, IGProGetUserListCallback paramIGProGetUserListCallback)
  {
    native_loadUserList(this.nativeRef, paramLong1, paramLong2, paramIGProGetUserListCallback);
  }
  
  public void onSendPbReply(long paramLong, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    native_onSendPbReply(this.nativeRef, paramLong, paramInt1, paramInt2, paramString, paramArrayOfByte);
  }
  
  public void onSendSSOReply(long paramLong, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    native_onSendSSOReply(this.nativeRef, paramLong, paramString1, paramInt, paramString2, paramArrayOfByte);
  }
  
  public boolean onServerPushMsg(int paramInt1, int paramInt2, GProMsgRouttingHead paramGProMsgRouttingHead, byte[] paramArrayOfByte)
  {
    return native_onServerPushMsg(this.nativeRef, paramInt1, paramInt2, paramGProMsgRouttingHead, paramArrayOfByte);
  }
  
  public void queryApplyAddGuildStatus(long paramLong, IGProResultCallback paramIGProResultCallback)
  {
    native_queryApplyAddGuildStatus(this.nativeRef, paramLong, paramIGProResultCallback);
  }
  
  public void queryTinyIdByLiveUID(ArrayList<Long> paramArrayList, IGProQueryTinyIdByLiveUIDCallback paramIGProQueryTinyIdByLiveUIDCallback)
  {
    native_queryTinyIdByLiveUID(this.nativeRef, paramArrayList, paramIGProQueryTinyIdByLiveUIDCallback);
  }
  
  public void refreshChannelInfo(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    native_refreshChannelInfo(this.nativeRef, paramLong1, paramLong2, paramBoolean);
  }
  
  public void refreshGuildInfo(long paramLong, boolean paramBoolean)
  {
    native_refreshGuildInfo(this.nativeRef, paramLong, paramBoolean);
  }
  
  public void refreshGuildList(boolean paramBoolean)
  {
    native_refreshGuildList(this.nativeRef, paramBoolean);
  }
  
  public void refreshGuildUserProfileInfo(long paramLong1, long paramLong2)
  {
    native_refreshGuildUserProfileInfo(this.nativeRef, paramLong1, paramLong2);
  }
  
  public void removeChannel(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback)
  {
    native_removeChannel(this.nativeRef, paramLong1, paramLong2, paramIGProResultCallback);
  }
  
  public void removeChannelCategoryWithId(long paramLong1, long paramLong2, boolean paramBoolean, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback)
  {
    native_removeChannelCategoryWithId(this.nativeRef, paramLong1, paramLong2, paramBoolean, paramIGProSetChannelCategoryInfoCallback);
  }
  
  public void removeGuild(long paramLong, IGProResultCallback paramIGProResultCallback)
  {
    native_removeGuild(this.nativeRef, paramLong, paramIGProResultCallback);
  }
  
  public void reportShareInfo(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, IGProResultCallback paramIGProResultCallback)
  {
    native_reportShareInfo(this.nativeRef, paramLong1, paramLong2, paramInt1, paramString, paramInt2, paramIGProResultCallback);
  }
  
  public void requestBeginBroadcast(long paramLong1, long paramLong2, long paramLong3, IGProResultCallback paramIGProResultCallback)
  {
    native_requestBeginBroadcast(this.nativeRef, paramLong1, paramLong2, paramLong3, paramIGProResultCallback);
  }
  
  public void searchChannelMemberFromServer(long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, IGProSearchMemberFromServerCallback paramIGProSearchMemberFromServerCallback)
  {
    native_searchChannelMemberFromServer(this.nativeRef, paramLong1, paramLong2, paramString, paramInt, paramLong3, paramIGProSearchMemberFromServerCallback);
  }
  
  public void searchGuildByShowNumber(String paramString1, int paramInt1, int paramInt2, String paramString2, IGProSearchGuildCallback paramIGProSearchGuildCallback)
  {
    native_searchGuildByShowNumber(this.nativeRef, paramString1, paramInt1, paramInt2, paramString2, paramIGProSearchGuildCallback);
  }
  
  public void searchMemberFromServer(long paramLong1, String paramString, int paramInt, long paramLong2, IGProSearchMemberFromServerCallback paramIGProSearchMemberFromServerCallback)
  {
    native_searchMemberFromServer(this.nativeRef, paramLong1, paramString, paramInt, paramLong2, paramIGProSearchMemberFromServerCallback);
  }
  
  public void setAddGuildOption(long paramLong, int paramInt, String paramString1, String paramString2, IGProResultCallback paramIGProResultCallback)
  {
    native_setAddGuildOption(this.nativeRef, paramLong, paramInt, paramString1, paramString2, paramIGProResultCallback);
  }
  
  public void setAudioChannelUserLimit(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_setAudioChannelUserLimit(this.nativeRef, paramLong1, paramLong2, paramInt, paramIGProResultCallback);
  }
  
  public void setChannelBannedSpeak(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_setChannelBannedSpeak(this.nativeRef, paramLong1, paramLong2, paramInt, paramIGProResultCallback);
  }
  
  public void setChannelCategoryInfoWithId(long paramLong, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback)
  {
    native_setChannelCategoryInfoWithId(this.nativeRef, paramLong, paramGProCategoryChannelIdList, paramArrayList, paramIGProSetChannelCategoryInfoCallback);
  }
  
  public void setChannelCategoryOrderWithId(long paramLong, ArrayList<Long> paramArrayList, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback)
  {
    native_setChannelCategoryOrderWithId(this.nativeRef, paramLong, paramArrayList, paramIGProSetChannelCategoryInfoCallback);
  }
  
  public void setChannelCategoryWithId(long paramLong1, long paramLong2, long paramLong3, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback)
  {
    native_setChannelCategoryWithId(this.nativeRef, paramLong1, paramLong2, paramLong3, paramIGProSetChannelCategoryInfoCallback);
  }
  
  public void setChannelMsgNotifyType(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_setChannelMsgNotifyType(this.nativeRef, paramLong1, paramLong2, paramInt, paramIGProResultCallback);
  }
  
  public void setChannelName(long paramLong1, long paramLong2, String paramString, IGProResultCallback paramIGProResultCallback)
  {
    native_setChannelName(this.nativeRef, paramLong1, paramLong2, paramString, paramIGProResultCallback);
  }
  
  public void setChannelSpeakerPerm(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_setChannelSpeakerPerm(this.nativeRef, paramLong1, paramLong2, paramInt, paramIGProResultCallback);
  }
  
  public void setChannelVisible(long paramLong1, long paramLong2, int paramInt, ArrayList<Long> paramArrayList, IGProResultCallback paramIGProResultCallback)
  {
    native_setChannelVisible(this.nativeRef, paramLong1, paramLong2, paramInt, paramArrayList, paramIGProResultCallback);
  }
  
  public void setChannelVisibleMembers(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, IGProResultCallback paramIGProResultCallback)
  {
    native_setChannelVisibleMembers(this.nativeRef, paramLong1, paramLong2, paramArrayList1, paramArrayList2, paramIGProResultCallback);
  }
  
  public void setFocusChannel(ArrayList<GProFocusChannelReqInfo> paramArrayList, IGProResultCallback paramIGProResultCallback)
  {
    native_setFocusChannel(this.nativeRef, paramArrayList, paramIGProResultCallback);
  }
  
  public void setGuildAdmin(long paramLong1, long paramLong2, boolean paramBoolean, IGProSetGuildAdminResultCallback paramIGProSetGuildAdminResultCallback)
  {
    native_setGuildAdmin(this.nativeRef, paramLong1, paramLong2, paramBoolean, paramIGProSetGuildAdminResultCallback);
  }
  
  public void setGuildClientId(long paramLong, int paramInt, IGProSetGuildClientIdCallback paramIGProSetGuildClientIdCallback)
  {
    native_setGuildClientId(this.nativeRef, paramLong, paramInt, paramIGProSetGuildClientIdCallback);
  }
  
  public void setGuildMemberName(long paramLong, String paramString, IGProResultCallback paramIGProResultCallback)
  {
    native_setGuildMemberName(this.nativeRef, paramLong, paramString, paramIGProResultCallback);
  }
  
  public void setGuildName(long paramLong, String paramString, IGProResultCallback paramIGProResultCallback)
  {
    native_setGuildName(this.nativeRef, paramLong, paramString, paramIGProResultCallback);
  }
  
  public void setGuildProfile(long paramLong, String paramString, IGProResultCallback paramIGProResultCallback)
  {
    native_setGuildProfile(this.nativeRef, paramLong, paramString, paramIGProResultCallback);
  }
  
  public void setGuildTop(long paramLong, boolean paramBoolean, IGProResultCallback paramIGProResultCallback)
  {
    native_setGuildTop(this.nativeRef, paramLong, paramBoolean, paramIGProResultCallback);
  }
  
  public void setLiveChannelAnchorList(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, IGProResultCallback paramIGProResultCallback)
  {
    native_setLiveChannelAnchorList(this.nativeRef, paramLong1, paramLong2, paramArrayList1, paramArrayList2, paramIGProResultCallback);
  }
  
  public void setLiveChannelBannedUser(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, IGProResultCallback paramIGProResultCallback)
  {
    native_setLiveChannelBannedUser(this.nativeRef, paramLong1, paramLong2, paramLong3, paramLong4, paramInt, paramIGProResultCallback);
  }
  
  public void setMemberClientIdentityForMsg(long paramLong1, long paramLong2, GProClientIdentity paramGProClientIdentity, long paramLong3)
  {
    native_setMemberClientIdentityForMsg(this.nativeRef, paramLong1, paramLong2, paramGProClientIdentity, paramLong3);
  }
  
  public void setMemberNameForMsg(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    native_setMemberNameForMsg(this.nativeRef, paramLong1, paramLong2, paramString1, paramString2, paramLong3);
  }
  
  public void setOnLogin()
  {
    native_setOnLogin(this.nativeRef);
  }
  
  public void setSelfTinyId(long paramLong)
  {
    native_setSelfTinyId(this.nativeRef, paramLong);
  }
  
  public void setShowArchive(int paramInt, boolean paramBoolean, IGProSwitchPresenceArchiveCallback paramIGProSwitchPresenceArchiveCallback)
  {
    native_setShowArchive(this.nativeRef, paramInt, paramBoolean, paramIGProSwitchPresenceArchiveCallback);
  }
  
  public void setShowPresence(int paramInt, boolean paramBoolean, IGProSwitchPresenceArchiveCallback paramIGProSwitchPresenceArchiveCallback)
  {
    native_setShowPresence(this.nativeRef, paramInt, paramBoolean, paramIGProSwitchPresenceArchiveCallback);
  }
  
  public void setUIData(String paramString1, String paramString2)
  {
    native_setUIData(this.nativeRef, paramString1, paramString2);
  }
  
  public void setUserMuteSeatInGuild(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, IGProResultCallback paramIGProResultCallback)
  {
    native_setUserMuteSeatInGuild(this.nativeRef, paramLong1, paramLong2, paramLong3, paramBoolean, paramIGProResultCallback);
  }
  
  public void setUserVoicelessToMe(long paramLong, boolean paramBoolean, IGProResultCallback paramIGProResultCallback)
  {
    native_setUserVoicelessToMe(this.nativeRef, paramLong, paramBoolean, paramIGProResultCallback);
  }
  
  public void start(long paramLong, GProSessionConfig paramGProSessionConfig)
  {
    native_start(this.nativeRef, paramLong, paramGProSessionConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.IGProSdkWrapper.CppProxy
 * JD-Core Version:    0.7.0.1
 */