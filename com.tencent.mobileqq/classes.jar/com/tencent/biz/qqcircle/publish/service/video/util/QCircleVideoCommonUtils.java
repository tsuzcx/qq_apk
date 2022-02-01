package com.tencent.biz.qqcircle.publish.service.video.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;

public class QCircleVideoCommonUtils
{
  public static QCircleVideoCommonUtils.VideoSupport a()
  {
    int i = 1;
    Object localObject = Integer.valueOf(1);
    if (QCircleConfigHelper.a("MiniVideo", "videoTrimEnableHw", (Integer)localObject).intValue() != 1) {
      return QCircleVideoCommonUtils.VideoSupport.c;
    }
    if (QCircleConfigHelper.a("TrimVideo", "SupportTrimVideoHW", Integer.valueOf(-1)).intValue() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() severBlackList");
      }
      return QCircleVideoCommonUtils.VideoSupport.c;
    }
    int j = QCircleConfigHelper.a("TrimVideo", "NeedLocalBlackList", (Integer)localObject).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Build.Model=");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.d("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((j > 0) && ("GT-N7100|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localBlackList");
      }
      return QCircleVideoCommonUtils.VideoSupport.c;
    }
    j = QCircleConfigHelper.a("TrimVideo", "MinSdkVersionHw", Integer.valueOf(18)).intValue();
    int k = Build.VERSION.SDK_INT;
    if (k < j)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTrimHWSupport() localSdkVersion=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" serverSdkVersion=");
        ((StringBuilder)localObject).append(j);
        QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
      }
      return QCircleVideoCommonUtils.VideoSupport.e;
    }
    j = MediaCodecSupport.checkSupportMediaCodecFeature(HostUIHelper.getInstance().getHostApplicationContext());
    if (((j & 0x1) <= 0) || ((j & 0x2) <= 0)) {
      i = 0;
    }
    if (i == 0) {
      return QCircleVideoCommonUtils.VideoSupport.h;
    }
    return QCircleVideoCommonUtils.VideoSupport.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.util.QCircleVideoCommonUtils
 * JD-Core Version:    0.7.0.1
 */