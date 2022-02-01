import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arbr
{
  private boolean a;
  private boolean b;
  private boolean c = true;
  
  public static arbr a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        arbr localarbr = new arbr();
        paramString = new JSONObject(paramString);
        localarbr.a = paramString.optBoolean("isIPCDivideToTransportEnable", false);
        localarbr.b = paramString.optBoolean("isSleepThreadWhenIPCBlockEnable", false);
        localarbr.c = paramString.optBoolean("isSendQuickHBByDeepSleepEnable", true);
        return localarbr;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(arbr paramarbr)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramarbr != null) {}
    try
    {
      localJSONObject.put("isIPCDivideToTransportEnable", paramarbr.a);
      localJSONObject.put("isSleepThreadWhenIPCBlockEnable", paramarbr.b);
      localJSONObject.put("isSendQuickHBByDeepSleepEnable", paramarbr.c);
      return localJSONObject.toString();
    }
    catch (JSONException paramarbr)
    {
      for (;;)
      {
        paramarbr.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MSFConfigBean{isIPCDivideToTransportEnable=" + this.a + ", isSleepThreadWhenIPCBlockEnable=" + this.b + ", isSendQuickHBByDeepSleepEnable=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbr
 * JD-Core Version:    0.7.0.1
 */