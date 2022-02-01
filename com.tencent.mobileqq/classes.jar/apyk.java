import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apyk
{
  private String a = "";
  private String b = "";
  
  public static apyk a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        apyk localapyk = new apyk();
        paramString = new JSONObject(paramString);
        localapyk.a = paramString.optString("dest_icon", "");
        localapyk.b = paramString.optString("avatar_pendant", "");
        return localapyk;
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
 * Qualified Name:     apyk
 * JD-Core Version:    0.7.0.1
 */