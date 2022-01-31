import org.json.JSONObject;

public class aozh
{
  public boolean a;
  
  public static aozh a(String paramString)
  {
    aozh localaozh = new aozh();
    try
    {
      localaozh.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localaozh;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aozh
 * JD-Core Version:    0.7.0.1
 */