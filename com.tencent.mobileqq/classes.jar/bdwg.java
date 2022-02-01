import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class bdwg
  implements Callable<File>
{
  bdwg(bdwf parambdwf) {}
  
  public File a()
  {
    try
    {
      boolean bool = bdwf.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.CdnPmUpdater", 2, "isNeedDownload:" + bool);
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
      bdwf.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwg
 * JD-Core Version:    0.7.0.1
 */