import org.json.JSONObject;

public class arrw
{
  public boolean a;
  
  public static arrw a(String paramString)
  {
    arrw localarrw = new arrw();
    try
    {
      localarrw.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localarrw;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arrw
 * JD-Core Version:    0.7.0.1
 */