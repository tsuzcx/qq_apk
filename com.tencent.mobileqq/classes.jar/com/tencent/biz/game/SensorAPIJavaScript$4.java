package com.tencent.biz.game;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;

class SensorAPIJavaScript$4
  implements Runnable
{
  SensorAPIJavaScript$4(SensorAPIJavaScript paramSensorAPIJavaScript, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SensorApi", 2, "play failure url=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.4
 * JD-Core Version:    0.7.0.1
 */