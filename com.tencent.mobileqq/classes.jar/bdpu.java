import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

final class bdpu
  implements DownloaderProxy.DownloadListener
{
  bdpu(MiniAppInfo paramMiniAppInfo, bdpx parambdpx, String paramString1, String paramString2, bdpy parambdpy) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, null, null, null, paramInt, "1", 0L, null);
    if (this.jdField_a_of_type_Bdpx != null)
    {
      this.jdField_a_of_type_Bdpx.a(2010, null, "download sub pkg fail");
      bdnw.a("[minigame] GpkgManager", "onDownloadFailed() called with: s = [" + paramInt + "], downloadResult = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bdpx != null) {
      this.jdField_a_of_type_Bdpx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, paramFloat, paramLong2);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, "1");
    paramString = bdnx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    paramMap = new File(this.jdField_a_of_type_JavaLangString);
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 615, "1");
    boolean bool = bdfi.a(paramMap.getAbsolutePath(), paramString, this.b, true);
    paramMap = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (bool)
    {
      paramInt = 0;
      bdsu.a(paramMap, 616, null, null, null, paramInt, "1", 0L, null);
      bdnw.a("[minigame] GpkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + this.b);
      if (!bool) {
        break label166;
      }
      if (this.jdField_a_of_type_Bdpx != null) {
        this.jdField_a_of_type_Bdpx.a(0, this.jdField_a_of_type_Bdpy, "download sub pkg and unpack succeed");
      }
    }
    label166:
    while (this.jdField_a_of_type_Bdpx == null)
    {
      return;
      paramInt = 1;
      break;
    }
    this.jdField_a_of_type_Bdpx.a(2011, null, "download sub pkg succeed, but unpack sub pkg fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpu
 * JD-Core Version:    0.7.0.1
 */