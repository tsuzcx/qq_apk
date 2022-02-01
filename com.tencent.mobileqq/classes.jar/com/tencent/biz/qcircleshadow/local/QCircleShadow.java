package com.tencent.biz.qcircleshadow.local;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleLogImpl;
import com.tencent.biz.qcircleshadow.delegateimpl.QCirclePluginInfoImpl;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleToastImpl;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import cooperation.qzone.QUA;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleShadow
{
  private static volatile QCircleShadow jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow;
  private long jdField_a_of_type_Long;
  private QCirclePluginEnterManger jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = MobileQQ.context;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private QCircleShadow()
  {
    f();
    e();
    d();
    c();
  }
  
  public static QCircleShadow a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow == null) {
        try
        {
          if (jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow == null) {
            jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow = new QCircleShadow();
          }
        }
        finally {}
      }
      QCircleShadow localQCircleShadow = jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow;
      return localQCircleShadow;
    }
    finally {}
  }
  
  private boolean b()
  {
    boolean bool;
    if ((f()) && (e()) && (!d()) && (c())) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canPreload");
    localStringBuilder.append(bool);
    QLog.d("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    return bool;
  }
  
  private void c()
  {
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(new QCircleShadow.1(this));
  }
  
  private boolean c()
  {
    boolean bool = QCircleConfigHelper.a("qqcircle", "qqcircle_open_qcircle_preload", "1").equals("1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WNS openPreload:");
    localStringBuilder.append(bool);
    QLog.d("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    return bool;
  }
  
  private void d()
  {
    QCircleInitInject.g().injectLogDelegate(new QCircleLogImpl()).injectToastDelegate(new QCircleToastImpl()).injectPluginInfoDelegate(new QCirclePluginInfoImpl());
  }
  
  private boolean d()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTime:");
    localStringBuilder.append(l1);
    localStringBuilder.append(" lastLodeTime:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" interval:");
    localStringBuilder.append(l2);
    QLog.d("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    if (l2 > 60000L)
    {
      this.jdField_a_of_type_Long = l1;
      return false;
    }
    return true;
  }
  
  private void e()
  {
    if ((f()) && (e())) {
      QQVideoPlaySDKManager.a(MobileQQ.context, new QCircleShadow.2(this));
    }
  }
  
  private boolean e()
  {
    int i = MobileQQ.sProcessId;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isMain:");
    localStringBuilder.append(bool);
    QLog.d("QCIRCLE_PLUGIN", 4, localStringBuilder.toString());
    return bool;
  }
  
  private void f()
  {
    g();
    a();
    QCirclePluginSelector.a().a();
  }
  
  private boolean f()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return (localAppRuntime != null) && (localAppRuntime.isLogin());
  }
  
  private void g() {}
  
  private void h()
  {
    List localList = QCirclePluginSelector.a().a();
    if (localList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < localList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)localList.get(i)))
        {
          localStringBuilder.append("plugin");
          localStringBuilder.append(i + 1);
          localStringBuilder.append(":");
          localStringBuilder.append((String)localList.get(i));
          localStringBuilder.append("\n");
        }
        i += 1;
      }
      QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    }
  }
  
  public QCirclePluginEnterManger a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger == null)
      {
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_start").setPluginType("UnKnow"));
        localObject1 = QCirclePluginSelector.a().a();
        if ((localObject1 != null) && (((QCirclePluginUpdater)localObject1).getLatest() != null))
        {
          this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger = new QCirclePluginEnterManger(new DynamicPluginManager((PluginManagerUpdater)localObject1));
          this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger.setUpdater((QCirclePluginUpdater)localObject1);
          this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger.setPluginInfo(((QCirclePluginUpdater)localObject1).a());
          h();
        }
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger;
      return localObject1;
    }
    finally {}
  }
  
  public QCircleSampleInfo a()
  {
    QCirclePluginEnterManger localQCirclePluginEnterManger = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger;
    if (localQCirclePluginEnterManger != null) {
      return localQCirclePluginEnterManger.getPluginInfo();
    }
    return null;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("_");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      try
      {
        LoggerFactory.setILoggerFactory(QCircleLoggerFactory.a());
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init plugin log exception:");
        localStringBuilder.append(localRuntimeException);
        QLog.d("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (paramString.toLowerCase().contains("qcircle"))
      {
        int i = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger.getPluginInfo().b();
        localObject = MobileQQ.getContext().getSharedPreferences("QCircle_crash_share", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QCircle_crash_count_");
        localStringBuilder.append(i);
        int j = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) + 1;
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("QCircle_crash_count_");
        localStringBuilder.append(i);
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), j).commit();
        if (j >= QCircleConfigHelper.c()) {
          QCirclePluginManager.a().a(i);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("crashCount: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" crashVersion:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("---------");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check stack exception:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public String b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger;
    if (localObject1 != null)
    {
      localObject1 = ((QCirclePluginEnterManger)localObject1).getPluginInfo();
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((QCircleSampleInfo)localObject1).b());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = ((QCircleSampleInfo)localObject1).d();
        break label64;
      }
    }
    Object localObject2 = "0";
    localObject1 = "U";
    label64:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    QLog.d("QCIRCLE_PLUGIN", 1, "exit qcircle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleShadow
 * JD-Core Version:    0.7.0.1
 */