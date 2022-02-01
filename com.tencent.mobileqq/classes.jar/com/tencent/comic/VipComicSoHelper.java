package com.tencent.comic;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class VipComicSoHelper
{
  public static long a;
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(AppHelper.a().getFilesDir(), "comic_so").getAbsolutePath());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("libqgplayer_841.so");
    if (!new File(localStringBuilder.toString()).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "initComicPlayerSo start download");
      }
      ((IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libqgplayer_841", "comic");
      try
      {
        a = SystemClock.elapsedRealtime();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("1|");
        localStringBuilder.append(a);
        localStringBuilder.append("|0");
        DcReportUtil.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", localStringBuilder.toString(), true);
        return;
      }
      catch (Throwable paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "initComicPlayerSo has exists");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "onSoDownloadCompleted");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("libQGamePlayer.zip");
    if (VasSoUtils.a(localStringBuilder.toString(), a(), "libqgplayer_841.so"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo success");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "comic player unCompressSo failure");
    }
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("2|");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt);
      DcReportUtil.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", localStringBuilder.toString(), true);
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicSoHelper
 * JD-Core Version:    0.7.0.1
 */