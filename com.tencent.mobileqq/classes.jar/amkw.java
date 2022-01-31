import org.json.JSONException;
import org.json.JSONObject;

public class amkw
{
  private String a = ajjy.a(2131649047);
  private String b = "";
  
  public static amkw a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amkw localamkw = new amkw();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].a);
      localamkw.a = paramArrayOfalzs.getString("emptyShowWording");
      localamkw.b = paramArrayOfalzs.getString("linkWord");
      return localamkw;
    }
    catch (JSONException paramArrayOfalzs)
    {
      paramArrayOfalzs.printStackTrace();
    }
    return localamkw;
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
 * Qualified Name:     amkw
 * JD-Core Version:    0.7.0.1
 */