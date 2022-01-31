import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bjcy
  implements ModuleDownloadListener
{
  bjcy(bjcx parambjcx) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bjcx.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    bjcx.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    bjcx.b(false);
    String str = bjcx.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bjps.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      bjcx.b(false);
      return;
    }
    if (bjcx.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      bjcx.a(this.a, true);
      bjcx.a(true);
    }
    for (;;)
    {
      bjcx.b(false);
      return;
      try
      {
        localFile.delete();
        bjcx.a(this.a, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjcy
 * JD-Core Version:    0.7.0.1
 */