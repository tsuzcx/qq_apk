import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import java.util.Comparator;

final class bjuv
  implements Comparator<ShareAppLogHelper.LogFile>
{
  public int a(ShareAppLogHelper.LogFile paramLogFile1, ShareAppLogHelper.LogFile paramLogFile2)
  {
    return (int)(paramLogFile1.lastModified() - paramLogFile2.lastModified()) / 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjuv
 * JD-Core Version:    0.7.0.1
 */