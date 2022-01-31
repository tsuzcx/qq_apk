import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.util.List;
import java.util.Map;

class bgvm
  implements DownloaderProxy.DownloadListener
{
  bgvm(bgvi parambgvi, bgvo parambgvo, bgod parambgod, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bgvo != null)
    {
      this.jdField_a_of_type_Bgvo.onInitApkgInfo(2, this.jdField_a_of_type_Bgod, "下载失败");
      QMLog.d("ApkgManager", "onDownloadFailed() called with: statusCode = [" + paramInt + "], errorMsg = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 615, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    paramString = bgvi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    boolean bool = bgoa.a(new File(this.b).getAbsolutePath(), paramString, bgvi.a(this.jdField_a_of_type_Bgvi));
    QMLog.d("ApkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + bgvi.a(this.jdField_a_of_type_Bgvi));
    bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 616, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    if (bool) {
      if (this.jdField_a_of_type_Bgvo != null) {
        this.jdField_a_of_type_Bgvo.onInitApkgInfo(0, this.jdField_a_of_type_Bgod, null);
      }
    }
    while (this.jdField_a_of_type_Bgvo == null) {
      return;
    }
    this.jdField_a_of_type_Bgvo.onInitApkgInfo(3, this.jdField_a_of_type_Bgod, "解包失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvm
 * JD-Core Version:    0.7.0.1
 */