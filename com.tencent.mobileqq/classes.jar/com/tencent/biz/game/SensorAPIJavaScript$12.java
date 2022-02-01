package com.tencent.biz.game;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class SensorAPIJavaScript$12
  implements ITroopMemberApiClientApi.Callback
{
  SensorAPIJavaScript$12(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("state");
      paramBundle = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript;
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      paramBundle.callJs(str, new String[] { localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.12
 * JD-Core Version:    0.7.0.1
 */