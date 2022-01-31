import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class amra
{
  private static volatile amra a;
  
  public static amra a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new amra();
      }
      return a;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = Pattern.compile("^\\[(\\d+)\\]$").matcher(paramString);
    } while (!paramString.find());
    return paramString.group(1);
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = Pattern.compile("^\\[('|\")(.+)('|\")\\]$").matcher(paramString);
    } while (!paramString.find());
    return paramString.group(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amra
 * JD-Core Version:    0.7.0.1
 */