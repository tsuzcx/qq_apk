import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.14.1;
import java.util.List;

public class bkpg
  implements DownloadListener
{
  bkpg(bkpb parambkpb) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((bkpb.b(this.a) != null) && (bkpb.c(this.a) != null) && (bkpb.b(this.a).equals(paramString1)) && (bkpb.c(this.a).equals(paramString2)))
    {
      QLog.d("MiniAppProxyImpl", 1, "installSucceed: " + paramString1 + "; pkgname : " + paramString2);
      InnerAppReportDc4239.innerAppReport(bkpb.a(this.a), null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((bkpb.a(this.a) != null) && (paramDownloadInfo != null) && (bkpb.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((bkpb.a(this.a) != null) && (paramDownloadInfo != null) && (bkpb.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((bkpb.a(this.a) != null) && (paramDownloadInfo != null) && (bkpb.a(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.14.1(this));
      InnerAppReportDc4239.innerAppReport(bkpb.a(this.a), null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((bkpb.a(this.a) != null) && (paramDownloadInfo != null) && (bkpb.a(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
      InnerAppReportDc4239.innerAppReport(bkpb.a(this.a), null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((bkpb.a(this.a) != null) && (paramDownloadInfo != null) && (bkpb.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpg
 * JD-Core Version:    0.7.0.1
 */