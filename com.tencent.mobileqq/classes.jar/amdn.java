import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UploadSoDownloader;
import java.io.File;

public class amdn
  implements Runnable
{
  public amdn(UploadSoDownloader paramUploadSoDownloader) {}
  
  public void run()
  {
    boolean bool = UploadSoDownloader.a(this.a, UploadSoDownloader.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      UploadSoDownloader.a(true);
      return;
    }
    try
    {
      if (UploadSoDownloader.a().exists()) {
        UploadSoDownloader.a().delete();
      }
      UploadSoDownloader.a(this.a, false);
      UploadSoDownloader.a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdn
 * JD-Core Version:    0.7.0.1
 */