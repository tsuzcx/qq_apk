package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import tel;
import tem;

public class OverloadTipsActivity
  extends BaseActivity
{
  private QQCustomDialog a;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969139);
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
      this.a = DialogUtil.a(this, 230);
      this.a.setContentView(2130968842);
      this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131438017, new tel(this));
      this.a.setTextContentDescription(paramBundle);
      this.a.setOnKeyListener(new tem(this));
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