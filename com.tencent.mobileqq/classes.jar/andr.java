import org.json.JSONObject;

public class andr
{
  public boolean a;
  
  public static andr a(String paramString)
  {
    andr localandr = new andr();
    try
    {
      localandr.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localandr;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andr
 * JD-Core Version:    0.7.0.1
 */