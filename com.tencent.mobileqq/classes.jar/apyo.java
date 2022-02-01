import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apyo
{
  private boolean a;
  private boolean b;
  private boolean c = true;
  
  public static apyo a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        apyo localapyo = new apyo();
        paramString = new JSONObject(paramString);
        localapyo.a = paramString.optBoolean("isIPCDivideToTransportEnable", false);
        localapyo.b = paramString.optBoolean("isSleepThreadWhenIPCBlockEnable", false);
        localapyo.c = paramString.optBoolean("isSendQuickHBByDeepSleepEnable", true);
        return localapyo;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(apyo paramapyo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramapyo != null) {}
    try
    {
      localJSONObject.put("isIPCDivideToTransportEnable", paramapyo.a);
      localJSONObject.put("isSleepThreadWhenIPCBlockEnable", paramapyo.b);
      localJSONObject.put("isSendQuickHBByDeepSleepEnable", paramapyo.c);
      return localJSONObject.toString();
    }
    catch (JSONException paramapyo)
    {
      for (;;)
      {
        paramapyo.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MSFConfigBean{isIPCDivideToTransportEnable=" + this.a + ", isSleepThreadWhenIPCBlockEnable=" + this.b + ", isSendQuickHBByDeepSleepEnable=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyo
 * JD-Core Version:    0.7.0.1
 */