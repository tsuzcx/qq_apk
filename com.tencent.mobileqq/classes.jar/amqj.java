import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amqj
{
  public boolean a;
  
  public static amqj a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amqj localamqj = new amqj();
        localamqj.a = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
        QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + localamqj.toString());
        return localamqj;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqj
 * JD-Core Version:    0.7.0.1
 */