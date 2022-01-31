import java.io.File;
import java.io.FileFilter;

public final class blgj
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgj
 * JD-Core Version:    0.7.0.1
 */