import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arey
{
  private boolean a;
  private boolean b;
  private boolean c = true;
  
  public static arey a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        arey localarey = new arey();
        paramString = new JSONObject(paramString);
        localarey.a = paramString.optBoolean("isIPCDivideToTransportEnable", false);
        localarey.b = paramString.optBoolean("isSleepThreadWhenIPCBlockEnable", false);
        localarey.c = paramString.optBoolean("isSendQuickHBByDeepSleepEnable", true);
        return localarey;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(arey paramarey)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramarey != null) {}
    try
    {
      localJSONObject.put("isIPCDivideToTransportEnable", paramarey.a);
      localJSONObject.put("isSleepThreadWhenIPCBlockEnable", paramarey.b);
      localJSONObject.put("isSendQuickHBByDeepSleepEnable", paramarey.c);
      return localJSONObject.toString();
    }
    catch (JSONException paramarey)
    {
      for (;;)
      {
        paramarey.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MSFConfigBean{isIPCDivideToTransportEnable=" + this.a + ", isSleepThreadWhenIPCBlockEnable=" + this.b + ", isSendQuickHBByDeepSleepEnable=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arey
 * JD-Core Version:    0.7.0.1
 */