import java.io.File;
import java.io.FileFilter;

public final class aqbp
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (paramFile.getName().startsWith("hc_")) || (paramFile.getName().startsWith(".hc_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbp
 * JD-Core Version:    0.7.0.1
 */