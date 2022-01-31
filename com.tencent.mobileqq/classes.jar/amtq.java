import java.io.File;
import java.io.FilenameFilter;

public class amtq
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtq
 * JD-Core Version:    0.7.0.1
 */