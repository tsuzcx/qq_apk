package com.tencent.mobileqq.Doraemon.impl.webviewModule;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class AbsWVModule$WebViewRuntimeCompat
{
  WeakReference<CustomWebView> a;
  WeakReference<AppInterface> b;
  WeakReference<Activity> c;
  WeakReference<WebUiBaseInterface> d = null;
  WeakReference<WebViewFragment> e = null;
  
  public AbsWVModule$WebViewRuntimeCompat(Activity paramActivity)
  {
    this.c = new WeakReference(paramActivity);
  }
  
  public CustomWebView a()
  {
    if (this.a == null)
    {
      WebViewFragment localWebViewFragment = e();
      if (localWebViewFragment != null) {
        this.a = new WeakReference(localWebViewFragment.getWebView());
      } else {
        this.a = new WeakReference(null);
      }
    }
    return (CustomWebView)this.a.get();
  }
  
  public AppInterface b()
  {
    if (this.b == null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof ToolAppRuntime)) {
        this.b = new WeakReference((AppInterface)localAppRuntime.getAppRuntime("modular_web"));
      } else if ((localAppRuntime instanceof AppInterface)) {
        this.b = new WeakReference((AppInterface)localAppRuntime);
      } else {
        this.b = new WeakReference(null);
      }
    }
    return (AppInterface)this.b.get();
  }
  
  public Activity c()
  {
    return (Activity)this.c.get();
  }
  
  public WebUiBaseInterface d()
  {
    if (this.d == null)
    {
      Activity localActivity = c();
      if ((localActivity instanceof WebUiBaseInterface)) {
        this.d = new WeakReference((WebUiBaseInterface)localActivity);
      } else {
        this.d = new WeakReference(e());
      }
    }
    return (WebUiBaseInterface)this.d.get();
  }
  
  public WebViewFragment e()
  {
    if (this.e == null)
    {
      Activity localActivity = c();
      if ((localActivity instanceof SwiftWebViewFragmentSupporter)) {
        this.e = new WeakReference(((SwiftWebViewFragmentSupporter)localActivity).getCurrentWebViewFragment());
      } else {
        this.e = new WeakReference(null);
      }
    }
    return (WebViewFragment)this.e.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webviewModule.AbsWVModule.WebViewRuntimeCompat
 * JD-Core Version:    0.7.0.1
 */