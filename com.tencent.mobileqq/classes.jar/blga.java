import java.io.File;
import java.io.FileFilter;

final class blga
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blga
 * JD-Core Version:    0.7.0.1
 */