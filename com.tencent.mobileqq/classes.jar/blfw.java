import java.io.File;
import java.io.FilenameFilter;

class blfw
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfw
 * JD-Core Version:    0.7.0.1
 */