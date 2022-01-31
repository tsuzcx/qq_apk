import org.json.JSONObject;

public class amnf
{
  public boolean a;
  
  public static amnf a(String paramString)
  {
    amnf localamnf = new amnf();
    try
    {
      localamnf.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localamnf;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnf
 * JD-Core Version:    0.7.0.1
 */