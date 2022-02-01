import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;

public class bjbp
  implements Downloader.DownloadListener
{
  public bjbp(AdProxyImpl paramAdProxyImpl, AdProxy.ILoadingAdListener paramILoadingAdListener, String paramString, long paramLong, MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + paramString + " canceled");
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onDownloadAdEnd(null, -1L, null);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + paramString + " failed");
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onDownloadAdEnd(null, -1L, null);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + paramString + " succeed");
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onDownloadAdEnd(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqMiniManagerMiniLoadingAdManager$CachedAdInfo.filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbp
 * JD-Core Version:    0.7.0.1
 */