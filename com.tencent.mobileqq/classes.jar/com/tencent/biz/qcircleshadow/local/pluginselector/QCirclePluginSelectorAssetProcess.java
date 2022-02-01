package com.tencent.biz.qcircleshadow.local.pluginselector;

import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.qphone.base.util.QLog;

public class QCirclePluginSelectorAssetProcess
  extends QCircleBaseSelectorProcess
{
  public QCircleSampleInfo a;
  
  public QCirclePluginSelectorAssetProcess(QCircleSampleInfo paramQCircleSampleInfo)
  {
    this.a = paramQCircleSampleInfo;
  }
  
  public QCirclePluginUpdater a()
  {
    if (this.a == null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorAssetProcess#checkAsset():No Asset Info");
      return null;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorAssetProcess#checkAsset():use asset plugin , assetVersion:" + this.a.b() + " ,MiniSupportVersion:" + 8050500);
    return new QCirclePluginUpdater(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorAssetProcess
 * JD-Core Version:    0.7.0.1
 */