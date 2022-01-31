import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class bdsx
  implements FilenameFilter
{
  bdsx(bdsw parambdsw) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsx
 * JD-Core Version:    0.7.0.1
 */