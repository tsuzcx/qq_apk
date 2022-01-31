import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bjhf
  implements ModuleDownloadListener
{
  bjhf(bjhe parambjhe) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bjhe.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    bjhe.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    bjhe.b(false);
    String str = bjhe.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bjtz.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      bjhe.b(false);
      return;
    }
    if (bjhe.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      bjhe.a(this.a, true);
      bjhe.a(true);
    }
    for (;;)
    {
      bjhe.b(false);
      return;
      try
      {
        localFile.delete();
        bjhe.a(this.a, false);
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
 * Qualified Name:     bjhf
 * JD-Core Version:    0.7.0.1
 */