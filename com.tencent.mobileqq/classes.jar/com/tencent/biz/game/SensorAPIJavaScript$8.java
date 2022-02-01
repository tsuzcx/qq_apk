package com.tencent.biz.game;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import org.json.JSONException;
import org.json.JSONObject;

class SensorAPIJavaScript$8
  implements AsyncBack
{
  SensorAPIJavaScript$8(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.8
 * JD-Core Version:    0.7.0.1
 */