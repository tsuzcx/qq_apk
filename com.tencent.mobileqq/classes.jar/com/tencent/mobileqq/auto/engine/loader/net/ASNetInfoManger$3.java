package com.tencent.mobileqq.auto.engine.loader.net;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qqcircle.report.ASEngineQualityReport.ReportData;
import java.io.File;

class ASNetInfoManger$3
  implements Downloader.DownloadListener
{
  ASNetInfoManger$3(ASNetInfoManger paramASNetInfoManger, ASDataBaseInfo paramASDataBaseInfo, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("onDownloadFailed manager apk");
    paramString.append(this.a.getBusinessKey());
    paramString.append("downloadResult:");
    paramString.append(this.b);
    QLog.e("ASNetInfoManger", 1, paramString.toString());
    ASNetInfoManger.a(this.c);
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_download").setExt1(this.a.getBusinessKey()).setPluginVersion(this.a.getVersion()).setPluginType("TYPE_NET").setExt2("apk").setRetCode(-1L));
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("onDownloadSucceed downloadResult manager apk");
    paramString.append(this.b);
    QLog.e("ASNetInfoManger", 1, paramString.toString());
    paramString = new File(this.b);
    if ((paramString.exists()) && (paramString.length() == this.a.getManagerFileLength()))
    {
      this.a.setPluginManagerPath(this.b);
      if (!TextUtils.isEmpty(this.a.getPluginZipPath()))
      {
        this.a.setIsReady(true);
      }
      else
      {
        paramString = (ASDataBaseInfo)ASNetInfoManger.b(this.c).find(ASDataBaseInfo.class, new String[] { this.a.getBusinessKey(), String.valueOf(this.a.getVersion()) });
        if ((paramString != null) && (paramString.getPluginZipPath() != null))
        {
          this.a.setPluginZipPath(paramString.getPluginZipPath());
          this.a.setIsReady(true);
        }
      }
      ASNetInfoManger.a(this.c, this.a);
      ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_download").setExt1(this.a.getBusinessKey()).setPluginVersion(this.a.getVersion()).setPluginType("TYPE_NET").setExt2("apk").setRetCode(0L));
      return;
    }
    paramString = new StringBuilder();
    paramString.append("onDownloadSucceed but manager apk file not complete:");
    paramString.append(this.b);
    QLog.e("ASNetInfoManger", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger.3
 * JD-Core Version:    0.7.0.1
 */