import org.json.JSONObject;

public class andm
{
  public boolean a;
  
  public static andm a(String paramString)
  {
    andm localandm = new andm();
    try
    {
      localandm.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localandm;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andm
 * JD-Core Version:    0.7.0.1
 */