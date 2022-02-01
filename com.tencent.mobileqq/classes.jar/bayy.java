import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

final class bayy
  implements Downloader.DownloadListener
{
  bayy(QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.a != null) {
      this.a.onResult(false);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.a != null) {
      this.a.onResult(false);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.a != null) {
      this.a.onResult(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayy
 * JD-Core Version:    0.7.0.1
 */