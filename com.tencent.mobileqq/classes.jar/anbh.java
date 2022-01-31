import org.json.JSONException;
import org.json.JSONObject;

public class anbh
{
  private String a = ajya.a(2131714847);
  private String b = "";
  
  public static anbh a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    anbh localanbh = new anbh();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a);
      localanbh.a = paramArrayOfamph.getString("emptyShowWording");
      localanbh.b = paramArrayOfamph.getString("linkWord");
      return localanbh;
    }
    catch (JSONException paramArrayOfamph)
    {
      paramArrayOfamph.printStackTrace();
    }
    return localanbh;
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
 * Qualified Name:     anbh
 * JD-Core Version:    0.7.0.1
 */