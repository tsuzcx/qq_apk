import android.os.Build;
import com.tencent.mobileqq.utils.StringUtil;

public class apja
{
  public static boolean a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {}
    while (!("" + Build.MANUFACTURER).equalsIgnoreCase(paramString)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apja
 * JD-Core Version:    0.7.0.1
 */