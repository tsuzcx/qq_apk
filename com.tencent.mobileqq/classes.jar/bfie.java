import org.json.JSONObject;

public class bfie
{
  public String a;
  public String b;
  public String c;
  
  public static bfie a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      bfie localbfie = new bfie();
      localbfie.a = paramJSONObject.optString("apurl");
      localbfie.c = paramJSONObject.optString("img");
      localbfie.b = paramJSONObject.optString("rl");
      return localbfie;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfie
 * JD-Core Version:    0.7.0.1
 */