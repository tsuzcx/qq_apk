package com.tencent.gdtad.web;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForLinkEventReporter;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.settings.AdSettingsManager.Listener;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public final class GdtLandingPageConfig
{
  private static GdtLandingPageConfig a;
  private AdSettingsManager.Listener b = new GdtLandingPageConfig.AddSettingListener(this, null);
  private volatile boolean c = false;
  private volatile boolean d;
  
  public static GdtLandingPageConfig a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GdtLandingPageConfig();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadLandingPageReportJsAsync isLoaded ==");
    localStringBuilder.append(this.d);
    GdtLog.a("GdtLandingPageConfig", localStringBuilder.toString());
    if (this.d) {
      return;
    }
    AdThreadManager.INSTANCE.post(new GdtLandingPageConfig.1(this), 4);
  }
  
  private String d()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject != null) {}
    }
    else
    {
      return "";
    }
    GdtLog.d("GdtLandingPageConfiggetUin ==", ((AppRuntime)localObject).getAccount());
    return ((AppRuntime)localObject).getAccount();
  }
  
  private void e()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isSupportNewLandingPageReport ==");
    ((StringBuilder)localObject1).append(b());
    GdtLog.d("GdtLandingPageConfig", ((StringBuilder)localObject1).toString());
    if (b())
    {
      localObject1 = AdSettingsManager.INSTANCE.getCache();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((gdt_settings.Settings)localObject1).settingsForLinkEventReporter.jsUrlForPagePerformance;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      GdtLog.d("GdtLandingPageConfig", "startLoad");
      this.d = true;
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("Referer", "h5.gdt.qq.com");
      try
      {
        localObject1 = HttpBaseUtil.a((String)localObject1, "GET", (Bundle)localObject2, null).a;
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
        {
          localObject1 = HttpBaseUtil.b((HttpResponse)localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load resultStr =");
          ((StringBuilder)localObject2).append((String)localObject1);
          GdtLog.a("GdtLandingPageConfig", ((StringBuilder)localObject2).toString());
          if (BaseApplicationImpl.getContext() != null)
          {
            localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("gdtLandingPageConfig", 4).edit();
            ((SharedPreferences.Editor)localObject2).putString("landingpageScript", (String)localObject1);
            ((SharedPreferences.Editor)localObject2).commit();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("writeFileException");
        ((StringBuilder)localObject2).append(localException.getMessage());
        GdtLog.a("GdtLandingPageConfig", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.c) {
      return;
    }
    try
    {
      if (this.c) {
        return;
      }
      this.c = true;
      AdSettingsManager.INSTANCE.addListener(new WeakReference(this.b));
      c();
      return;
    }
    finally {}
  }
  
  public String b(Context paramContext)
  {
    boolean bool = b();
    Object localObject = "";
    if (!bool) {
      return "";
    }
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("gdtLandingPageConfig", 4).getString("landingpageScript", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sharedPreferences result ==");
      ((StringBuilder)localObject).append(paramContext);
      GdtLog.a("GdtLandingPageConfig", ((StringBuilder)localObject).toString());
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {}
    }
    return localObject;
  }
  
  public boolean b()
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    return (localSettings != null) && (localSettings.settingsForLinkEventReporter != null) && (!TextUtils.isEmpty(localSettings.settingsForLinkEventReporter.jsUrlForPagePerformance)) && (localSettings.settingsForLinkEventReporter.abTest != null) && (AdABTest.isABTestByUIN(d(), localSettings.settingsForLinkEventReporter.abTest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageConfig
 * JD-Core Version:    0.7.0.1
 */