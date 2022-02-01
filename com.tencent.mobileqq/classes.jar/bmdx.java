import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class bmdx
  implements FilenameFilter
{
  bmdx(bmdw parambmdw) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramFile != null) && (paramFile.isDirectory()) && (bmdw.a(this.a).matcher(paramString).matches());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdx
 * JD-Core Version:    0.7.0.1
 */