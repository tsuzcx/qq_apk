import java.io.File;
import java.io.FilenameFilter;

class bnhj
  implements FilenameFilter
{
  bnhj(bnhh parambnhh) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhj
 * JD-Core Version:    0.7.0.1
 */