package com.tencent.biz.qcircleshadow.local;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleDaTongReportImpl;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleLogImpl;
import com.tencent.biz.qcircleshadow.delegateimpl.QCirclePluginInfoImpl;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleToastImpl;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
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
  
  /* Error */
  public static QCircleShadow a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/tencent/biz/qcircleshadow/local/QCircleShadow:jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow	Lcom/tencent/biz/qcircleshadow/local/QCircleShadow;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 38	com/tencent/biz/qcircleshadow/local/QCircleShadow:jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow	Lcom/tencent/biz/qcircleshadow/local/QCircleShadow;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/biz/qcircleshadow/local/QCircleShadow
    //   21: dup
    //   22: invokespecial 39	com/tencent/biz/qcircleshadow/local/QCircleShadow:<init>	()V
    //   25: putstatic 38	com/tencent/biz/qcircleshadow/local/QCircleShadow:jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow	Lcom/tencent/biz/qcircleshadow/local/QCircleShadow;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 38	com/tencent/biz/qcircleshadow/local/QCircleShadow:jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleShadow	Lcom/tencent/biz/qcircleshadow/local/QCircleShadow;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localQCircleShadow	QCircleShadow
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private boolean b()
  {
    boolean bool = true;
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    QLog.d("QCIRCLE_PLUGIN", 1, "currentTime:" + l1 + " lastLodeTime:" + this.jdField_a_of_type_Long + " interval:" + l2);
    if (l2 > 60000L)
    {
      this.jdField_a_of_type_Long = l1;
      bool = false;
    }
    return bool;
  }
  
  private void c()
  {
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(new QCircleShadow.1(this));
  }
  
  private boolean c()
  {
    boolean bool = true;
    if (MobileQQ.sProcessId == 1) {}
    for (;;)
    {
      QLog.d("QCIRCLE_PLUGIN", 4, "isMain:" + bool);
      return bool;
      bool = false;
    }
  }
  
  private void d()
  {
    QCircleInitInject.g().injectLogDelegate(new QCircleLogImpl()).injectToastDelegate(new QCircleToastImpl()).injectPluginInfoDelegate(new QCirclePluginInfoImpl()).injectDaTongReportDelegate(new QCircleDaTongReportImpl());
  }
  
  private boolean d()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return (localAppRuntime != null) && (localAppRuntime.isLogin());
  }
  
  private void e()
  {
    if ((d()) && (c())) {
      QCircleServiceImpl.getQQService().initSDKAsync(new QCircleShadow.2(this));
    }
  }
  
  private void f()
  {
    g();
    a();
    DynamicRuntime.recoveryRuntime(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication);
    QCirclePluginSelector.a().a();
    HostUIHelper.init(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication);
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
        if (!TextUtils.isEmpty((CharSequence)localList.get(i))) {
          localStringBuilder.append("plugin").append(i + 1).append(":").append((String)localList.get(i)).append("\n");
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
    if (this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger != null) {
      return this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger.getPluginInfo();
    }
    return null;
  }
  
  public String a()
  {
    return QCircleServiceImpl.getQZoneService().getQUA3() + "_" + b();
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      LoggerFactory.setILoggerFactory(QCircleServiceImpl.getQQService().getILoggerFactory());
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        QLog.d("QCIRCLE_PLUGIN", 1, "init plugin log exception:" + localRuntimeException);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if (paramString.toLowerCase().contains("qcircle"))
        {
          int i = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger.getPluginInfo().b();
          SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("QCircle_crash_share", 0);
          int j = localSharedPreferences.getInt("QCircle_crash_count_" + i, 0) + 1;
          localSharedPreferences.edit().putInt("QCircle_crash_count_" + i, j).commit();
          if (j >= QCircleConfigHelper.a()) {
            QCirclePluginManager.a().a(i);
          }
          QLog.i("QCIRCLE_PLUGIN", 1, "crashCount: " + j + " crashVersion:" + i + "---------" + paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.i("QCIRCLE_PLUGIN", 1, "check stack exception:" + paramString);
      }
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
    String str3 = "0";
    String str4 = "U";
    String str2 = str4;
    String str1 = str3;
    if (this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger != null)
    {
      QCircleSampleInfo localQCircleSampleInfo = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginEnterManger.getPluginInfo();
      str2 = str4;
      str1 = str3;
      if (localQCircleSampleInfo != null)
      {
        str1 = localQCircleSampleInfo.b() + "";
        str2 = localQCircleSampleInfo.d();
      }
    }
    return str2 + "_" + str1;
  }
  
  public void b()
  {
    QLog.d("QCIRCLE_PLUGIN", 1, "exit qcircle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleShadow
 * JD-Core Version:    0.7.0.1
 */