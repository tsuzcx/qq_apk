import java.io.File;
import java.io.FilenameFilter;

class bnoy
  implements FilenameFilter
{
  bnoy(bnox parambnox) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoy
 * JD-Core Version:    0.7.0.1
 */