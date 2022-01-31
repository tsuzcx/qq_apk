import com.tencent.mobileqq.statistics.LocalCrashCollector;
import java.io.File;
import java.io.FilenameFilter;

public class axqj
  implements FilenameFilter
{
  public axqj(LocalCrashCollector paramLocalCrashCollector) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqj
 * JD-Core Version:    0.7.0.1
 */