import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class bkgc
  implements FilenameFilter
{
  bkgc(bkgb parambkgb) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgc
 * JD-Core Version:    0.7.0.1
 */