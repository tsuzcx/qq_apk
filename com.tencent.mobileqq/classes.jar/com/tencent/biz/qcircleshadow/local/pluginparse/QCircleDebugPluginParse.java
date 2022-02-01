package com.tencent.biz.qcircleshadow.local.pluginparse;

import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QCircleDebugPluginParse
  extends QCircleBasePluginParse
{
  private static final String f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleConstants.QCIRCLE_TEST_ROOT_PATH);
    localStringBuilder.append("pluginInfo.xml");
    f = localStringBuilder.toString();
  }
  
  public QCircleDebugPluginParse(String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    super(paramString, paramQCirclePluginInfo);
    paramQCirclePluginInfo.version = -2;
    this.jdField_a_of_type_Int = paramQCirclePluginInfo.version;
  }
  
  private QCircleSampleInfo b()
  {
    QLog.i("QCIRCLE_PLUGIN", 1, "parseTest# not debugVersion return");
    return null;
  }
  
  public QCircleSampleInfo a()
  {
    QCircleSampleInfo localQCircleSampleInfo = b();
    if (localQCircleSampleInfo != null)
    {
      QCircleUnZip localQCircleUnZip = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip;
      if (a(QCircleUnZip.a(new File(localQCircleSampleInfo.a())), localQCircleSampleInfo.a(), "parseTest#")) {
        QLog.i("QCIRCLE_PLUGIN", 1, "parseTest# unzip success");
      }
    }
    return localQCircleSampleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleDebugPluginParse
 * JD-Core Version:    0.7.0.1
 */