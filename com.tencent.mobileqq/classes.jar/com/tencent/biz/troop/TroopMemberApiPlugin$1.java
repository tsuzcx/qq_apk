package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class TroopMemberApiPlugin$1
  implements TroopMemberApiClient.Callback
{
  TroopMemberApiPlugin$1(TroopMemberApiPlugin paramTroopMemberApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess", false);
    if (bool)
    {
      paramBundle = paramBundle.getString("data");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.TAG, 2, "getTroopBarPublishInfo() in callback isSuccess=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */