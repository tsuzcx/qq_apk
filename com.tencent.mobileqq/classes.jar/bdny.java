import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

class bdny
  implements DownloaderProxy.DownloadListener
{
  bdny(bdnx parambdnx, bdnz parambdnz, bdfx parambdfx, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bdnz != null)
    {
      this.jdField_a_of_type_Bdnz.onInitApkgInfo(2, this.jdField_a_of_type_Bdfx, "下载失败");
      bdnw.a("ApkgManager", "onDownloadFailed() called with: statusCode = [" + paramInt + "], errorMsg = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 615, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    paramString = bdnx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    boolean bool = bdfi.a(new File(this.b).getAbsolutePath(), paramString, bdnx.a(this.jdField_a_of_type_Bdnx));
    bdnw.a("ApkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + bdnx.a(this.jdField_a_of_type_Bdnx));
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 616, this.jdField_a_of_type_JavaLangString, null, null, 0, "0", 0L, null);
    if (bool) {
      if (this.jdField_a_of_type_Bdnz != null) {
        this.jdField_a_of_type_Bdnz.onInitApkgInfo(0, this.jdField_a_of_type_Bdfx, null);
      }
    }
    while (this.jdField_a_of_type_Bdnz == null) {
      return;
    }
    this.jdField_a_of_type_Bdnz.onInitApkgInfo(3, this.jdField_a_of_type_Bdfx, "解包失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdny
 * JD-Core Version:    0.7.0.1
 */