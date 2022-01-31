import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class aqjt
  implements Callable<File>
{
  aqjt(aqjs paramaqjs) {}
  
  public File a()
  {
    try
    {
      boolean bool = aqjs.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.a();
      return localFile;
    }
    finally
    {
      aqjs.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqjt
 * JD-Core Version:    0.7.0.1
 */