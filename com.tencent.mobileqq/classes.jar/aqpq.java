import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqpq
{
  private boolean a;
  private boolean b;
  private boolean c = true;
  
  public static aqpq a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqpq localaqpq = new aqpq();
        paramString = new JSONObject(paramString);
        localaqpq.a = paramString.optBoolean("isIPCDivideToTransportEnable", false);
        localaqpq.b = paramString.optBoolean("isSleepThreadWhenIPCBlockEnable", false);
        localaqpq.c = paramString.optBoolean("isSendQuickHBByDeepSleepEnable", true);
        return localaqpq;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(aqpq paramaqpq)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramaqpq != null) {}
    try
    {
      localJSONObject.put("isIPCDivideToTransportEnable", paramaqpq.a);
      localJSONObject.put("isSleepThreadWhenIPCBlockEnable", paramaqpq.b);
      localJSONObject.put("isSendQuickHBByDeepSleepEnable", paramaqpq.c);
      return localJSONObject.toString();
    }
    catch (JSONException paramaqpq)
    {
      for (;;)
      {
        paramaqpq.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MSFConfigBean{isIPCDivideToTransportEnable=" + this.a + ", isSleepThreadWhenIPCBlockEnable=" + this.b + ", isSendQuickHBByDeepSleepEnable=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpq
 * JD-Core Version:    0.7.0.1
 */