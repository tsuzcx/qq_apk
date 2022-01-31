package com.tencent.mobileqq.activity;

import adme;
import admf;
import android.content.Intent;
import android.os.Bundle;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;

public class OverloadTipsActivity
  extends BaseActivity
{
  private bdjz a;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559398);
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
      this.a = bdgm.a(this, 230);
      this.a.setContentView(2131558919);
      this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131695097, new adme(this));
      this.a.setTextContentDescription(paramBundle);
      this.a.setOnKeyListener(new admf(this));
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