import org.json.JSONException;
import org.json.JSONObject;

public class armx
{
  private String a = anvx.a(2131714219);
  private String b = "";
  
  public static armx a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    armx localarmx = new armx();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a);
      localarmx.a = paramArrayOfaqxa.getString("emptyShowWording");
      localarmx.b = paramArrayOfaqxa.getString("linkWord");
      return localarmx;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
      return localarmx;
    }
    catch (NullPointerException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return localarmx;
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
 * Qualified Name:     armx
 * JD-Core Version:    0.7.0.1
 */