import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class bdto
  implements FilenameFilter
{
  bdto(bdtn parambdtn) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdto
 * JD-Core Version:    0.7.0.1
 */