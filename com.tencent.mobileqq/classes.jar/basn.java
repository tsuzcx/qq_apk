import java.io.File;
import java.io.FilenameFilter;

public final class basn
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".hy")) || (paramString.endsWith(".fz")) || (paramString.endsWith(".hy3")) || (paramString.endsWith(".fz4"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     basn
 * JD-Core Version:    0.7.0.1
 */