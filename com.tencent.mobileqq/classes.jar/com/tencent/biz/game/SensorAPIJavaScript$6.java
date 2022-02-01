package com.tencent.biz.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

final class SensorAPIJavaScript$6
  implements ITroopMemberApiClientApi.Callback
{
  SensorAPIJavaScript$6(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("currentFragment", -1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("isFromAio callback ");
      paramBundle.append(i);
      QLog.i("SensorAPIJavaScript", 2, paramBundle.toString());
    }
    if (i == 2)
    {
      paramBundle = new Intent(this.a, SplashActivity.class);
      paramBundle.setFlags(67108864);
      this.a.startActivity(paramBundle);
      return;
    }
    if ((this.b) && (!TextUtils.isEmpty(this.c)))
    {
      paramBundle = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
      paramBundle.putExtra("uin", this.c);
      paramBundle.putExtra("uintype", 1);
      this.a.startActivity(paramBundle);
      return;
    }
    this.a.setResult(4660);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.6
 * JD-Core Version:    0.7.0.1
 */