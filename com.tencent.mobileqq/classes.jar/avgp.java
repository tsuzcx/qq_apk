import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class avgp
  implements Callable<File>
{
  avgp(avgo paramavgo) {}
  
  public File a()
  {
    try
    {
      boolean bool = avgo.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.a();
      if (avgo.a(this.a) != null) {
        avgo.a(this.a).a();
      }
      return localFile;
    }
    finally
    {
      avgo.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgp
 * JD-Core Version:    0.7.0.1
 */