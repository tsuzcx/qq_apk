package com.tencent.TMG.audio;

class AudioDeviceInterface$2
  implements TraeAudioSession.ITraeAudioCallback
{
  AudioDeviceInterface$2(AudioDeviceInterface paramAudioDeviceInterface) {}
  
  public void onAudioRouteSwitchEnd(String paramString, long paramLong) {}
  
  public void onAudioRouteSwitchStart(String paramString1, String paramString2) {}
  
  public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void onDeviceChangabledUpdate(boolean paramBoolean) {}
  
  public void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (AudioDeviceInterface.access$300(this.this$0)) {
      AudioDeviceInterface.access$400(this.this$0, paramString1);
    }
  }
  
  public void onGetConnectedDeviceRes(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AudioDeviceInterface.access$400(this.this$0, paramString);
    }
  }
  
  public void onGetConnectingDeviceRes(int paramInt, String paramString) {}
  
  public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void onGetStreamTypeRes(int paramInt1, int paramInt2) {}
  
  public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
  
  public void onRingCompletion(int paramInt, String paramString) {}
  
  public void onServiceStateUpdate(boolean paramBoolean) {}
  
  public void onStreamTypeUpdate(int paramInt) {}
  
  public void onVoicecallPreprocessRes(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.AudioDeviceInterface.2
 * JD-Core Version:    0.7.0.1
 */