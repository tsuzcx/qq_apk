import com.tencent.mobileqq.statistics.LocalCrashCollector;
import java.io.File;
import java.util.Comparator;

public class awqj
  implements Comparator<File>
{
  public awqj(LocalCrashCollector paramLocalCrashCollector) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqj
 * JD-Core Version:    0.7.0.1
 */