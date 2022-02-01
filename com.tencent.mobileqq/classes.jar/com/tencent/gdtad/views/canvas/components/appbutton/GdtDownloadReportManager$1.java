package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class GdtDownloadReportManager$1
  implements DownloadListener
{
  GdtDownloadReportManager$1(GdtDownloadReportManager paramGdtDownloadReportManager) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((GdtDownloadReportManager.c(this.a) != null) && (GdtDownloadReportManager.c(this.a).getAppId() != null) && (GdtDownloadReportManager.c(this.a).getAppPackageName() != null) && (GdtDownloadReportManager.c(this.a).getAppId().equals(paramString1)) && (GdtDownloadReportManager.c(this.a).getAppPackageName().equals(paramString2)))
    {
      paramString2 = GdtDownloadReportManager.a(this.a, paramString2);
      ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, paramString1));
      return;
    }
    GdtLog.d("GdtDownloadReportManager", "no ad or not the same ad");
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (TextUtils.isEmpty(paramDownloadInfo.c)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFinish: infos:");
      ((StringBuilder)localObject).append(paramDownloadInfo.t);
      GdtLog.a("GdtDownloadReportManager", ((StringBuilder)localObject).toString());
      if ((GdtDownloadReportManager.a(this.a).containsKey(paramDownloadInfo.c)) && (GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c) != null))
      {
        GdtTraceReporter.a((Ad)GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c), 274);
        return;
      }
      localObject = this.a;
      if (GdtDownloadReportManager.a((GdtDownloadReportManager)localObject, paramDownloadInfo, GdtDownloadReportManager.c((GdtDownloadReportManager)localObject))) {
        GdtTraceReporter.a(GdtDownloadReportManager.c(this.a), 274);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (TextUtils.isEmpty(paramDownloadInfo.c)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadPause: infos:");
      ((StringBuilder)localObject).append(paramDownloadInfo.t);
      GdtLog.a("GdtDownloadReportManager", ((StringBuilder)localObject).toString());
      if ((GdtDownloadReportManager.a(this.a).containsKey(paramDownloadInfo.c)) && (GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c) != null))
      {
        GdtTraceReporter.a((Ad)GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c), 273);
        GdtDownloadReportManager.b(this.a).put(paramDownloadInfo.c, GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c));
        return;
      }
      localObject = this.a;
      if (GdtDownloadReportManager.a((GdtDownloadReportManager)localObject, paramDownloadInfo, GdtDownloadReportManager.c((GdtDownloadReportManager)localObject))) {
        GdtTraceReporter.a(GdtDownloadReportManager.c(this.a), 273);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadUpdate: infos:");
      ((StringBuilder)localObject).append(paramList.size());
      GdtLog.a("GdtDownloadReportManager", ((StringBuilder)localObject).toString());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (DownloadInfo)paramList.next();
        if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).c)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDownloadUpdate: progress:");
          localStringBuilder.append(((DownloadInfo)localObject).t);
          GdtLog.a("GdtDownloadReportManager", localStringBuilder.toString());
          if ((GdtDownloadReportManager.b(this.a).containsKey(((DownloadInfo)localObject).c)) && (GdtDownloadReportManager.b(this.a).get(((DownloadInfo)localObject).c) != null))
          {
            GdtTraceReporter.a((Ad)GdtDownloadReportManager.b(this.a).get(((DownloadInfo)localObject).c), 271);
            GdtDownloadReportManager.b(this.a).remove(((DownloadInfo)localObject).c);
          }
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    installSucceed(paramString1, paramString2);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1
 * JD-Core Version:    0.7.0.1
 */