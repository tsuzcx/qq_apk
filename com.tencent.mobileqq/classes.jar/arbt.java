import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbt
{
  public boolean a;
  
  public static arbt a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        arbt localarbt = new arbt();
        localarbt.a = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
        QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + localarbt.toString());
        return localarbt;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */