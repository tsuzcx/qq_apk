package com.sina.weibo.sdk.web;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.sina.weibo.sdk.c.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;

public class WebActivity
  extends Activity
  implements a
{
  private LinearLayout as;
  private TextView at;
  private TextView au;
  private WebView av;
  private ProgressBar aw;
  private com.sina.weibo.sdk.web.b.b ax;
  private com.sina.weibo.sdk.web.a.b ay;
  private String az;
  
  private static void a(WebView paramWebView, String paramString)
  {
    try
    {
      WebView.class.getDeclaredMethod("removeJavascriptInterface", new Class[] { String.class }).invoke(paramWebView, new Object[] { paramString });
      return;
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23) {
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    paramBundle = new RelativeLayout(this);
    paramBundle.setBackgroundColor(-1);
    Object localObject1 = new RelativeLayout(this);
    this.at = new TextView(this);
    this.at.setText("关闭");
    this.at.setTextSize(17.0F);
    this.at.setTextColor(-32256);
    this.at.setOnClickListener(new WebActivity.2(this));
    this.au = new TextView(this);
    this.au.setTextSize(18.0F);
    this.au.setTextColor(-11382190);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    this.at.setPadding(e.a(10, this), 0, e.a(10, this), 0);
    localLayoutParams.addRule(13);
    ((RelativeLayout)localObject1).addView(this.at, (ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).addView(this.au, localLayoutParams);
    paramBundle.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, e.a(55, this)));
    this.av = new WebView(getApplicationContext());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = e.a(55, this);
    paramBundle.addView(this.av, (ViewGroup.LayoutParams)localObject1);
    this.aw = new ProgressBar(this);
    localObject1 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = e.a(55, this);
    paramBundle.addView(this.aw, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new View(this);
    ((View)localObject1).setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
    localObject2 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = e.a(55, this);
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.as = new LinearLayout(this);
    this.as.setOrientation(1);
    localObject1 = new ImageView(this);
    ((ImageView)localObject1).setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
    this.as.addView((View)localObject1);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setTextSize(14.0F);
    ((TextView)localObject1).setTextColor(-4342339);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).topMargin = e.a(18, this);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = e.a(20, this);
    this.as.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText("网络出错啦，请点击按钮重新加载");
    localObject1 = new Button(this);
    ((Button)localObject1).setTextSize(16.0F);
    ((Button)localObject1).setTextColor(-8882056);
    localObject2 = new LinearLayout.LayoutParams(e.a(142, this), e.a(46, this));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    this.as.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((Button)localObject1).setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
    ((Button)localObject1).setText("重新加载");
    ((Button)localObject1).setOnClickListener(new WebActivity.3(this));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    paramBundle.addView(this.as, (ViewGroup.LayoutParams)localObject1);
    this.as.setVisibility(8);
    this.av.setWebChromeClient(new WebActivity.4(this));
    setContentView(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    localObject1 = paramBundle.getExtras();
    if (localObject1 == null)
    {
      finish();
      return;
    }
    int i = paramBundle.getIntExtra("web_type", -1);
    if (i == -1)
    {
      finish();
      return;
    }
    switch (i)
    {
    default: 
      label740:
      this.av.setWebViewClient(this.ay);
      this.ax.readFromBundle((Bundle)localObject1);
      paramBundle = this.av.getSettings();
      paramBundle.setJavaScriptEnabled(true);
      paramBundle.setSavePassword(false);
      paramBundle.setAllowContentAccess(false);
      paramBundle.setUserAgentString(e.r());
      this.av.requestFocus();
      this.av.setScrollBarStyle(0);
      a(this.av, "searchBoxJavaBridge_");
      a(this.av, "accessibility");
      a(this.av, "accessibilityTraversal");
      if (Build.VERSION.SDK_INT >= 21) {
        paramBundle.setMixedContentMode(2);
      }
      if (this.ax.w()) {
        this.ax.a(new WebActivity.1(this));
      }
      break;
    }
    while (this.au != null)
    {
      this.au.setText(this.az);
      return;
      this.az = "微博分享";
      this.ax = new com.sina.weibo.sdk.web.b.d(this);
      this.ay = new com.sina.weibo.sdk.web.a.d(this, this, this.ax);
      break label740;
      this.az = "微博登录";
      this.ax = new com.sina.weibo.sdk.web.b.a();
      this.ay = new com.sina.weibo.sdk.web.a.a(this, this, this.ax);
      break label740;
      this.ax = new com.sina.weibo.sdk.web.b.c();
      this.ay = new com.sina.weibo.sdk.web.a.c(this, this.ax);
      break label740;
      paramBundle = this.ax.getUrl();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.av.loadUrl(paramBundle);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.ay.v()) {
        return true;
      }
      if (this.av.canGoBack())
      {
        this.av.goBack();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void s()
  {
    this.as.setVisibility(0);
    this.av.setVisibility(8);
  }
  
  public final void t()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.WebActivity
 * JD-Core Version:    0.7.0.1
 */