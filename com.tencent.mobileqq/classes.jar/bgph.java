import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgph
{
  public static void a(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    switch (paramInt)
    {
    case -4: 
    default: 
    case -5: 
      try
      {
        paramJSONObject.put("errMsg", "unknown reason");
        return;
      }
      catch (Throwable paramString)
      {
        QMLog.e("MiniappHttpUtil", "fillErrMsg", paramString);
        return;
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "abort";; paramString = paramString + ":fail abort")
      {
        paramJSONObject.put("errMsg", paramString);
        return;
      }
    }
    paramJSONObject.put("errMsg", "request protocol error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgph
 * JD-Core Version:    0.7.0.1
 */