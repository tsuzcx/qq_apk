package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class TroopMemberApiPlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  TroopMemberApiPlugin$1(TroopMemberApiPlugin paramTroopMemberApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess", false);
    if (bool)
    {
      paramBundle = paramBundle.getString("data");
      this.b.callJs(this.a, new String[] { paramBundle });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = this.b.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopBarPublishInfo() in callback isSuccess=");
      localStringBuilder.append(bool);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */