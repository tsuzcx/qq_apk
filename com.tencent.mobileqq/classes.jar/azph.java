import org.json.JSONObject;

public class azph
{
  public String a;
  public String b;
  public String c;
  
  public static azph a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      azph localazph = new azph();
      localazph.a = paramJSONObject.optString("apurl");
      localazph.c = paramJSONObject.optString("img");
      localazph.b = paramJSONObject.optString("rl");
      return localazph;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azph
 * JD-Core Version:    0.7.0.1
 */