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
      paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      paramBundle.setFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramBundle = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      paramBundle.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramBundle.putExtra("uintype", 1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(4660);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.6
 * JD-Core Version:    0.7.0.1
 */