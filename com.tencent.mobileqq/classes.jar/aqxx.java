import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

public class aqxx
{
  public int a;
  
  public static aqxx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new aqxx();
    }
    aqxx localaqxx = new aqxx();
    try
    {
      localaqxx.a = new JSONObject(paramString).optInt("enable", 0);
      return localaqxx;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localaqxx;
  }
  
  @NonNull
  public String toString()
  {
    return "switch = " + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxx
 * JD-Core Version:    0.7.0.1
 */