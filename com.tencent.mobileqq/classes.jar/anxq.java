import java.io.File;
import java.io.FilenameFilter;

public final class anxq
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxq
 * JD-Core Version:    0.7.0.1
 */