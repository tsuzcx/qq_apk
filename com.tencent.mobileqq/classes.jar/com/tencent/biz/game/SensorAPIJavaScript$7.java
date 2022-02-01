package com.tencent.biz.game;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class SensorAPIJavaScript$7
  implements AsyncBack
{
  SensorAPIJavaScript$7(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("loaded code:");
      paramString.append(paramInt);
      QLog.d("forceUpdate", 2, paramString.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript;
    paramString.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramString.notifyCacheReady(paramInt);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.7
 * JD-Core Version:    0.7.0.1
 */