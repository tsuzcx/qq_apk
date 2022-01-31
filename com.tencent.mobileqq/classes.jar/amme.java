import java.io.File;
import java.io.FilenameFilter;

public class amme
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amme
 * JD-Core Version:    0.7.0.1
 */