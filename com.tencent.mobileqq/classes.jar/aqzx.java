import org.json.JSONException;
import org.json.JSONObject;

public class aqzx
{
  private String a = anni.a(2131713531);
  private String b = "";
  
  public static aqzx a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    aqzx localaqzx = new aqzx();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a);
      localaqzx.a = paramArrayOfaqlg.getString("emptyShowWording");
      localaqzx.b = paramArrayOfaqlg.getString("linkWord");
      return localaqzx;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      paramArrayOfaqlg.printStackTrace();
      return localaqzx;
    }
    catch (NullPointerException paramArrayOfaqlg)
    {
      paramArrayOfaqlg.printStackTrace();
    }
    return localaqzx;
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
 * Qualified Name:     aqzx
 * JD-Core Version:    0.7.0.1
 */