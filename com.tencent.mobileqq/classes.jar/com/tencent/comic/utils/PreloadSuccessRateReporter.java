package com.tencent.comic.utils;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class PreloadSuccessRateReporter
{
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt2);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt1);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramLong);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(Build.BRAND);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(Build.MODEL);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(Build.VERSION.RELEASE);
    if ((paramAppRuntime instanceof BaseQQAppInterface)) {
      paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[preloadSuccessRate]: ");
      localStringBuilder2.append(localStringBuilder1.toString());
      QLog.d("PreloadSuccessRateReporter", 2, localStringBuilder2.toString());
    }
    DcReportUtil.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preloadSuccessRate", localStringBuilder1.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.utils.PreloadSuccessRateReporter
 * JD-Core Version:    0.7.0.1
 */