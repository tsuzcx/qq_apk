package com.tencent.gdtad.web;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForWebView;
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
  private static GdtLandingPageConfig jdField_a_of_type_ComTencentGdtadWebGdtLandingPageConfig;
  private AdSettingsManager.Listener jdField_a_of_type_ComTencentAdTangramSettingsAdSettingsManager$Listener = new GdtLandingPageConfig.AddSettingListener(this, null);
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b;
  
  public static GdtLandingPageConfig a()
  {
    if (jdField_a_of_type_ComTencentGdtadWebGdtLandingPageConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentGdtadWebGdtLandingPageConfig == null) {
          jdField_a_of_type_ComTencentGdtadWebGdtLandingPageConfig = new GdtLandingPageConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentGdtadWebGdtLandingPageConfig;
  }
  
  private String a()
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
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadLandingPageReportJsAsync isLoaded ==");
    localStringBuilder.append(this.b);
    GdtLog.a("GdtLandingPageConfig", localStringBuilder.toString());
    if (this.b) {
      return;
    }
    AdThreadManager.INSTANCE.post(new GdtLandingPageConfig.1(this), 4);
  }
  
  private void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isSupportNewLandingPageReport ==");
    ((StringBuilder)localObject1).append(a());
    GdtLog.d("GdtLandingPageConfig", ((StringBuilder)localObject1).toString());
    if (a())
    {
      localObject1 = AdSettingsManager.INSTANCE.getCache();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((gdt_settings.Settings)localObject1).settingsForWebView.jsUrlForPagePerformance;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      GdtLog.d("GdtLandingPageConfig", "startLoad");
      this.b = true;
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("Referer", "h5.gdt.qq.com");
      try
      {
        localObject1 = HttpBaseUtil.a((String)localObject1, "GET", (Bundle)localObject2, null).a;
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
        {
          localObject1 = HttpBaseUtil.a((HttpResponse)localObject1);
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
  
  public String a(Context paramContext)
  {
    boolean bool = a();
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
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      AdSettingsManager.INSTANCE.addListener(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramSettingsAdSettingsManager$Listener));
      a();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    return (localSettings != null) && (localSettings.settingsForWebView != null) && (localSettings.settingsForWebView.abTest != null) && (AdABTest.isABTestByUIN(a(), localSettings.settingsForWebView.abTest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageConfig
 * JD-Core Version:    0.7.0.1
 */