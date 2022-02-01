package com.tencent.mobileqq.auto.engine.enter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qqcircle.report.ASEngineQualityReport.ReportData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ASPluginManager
  implements PluginManager
{
  private DynamicPluginManager a;
  private PluginManagerUpdater b;
  private ASPluginBean c;
  private ExecutorService d = Executors.newSingleThreadExecutor();
  
  public ASPluginManager(@NonNull ASPluginBean paramASPluginBean)
  {
    this.c = paramASPluginBean;
    b();
    a();
  }
  
  private void a()
  {
    this.a = new DynamicPluginManager(this.b);
  }
  
  private void b()
  {
    this.b = new ASPluginManager.1(this);
  }
  
  private void c()
  {
    if (this.c == null) {
      return;
    }
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.c.getBusinessKey()).setPluginVersion(this.c.getVersionCode()).setPluginType(this.c.getType()).setEventId("autoshadow_plugin_load_result").setRetCode(2L));
  }
  
  private boolean d()
  {
    ASPluginBean localASPluginBean = this.c;
    boolean bool2 = false;
    if (localASPluginBean == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.c.getPluginZipPath()))
    {
      bool1 = bool2;
      if (((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.c.getPluginMangerApkPath())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(ASEnterBean paramASEnterBean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("pluginZipPath", this.c.getPluginZipPath());
    localBundle1.putString("KEY_PLUGIN_PART_KEY", this.c.getBusinessKey());
    Bundle localBundle2 = new Bundle();
    if (paramASEnterBean.getLoadAction() == 0) {
      paramASEnterBean.setLoadAction(1001);
    }
    localBundle2.putSerializable("KEY_AS_ENTER_BEAN", paramASEnterBean);
    localBundle1.putBundle("KEY_EXTRAS", localBundle2);
    enter(RFApplication.getApplication(), paramASEnterBean.getLoadAction(), localBundle1, null);
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    try
    {
      if (d())
      {
        String str = ASDynamicEngine.a(this.c.getBusinessKey());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enter plugin:");
        localStringBuilder.append(this.c);
        QLog.d(str, 1, localStringBuilder.toString());
        this.a.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
        return;
      }
      QLog.d(ASDynamicEngine.a(this.c.getBusinessKey()), 1, "enter plugin failed , files not exits");
      c();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASPluginManager
 * JD-Core Version:    0.7.0.1
 */