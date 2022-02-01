import java.io.File;
import java.io.FilenameFilter;

final class blwl
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.endsWith("OldVersion.version");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwl
 * JD-Core Version:    0.7.0.1
 */