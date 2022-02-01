import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arfe
{
  public boolean a;
  
  public static arfe a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      arfe localarfe = new arfe();
      localarfe.a = new JSONObject(paramString).optBoolean("isSendQuickHBBackToForeground", false);
      return localarfe;
    }
    catch (Exception paramString)
    {
      QLog.e("QuickHeartbeatConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return null;
  }
  
  public String toString()
  {
    return "QuickHeartbeatConfigBean{isSendQuickHBBackToForeground=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfe
 * JD-Core Version:    0.7.0.1
 */