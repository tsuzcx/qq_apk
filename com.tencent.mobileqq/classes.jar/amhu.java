import com.tencent.mobileqq.app.automator.step.CleanCache;
import java.io.File;
import java.util.Comparator;

public class amhu
  implements Comparator<File>
{
  public amhu(CleanCache paramCleanCache) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhu
 * JD-Core Version:    0.7.0.1
 */