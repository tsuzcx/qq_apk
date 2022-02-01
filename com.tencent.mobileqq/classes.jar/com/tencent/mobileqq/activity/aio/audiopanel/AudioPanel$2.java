package com.tencent.mobileqq.activity.aio.audiopanel;

import afyb;
import com.tencent.qphone.base.util.QLog;

class AudioPanel$2
  implements Runnable
{
  AudioPanel$2(AudioPanel paramAudioPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "playAnimRunable isEnabled():" + this.this$0.isEnabled() + " mCurAnimType=" + AudioPanel.a(this.this$0));
    }
    if (this.this$0.isEnabled()) {
      afyb.a().a(AudioPanel.a(this.this$0), AudioPanel.a(this.this$0), AudioPanel.a(this.this$0), AudioPanel.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel.2
 * JD-Core Version:    0.7.0.1
 */