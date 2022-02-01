import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apvj
{
  public boolean a;
  
  public static apvj a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        apvj localapvj = new apvj();
        localapvj.a = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
        QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + localapvj.toString());
        return localapvj;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvj
 * JD-Core Version:    0.7.0.1
 */