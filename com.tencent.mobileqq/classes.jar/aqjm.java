import org.json.JSONException;
import org.json.JSONObject;

public class aqjm
{
  private String a = amtj.a(2131713872);
  private String b = "";
  
  public static aqjm a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqjm localaqjm = new aqjm();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a);
      localaqjm.a = paramArrayOfaptx.getString("emptyShowWording");
      localaqjm.b = paramArrayOfaptx.getString("linkWord");
      return localaqjm;
    }
    catch (JSONException paramArrayOfaptx)
    {
      paramArrayOfaptx.printStackTrace();
      return localaqjm;
    }
    catch (NullPointerException paramArrayOfaptx)
    {
      paramArrayOfaptx.printStackTrace();
    }
    return localaqjm;
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
 * Qualified Name:     aqjm
 * JD-Core Version:    0.7.0.1
 */