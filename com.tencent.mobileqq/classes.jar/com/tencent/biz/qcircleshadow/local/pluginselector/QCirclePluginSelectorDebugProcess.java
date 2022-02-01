package com.tencent.biz.qcircleshadow.local.pluginselector;

import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class QCirclePluginSelectorDebugProcess
  extends QCircleBaseSelectorProcess
{
  private QCircleSampleInfo a;
  
  public QCirclePluginSelectorDebugProcess(QCircleSampleInfo paramQCircleSampleInfo)
  {
    this.a = paramQCircleSampleInfo;
  }
  
  private QCirclePluginUpdater b()
  {
    if ((this.a == null) || (!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorDebugProcess#checkDebug():use test plugin？ false");
      return null;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorDebugProcess#checkDebug():use test plugin？ true");
    return new QCirclePluginUpdater(this.a);
  }
  
  public QCirclePluginUpdater a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorDebugProcess
 * JD-Core Version:    0.7.0.1
 */