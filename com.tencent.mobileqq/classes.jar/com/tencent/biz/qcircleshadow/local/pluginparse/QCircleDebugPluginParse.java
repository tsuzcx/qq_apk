package com.tencent.biz.qcircleshadow.local.pluginparse;

import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QCircleDebugPluginParse
  extends QCircleBasePluginParse
{
  public QCircleDebugPluginParse(String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    super(paramString, paramQCirclePluginInfo);
  }
  
  private QCircleSampleInfo b()
  {
    QLog.i("QCIRCLE_PLUGIN", 1, "parseTest# not debugVersion return");
    return null;
  }
  
  public QCircleSampleInfo a()
  {
    QCircleSampleInfo localQCircleSampleInfo = b();
    if ((localQCircleSampleInfo != null) && (a(this.a.a(new File(localQCircleSampleInfo.a())), localQCircleSampleInfo.a(), "parseTest#"))) {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseTest# unzip success");
    }
    return localQCircleSampleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleDebugPluginParse
 * JD-Core Version:    0.7.0.1
 */