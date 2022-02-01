package com.tencent.avcore.engine.dav;

public abstract interface IDavEventListener
{
  public abstract void checkNetStatus();
  
  public abstract void dataTransferred(int paramInt, long paramLong);
  
  public abstract int getAPAndGateWayIP();
  
  public abstract long getMSFInviteMessageTimeStamp(long paramLong);
  
  public abstract int isOfflineSession(String paramString);
  
  public abstract void onAVShiftEvent(int paramInt, String paramString);
  
  public abstract void onAcceptVideoMode(String paramString);
  
  public abstract void onAcceptedVideo(String paramString);
  
  public abstract void onAnotherHaveAccept(String paramString);
  
  public abstract void onAnotherHaveReject(String paramString);
  
  public abstract void onAnotherIsRing(String paramString, boolean paramBoolean);
  
  public abstract void onAudioVolumeChange(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onAvReqAutoAccept(String paramString);
  
  public abstract void onCancelRequest(String paramString);
  
  public abstract void onCancelVideoMode(String paramString);
  
  public abstract void onChangePreviewSize(int paramInt1, int paramInt2);
  
  public abstract void onChannelReady(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong);
  
  public abstract void onCloseVideo(String paramString, int paramInt, long paramLong);
  
  public abstract void onConfigSysDealDone(String paramString);
  
  public abstract void onDetectAudioDataIssue(int paramInt);
  
  public abstract void onFpsChange(int paramInt);
  
  public abstract void onGroundGlassSwitch(String paramString, int paramInt);
  
  public abstract void onGroundGlassWaitTimeChange(String paramString, int paramInt);
  
  public abstract void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  public abstract void onMediaCameraNotify(byte[] paramArrayOfByte, long paramLong);
  
  public abstract void onNeedShowPeerVideo(String paramString);
  
  public abstract void onNetLevel_S2C(String paramString, long paramLong, byte[] paramArrayOfByte);
  
  public abstract void onNetworkDisconnect(String paramString);
  
  public abstract void onNetworkInfo_S2C(String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void onNetworkMonitorInfo(String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void onNetworkQualityChanged(int paramInt);
  
  public abstract void onNotRecvAudioData(boolean paramBoolean);
  
  public abstract void onNotifyAIDenoiseTips(boolean paramBoolean);
  
  public abstract void onOtherTerminalChatingStatus(String paramString, long paramLong, int paramInt);
  
  public abstract void onPauseAudio(String paramString);
  
  public abstract void onPauseVideo(String paramString);
  
  public abstract void onPeerSwitchTerminal(String paramString, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void onPeerSwitchTerminalFail(String paramString, int paramInt);
  
  public abstract void onPstnCallConnected(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  public abstract void onRecordAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void onRecvFirstAudioData(boolean paramBoolean);
  
  public abstract void onRejectVideo(String paramString);
  
  public abstract void onRejectVideoMode(String paramString);
  
  public abstract void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3);
  
  public abstract void onRequestVideoMode(String paramString);
  
  public abstract void onResumeAudio(String paramString);
  
  public abstract void onResumeVideo(String paramString);
  
  public abstract void onSDKCustomCommand(String paramString, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onSendC2CMsg(String paramString);
  
  public abstract void onSwitchGroup(String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void onSwitchMeeting(String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void onSwitchTerminalSuccess(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, long paramLong);
  
  public abstract void onSyncOtherTerminalChatStatus(String paramString, int paramInt);
  
  public abstract void receiveTransferMsg(String paramString, int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.dav.IDavEventListener
 * JD-Core Version:    0.7.0.1
 */