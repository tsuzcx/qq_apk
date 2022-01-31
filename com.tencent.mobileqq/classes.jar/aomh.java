import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class aomh
{
  private static volatile aomh a;
  
  public static aomh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aomh();
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
 * Qualified Name:     aomh
 * JD-Core Version:    0.7.0.1
 */