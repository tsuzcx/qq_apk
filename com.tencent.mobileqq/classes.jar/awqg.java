import android.util.Log;
import java.util.ArrayList;

public class awqg
{
  public static awpy a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() >= 0))
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          paramString = new awqk(paramString).a();
          if ((paramString == null) || (paramString.a.size() <= 0)) {
            break;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("LyricParseHelper", "parse exception:", paramString);
        }
        paramString = new awqh(paramString).a();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqg
 * JD-Core Version:    0.7.0.1
 */