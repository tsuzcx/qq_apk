import java.io.File;
import java.io.FilenameFilter;

class bntx
  implements FilenameFilter
{
  bntx(bntw parambntw) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntx
 * JD-Core Version:    0.7.0.1
 */