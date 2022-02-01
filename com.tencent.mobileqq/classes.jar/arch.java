import org.json.JSONObject;

public class arch
{
  public boolean a;
  
  public static arch a(String paramString)
  {
    arch localarch = new arch();
    try
    {
      localarch.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localarch;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arch
 * JD-Core Version:    0.7.0.1
 */