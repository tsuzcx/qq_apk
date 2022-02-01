import org.json.JSONObject;

public class besk
{
  public String a;
  public String b;
  public String c;
  
  public static besk a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      besk localbesk = new besk();
      localbesk.a = paramJSONObject.optString("apurl");
      localbesk.c = paramJSONObject.optString("img");
      localbesk.b = paramJSONObject.optString("rl");
      return localbesk;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besk
 * JD-Core Version:    0.7.0.1
 */