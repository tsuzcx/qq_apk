import com.tencent.mobileqq.app.automator.step.CleanCache;
import java.io.File;
import java.io.FilenameFilter;

public class aoic
  implements FilenameFilter
{
  public aoic(CleanCache paramCleanCache) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoic
 * JD-Core Version:    0.7.0.1
 */