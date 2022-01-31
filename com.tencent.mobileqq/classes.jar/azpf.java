import org.json.JSONObject;

public class azpf
{
  public String a;
  public String b;
  public String c;
  
  public static azpf a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      azpf localazpf = new azpf();
      localazpf.a = paramJSONObject.optString("apurl");
      localazpf.c = paramJSONObject.optString("img");
      localazpf.b = paramJSONObject.optString("rl");
      return localazpf;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azpf
 * JD-Core Version:    0.7.0.1
 */