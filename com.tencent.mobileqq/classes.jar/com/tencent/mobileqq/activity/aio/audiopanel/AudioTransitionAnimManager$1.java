package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

class AudioTransitionAnimManager$1
  implements Runnable
{
  AudioTransitionAnimManager$1(AudioTransitionAnimManager paramAudioTransitionAnimManager, String paramString, Context paramContext, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AudioTransitionAnimManager.b);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("data.json");
      localObject = new FileInputStream(((StringBuilder)localObject).toString());
      AudioTransitionAnimManager.a(this.this$0, LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_AndroidContentContext, (InputStream)localObject, new AudioTransitionAnimManager.1.1(this)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AudioTransitionAnimManager", 1, "loadVoiceAnimation fail.", localThrowable);
      AudioTransitionAnimManager.a(this.this$0).remove(Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1
 * JD-Core Version:    0.7.0.1
 */