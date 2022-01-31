import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bhbr
  implements ModuleDownloadListener
{
  bhbr(bhbq parambhbq) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bhbq.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    bhbq.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    bhbq.b(false);
    String str = bhbq.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bhoh.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      bhbq.b(false);
      return;
    }
    if (bhbq.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      bhbq.a(this.a, true);
      bhbq.a(true);
    }
    for (;;)
    {
      bhbq.b(false);
      return;
      try
      {
        localFile.delete();
        bhbq.a(this.a, false);
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
 * Qualified Name:     bhbr
 * JD-Core Version:    0.7.0.1
 */