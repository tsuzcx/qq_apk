import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;

final class bevn
  implements DownloaderProxy.DownloadListener
{
  bevn(MiniAppInfo paramMiniAppInfo, bevs parambevs, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1011, "game pkg download failed s=[" + paramString + "], httpStatus=[" + paramInt + "] ", "1");
    bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 620, null, null, null, paramInt, "1", 0L, null);
    if (this.jdField_a_of_type_Bevs != null)
    {
      this.jdField_a_of_type_Bevs.onInitGpkgInfo(2004, null, "download pkg fail");
      betc.d("[minigame] GpkgManager", "[Gpkg]onDownloadFailed() called with: s = [" + paramInt + "], downloadResult = [" + paramString + "]");
    }
    bezl.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, "page_view", "load_fail", "download_apk_fail", "");
    beyq.a("2launch_fail", "download_apk_fail", null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bevs != null)
    {
      float f = paramFloat;
      long l = paramLong2;
      if (paramLong2 == 0L)
      {
        f = paramFloat;
        l = paramLong2;
        if (this.jdField_a_of_type_Int > 0)
        {
          paramLong2 = this.jdField_a_of_type_Int;
          f = paramFloat;
          l = paramLong2;
          if (paramLong2 > paramLong1)
          {
            f = (float)paramLong1 * 1.0F / (float)paramLong2;
            l = paramLong2;
          }
        }
      }
      this.jdField_a_of_type_Bevs.onDownloadGpkgProgress(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, f, l);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    long l = 0L;
    bevk.jdField_a_of_type_Long = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    betc.b("[minigame] GpkgManager", "[Gpkg] onDownloadSucceed " + paramInt + ",cost:" + bevk.jdField_a_of_type_Long);
    bezi.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 2, "1");
    paramString = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (bevk.jdField_a_of_type_Long > 0L) {
      l = bevk.jdField_a_of_type_Long;
    }
    bezi.a(paramString, 620, null, null, null, 0, "1", l, null);
    bevk.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_Bevs, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevn
 * JD-Core Version:    0.7.0.1
 */