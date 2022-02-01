import org.json.JSONObject;

public class aqlu
{
  public boolean a;
  
  public static aqlu a(String paramString)
  {
    aqlu localaqlu = new aqlu();
    try
    {
      localaqlu.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localaqlu;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqlu
 * JD-Core Version:    0.7.0.1
 */