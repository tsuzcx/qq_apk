import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class auls
  implements Callable<File>
{
  auls(aulr paramaulr) {}
  
  public File a()
  {
    try
    {
      boolean bool = aulr.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.a();
      if (aulr.a(this.a) != null) {
        aulr.a(this.a).a();
      }
      return localFile;
    }
    finally
    {
      aulr.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auls
 * JD-Core Version:    0.7.0.1
 */