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
    if (AVAudioCtrl.access$600(this.this$0))
    {
      Log.e("SdkJni", "onCallStateChanged isSystemApp return");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCallStateChanged isCalling: ");
    ((StringBuilder)localObject).append(paramBoolean);
    Log.e("SdkJni", ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    ((AVAudioCtrl)localObject).mIsCalling = paramBoolean;
    if (paramBoolean)
    {
      if (!((AVAudioCtrl)localObject).mIsPauseByUser)
      {
        this.this$0.pauseAudio();
        Log.e("SdkJni", "MyPhoneStatusListener iscalling ");
        if (AVAudioCtrl.access$400(this.this$0) != null)
        {
          Log.e("SdkJni", "MyPhoneStatusListener stopService ");
          AVAudioCtrl.access$400(this.this$0).stopService();
        }
      }
    }
    else
    {
      Log.e("SdkJni", "MyPhoneStatusListener notcalling ");
      if (!this.this$0.mIsPauseByUser)
      {
        if (AVAudioCtrl.access$400(this.this$0) != null)
        {
          AVAudioCtrl.access$400(this.this$0).startService(AVAudioCtrl.access$700(this.this$0));
          Log.e("SdkJni", "MyPhoneStatusListener startService ");
        }
        this.this$0.resumeAudio();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.MyPhoneStatusListener
 * JD-Core Version:    0.7.0.1
 */