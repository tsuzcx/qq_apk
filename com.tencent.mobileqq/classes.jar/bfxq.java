import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class bfxq
  implements FilenameFilter
{
  bfxq(bfxp parambfxp) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxq
 * JD-Core Version:    0.7.0.1
 */