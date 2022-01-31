import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.util.List;
import java.util.Map;

final class bgug
  implements DownloaderProxy.DownloadListener
{
  bgug(MiniGamePluginInfo paramMiniGamePluginInfo, bguk parambguk, File paramFile1, File paramFile2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin failed " + paramInt + " " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
    this.jdField_a_of_type_Bguk.a(false, null);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo.packageSize != 0) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo.packageSize != this.jdField_a_of_type_JavaIoFile.length()))
      {
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin file-size mismatch " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
        this.jdField_a_of_type_Bguk.a(false, new RuntimeException("file size mismatch, expected:" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo.packageSize + " got:" + this.jdField_a_of_type_JavaIoFile.length()));
        return;
      }
      bgkv.a(this.b.getAbsolutePath(), false);
      if (!bgjt.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.b.getAbsolutePath()))
      {
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin unpack failed " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
        this.jdField_a_of_type_Bguk.a(false, new RuntimeException("unpack file failed"));
        return;
      }
      QMLog.i("[minigame] GpkgManager", "[Gpkg] download plugin success " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniGamePluginInfo);
      this.jdField_a_of_type_Bguk.a(true, null);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgug
 * JD-Core Version:    0.7.0.1
 */