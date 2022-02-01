import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkr
{
  public String a = amtj.a(2131713857);
  public String b = amtj.a(2131713864);
  public String c = amtj.a(2131713860);
  public String d = amtj.a(2131713862);
  public String e = amtj.a(2131713855);
  
  public static aqkr a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqkr localaqkr = new aqkr();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a).optJSONObject("MyFileNameConfig");
      localaqkr.a = paramArrayOfaptx.optString("tdfileTabName");
      localaqkr.b = paramArrayOfaptx.optString("wyfileTabName");
      localaqkr.c = paramArrayOfaptx.optString("tdlistTabviewName");
      localaqkr.d = paramArrayOfaptx.optString("createTXDocTitle");
      localaqkr.e = paramArrayOfaptx.optString("safeShareToastWording");
      return localaqkr;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
    }
    return localaqkr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkr
 * JD-Core Version:    0.7.0.1
 */