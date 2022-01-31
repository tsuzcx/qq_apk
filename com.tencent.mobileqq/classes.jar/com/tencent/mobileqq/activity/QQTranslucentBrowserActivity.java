package com.tencent.mobileqq.activity;

import abnl;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.smtt.sdk.WebView;

public class QQTranslucentBrowserActivity
  extends QQBrowserActivity
{
  private Dialog a;
  
  public QQTranslucentBrowserActivity()
  {
    this.jdField_a_of_type_JavaLangClass = QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.class;
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    b();
    super.a(paramWebView, paramString);
  }
  
  public void av_()
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = new abnl(this);
      }
    } while (this.jdField_a_of_type_AndroidAppDialog == null);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    getWindow().setBackgroundDrawableResource(2131101491);
    View localView = findViewById(2131297873);
    if (localView != null) {
      localView.setBackgroundResource(2131101491);
    }
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("flag_show_loading_dialog", false))) {
      av_();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    b();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */