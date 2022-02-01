package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public class QQTranslucentBrowserActivity
  extends QQBrowserActivity
{
  private Dialog a;
  
  public QQTranslucentBrowserActivity()
  {
    this.mFragmentClass = QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.class;
  }
  
  public void a()
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.a == null) {
        this.a = new QQTranslucentBrowserActivity.LoadingDialog(this);
      }
    } while (this.a == null);
    this.a.show();
  }
  
  public void b()
  {
    if ((this.a != null) && (this.a.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    getWindow().setBackgroundDrawableResource(2131167305);
    View localView = findViewById(2131363879);
    if (localView != null) {
      localView.setBackgroundResource(2131167305);
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
        this.a = TogetherWatchFloatingUtil.a(this);
        this.a.setOnDismissListener(new QQTranslucentBrowserActivity.1(this));
        a();
        return bool;
      }
    } while (i != 5);
    this.a = TogetherWatchFloatingUtil.a(this, paramBundle);
    this.a.setOnDismissListener(new QQTranslucentBrowserActivity.2(this));
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
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    b();
    super.onPageFinished(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */