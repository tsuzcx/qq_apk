import java.io.File;
import java.io.FilenameFilter;

class blzo
  implements FilenameFilter
{
  blzo(blzn paramblzn) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzo
 * JD-Core Version:    0.7.0.1
 */