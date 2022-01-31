import com.tencent.mobileqq.statistics.LocalCrashCollector;
import java.io.File;
import java.io.FilenameFilter;

public class awqi
  implements FilenameFilter
{
  public awqi(LocalCrashCollector paramLocalCrashCollector) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqi
 * JD-Core Version:    0.7.0.1
 */