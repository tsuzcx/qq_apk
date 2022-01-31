import android.util.Log;
import java.util.ArrayList;

public class atwt
{
  public static atwl a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() >= 0))
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          paramString = new atwx(paramString).a();
          if ((paramString == null) || (paramString.a.size() <= 0)) {
            break;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("LyricParseHelper", "parse exception:", paramString);
        }
        paramString = new atwu(paramString).a();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atwt
 * JD-Core Version:    0.7.0.1
 */