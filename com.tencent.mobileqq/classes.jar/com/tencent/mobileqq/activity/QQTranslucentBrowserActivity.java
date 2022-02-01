package com.tencent.mobileqq.activity;

import Override;
import aezq;
import aezr;
import aezs;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import avmc;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public class QQTranslucentBrowserActivity
  extends QQBrowserActivity
{
  private Dialog a;
  
  public QQTranslucentBrowserActivity()
  {
    this.jdField_a_of_type_JavaLangClass = QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.class;
  }
  
  public void a()
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = new aezs(this);
      }
    } while (this.jdField_a_of_type_AndroidAppDialog == null);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    b();
    super.a(paramWebView, paramString);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    getWindow().setBackgroundDrawableResource(2131167224);
    View localView = findViewById(2131363653);
    if (localView != null) {
      localView.setBackgroundResource(2131167224);
    }
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getIntExtra("key_dialog_type", -1);
      if (!paramBundle.getBooleanExtra("flag_show_loading_dialog", false)) {
        break label68;
      }
      a();
    }
    label68:
    do
    {
      return bool;
      if (i == 4)
      {
        this.jdField_a_of_type_AndroidAppDialog = avmc.a(this);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aezq(this));
        a();
        return bool;
      }
    } while (i != 5);
    this.jdField_a_of_type_AndroidAppDialog = avmc.a(this, paramBundle);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aezr(this));
    a();
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */