import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class bdok
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith(".so")) || (paramString.endsWith(".jar")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdok
 * JD-Core Version:    0.7.0.1
 */