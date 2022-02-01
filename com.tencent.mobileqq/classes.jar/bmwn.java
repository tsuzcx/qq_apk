import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bmwn
  implements ModuleDownloadListener
{
  bmwn(bmwm parambmwm) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bmwm.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    bmwm.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    bmwm.b(false);
    String str = bmwm.a().getAbsolutePath();
    QLog.d("[upload2]UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bnjl.b(new File(paramString), localFile))
    {
      QLog.d("[upload2]UploadEnv", 1, "upload so unzip fail");
      bmwm.b(false);
      return;
    }
    if (bmwm.a(this.a, str))
    {
      QLog.d("[upload2]UploadEnv", 1, "upload so save success");
      bmwm.a(this.a, true);
      bmwm.a(true);
    }
    for (;;)
    {
      bmwm.b(false);
      return;
      try
      {
        localFile.delete();
        bmwm.a(this.a, false);
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
 * Qualified Name:     bmwn
 * JD-Core Version:    0.7.0.1
 */