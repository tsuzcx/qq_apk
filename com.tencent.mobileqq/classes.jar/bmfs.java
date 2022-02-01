import java.io.File;
import java.io.FileFilter;

public final class bmfs
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfs
 * JD-Core Version:    0.7.0.1
 */