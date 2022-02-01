package com.tencent.TMG.audio;

public abstract interface TraeAudioSession$ITraeAudioCallback
{
  public abstract void onAudioRouteSwitchEnd(String paramString, long paramLong);
  
  public abstract void onAudioRouteSwitchStart(String paramString1, String paramString2);
  
  public abstract void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onDeviceChangabledUpdate(boolean paramBoolean);
  
  public abstract void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
  
  public abstract void onGetConnectedDeviceRes(int paramInt, String paramString);
  
  public abstract void onGetConnectingDeviceRes(int paramInt, String paramString);
  
  public abstract void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
  
  public abstract void onGetStreamTypeRes(int paramInt1, int paramInt2);
  
  public abstract void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean);
  
  public abstract void onRingCompletion(int paramInt, String paramString);
  
  public abstract void onServiceStateUpdate(boolean paramBoolean);
  
  public abstract void onStreamTypeUpdate(int paramInt);
  
  public abstract void onVoicecallPreprocessRes(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioSession.ITraeAudioCallback
 * JD-Core Version:    0.7.0.1
 */