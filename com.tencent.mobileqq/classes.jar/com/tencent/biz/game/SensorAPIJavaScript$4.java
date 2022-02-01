package com.tencent.biz.game;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;

class SensorAPIJavaScript$4
  implements Runnable
{
  SensorAPIJavaScript$4(SensorAPIJavaScript paramSensorAPIJavaScript, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play failure url=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("SensorApi", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.4
 * JD-Core Version:    0.7.0.1
 */