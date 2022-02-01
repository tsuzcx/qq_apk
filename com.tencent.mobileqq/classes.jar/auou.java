import java.io.File;
import java.io.FilenameFilter;

final class auou
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("res_timestamp-");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auou
 * JD-Core Version:    0.7.0.1
 */