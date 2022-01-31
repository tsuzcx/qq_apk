import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import cooperation.qzone.util.FileUtils;
import java.io.File;

public class amki
  implements ModuleDownloadListener
{
  public amki(AlbumLibDownloaderUtil paramAlbumLibDownloaderUtil) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("pictureMarkerSo.so")) {
      return;
    }
    String str = AlbumLibDownloaderUtil.a.getPath();
    paramString = new File(QzoneModuleManager.getInstance().getModuleFilePath(paramString));
    if (paramString.exists()) {
      paramString.renameTo(new File(AlbumLibDownloaderUtil.a.getPath() + "/photoQulatitySo.zip"));
    }
    paramString = new File(str);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    FileUtils.b(new File(AlbumLibDownloaderUtil.a.getPath() + "/photoQulatitySo.zip"), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amki
 * JD-Core Version:    0.7.0.1
 */