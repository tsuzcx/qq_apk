import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.util.List;
import java.util.Map;

class bgrf
  implements DownloaderProxy.DownloadListener
{
  bgrf(bgrb parambgrb, bgrh parambgrh, bgjw parambgjw, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bgrh != null)
    {
      this.jdField_a_of_type_Bgrh.onInitApkgInfo(2, this.jdField_a_of_type_Bgjw, "下载失败");
      QMLog.d("ApkgManager", "onDownloadFailed() called with: statusCode = [" + paramInt + "], errorMsg = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 615, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    paramString = bgrb.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    boolean bool = bgjt.a(new File(this.b).getAbsolutePath(), paramString, bgrb.a(this.jdField_a_of_type_Bgrb));
    QMLog.d("ApkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + bgrb.a(this.jdField_a_of_type_Bgrb));
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 616, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    if (bool) {
      if (this.jdField_a_of_type_Bgrh != null) {
        this.jdField_a_of_type_Bgrh.onInitApkgInfo(0, this.jdField_a_of_type_Bgjw, null);
      }
    }
    while (this.jdField_a_of_type_Bgrh == null) {
      return;
    }
    this.jdField_a_of_type_Bgrh.onInitApkgInfo(3, this.jdField_a_of_type_Bgjw, "解包失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrf
 * JD-Core Version:    0.7.0.1
 */