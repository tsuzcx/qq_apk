import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

public class apuu
{
  public int a;
  
  public static apuu a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new apuu();
    }
    apuu localapuu = new apuu();
    try
    {
      localapuu.a = new JSONObject(paramString).optInt("enable", 0);
      return localapuu;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localapuu;
  }
  
  @NonNull
  public String toString()
  {
    return "switch = " + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apuu
 * JD-Core Version:    0.7.0.1
 */