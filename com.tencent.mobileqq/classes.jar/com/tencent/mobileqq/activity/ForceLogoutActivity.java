package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import skn;

public class ForceLogoutActivity
  extends BaseActivity
  implements AppConstants
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968997);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("msg");
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      ((TextView)findViewById(2131364619)).setText(paramBundle);
    }
    if ((str != null) && (str.length() > 0)) {
      ((TextView)findViewById(2131364620)).setText(str);
    }
    ((Button)findViewById(2131363664)).setOnClickListener(new skn(this));
    return true;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    startActivity(new Intent(this, LoginActivity.class).addFlags(67108864));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForceLogoutActivity
 * JD-Core Version:    0.7.0.1
 */