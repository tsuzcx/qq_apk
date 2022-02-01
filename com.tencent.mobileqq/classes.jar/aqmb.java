import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

public class aqmb
{
  public int a;
  
  public static aqmb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new aqmb();
    }
    aqmb localaqmb = new aqmb();
    try
    {
      localaqmb.a = new JSONObject(paramString).optInt("enable", 0);
      return localaqmb;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localaqmb;
  }
  
  @NonNull
  public String toString()
  {
    return "switch = " + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmb
 * JD-Core Version:    0.7.0.1
 */