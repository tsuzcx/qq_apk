import com.tencent.mobileqq.statistics.LocalCrashCollector;
import java.io.File;
import java.io.FilenameFilter;

public class azlu
  implements FilenameFilter
{
  public azlu(LocalCrashCollector paramLocalCrashCollector) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlu
 * JD-Core Version:    0.7.0.1
 */