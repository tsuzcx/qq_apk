import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class avrn
  implements Callable<File>
{
  avrn(avrm paramavrm) {}
  
  public File a()
  {
    try
    {
      boolean bool = avrm.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.a();
      if (avrm.a(this.a) != null) {
        avrm.a(this.a).a();
      }
      return localFile;
    }
    finally
    {
      avrm.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrn
 * JD-Core Version:    0.7.0.1
 */