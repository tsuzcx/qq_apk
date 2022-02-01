package com.tencent.gprosdk;

import java.util.ArrayList;

public abstract interface IGProSdkWrapper
{
  public abstract void LoadGuildUserProfileInfo(long paramLong1, long paramLong2, IGProLoadGuildUserProfileCallback paramIGProLoadGuildUserProfileCallback);
  
  public abstract void addGuild(long paramLong, GProSourceId paramGProSourceId, String paramString, IGProResultCallback paramIGProResultCallback);
  
  public abstract void addGuildWithOption(long paramLong, GProSourceId paramGProSourceId, String paramString1, String paramString2, String paramString3, IGProResultCallback paramIGProResultCallback);
  
  public abstract void addGuildWithSource(long paramLong, GProSourceId paramGProSourceId, String paramString, GProSourceInfo paramGProSourceInfo, IGProResultCallback paramIGProResultCallback);
  
  public abstract void appAuthorization(int paramInt, IGProAppAuthorization paramIGProAppAuthorization);
  
  public abstract void batchFetchAudioChannelSimpleUserList(long paramLong, ArrayList<Long> paramArrayList, boolean paramBoolean, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback);
  
  public abstract void bindAppRole(int paramInt1, String paramString, int paramInt2, IGProBindAppRole paramIGProBindAppRole);
  
  public abstract void changeChannelCategoryNameWithId(long paramLong1, long paramLong2, String paramString, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  public abstract void checkSelfRealNameVerified(IGProCheckSelfRealNameVerifiedCallback paramIGProCheckSelfRealNameVerifiedCallback);
  
  public abstract void checkUserBannedSpeakInChannel(long paramLong1, long paramLong2, long paramLong3, IGProCheckUserBannedSpeakInChannelCallback paramIGProCheckUserBannedSpeakInChannelCallback);
  
  public abstract void clearNoticeRedPoint(int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void close();
  
  public abstract void createChannelCategoryWithId(long paramLong, String paramString, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  public abstract void createChannelWithId(long paramLong1, GProChannelCreateInfo paramGProChannelCreateInfo, long paramLong2, IGProCreateChannelCallback paramIGProCreateChannelCallback);
  
  public abstract void customChannelMsgNotifyType(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void dealNotice(String paramString1, String paramString2, IGProDealNoticeCallback paramIGProDealNoticeCallback);
  
  public abstract void destroyGuild(long paramLong, IGProResultCallback paramIGProResultCallback);
  
  public abstract void enterAudioChannel(long paramLong1, long paramLong2, int paramInt, IGProEnterAudioChannelCallback paramIGProEnterAudioChannelCallback);
  
  public abstract void exitAudioChannel(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback);
  
  public abstract void fetchAddGuildOption(long paramLong, IGProFetchAddGuildOptionCallback paramIGProFetchAddGuildOptionCallback);
  
  public abstract void fetchAppChnnPreInfoList(ArrayList<GProAppChnnPreFetchInfo> paramArrayList, boolean paramBoolean, IGProFetchAppChnnPreInfoListCallback paramIGProFetchAppChnnPreInfoListCallback);
  
  public abstract void fetchAppInfoList(IGProFetchAppInfoListCallback paramIGProFetchAppInfoListCallback);
  
  public abstract void fetchAudioChannelUserList(long paramLong1, long paramLong2, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback);
  
  public abstract void fetchChannelInfo(long paramLong1, long paramLong2, IGProFetchChannelInfoCallback paramIGProFetchChannelInfoCallback);
  
  public abstract void fetchChannelList(ArrayList<Long> paramArrayList, IGProFetchChannelListCategoryCallback paramIGProFetchChannelListCategoryCallback);
  
  public abstract void fetchChannelListForGuest(ArrayList<Long> paramArrayList, IGProFetchChannelListForGuestCallback paramIGProFetchChannelListForGuestCallback);
  
  public abstract void fetchChannelMemberList(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProFetchChannelMemberListCallback paramIGProFetchChannelMemberListCallback);
  
  public abstract void fetchEnterChannelPermission(long paramLong1, long paramLong2, IGProFetchEnterChannelPermissionCallback paramIGProFetchEnterChannelPermissionCallback);
  
  public abstract void fetchGuestGuild(long paramLong, IGProFetchGuestGuildCallback paramIGProFetchGuestGuildCallback);
  
  public abstract void fetchGuildInfo(long paramLong, IGProFetchGuildInfoCallback paramIGProFetchGuildInfoCallback);
  
  public abstract void fetchGuildInfoByAppIdentity(GProGuildIdentity paramGProGuildIdentity, String paramString1, String paramString2, IGProFetchGuildInfoByAppIdentityCallback paramIGProFetchGuildInfoByAppIdentityCallback);
  
  public abstract void fetchGuildInfoForGuest(long paramLong, IGProFetchGuildInfoCallback paramIGProFetchGuildInfoCallback);
  
  public abstract void fetchGuildList(ArrayList<GProGuildReqInfo> paramArrayList, byte[] paramArrayOfByte, IGProFetchGuildListCallback paramIGProFetchGuildListCallback);
  
  public abstract void fetchInviteInfo(String paramString, IGProFetchInviteInfoCallback paramIGProFetchInviteInfoCallback);
  
  public abstract void fetchIsLiveChannelOpen(long paramLong, IGProFetchIsLiveChannelOpenCallback paramIGProFetchIsLiveChannelOpenCallback);
  
  public abstract void fetchIsVoiceChannelOpen(long paramLong, IGProFetchIsVoiceChannelOpenCallback paramIGProFetchIsVoiceChannelOpenCallback);
  
  public abstract void fetchLiveChannelAnchorList(long paramLong1, long paramLong2, IGProFetchLiveChannelAnchorListCallback paramIGProFetchLiveChannelAnchorListCallback);
  
  public abstract void fetchLiveChannelBannedUserList(long paramLong1, long paramLong2, long paramLong3, IGProFetchBannedUserListCallback paramIGProFetchBannedUserListCallback);
  
  public abstract void fetchLiveRoomInfoByChannelIds(long paramLong, ArrayList<Long> paramArrayList, IGProFetchLiveChannelInfoListCallback paramIGProFetchLiveChannelInfoListCallback);
  
  public abstract void fetchLiveRoomInfoByRoomIds(ArrayList<Long> paramArrayList, IGProFetchLiveChannelInfoListCallback paramIGProFetchLiveChannelInfoListCallback);
  
  public abstract void fetchLiveSecurityTips(IGProFetchLiveSecurityTipsCallback paramIGProFetchLiveSecurityTipsCallback);
  
  public abstract void fetchNoticeRedPoint(ArrayList<Integer> paramArrayList, IGProFetchNoticeRedPointCallback paramIGProFetchNoticeRedPointCallback);
  
  public abstract void fetchRemainAtAllCount(long paramLong, IGProFetchRemainAtAllCountCallback paramIGProFetchRemainAtAllCountCallback);
  
  public abstract void fetchShareInfo(long paramLong1, long paramLong2, IGProFetchShareInfoCallback paramIGProFetchShareInfoCallback);
  
  public abstract void fetchUserInfo(long paramLong, ArrayList<Long> paramArrayList, IGProGetUserInfoCallback paramIGProGetUserInfoCallback);
  
  public abstract void fetchUserList(long paramLong1, long paramLong2, IGProGetUserListCallback paramIGProGetUserListCallback);
  
  public abstract void fetchVisibleMemberList(long paramLong1, long paramLong2, long paramLong3, int paramInt, IGProFetchVisibleMemberListCallback paramIGProFetchVisibleMemberListCallback);
  
  public abstract void fetchVisibleMemberListByTinyId(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProFetchVisibleMemberListByTinyIdCallback paramIGProFetchVisibleMemberListByTinyIdCallback);
  
  public abstract void getAppAuthorizationInfo(int paramInt1, int paramInt2, IGProGetAppAuthorizationInfo paramIGProGetAppAuthorizationInfo);
  
  public abstract void getAppRoleList(int paramInt, IGProGetAppRoleList paramIGProGetAppRoleList);
  
  public abstract void getClientInfoList(int paramInt, IGProGetClientInfoList paramIGProGetClientInfoList);
  
  public abstract void getGuildMemberClientIdentity(long paramLong, int paramInt, ArrayList<Long> paramArrayList);
  
  public abstract void getGuildMemberName(long paramLong, ArrayList<Long> paramArrayList);
  
  public abstract void getGuildUserAvatarUrl(ArrayList<Long> paramArrayList);
  
  public abstract void getGuildUsersNick(ArrayList<Long> paramArrayList);
  
  public abstract void getMoreNoticeList(int paramInt, IGProGetMoreNoticeListCallback paramIGProGetMoreNoticeListCallback);
  
  public abstract String getUIData(String paramString);
  
  public abstract void getUserList(long paramLong1, long paramLong2, boolean paramBoolean, IGProGetUserListCallback paramIGProGetUserListCallback);
  
  public abstract void initGetNoticeList(boolean paramBoolean, IGProInitGetNoticeListCallback paramIGProInitGetNoticeListCallback);
  
  public abstract void initGuildAndChannelListWithId(IGProLoadGuildAndChnListCallback paramIGProLoadGuildAndChnListCallback);
  
  public abstract void kickAudioChannelUsers(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, IGProKickChannelMemberCallback paramIGProKickChannelMemberCallback);
  
  public abstract void kickGuildUser(long paramLong, ArrayList<Long> paramArrayList, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  public abstract void loadAllMemberList(long paramLong1, long paramLong2, IGProLoadAllMemberListCallback paramIGProLoadAllMemberListCallback);
  
  public abstract void loadGuildAndChannelListWithId(IGProLoadGuildAndChnListCallback paramIGProLoadGuildAndChnListCallback);
  
  public abstract void loadNextPageMemberList(long paramLong1, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte, IGProLoadNextPageMemberListCallback paramIGProLoadNextPageMemberListCallback);
  
  public abstract void loadSimpleProfiles(int paramInt, IGProLoadGuildUserSimpleProfileCallback paramIGProLoadGuildUserSimpleProfileCallback);
  
  public abstract void loadUserInfo(long paramLong, ArrayList<Long> paramArrayList, IGProGetUserInfoCallback paramIGProGetUserInfoCallback);
  
  public abstract void loadUserList(long paramLong1, long paramLong2, IGProGetUserListCallback paramIGProGetUserListCallback);
  
  public abstract void onSendPbReply(long paramLong, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte);
  
  public abstract void onSendSSOReply(long paramLong, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte);
  
  public abstract boolean onServerPushMsg(int paramInt1, int paramInt2, GProMsgRouttingHead paramGProMsgRouttingHead, byte[] paramArrayOfByte);
  
  public abstract void queryApplyAddGuildStatus(long paramLong, IGProResultCallback paramIGProResultCallback);
  
  public abstract void queryTinyIdByLiveUID(ArrayList<Long> paramArrayList, IGProQueryTinyIdByLiveUIDCallback paramIGProQueryTinyIdByLiveUIDCallback);
  
  public abstract void refreshChannelInfo(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void refreshGuildInfo(long paramLong, boolean paramBoolean);
  
  public abstract void refreshGuildList(boolean paramBoolean);
  
  public abstract void refreshGuildUserProfileInfo(long paramLong1, long paramLong2);
  
  public abstract void removeChannel(long paramLong1, long paramLong2, IGProResultCallback paramIGProResultCallback);
  
  public abstract void removeChannelCategoryWithId(long paramLong1, long paramLong2, boolean paramBoolean, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  public abstract void removeGuild(long paramLong, IGProResultCallback paramIGProResultCallback);
  
  public abstract void reportShareInfo(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, IGProResultCallback paramIGProResultCallback);
  
  public abstract void requestBeginBroadcast(long paramLong1, long paramLong2, long paramLong3, IGProResultCallback paramIGProResultCallback);
  
  public abstract void searchChannelMemberFromServer(long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, IGProSearchMemberFromServerCallback paramIGProSearchMemberFromServerCallback);
  
  public abstract void searchGuildByShowNumber(String paramString1, int paramInt1, int paramInt2, String paramString2, IGProSearchGuildCallback paramIGProSearchGuildCallback);
  
  public abstract void searchMemberFromServer(long paramLong1, String paramString, int paramInt, long paramLong2, IGProSearchMemberFromServerCallback paramIGProSearchMemberFromServerCallback);
  
  public abstract void setAddGuildOption(long paramLong, int paramInt, String paramString1, String paramString2, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setAudioChannelUserLimit(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setChannelBannedSpeak(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setChannelCategoryInfoWithId(long paramLong, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  public abstract void setChannelCategoryOrderWithId(long paramLong, ArrayList<Long> paramArrayList, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  public abstract void setChannelCategoryWithId(long paramLong1, long paramLong2, long paramLong3, IGProSetChannelCategoryInfoCallback paramIGProSetChannelCategoryInfoCallback);
  
  public abstract void setChannelMsgNotifyType(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setChannelName(long paramLong1, long paramLong2, String paramString, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setChannelSpeakerPerm(long paramLong1, long paramLong2, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setChannelVisible(long paramLong1, long paramLong2, int paramInt, ArrayList<Long> paramArrayList, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setChannelVisibleMembers(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setFocusChannel(ArrayList<GProFocusChannelReqInfo> paramArrayList, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setGuildAdmin(long paramLong1, long paramLong2, boolean paramBoolean, IGProSetGuildAdminResultCallback paramIGProSetGuildAdminResultCallback);
  
  public abstract void setGuildClientId(long paramLong, int paramInt, IGProSetGuildClientIdCallback paramIGProSetGuildClientIdCallback);
  
  public abstract void setGuildMemberName(long paramLong, String paramString, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setGuildName(long paramLong, String paramString, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setGuildProfile(long paramLong, String paramString, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setGuildTop(long paramLong, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setLiveChannelAnchorList(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setLiveChannelBannedUser(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setMemberClientIdentityForMsg(long paramLong1, long paramLong2, GProClientIdentity paramGProClientIdentity, long paramLong3);
  
  public abstract void setMemberNameForMsg(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3);
  
  public abstract void setOnLogin();
  
  public abstract void setSelfTinyId(long paramLong);
  
  public abstract void setShowArchive(int paramInt, boolean paramBoolean, IGProSwitchPresenceArchiveCallback paramIGProSwitchPresenceArchiveCallback);
  
  public abstract void setShowPresence(int paramInt, boolean paramBoolean, IGProSwitchPresenceArchiveCallback paramIGProSwitchPresenceArchiveCallback);
  
  public abstract void setUIData(String paramString1, String paramString2);
  
  public abstract void setUserMuteSeatInGuild(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  public abstract void setUserVoicelessToMe(long paramLong, boolean paramBoolean, IGProResultCallback paramIGProResultCallback);
  
  public abstract void start(long paramLong, GProSessionConfig paramGProSessionConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.IGProSdkWrapper
 * JD-Core Version:    0.7.0.1
 */