package com.tencent.TMG.wrapper;

import com.tencent.TMG.audio.TraeAudioSession.ITraeAudioCallback;

class AudioRouteMgr$1
  implements TraeAudioSession.ITraeAudioCallback
{
  AudioRouteMgr$1(AudioRouteMgr paramAudioRouteMgr) {}
  
  public void onAudioRouteSwitchEnd(String paramString, long paramLong) {}
  
  public void onAudioRouteSwitchStart(String paramString1, String paramString2) {}
  
  public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void onDeviceChangabledUpdate(boolean paramBoolean) {}
  
  public void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AudioRouteMgr.access$000(this.this$0, paramString1);
  }
  
  public void onGetConnectedDeviceRes(int paramInt, String paramString) {}
  
  public void onGetConnectingDeviceRes(int paramInt, String paramString) {}
  
  public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void onGetStreamTypeRes(int paramInt1, int paramInt2) {}
  
  public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
  
  public void onRingCompletion(int paramInt, String paramString) {}
  
  public void onServiceStateUpdate(boolean paramBoolean) {}
  
  public void onStreamTypeUpdate(int paramInt) {}
  
  public void onVoicecallPreprocessRes(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.wrapper.AudioRouteMgr.1
 * JD-Core Version:    0.7.0.1
 */