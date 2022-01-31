import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amsv
{
  private String a = "";
  private String b = "";
  
  public static amsv a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amsv localamsv = new amsv();
        paramString = new JSONObject(paramString);
        localamsv.a = paramString.optString("dest_icon", "");
        localamsv.b = paramString.optString("avatar_pendant", "");
        return localamsv;
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
 * Qualified Name:     amsv
 * JD-Core Version:    0.7.0.1
 */