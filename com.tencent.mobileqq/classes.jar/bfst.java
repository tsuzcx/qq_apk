import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

class bfst
  implements ModuleDownloadListener
{
  bfst(bfss parambfss) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bfss.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    bfss.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    bfss.b(false);
    String str = bfss.a().getAbsolutePath();
    QLog.d("UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!bgfb.b(new File(paramString), localFile))
    {
      QLog.d("UploadEnv", 1, "upload so unzip fail");
      bfss.b(false);
      return;
    }
    if (bfss.a(this.a, str))
    {
      QLog.d("UploadEnv", 1, "upload so save success");
      bfss.a(this.a, true);
      bfss.a(true);
    }
    for (;;)
    {
      bfss.b(false);
      return;
      try
      {
        localFile.delete();
        bfss.a(this.a, false);
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
 * Qualified Name:     bfst
 * JD-Core Version:    0.7.0.1
 */