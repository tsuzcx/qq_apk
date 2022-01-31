import java.io.File;
import java.io.FileFilter;

public final class ammg
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammg
 * JD-Core Version:    0.7.0.1
 */