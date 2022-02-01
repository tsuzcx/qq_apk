import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.14.1;
import java.util.List;

public class bkyc
  implements DownloadListener
{
  bkyc(bkxx parambkxx) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((bkxx.b(this.a) != null) && (bkxx.c(this.a) != null) && (bkxx.b(this.a).equals(paramString1)) && (bkxx.c(this.a).equals(paramString2)))
    {
      QLog.d("MiniAppProxyImpl", 1, "installSucceed: " + paramString1 + "; pkgname : " + paramString2);
      InnerAppReportDc4239.innerAppReport(bkxx.a(this.a), null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((bkxx.a(this.a) != null) && (paramDownloadInfo != null) && (bkxx.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((bkxx.a(this.a) != null) && (paramDownloadInfo != null) && (bkxx.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((bkxx.a(this.a) != null) && (paramDownloadInfo != null) && (bkxx.a(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.14.1(this));
      InnerAppReportDc4239.innerAppReport(bkxx.a(this.a), null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((bkxx.a(this.a) != null) && (paramDownloadInfo != null) && (bkxx.a(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
      InnerAppReportDc4239.innerAppReport(bkxx.a(this.a), null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((bkxx.a(this.a) != null) && (paramDownloadInfo != null) && (bkxx.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyc
 * JD-Core Version:    0.7.0.1
 */