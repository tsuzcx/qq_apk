package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Build;
import android.view.LayoutInflater;
import audi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class AudioPanelAdapter$1
  implements Runnable
{
  AudioPanelAdapter$1(AudioPanelAdapter paramAudioPanelAdapter) {}
  
  public void run()
  {
    if (this.this$0.b == null) {}
    try
    {
      ListenChangeVoicePanel localListenChangeVoicePanel = (ListenChangeVoicePanel)LayoutInflater.from(AudioPanelAdapter.a(this.this$0).getApp()).inflate(2131495038, null);
      if (this.this$0.b == null) {
        this.this$0.b = localListenChangeVoicePanel;
      }
      audi.a(AudioPanelAdapter.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "inflate ListenPanel on subthread get exception " + localException + " model=" + Build.MANUFACTURER + Build.MODEL);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */