import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqym
{
  public boolean a;
  
  public static aqym a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqym localaqym = new aqym();
        localaqym.a = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
        QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + localaqym.toString());
        return localaqym;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqym
 * JD-Core Version:    0.7.0.1
 */