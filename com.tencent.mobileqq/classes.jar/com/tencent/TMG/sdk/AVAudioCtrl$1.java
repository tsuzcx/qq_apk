package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.audio.TraeAudioSession;
import com.tencent.TMG.audio.TraeAudioSession.ITraeAudioCallback;

class AVAudioCtrl$1
  implements TraeAudioSession.ITraeAudioCallback
{
  AVAudioCtrl$1(AVAudioCtrl paramAVAudioCtrl) {}
  
  public void onAudioRouteSwitchEnd(String paramString, long paramLong) {}
  
  public void onAudioRouteSwitchStart(String paramString1, String paramString2) {}
  
  public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean)
  {
    Log.e("SdkJni", "onConnectDeviceRes" + paramString);
    if ((paramInt != 0) || (!paramBoolean)) {}
    while (!paramBoolean) {
      return;
    }
    AVAudioCtrl.access$002(this.this$0, paramString);
  }
  
  public void onDeviceChangabledUpdate(boolean paramBoolean) {}
  
  public void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    Log.e("SdkJni", "Connect Device:" + paramString1);
    AVAudioCtrl.access$002(this.this$0, paramString1);
    AVAudioCtrl.access$102(this.this$0, paramArrayOfString);
    if (AVAudioCtrl.access$200(this.this$0) != null)
    {
      paramArrayOfString = AVAudioCtrl.access$200(this.this$0);
      if (!AVAudioCtrl.access$000(this.this$0).endsWith("DEVICE_SPEAKERPHONE")) {
        break label151;
      }
    }
    label151:
    for (int i = 1;; i = 0)
    {
      paramArrayOfString.onOutputModeChange(i);
      if (!AVAudioCtrl.access$300(this.this$0).equals("DEVICE_NONE"))
      {
        Log.e("SdkJni", "!mAudioStateBeforePhoneCall.equals(TraeAudioManager.DEVICE_NONE");
        if (!paramString1.equals(AVAudioCtrl.access$300(this.this$0))) {
          AVAudioCtrl.access$400(this.this$0).connectDevice(AVAudioCtrl.access$300(this.this$0));
        }
        AVAudioCtrl.access$302(this.this$0, "DEVICE_NONE");
      }
      return;
    }
  }
  
  public void onGetConnectedDeviceRes(int paramInt, String paramString)
  {
    Log.e("SdkJni", "onGetConnectedDeviceRes" + paramString);
  }
  
  public void onGetConnectingDeviceRes(int paramInt, String paramString)
  {
    Log.e("SdkJni", "onGetConnectingDeviceRes" + paramString);
  }
  
  public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    Log.e("SdkJni", "onGetDeviceListRes" + paramString1);
    if (paramInt != 0) {
      return;
    }
    AVAudioCtrl.access$102(this.this$0, paramArrayOfString);
    AVAudioCtrl.access$002(this.this$0, paramString1);
  }
  
  public void onGetStreamTypeRes(int paramInt1, int paramInt2)
  {
    AVAudioCtrl.access$502(this.this$0, paramInt2);
  }
  
  public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
  
  public void onRingCompletion(int paramInt, String paramString) {}
  
  public void onServiceStateUpdate(boolean paramBoolean) {}
  
  public void onStreamTypeUpdate(int paramInt)
  {
    AVAudioCtrl.access$502(this.this$0, paramInt);
  }
  
  public void onVoicecallPreprocessRes(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.1
 * JD-Core Version:    0.7.0.1
 */