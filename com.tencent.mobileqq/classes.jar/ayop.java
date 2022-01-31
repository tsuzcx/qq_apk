import org.json.JSONObject;

public class ayop
{
  public String a;
  public String b;
  public String c;
  
  public static ayop a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      ayop localayop = new ayop();
      localayop.a = paramJSONObject.optString("apurl");
      localayop.c = paramJSONObject.optString("img");
      localayop.b = paramJSONObject.optString("rl");
      return localayop;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayop
 * JD-Core Version:    0.7.0.1
 */