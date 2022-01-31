package com.tencent.mobileqq.activity;

import abbo;
import ajsd;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;

public class ForceLogoutActivity
  extends BaseActivity
  implements ajsd
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559066);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("msg");
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      ((TextView)findViewById(2131378010)).setText(paramBundle);
    }
    if ((str != null) && (str.length() > 0)) {
      ((TextView)findViewById(2131378011)).setText(str);
    }
    ((Button)findViewById(2131363430)).setOnClickListener(new abbo(this));
    return true;
  }
  
  public boolean onBackEvent()
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