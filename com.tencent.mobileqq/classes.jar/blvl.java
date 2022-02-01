import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class blvl
  implements ModuleDownloadListener
{
  blvl(blvk paramblvk) {}
  
  public void onDownloadCanceled(String paramString)
  {
    blvk.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    blvk.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    blvk.b(false);
    String str = blvk.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bmij.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      blvk.b(false);
      return;
    }
    if (blvk.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      blvk.a(this.a, true);
      blvk.a(true);
    }
    for (;;)
    {
      blvk.b(false);
      return;
      try
      {
        localFile.delete();
        blvk.a(this.a, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvl
 * JD-Core Version:    0.7.0.1
 */