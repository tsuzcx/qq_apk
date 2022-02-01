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
  public static final int DIALOG_WATCH_FLOATING_PERMISSION_CHECK = 4;
  public static final int DIALOG_WATCH_FLOATING_QUITE = 5;
  public static final String FLAG_HIDE_FLOAT_BAR = "flag_hide_float_bar";
  public static final String FLAG_SHOW_LOADING_DIALOG = "flag_show_loading_dialog";
  public static final String KEY_DIALOG_TYPE = "key_dialog_type";
  private Dialog loadingDialog;
  
  public QQTranslucentBrowserActivity()
  {
    this.mFragmentClass = QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.class;
  }
  
  public void dismissLoadingDialog()
  {
    Dialog localDialog = this.loadingDialog;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      this.loadingDialog.dismiss();
      this.loadingDialog = null;
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
    getWindow().setBackgroundDrawableResource(2131167333);
    View localView = findViewById(2131363807);
    if (localView != null) {
      localView.setBackgroundResource(2131167333);
    }
    if (paramBundle != null)
    {
      int i = paramBundle.getIntExtra("key_dialog_type", -1);
      if (paramBundle.getBooleanExtra("flag_show_loading_dialog", false))
      {
        showLoadingDialog();
        return bool;
      }
      if (i == 4)
      {
        this.loadingDialog = TogetherWatchFloatingUtil.a(this);
        this.loadingDialog.setOnDismissListener(new QQTranslucentBrowserActivity.1(this));
        showLoadingDialog();
        return bool;
      }
      if (i == 5)
      {
        this.loadingDialog = TogetherWatchFloatingUtil.a(this, paramBundle);
        this.loadingDialog.setOnDismissListener(new QQTranslucentBrowserActivity.2(this));
        showLoadingDialog();
      }
    }
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    dismissLoadingDialog();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    dismissLoadingDialog();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    dismissLoadingDialog();
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void showLoadingDialog()
  {
    if (isFinishing()) {
      return;
    }
    if (this.loadingDialog == null) {
      this.loadingDialog = new QQTranslucentBrowserActivity.LoadingDialog(this);
    }
    Dialog localDialog = this.loadingDialog;
    if (localDialog != null) {
      localDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */