import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amsu
{
  private String a = "";
  private String b = "";
  
  public static amsu a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amsu localamsu = new amsu();
        paramString = new JSONObject(paramString);
        localamsu.a = paramString.optString("dest_icon", "");
        localamsu.b = paramString.optString("avatar_pendant", "");
        return localamsu;
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
 * Qualified Name:     amsu
 * JD-Core Version:    0.7.0.1
 */