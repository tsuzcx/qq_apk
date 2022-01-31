import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bhba
  implements ModuleDownloadListener
{
  bhba(bhaz parambhaz) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bhaz.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    bhaz.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    bhaz.b(false);
    String str = bhaz.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bhnq.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      bhaz.b(false);
      return;
    }
    if (bhaz.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      bhaz.a(this.a, true);
      bhaz.a(true);
    }
    for (;;)
    {
      bhaz.b(false);
      return;
      try
      {
        localFile.delete();
        bhaz.a(this.a, false);
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
 * Qualified Name:     bhba
 * JD-Core Version:    0.7.0.1
 */