import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class bdsp
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsp
 * JD-Core Version:    0.7.0.1
 */