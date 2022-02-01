package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.util.Set;

class AudioTransitionAnimManager$1
  implements Runnable
{
  AudioTransitionAnimManager$1(AudioTransitionAnimManager paramAudioTransitionAnimManager, String paramString, Context paramContext, int paramInt) {}
  
  public void run()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(AudioTransitionAnimManager.b + this.jdField_a_of_type_JavaLangString + "data.json");
      AudioTransitionAnimManager.a(this.this$0, LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_AndroidContentContext, localFileInputStream, new AudioTransitionAnimManager.1.1(this)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AudioTransitionAnimManager", 1, "loadVoiceAnimation fail.", localThrowable);
      AudioTransitionAnimManager.a(this.this$0).remove(Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1
 * JD-Core Version:    0.7.0.1
 */