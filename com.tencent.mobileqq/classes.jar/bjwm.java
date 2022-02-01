import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class bjwm
  implements FilenameFilter
{
  bjwm(bjwl parambjwl) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwm
 * JD-Core Version:    0.7.0.1
 */