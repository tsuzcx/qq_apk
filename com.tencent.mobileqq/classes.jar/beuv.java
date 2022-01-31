import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

final class beuv
  implements DownloaderProxy.DownloadListener
{
  beuv(MiniGamePluginInfo paramMiniGamePluginInfo, beuz parambeuz, File paramFile1, File paramFile2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    besl.d("[minigame] GpkgManager", "[Gpkg] download plugin failed " + paramInt + " " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
    this.jdField_a_of_type_Beuz.a(false, null);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo.a != 0) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo.a != this.jdField_a_of_type_JavaIoFile.length()))
      {
        besl.d("[minigame] GpkgManager", "[Gpkg] download plugin file-size mismatch " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
        this.jdField_a_of_type_Beuz.a(false, new RuntimeException("file size mismatch, expected:" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo.a + " got:" + this.jdField_a_of_type_JavaIoFile.length()));
        return;
      }
      bekq.a(this.b.getAbsolutePath(), false);
      if (!beji.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.b.getAbsolutePath()))
      {
        besl.d("[minigame] GpkgManager", "[Gpkg] download plugin unpack failed " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
        this.jdField_a_of_type_Beuz.a(false, new RuntimeException("unpack file failed"));
        return;
      }
      besl.b("[minigame] GpkgManager", "[Gpkg] download plugin success " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
      this.jdField_a_of_type_Beuz.a(true, null);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuv
 * JD-Core Version:    0.7.0.1
 */