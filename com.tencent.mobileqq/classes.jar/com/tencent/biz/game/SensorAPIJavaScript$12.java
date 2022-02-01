package com.tencent.biz.game;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

class SensorAPIJavaScript$12
  implements TroopMemberApiClient.Callback
{
  SensorAPIJavaScript$12(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("state");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { i + "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.12
 * JD-Core Version:    0.7.0.1
 */