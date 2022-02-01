package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;
import java.util.concurrent.Future;

public class QCirclePluginEnterManger
  implements PluginManager
{
  private QCirclePluginUpdater mManagerUpdater;
  private QCircleSampleInfo mPluginInfo;
  private final DynamicPluginManager mPluginManager;
  
  public QCirclePluginEnterManger(DynamicPluginManager paramDynamicPluginManager)
  {
    this.mPluginManager = paramDynamicPluginManager;
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginEnterManger#enter():enter formId:" + paramLong);
        }
        try
        {
          if ((this.mManagerUpdater != null) && (this.mManagerUpdater.getLatest().exists()) && (((Boolean)this.mManagerUpdater.isAvailable(this.mManagerUpdater.getLatest()).get()).booleanValue()))
          {
            this.mPluginManager.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
            return;
          }
          QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginEnterManger#enter():plugin source file is deleted");
          if ((paramLong != 1000L) && (paramLong != 1004L)) {
            continue;
          }
          paramBundle = new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result");
          if (this.mPluginInfo != null)
          {
            paramContext = this.mPluginInfo.c();
            paramContext = paramBundle.setPluginType(paramContext);
            if (this.mPluginInfo == null) {
              break label241;
            }
            paramLong = this.mPluginInfo.b();
            QCirclePluginQualityReporter.report(paramContext.setPluginVersion(paramLong).setRetCode(1L));
            ILoadPluginDelegate.disPatchCallback(1, "file has delete");
            continue;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginEnterManger#enter():" + paramContext.getMessage());
          continue;
        }
        paramContext = "";
      }
      finally {}
      continue;
      label241:
      paramLong = -3L;
    }
  }
  
  public QCircleSampleInfo getPluginInfo()
  {
    return this.mPluginInfo;
  }
  
  public void setPluginInfo(QCircleSampleInfo paramQCircleSampleInfo)
  {
    this.mPluginInfo = paramQCircleSampleInfo;
  }
  
  public void setUpdater(QCirclePluginUpdater paramQCirclePluginUpdater)
  {
    this.mManagerUpdater = paramQCirclePluginUpdater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnterManger
 * JD-Core Version:    0.7.0.1
 */