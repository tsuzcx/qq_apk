import java.io.File;
import java.io.FilenameFilter;

class blep
  implements FilenameFilter
{
  blep(bleo parambleo) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blep
 * JD-Core Version:    0.7.0.1
 */