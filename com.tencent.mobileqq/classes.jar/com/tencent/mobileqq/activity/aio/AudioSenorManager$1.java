package com.tencent.mobileqq.activity.aio;

import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

class AudioSenorManager$1
  implements Runnable
{
  AudioSenorManager$1(AudioSenorManager paramAudioSenorManager) {}
  
  public void run()
  {
    if ((AudioSenorManager.a(this.this$0) == null) || (AudioSenorManager.b(this.this$0) != null)) {}
    try
    {
      AudioSenorManager.a(this.this$0).registerListener(AudioSenorManager.a(this.this$0), AudioSenorManager.b(this.this$0), 3);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          AudioSenorManager.a(this.this$0).registerListener(AudioSenorManager.a(this.this$0), AudioSenorManager.a(this.this$0), 3);
          if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SenorManager", 2, "$requestPlay| mAccelerationSensro=" + AudioSenorManager.b(this.this$0) + " | mProximitySensor = " + AudioSenorManager.a(this.this$0));
          }
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioSenorManager.1
 * JD-Core Version:    0.7.0.1
 */