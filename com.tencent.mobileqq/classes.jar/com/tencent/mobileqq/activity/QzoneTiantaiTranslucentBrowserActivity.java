package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import bgrn;
import com.tencent.smtt.sdk.WebView;

public class QzoneTiantaiTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
{
  private bgrn a;
  
  private bgrn a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      switch (localIntent.getIntExtra("translucent_controller", 0))
      {
      default: 
        return new bgrn(this);
      }
      return new bgrn(this);
    }
    return new bgrn(this);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if (this.a != null) {
      this.a.e();
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.a != null) && (this.a.a())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.a != null) {
      this.a.a();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.a != null) {
      this.a.d();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.a = a();
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */