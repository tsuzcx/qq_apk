import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;

class bder
  implements DownloaderProxy.DownloadListener
{
  bder(bdep parambdep, MiniAppInfo paramMiniAppInfo, String paramString, bdes parambdes) {}
  
  public void onDownloadFailed(int paramInt, String paramString) {}
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    if (!bdfi.a(paramString, bdep.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false), this.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_Bdes != null) {
        this.jdField_a_of_type_Bdes.a(null, -1, "解包失败");
      }
    }
    while (this.jdField_a_of_type_Bdes == null) {
      return;
    }
    this.jdField_a_of_type_Bdes.a((bdfx)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.apkgInfo, 0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bder
 * JD-Core Version:    0.7.0.1
 */