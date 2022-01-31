import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;

class bjtv
  implements ModuleDownloadListener
{
  bjtv(bjts parambjts) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("libandroidndkbeauty.so")) {}
    for (;;)
    {
      return;
      String str = bjts.a.getPath();
      paramString = new File(QzoneModuleManager.getInstance().getModuleFilePath(paramString));
      if (paramString.exists()) {}
      try
      {
        bjts.a(paramString, new File(bjts.a.getPath() + "/libandroidndkbeauty.zip"));
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        if (this.a.a(bjts.b, false)) {
          continue;
        }
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "unzip beauty so" });
        bjtz.b(new File(bjts.a.getPath() + "/libandroidndkbeauty.zip"), paramString);
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "unzip beauty so finish" });
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtv
 * JD-Core Version:    0.7.0.1
 */