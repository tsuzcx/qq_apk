import org.json.JSONObject;

public class bbrz
{
  public String a;
  public String b;
  public String c;
  
  public static bbrz a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      bbrz localbbrz = new bbrz();
      localbbrz.a = paramJSONObject.optString("apurl");
      localbbrz.c = paramJSONObject.optString("img");
      localbbrz.b = paramJSONObject.optString("rl");
      return localbbrz;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrz
 * JD-Core Version:    0.7.0.1
 */