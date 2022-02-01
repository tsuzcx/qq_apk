package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class UrlCheckPlugin
  extends WebViewPlugin
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public int e = a;
  public SoftKeyboardObserver f;
  QBaseActivity g = null;
  CustomWebView h = null;
  WindowManager i = null;
  WindowManager.LayoutParams j = null;
  RelativeLayout k = null;
  TextView l = null;
  ImageView m = null;
  int n = 0;
  int o = 0;
  int p = 0;
  boolean q = false;
  public Runnable r = new UrlCheckPlugin.4(this);
  
  public UrlCheckPlugin()
  {
    this.mPluginNameSpace = "URL_CHECK";
  }
  
  private void b()
  {
    if (this.f == null) {
      this.f = new SoftKeyboardObserver(this.h, new UrlCheckPlugin.2(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.mRuntime.d();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (this.k != null) && (this.e == c))
    {
      localObject = ((Activity)localObject).getWindowManager();
      this.e = d;
      try
      {
        ((WindowManager)localObject).removeView(this.k);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          String str = this.mTAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeView Error:");
          localStringBuilder.append(localIllegalArgumentException.getMessage());
          QLog.e(str, 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.mRuntime.d();
    if (!(localObject instanceof QBaseActivity)) {
      return;
    }
    if (this.h == null) {
      return;
    }
    if (this.k == null)
    {
      this.g = ((QBaseActivity)localObject);
      this.k = ((RelativeLayout)this.g.getLayoutInflater().inflate(2131624635, null));
      this.l = ((TextView)this.k.findViewById(2131447672));
      this.m = ((ImageView)this.k.findViewById(2131447668));
      this.i = this.g.getWindowManager();
      this.j = new WindowManager.LayoutParams();
      localObject = this.g.getResources();
    }
    try
    {
      i1 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
    catch (Exception localException2)
    {
      int i1;
      label148:
      double d1;
      break label148;
    }
    d1 = ((Resources)localObject).getDisplayMetrics().density * 25.0F;
    Double.isNaN(d1);
    i1 = (int)(d1 + 0.5D);
    localObject = this.j;
    ((WindowManager.LayoutParams)localObject).gravity = 49;
    ((WindowManager.LayoutParams)localObject).y = (this.g.getTitleBarHeight() + i1);
    localObject = this.j;
    ((WindowManager.LayoutParams)localObject).type = 1002;
    ((WindowManager.LayoutParams)localObject).format = 1;
    ((WindowManager.LayoutParams)localObject).flags = 262664;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    localObject = this.m;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new UrlCheckPlugin.3(this));
    }
    if (this.i == null) {
      this.i = this.g.getWindowManager();
    }
    localObject = this.l;
    if (localObject != null) {
      ((TextView)localObject).setText(this.g.getResources().getText(paramInt));
    }
    this.h.postDelayed(this.r, this.p + this.o);
    this.e = c;
    try
    {
      this.i.addView(this.k, this.j);
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel())
      {
        String str = this.mTAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addView exception:");
        localStringBuilder.append(localException1.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramInt3;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.h = this.mRuntime.a();
    if (this.h == null) {
      return false;
    }
    paramString = this.mRuntime.d();
    if (!(paramString instanceof QBaseActivity)) {
      return false;
    }
    this.g = ((QBaseActivity)paramString);
    b();
    if (paramLong == 8589934597L)
    {
      paramString = this.f;
      if (paramString != null)
      {
        paramString.a();
        this.f = null;
      }
      if (this.e == c)
      {
        paramString = this.m;
        if (paramString != null)
        {
          paramString.setOnClickListener(null);
          this.h.removeCallbacks(this.r);
          a();
          return false;
        }
      }
    }
    else if ((paramLong == 8589934594L) && (this.n == 2) && (this.e != c))
    {
      this.h.postDelayed(new UrlCheckPlugin.1(this), this.o);
    }
    return false;
  }
  
  protected void onDestroy()
  {
    SoftKeyboardObserver localSoftKeyboardObserver = this.f;
    if (localSoftKeyboardObserver != null)
    {
      localSoftKeyboardObserver.a();
      this.f = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.UrlCheckPlugin
 * JD-Core Version:    0.7.0.1
 */