import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class bgtn
  implements FilenameFilter
{
  bgtn(bgtm parambgtm) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramFile != null) && (paramFile.isDirectory()) && (bgtm.a(this.a).matcher(paramString).matches());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtn
 * JD-Core Version:    0.7.0.1
 */