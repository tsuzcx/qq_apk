import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

public class arbe
{
  public int a;
  
  public static arbe a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new arbe();
    }
    arbe localarbe = new arbe();
    try
    {
      localarbe.a = new JSONObject(paramString).optInt("enable", 0);
      return localarbe;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localarbe;
  }
  
  @NonNull
  public String toString()
  {
    return "switch = " + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbe
 * JD-Core Version:    0.7.0.1
 */