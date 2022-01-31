import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class bfxh
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".cfg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxh
 * JD-Core Version:    0.7.0.1
 */