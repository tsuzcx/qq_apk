package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.qphone.base.util.QLog;

class AudioPanel$2
  implements Runnable
{
  AudioPanel$2(AudioPanel paramAudioPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playAnimRunable isEnabled():");
      localStringBuilder.append(this.this$0.isEnabled());
      localStringBuilder.append(" mCurAnimType=");
      localStringBuilder.append(AudioPanel.a(this.this$0));
      QLog.d("AudioPanel", 2, localStringBuilder.toString());
    }
    if (this.this$0.isEnabled()) {
      AudioTransitionAnimManager.a().a(AudioPanel.b(this.this$0), AudioPanel.a(this.this$0), AudioPanel.c(this.this$0), AudioPanel.d(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel.2
 * JD-Core Version:    0.7.0.1
 */