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
    if ((GdtDownloadReportManager.a(this.a) == null) || (GdtDownloadReportManager.a(this.a).getAppId() == null) || (GdtDownloadReportManager.a(this.a).getAppPackageName() == null) || (!GdtDownloadReportManager.a(this.a).getAppId().equals(paramString1)) || (!GdtDownloadReportManager.a(this.a).getAppPackageName().equals(paramString2)))
    {
      GdtLog.d("GdtDownloadReportManager", "no ad or not the same ad");
      return;
    }
    paramString2 = GdtDownloadReportManager.a(this.a, paramString2);
    ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, paramString1));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      GdtLog.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
      if ((GdtDownloadReportManager.a(this.a).containsKey(paramDownloadInfo.c)) && (GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c) != null))
      {
        GdtTraceReporter.a((Ad)GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c), 274);
        return;
      }
    } while (!GdtDownloadReportManager.a(this.a, paramDownloadInfo, GdtDownloadReportManager.a(this.a)));
    GdtTraceReporter.a(GdtDownloadReportManager.a(this.a), 274);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.c))) {}
    do
    {
      return;
      GdtLog.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
      if ((GdtDownloadReportManager.a(this.a).containsKey(paramDownloadInfo.c)) && (GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c) != null))
      {
        GdtTraceReporter.a((Ad)GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c), 273);
        GdtDownloadReportManager.b(this.a).put(paramDownloadInfo.c, GdtDownloadReportManager.a(this.a).get(paramDownloadInfo.c));
        return;
      }
    } while (!GdtDownloadReportManager.a(this.a, paramDownloadInfo, GdtDownloadReportManager.a(this.a)));
    GdtTraceReporter.a(GdtDownloadReportManager.a(this.a), 273);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      GdtLog.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.c)))
        {
          GdtLog.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
          if ((GdtDownloadReportManager.b(this.a).containsKey(localDownloadInfo.c)) && (GdtDownloadReportManager.b(this.a).get(localDownloadInfo.c) != null))
          {
            GdtTraceReporter.a((Ad)GdtDownloadReportManager.b(this.a).get(localDownloadInfo.c), 271);
            GdtDownloadReportManager.b(this.a).remove(localDownloadInfo.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1
 * JD-Core Version:    0.7.0.1
 */