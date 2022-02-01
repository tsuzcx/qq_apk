import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpm
{
  private String a = "";
  private String b = "";
  
  public static aqpm a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqpm localaqpm = new aqpm();
        paramString = new JSONObject(paramString);
        localaqpm.a = paramString.optString("dest_icon", "");
        localaqpm.b = paramString.optString("avatar_pendant", "");
        return localaqpm;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpm
 * JD-Core Version:    0.7.0.1
 */