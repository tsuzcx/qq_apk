import java.io.File;
import java.io.FilenameFilter;

class bovj
  implements FilenameFilter
{
  bovj(bovi parambovi) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovj
 * JD-Core Version:    0.7.0.1
 */