package com.tencent.mobileqq.activity.aio;

import aelc;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class AudioPlayer$2
  extends TimerTask
{
  AudioPlayer$2(AudioPlayer paramAudioPlayer) {}
  
  public void run()
  {
    if (AudioPlayer.a(this.this$0) != null) {}
    try
    {
      AudioPlayer.a(this.this$0).d(this.this$0, this.this$0.b());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, "startProgressTimer e= " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */