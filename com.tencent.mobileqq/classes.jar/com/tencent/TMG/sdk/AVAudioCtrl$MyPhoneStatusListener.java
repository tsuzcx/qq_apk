package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.audio.TraeAudioSession;
import com.tencent.TMG.utils.PhoneStatusMonitor.PhoneStatusListener;

class AVAudioCtrl$MyPhoneStatusListener
  implements PhoneStatusMonitor.PhoneStatusListener
{
  AVAudioCtrl$MyPhoneStatusListener(AVAudioCtrl paramAVAudioCtrl) {}
  
  public void onCallStateChanged(boolean paramBoolean)
  {
    if (AVAudioCtrl.access$600(this.this$0)) {
      Log.e("SdkJni", "onCallStateChanged isSystemApp return");
    }
    do
    {
      do
      {
        do
        {
          return;
          Log.e("SdkJni", "onCallStateChanged isCalling: " + paramBoolean);
          this.this$0.mIsCalling = paramBoolean;
          if (!paramBoolean) {
            break;
          }
        } while (this.this$0.mIsPauseByUser);
        this.this$0.pauseAudio();
        Log.e("SdkJni", "MyPhoneStatusListener iscalling ");
      } while (AVAudioCtrl.access$400(this.this$0) == null);
      Log.e("SdkJni", "MyPhoneStatusListener stopService ");
      AVAudioCtrl.access$400(this.this$0).stopService();
      return;
      Log.e("SdkJni", "MyPhoneStatusListener notcalling ");
    } while (this.this$0.mIsPauseByUser);
    if (AVAudioCtrl.access$400(this.this$0) != null)
    {
      AVAudioCtrl.access$400(this.this$0).startService(AVAudioCtrl.access$700(this.this$0));
      Log.e("SdkJni", "MyPhoneStatusListener startService ");
    }
    this.this$0.resumeAudio();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.MyPhoneStatusListener
 * JD-Core Version:    0.7.0.1
 */