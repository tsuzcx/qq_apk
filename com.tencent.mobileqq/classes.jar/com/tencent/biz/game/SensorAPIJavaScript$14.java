package com.tencent.biz.game;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class SensorAPIJavaScript$14
  implements ITroopMemberApiClientApi.Callback
{
  SensorAPIJavaScript$14(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("music");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.14
 * JD-Core Version:    0.7.0.1
 */