import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojw
{
  private String a = "";
  private String b = "";
  
  public static aojw a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aojw localaojw = new aojw();
        paramString = new JSONObject(paramString);
        localaojw.a = paramString.optString("dest_icon", "");
        localaojw.b = paramString.optString("avatar_pendant", "");
        return localaojw;
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
 * Qualified Name:     aojw
 * JD-Core Version:    0.7.0.1
 */