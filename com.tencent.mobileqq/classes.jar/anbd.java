import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UploadSoDownloader;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.FileUtils;
import java.io.File;

public class anbd
  implements ModuleDownloadListener
{
  public anbd(UploadSoDownloader paramUploadSoDownloader) {}
  
  public void onDownloadCanceled(String paramString)
  {
    UploadSoDownloader.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    UploadSoDownloader.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    UploadSoDownloader.b(false);
    String str = UploadSoDownloader.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!FileUtils.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      UploadSoDownloader.b(false);
      return;
    }
    if (UploadSoDownloader.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      UploadSoDownloader.a(this.a, true);
      UploadSoDownloader.a(true);
    }
    for (;;)
    {
      UploadSoDownloader.b(false);
      return;
      try
      {
        localFile.delete();
        UploadSoDownloader.a(this.a, false);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbd
 * JD-Core Version:    0.7.0.1
 */