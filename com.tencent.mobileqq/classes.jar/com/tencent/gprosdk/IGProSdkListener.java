package com.tencent.gprosdk;

import java.util.ArrayList;
import java.util.HashMap;

public abstract interface IGProSdkListener
{
  public abstract void onBatchGetUserAvatarUrl(ArrayList<GProAvatarInfo> paramArrayList);
  
  public abstract void onBatchGuildMemberNameUpdate(long paramLong, ArrayList<GProMemberNickNameInfo> paramArrayList);
  
  public abstract void onBatchGuildUserNickUpdate(ArrayList<GProMemberNickNameInfo> paramArrayList);
  
  public abstract void onChannelInfoUpdated(int paramInt, String paramString, GProChannel paramGProChannel);
  
  public abstract void onChannelListUpdated(int paramInt, String paramString, long paramLong, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList);
  
  public abstract void onGetGuildUserAvatarUrl(long paramLong1, String paramString, int paramInt, long paramLong2);
  
  public abstract void onGetSelfTinyId(long paramLong);
  
  public abstract long onGetSrvCalTime();
  
  public abstract void onGuildInfoUpdated(int paramInt, String paramString, GProGuild paramGProGuild, boolean paramBoolean);
  
  public abstract void onGuildListUpdated(int paramInt, String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList, ArrayList<GProGuild> paramArrayList1);
  
  public abstract void onGuildMemberClientIdentityUpdate(long paramLong1, long paramLong2, GProClientIdentity paramGProClientIdentity);
  
  public abstract void onGuildMemberNameUpdate(long paramLong1, long paramLong2, String paramString);
  
  public abstract void onGuildUserNickUpdate(long paramLong, String paramString);
  
  public abstract void onLog(int paramInt, String paramString);
  
  public abstract void onMemberCountUpdate(GProGuildMemberCountInfo paramGProGuildMemberCountInfo);
  
  public abstract void onNoticeListUpdate(GProNoticeRedPoint paramGProNoticeRedPoint, byte[] paramArrayOfByte);
  
  public abstract void onPushAdminChanged(long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3);
  
  public abstract void onPushAudioChannelUserEnter(long paramLong1, long paramLong2, GProUser paramGProUser);
  
  public abstract void onPushAudioChannelUserExit(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onPushAudioChannelUserPlatSwitch(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2);
  
  public abstract void onPushChannelCategoryChanged(GProGuildInit paramGProGuildInit);
  
  public abstract void onPushChannelCreated(long paramLong1, long paramLong2, GProGuildInit paramGProGuildInit);
  
  public abstract void onPushChannelDestroy(long paramLong1, ArrayList<Long> paramArrayList, long paramLong2);
  
  public abstract void onPushChannelVisibleChanged(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract void onPushCreateGuild(long paramLong, GProGuild paramGProGuild, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList);
  
  public abstract void onPushDestroyGuild(long paramLong);
  
  public abstract void onPushJoinChannel(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList);
  
  public abstract void onPushJoinGuild(long paramLong1, long paramLong2, long paramLong3, int paramInt, GProGuild paramGProGuild, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList);
  
  public abstract void onPushKickOffGuild(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  public abstract void onPushKickOutAudioChannel(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, String paramString);
  
  public abstract void onPushLeaveChannel(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList);
  
  public abstract void onPushLiveChannelAnchorIdentityChange(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void onPushLiveRoomStatusChangeMsg(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt);
  
  public abstract void onPushMsgRecvTypeChanged(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  public abstract void onPushQuitGuild(long paramLong1, long paramLong2);
  
  public abstract void onPushSelfBannedSpeakChange(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  public abstract void onPushSetUserVoicelessToMe(long paramLong, boolean paramBoolean);
  
  public abstract void onPushSwitchLiveRoom(long paramLong1, long paramLong2, ArrayList<GProMember> paramArrayList, int paramInt);
  
  public abstract void onPushUserMuteSeatInGuild(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void onRefreshGuildUserProfileInfo(int paramInt, String paramString, long paramLong1, long paramLong2, GProGuildUserProfile paramGProGuildUserProfile);
  
  public abstract void onSecurityError(long paramLong, int paramInt);
  
  public abstract void onSendPbRequest(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onSendSSORequest(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  public abstract void onUserListFetchFinish(int paramInt, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.IGProSdkListener
 * JD-Core Version:    0.7.0.1
 */