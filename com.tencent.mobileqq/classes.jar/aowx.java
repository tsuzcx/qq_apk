import org.json.JSONException;
import org.json.JSONObject;

public class aowx
{
  private String a = alud.a(2131715231);
  private String b = "";
  
  public static aowx a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aowx localaowx = new aowx();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a);
      localaowx.a = paramArrayOfaoko.getString("emptyShowWording");
      localaowx.b = paramArrayOfaoko.getString("linkWord");
      return localaowx;
    }
    catch (JSONException paramArrayOfaoko)
    {
      paramArrayOfaoko.printStackTrace();
      return localaowx;
    }
    catch (NullPointerException paramArrayOfaoko)
    {
      paramArrayOfaoko.printStackTrace();
    }
    return localaowx;
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
 * Qualified Name:     aowx
 * JD-Core Version:    0.7.0.1
 */