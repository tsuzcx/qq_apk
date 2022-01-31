import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.util.List;
import java.util.Map;

final class bguj
  implements DownloaderProxy.DownloadListener
{
  bguj(MiniAppInfo paramMiniAppInfo, bgum parambgum, String paramString1, String paramString2, bgun parambgun, int paramInt) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, null, null, null, paramInt, "1", 0L, null);
    if (this.jdField_a_of_type_Bgum != null)
    {
      this.jdField_a_of_type_Bgum.onInitGpkgInfo(2010, null, "download sub pkg fail");
      QMLog.d("[minigame] GpkgManager", "onDownloadFailed() called with: s = [" + paramInt + "], downloadResult = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bgum != null)
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
      this.jdField_a_of_type_Bgum.onDownloadGpkgProgress(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, f, l);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, "1");
    paramString = bgrb.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    paramMap = new File(this.jdField_a_of_type_JavaLangString);
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 615, "1");
    boolean bool = bgjt.a(paramMap.getAbsolutePath(), paramString, this.b, true);
    paramMap = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (bool)
    {
      paramInt = 0;
      bgyd.a(paramMap, 616, null, null, null, paramInt, "1", 0L, null);
      QMLog.d("[minigame] GpkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + this.b);
      if (!bool) {
        break label166;
      }
      if (this.jdField_a_of_type_Bgum != null) {
        this.jdField_a_of_type_Bgum.onInitGpkgInfo(0, this.jdField_a_of_type_Bgun, "download sub pkg and unpack succeed");
      }
    }
    label166:
    while (this.jdField_a_of_type_Bgum == null)
    {
      return;
      paramInt = 1;
      break;
    }
    this.jdField_a_of_type_Bgum.onInitGpkgInfo(2011, null, "download sub pkg succeed, but unpack sub pkg fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguj
 * JD-Core Version:    0.7.0.1
 */