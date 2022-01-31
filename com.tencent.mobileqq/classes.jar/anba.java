import org.json.JSONException;
import org.json.JSONObject;

public class anba
{
  private String a = ajyc.a(2131714836);
  private String b = "";
  
  public static anba a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    anba localanba = new anba();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a);
      localanba.a = paramArrayOfampi.getString("emptyShowWording");
      localanba.b = paramArrayOfampi.getString("linkWord");
      return localanba;
    }
    catch (JSONException paramArrayOfampi)
    {
      paramArrayOfampi.printStackTrace();
    }
    return localanba;
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
 * Qualified Name:     anba
 * JD-Core Version:    0.7.0.1
 */