package com.tencent.mobileqq.activity;

import adhp;
import adhq;
import android.content.Intent;
import android.os.Bundle;
import bdcd;
import bdfq;
import com.tencent.mobileqq.app.BaseActivity;

public class OverloadTipsActivity
  extends BaseActivity
{
  private bdfq a;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559399);
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
      this.a = bdcd.a(this, 230);
      this.a.setContentView(2131558920);
      this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131695095, new adhp(this));
      this.a.setTextContentDescription(paramBundle);
      this.a.setOnKeyListener(new adhq(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OverloadTipsActivity
 * JD-Core Version:    0.7.0.1
 */