import java.io.File;
import java.io.FilenameFilter;

final class bmxn
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.endsWith("OldVersion.version");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxn
 * JD-Core Version:    0.7.0.1
 */