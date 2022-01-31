import java.io.File;
import java.io.FileFilter;

public final class amhx
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhx
 * JD-Core Version:    0.7.0.1
 */