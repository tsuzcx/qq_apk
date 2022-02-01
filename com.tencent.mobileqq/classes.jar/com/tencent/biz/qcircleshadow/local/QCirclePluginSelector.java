package com.tencent.biz.qcircleshadow.local;

import android.content.SharedPreferences;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.pluginparse.QCircleAssetPluginParse;
import com.tencent.biz.qcircleshadow.local.pluginparse.QCircleDebugPluginParse;
import com.tencent.biz.qcircleshadow.local.pluginparse.QCircleNetPluginParse;
import com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorAssetProcess;
import com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorChain;
import com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorDebugProcess;
import com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorNetProcess;
import com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorSupportProcess;
import com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorWnsProcess;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class QCirclePluginSelector
{
  private static volatile QCirclePluginSelector jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginSelector;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private Future<QCircleSampleInfo> jdField_a_of_type_JavaUtilConcurrentFuture;
  private Future<QCircleSampleInfo> b;
  private Future<QCircleSampleInfo> c;
  private Future<QCirclePluginUpdater> d;
  
  public static QCirclePluginSelector a()
  {
    if (jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginSelector == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginSelector == null) {
          jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginSelector = new QCirclePluginSelector();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizQcircleshadowLocalQCirclePluginSelector;
  }
  
  private QCircleSampleInfo a(Future<QCircleSampleInfo> paramFuture)
  {
    if (paramFuture == null) {
      return null;
    }
    try
    {
      paramFuture = (QCircleSampleInfo)paramFuture.get();
      return paramFuture;
    }
    catch (Exception paramFuture)
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_exception_msg").setExt1(paramFuture.getMessage()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createMangerUpdate():exception:");
      localStringBuilder.append(paramFuture.getMessage());
      QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  private String a(Future<QCircleSampleInfo> paramFuture)
  {
    if (paramFuture != null) {}
    try
    {
      if (paramFuture.get() == null) {
        return "";
      }
      paramFuture = ((QCircleSampleInfo)paramFuture.get()).toString();
      return paramFuture;
    }
    catch (Exception paramFuture)
    {
      break label34;
    }
    return "";
    label34:
    QLog.i("QCIRCLE_PLUGIN", 1, " generateInfo failed");
    return "";
  }
  
  private Future<QCircleSampleInfo> a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    if ((!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isPublicVersion()) && (!a()))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "createNetWorkPluginInfo():is not publish");
      return null;
    }
    if (this.c == null) {
      this.c = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new QCircleNetPluginParse("Q_CIRCLE_PLUGIN_NETWORK", paramQCirclePluginInfo));
    }
    return this.c;
  }
  
  private boolean a()
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0).getBoolean("qcircle_is_net_open", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSettingOpen():openNet:");
    localStringBuilder.append(bool);
    QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    return bool;
  }
  
  private boolean a(QCircleSampleInfo paramQCircleSampleInfo1, QCircleSampleInfo paramQCircleSampleInfo2, QCircleSampleInfo paramQCircleSampleInfo3)
  {
    if ((paramQCircleSampleInfo1 == null) && (paramQCircleSampleInfo2 == null) && (paramQCircleSampleInfo3 == null))
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result").setRetCode(5L));
      ILoadPluginDelegate.disPatchCallback(5, "un know exception");
      QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():there is no plugin can be used");
      return true;
    }
    return false;
  }
  
  private QCirclePluginUpdater b()
  {
    QCircleSampleInfo localQCircleSampleInfo1 = a(this.b);
    QCircleSampleInfo localQCircleSampleInfo2 = a(this.jdField_a_of_type_JavaUtilConcurrentFuture);
    QCircleSampleInfo localQCircleSampleInfo3 = a(this.c);
    if (a(localQCircleSampleInfo1, localQCircleSampleInfo2, localQCircleSampleInfo3)) {
      return null;
    }
    return new QCirclePluginSelectorChain().a(new QCirclePluginSelectorSupportProcess()).a(new QCirclePluginSelectorDebugProcess(localQCircleSampleInfo1)).a(new QCirclePluginSelectorWnsProcess(localQCircleSampleInfo2)).a(new QCirclePluginSelectorNetProcess(localQCircleSampleInfo3, localQCircleSampleInfo2)).a(new QCirclePluginSelectorAssetProcess(localQCircleSampleInfo2)).a();
  }
  
  private void b()
  {
    this.d = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new QCirclePluginSelector.1(this));
  }
  
  private void c()
  {
    QCirclePluginInfo localQCirclePluginInfo = new QCirclePluginInfo();
    localQCirclePluginInfo.version = -1;
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new QCircleAssetPluginParse("Q_CIRCLE_PLUGIN_ASSET", localQCirclePluginInfo));
  }
  
  private void d()
  {
    QCirclePluginInfo localQCirclePluginInfo = new QCirclePluginInfo();
    this.b = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new QCircleDebugPluginParse("Q_CIRCLE_PLUGIN_TEST", localQCirclePluginInfo));
  }
  
  private void e()
  {
    QCirclePluginInfo localQCirclePluginInfo = QCirclePluginManager.a().a(true);
    if (localQCirclePluginInfo == null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelector():no net plugin info");
      return;
    }
    a(localQCirclePluginInfo);
  }
  
  public QCirclePluginUpdater a()
  {
    try
    {
      QCirclePluginUpdater localQCirclePluginUpdater = (QCirclePluginUpdater)this.d.get();
      return localQCirclePluginUpdater;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMangerUpdate#:exception:");
      localStringBuilder.append(localException.getMessage());
      QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(a(this.b));
      localArrayList.add(a(this.jdField_a_of_type_JavaUtilConcurrentFuture));
      localArrayList.add(a(this.c));
      return localArrayList;
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, " getInitInfo failed");
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = QCircleFeedPicLoader.createPool(3, 3);
    c();
    d();
    e();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginSelector
 * JD-Core Version:    0.7.0.1
 */