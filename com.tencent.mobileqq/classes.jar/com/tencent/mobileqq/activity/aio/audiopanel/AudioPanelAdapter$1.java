package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Build;
import android.view.LayoutInflater;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.qphone.base.util.QLog;

class AudioPanelAdapter$1
  implements Runnable
{
  AudioPanelAdapter$1(AudioPanelAdapter paramAudioPanelAdapter) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      try
      {
        ListenChangeVoicePanel localListenChangeVoicePanel = (ListenChangeVoicePanel)LayoutInflater.from(AudioPanelAdapter.a(this.this$0).getApp()).inflate(2131627264, null);
        if (this.this$0.c == null) {
          this.this$0.c = localListenChangeVoicePanel;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("inflate ListenPanel on subthread get exception ");
          localStringBuilder.append(localException);
          localStringBuilder.append(" model=");
          localStringBuilder.append(Build.MANUFACTURER);
          localStringBuilder.append(Build.MODEL);
          QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
        }
      }
    }
    AudioPanelAdapter.a(this.this$0).getRuntimeService(IPttPreSendService.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */