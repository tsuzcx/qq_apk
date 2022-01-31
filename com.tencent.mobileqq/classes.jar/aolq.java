import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aolq
{
  public boolean a;
  
  public static aolq a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aolq localaolq = new aolq();
        localaolq.a = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
        QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + localaolq.toString());
        return localaolq;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolq
 * JD-Core Version:    0.7.0.1
 */