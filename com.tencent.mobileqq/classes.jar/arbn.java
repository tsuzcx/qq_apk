import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbn
{
  private String a = "";
  private String b = "";
  
  public static arbn a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        arbn localarbn = new arbn();
        paramString = new JSONObject(paramString);
        localarbn.a = paramString.optString("dest_icon", "");
        localarbn.b = paramString.optString("avatar_pendant", "");
        return localarbn;
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
 * Qualified Name:     arbn
 * JD-Core Version:    0.7.0.1
 */