import org.json.JSONException;
import org.json.JSONObject;

public class arpo
{
  private String a = anzj.a(2131713640);
  private String b = "";
  
  public static arpo a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arpo localarpo = new arpo();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a);
      localarpo.a = paramArrayOfaraj.getString("emptyShowWording");
      localarpo.b = paramArrayOfaraj.getString("linkWord");
      return localarpo;
    }
    catch (JSONException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
      return localarpo;
    }
    catch (NullPointerException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
    }
    return localarpo;
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
 * Qualified Name:     arpo
 * JD-Core Version:    0.7.0.1
 */