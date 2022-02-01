package com.tencent.luggage.sdk.customize.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FullSdkExternalToolsHelper$SimpleWebViewActivity
  extends BaseActivity
{
  private WebView a;
  
  private void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("_url_");
    this.a.stopLoading();
    this.a.loadUrl(paramIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131625272;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ((WebView)findViewById(2131450088));
    a(getIntent());
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper.SimpleWebViewActivity
 * JD-Core Version:    0.7.0.1
 */