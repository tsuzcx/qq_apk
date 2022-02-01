import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class avys
  implements Callable<File>
{
  avys(avyr paramavyr) {}
  
  public File a()
  {
    try
    {
      boolean bool = avyr.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.a();
      if (avyr.a(this.a) != null) {
        avyr.a(this.a).a();
      }
      return localFile;
    }
    finally
    {
      avyr.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avys
 * JD-Core Version:    0.7.0.1
 */