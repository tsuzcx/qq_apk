package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.atomic.AtomicBoolean;

class BrowserAppInterface$3
  implements TbsListener
{
  BrowserAppInterface$3(BrowserAppInterface paramBrowserAppInterface, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  public void onDownloadFinish(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs download finish result=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("TBS_update", 1, ((StringBuilder)localObject).toString());
    if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122))
    {
      if (BrowserAppInterface.c.compareAndSet(true, false))
      {
        QbSdk.setTbsListener(null);
        int i = this.a.getInt("tbs_download_count", 0);
        long l1 = this.a.getLong("tbs_download_cost", 0L);
        long l2 = System.currentTimeMillis();
        long l3 = this.b;
        localObject = this.a.edit();
        ((SharedPreferences.Editor)localObject).putInt("tbs_download_count", i + 1);
        ((SharedPreferences.Editor)localObject).putLong("tbs_download_cost", l1 + (l2 - l3));
        ((SharedPreferences.Editor)localObject).commit();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_error", 0, 1, paramInt, "", "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tbs download aborted:");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("TBS_update", 2, ((StringBuilder)localObject).toString());
        }
      }
      localObject = this.a.edit();
      ((SharedPreferences.Editor)localObject).putInt("tbs_download_complete", paramInt);
      ((SharedPreferences.Editor)localObject).remove("tbs_downloading");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
      if (this.c.e)
      {
        localObject = this.c;
        BrowserAppInterface.a((BrowserAppInterface)localObject, ((BrowserAppInterface)localObject).g);
      }
    }
    else
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_ok", 0, 1, paramInt, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs download finished");
      }
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tbs download progress ");
      localStringBuilder.append(paramInt);
      QLog.d("TBS_update", 2, localStringBuilder.toString());
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs download install finish result=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("TBS_update", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 200) {
      return;
    }
    if (BrowserAppInterface.c.compareAndSet(true, false))
    {
      QbSdk.setTbsListener(null);
      int i;
      long l1;
      long l2;
      long l3;
      if ((paramInt != 232) && (paramInt != 220))
      {
        i = this.a.getInt("tbs_download_count", 0);
        l1 = this.a.getLong("tbs_download_cost", 0L);
        l2 = System.currentTimeMillis();
        l3 = this.b;
        localObject = this.a.edit();
        ((SharedPreferences.Editor)localObject).putInt("tbs_download_count", i + 1);
        ((SharedPreferences.Editor)localObject).putLong("tbs_download_cost", l1 + (l2 - l3));
        ((SharedPreferences.Editor)localObject).commit();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_error", 0, 1, paramInt, "", "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tbs install error:");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("TBS_update", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        i = this.a.getInt("tbs_download_count", 0);
        l1 = this.a.getLong("tbs_download_cost", 0L);
        l2 = System.currentTimeMillis();
        l3 = this.b;
        localObject = this.a.edit();
        ((SharedPreferences.Editor)localObject).remove("tbs_download_count");
        ((SharedPreferences.Editor)localObject).remove("tbs_download_cost");
        ((SharedPreferences.Editor)localObject).commit();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_ok", 0, 1, paramInt, Long.toString(l1 + (l2 - l3)), Integer.toString(i + 1), "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tbs install finished:");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("TBS_update", 2, ((StringBuilder)localObject).toString());
        }
        WebpSoLoader.a(false);
      }
      localObject = this.a.edit();
      ((SharedPreferences.Editor)localObject).putInt("tbs_download_complete", paramInt);
      ((SharedPreferences.Editor)localObject).remove("tbs_downloading");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (this.c.e)
    {
      localObject = this.c;
      BrowserAppInterface.a((BrowserAppInterface)localObject, ((BrowserAppInterface)localObject).g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface.3
 * JD-Core Version:    0.7.0.1
 */