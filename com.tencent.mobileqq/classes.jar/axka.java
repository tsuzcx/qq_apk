import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

final class axka
  implements Downloader.DownloadListener
{
  axka(QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axka
 * JD-Core Version:    0.7.0.1
 */