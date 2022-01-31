import org.json.JSONObject;

public class aouy
{
  public boolean a;
  
  public static aouy a(String paramString)
  {
    aouy localaouy = new aouy();
    try
    {
      localaouy.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localaouy;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouy
 * JD-Core Version:    0.7.0.1
 */