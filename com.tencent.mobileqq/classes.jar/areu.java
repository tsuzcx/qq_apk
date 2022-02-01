import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class areu
{
  private String a = "";
  private String b = "";
  
  public static areu a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        areu localareu = new areu();
        paramString = new JSONObject(paramString);
        localareu.a = paramString.optString("dest_icon", "");
        localareu.b = paramString.optString("avatar_pendant", "");
        return localareu;
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
 * Qualified Name:     areu
 * JD-Core Version:    0.7.0.1
 */