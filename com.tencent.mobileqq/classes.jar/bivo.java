import java.io.File;
import java.io.FilenameFilter;

class bivo
  implements FilenameFilter
{
  bivo(bivn parambivn) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivo
 * JD-Core Version:    0.7.0.1
 */