import java.io.File;
import java.io.FilenameFilter;

public final class bbvd
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".hy")) || (paramString.endsWith(".fz")) || (paramString.endsWith(".hy3")) || (paramString.endsWith(".fz4"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbvd
 * JD-Core Version:    0.7.0.1
 */