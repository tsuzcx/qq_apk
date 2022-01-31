import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;

class bgjj
  implements DownloaderProxy.DownloadListener
{
  bgjj(bgjh parambgjh, MiniAppInfo paramMiniAppInfo, String paramString, bgjk parambgjk) {}
  
  public void onDownloadFailed(int paramInt, String paramString) {}
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    if (!bgjt.a(paramString, bgjh.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false), this.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_Bgjk != null) {
        this.jdField_a_of_type_Bgjk.a(null, -1, "解包失败");
      }
    }
    while (this.jdField_a_of_type_Bgjk == null) {
      return;
    }
    this.jdField_a_of_type_Bgjk.a((bgjw)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.apkgInfo, 0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjj
 * JD-Core Version:    0.7.0.1
 */