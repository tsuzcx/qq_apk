import org.json.JSONObject;

public class arpf
{
  public boolean a;
  
  public static arpf a(String paramString)
  {
    arpf localarpf = new arpf();
    try
    {
      localarpf.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localarpf;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpf
 * JD-Core Version:    0.7.0.1
 */