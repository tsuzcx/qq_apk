import java.io.File;
import java.io.FilenameFilter;

public final class bigp
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".hy")) || (paramString.endsWith(".fz")) || (paramString.endsWith(".hy3")) || (paramString.endsWith(".fz4"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigp
 * JD-Core Version:    0.7.0.1
 */