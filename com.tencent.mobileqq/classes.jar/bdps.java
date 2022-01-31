import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;

final class bdps
  implements DownloaderProxy.DownloadListener
{
  bdps(MiniAppInfo paramMiniAppInfo, bdpx parambdpx, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1011, "game pkg download failed s=[" + paramString + "], httpStatus=[" + paramInt + "] ", "1");
    bdsu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 620, null, null, null, paramInt, "1", 0L, null);
    if (this.jdField_a_of_type_Bdpx != null)
    {
      this.jdField_a_of_type_Bdpx.a(2004, null, "download pkg fail");
      bdnw.d("[minigame] GpkgManager", "[Gpkg]onDownloadFailed() called with: s = [" + paramInt + "], downloadResult = [" + paramString + "]");
    }
    bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "page_view", "load_fail", "download_apk_fail", "");
    bdsc.a("2launch_fail", "download_apk_fail", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
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
    long l = 0L;
    bdpp.jdField_a_of_type_Long = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    bdnw.b("[minigame] GpkgManager", "[Gpkg] onDownloadSucceed " + paramInt + ",cost:" + bdpp.jdField_a_of_type_Long);
    bdsu.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 2, "1");
    paramString = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (bdpp.jdField_a_of_type_Long > 0L) {
      l = bdpp.jdField_a_of_type_Long;
    }
    bdsu.a(paramString, 620, null, null, null, 0, "1", l, null);
    bdpp.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_Bdpx, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdps
 * JD-Core Version:    0.7.0.1
 */