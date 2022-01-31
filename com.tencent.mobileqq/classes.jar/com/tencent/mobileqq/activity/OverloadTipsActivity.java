package com.tencent.mobileqq.activity;

import abql;
import abqm;
import android.content.Intent;
import android.os.Bundle;
import bbcv;
import bbgg;
import com.tencent.mobileqq.app.BaseActivity;

public class OverloadTipsActivity
  extends BaseActivity
{
  private bbgg a;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559347);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (paramBundle = getIntent().getExtras().getString("msg");; paramBundle = null)
    {
      if (paramBundle == null)
      {
        finish();
        return false;
      }
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = null;
      this.a = bbcv.a(this, 230);
      this.a.setContentView(2131558883);
      this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131694937, new abql(this));
      this.a.setTextContentDescription(paramBundle);
      this.a.setOnKeyListener(new abqm(this));
      this.a.show();
      return false;
    }
  }
  
  public void finish()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OverloadTipsActivity
 * JD-Core Version:    0.7.0.1
 */