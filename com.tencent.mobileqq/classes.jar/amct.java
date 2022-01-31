import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amct
{
  private String a = "";
  private String b = "";
  
  public static amct a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amct localamct = new amct();
        paramString = new JSONObject(paramString);
        localamct.a = paramString.optString("dest_icon", "");
        localamct.b = paramString.optString("avatar_pendant", "");
        return localamct;
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
 * Qualified Name:     amct
 * JD-Core Version:    0.7.0.1
 */