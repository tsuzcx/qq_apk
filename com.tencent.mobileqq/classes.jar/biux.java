import java.io.File;
import java.io.FilenameFilter;

class biux
  implements FilenameFilter
{
  biux(biuw parambiuw) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biux
 * JD-Core Version:    0.7.0.1
 */