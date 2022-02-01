import org.json.JSONObject;

public class bfrr
{
  public String a;
  public String b;
  public String c;
  
  public static bfrr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      bfrr localbfrr = new bfrr();
      localbfrr.a = paramJSONObject.optString("apurl");
      localbfrr.c = paramJSONObject.optString("img");
      localbfrr.b = paramJSONObject.optString("rl");
      return localbfrr;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrr
 * JD-Core Version:    0.7.0.1
 */