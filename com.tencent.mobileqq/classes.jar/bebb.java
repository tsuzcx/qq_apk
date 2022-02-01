import org.json.JSONObject;

public class bebb
{
  public String a;
  public String b;
  public String c;
  
  public static bebb a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      bebb localbebb = new bebb();
      localbebb.a = paramJSONObject.optString("apurl");
      localbebb.c = paramJSONObject.optString("img");
      localbebb.b = paramJSONObject.optString("rl");
      return localbebb;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebb
 * JD-Core Version:    0.7.0.1
 */