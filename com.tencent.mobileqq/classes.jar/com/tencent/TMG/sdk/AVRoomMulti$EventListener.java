package com.tencent.TMG.sdk;

public abstract interface AVRoomMulti$EventListener
{
  public abstract void onCameraSettingNotify(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onDisableAudioIssue();
  
  public abstract void onEndpointsUpdateInfo(int paramInt, String[] paramArrayOfString);
  
  public abstract void onEnterRoomComplete(int paramInt, String paramString);
  
  public abstract void onExitRoomComplete();
  
  public abstract void onHwStateChangeNotify(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString);
  
  public abstract void onPrivilegeDiffNotify(int paramInt);
  
  public abstract void onRecvCustomData(AVRoomMulti.AVCustomData paramAVCustomData, String paramString);
  
  public abstract void onRoomDisconnect(int paramInt, String paramString);
  
  public abstract void onRoomEvent(int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void onSemiAutoRecvCameraVideo(String[] paramArrayOfString);
  
  public abstract void onSemiAutoRecvMediaFileVideo(String[] paramArrayOfString);
  
  public abstract void onSemiAutoRecvScreenVideo(String[] paramArrayOfString);
  
  public abstract void onSwitchRoomComplete(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti.EventListener
 * JD-Core Version:    0.7.0.1
 */