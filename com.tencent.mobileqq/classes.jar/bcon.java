import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class bcon
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".cfg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcon
 * JD-Core Version:    0.7.0.1
 */