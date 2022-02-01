import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;

final class bnkj
  implements FilenameFilter
{
  bnkj(long paramLong1, long paramLong2) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((!paramString.startsWith("QAVSDK")) && (!paramString.startsWith("qavsdk"))) {}
    long l;
    do
    {
      File localFile;
      do
      {
        do
        {
          return false;
        } while (paramString.split("_").length == 2);
        localFile = new File(paramFile + File.separator + paramString);
      } while ((localFile == null) || (!localFile.exists()));
      l = localFile.lastModified();
      if (QLog.isDevelopLevel())
      {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "file dir: " + paramFile.getName());
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "file name: " + paramString + " mStartTime: " + this.a + " mEndTime: " + this.b + " lastModifiedTime: " + l);
      }
    } while ((l < this.a) || (l > this.b));
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file name: " + paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkj
 * JD-Core Version:    0.7.0.1
 */