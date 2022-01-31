import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

final class beuy
  implements DownloaderProxy.DownloadListener
{
  beuy(MiniAppInfo paramMiniAppInfo, bevb parambevb, String paramString1, String paramString2, bevc parambevc, int paramInt) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, null, null, null, paramInt, "1", 0L, null);
    if (this.jdField_a_of_type_Bevb != null)
    {
      this.jdField_a_of_type_Bevb.onInitGpkgInfo(2010, null, "download sub pkg fail");
      besl.a("[minigame] GpkgManager", "onDownloadFailed() called with: s = [" + paramInt + "], downloadResult = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bevb != null)
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
      this.jdField_a_of_type_Bevb.onDownloadGpkgProgress(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, f, l);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 614, "1");
    paramString = besm.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    paramMap = new File(this.jdField_a_of_type_JavaLangString);
    beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 615, "1");
    boolean bool = beji.a(paramMap.getAbsolutePath(), paramString, this.b, true);
    paramMap = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (bool)
    {
      paramInt = 0;
      beyr.a(paramMap, 616, null, null, null, paramInt, "1", 0L, null);
      besl.a("[minigame] GpkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + this.b);
      if (!bool) {
        break label166;
      }
      if (this.jdField_a_of_type_Bevb != null) {
        this.jdField_a_of_type_Bevb.onInitGpkgInfo(0, this.jdField_a_of_type_Bevc, "download sub pkg and unpack succeed");
      }
    }
    label166:
    while (this.jdField_a_of_type_Bevb == null)
    {
      return;
      paramInt = 1;
      break;
    }
    this.jdField_a_of_type_Bevb.onInitGpkgInfo(2011, null, "download sub pkg succeed, but unpack sub pkg fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuy
 * JD-Core Version:    0.7.0.1
 */