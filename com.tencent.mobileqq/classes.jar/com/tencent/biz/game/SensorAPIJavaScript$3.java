package com.tencent.biz.game;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class SensorAPIJavaScript$3
  implements SoundPool.OnLoadCompleteListener
{
  SensorAPIJavaScript$3(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SensorApi", 2, "play failure url=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.3
 * JD-Core Version:    0.7.0.1
 */