import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoof
{
  private String a = "";
  private String b = "";
  
  public static aoof a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aoof localaoof = new aoof();
        paramString = new JSONObject(paramString);
        localaoof.a = paramString.optString("dest_icon", "");
        localaoof.b = paramString.optString("avatar_pendant", "");
        return localaoof;
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
 * Qualified Name:     aoof
 * JD-Core Version:    0.7.0.1
 */