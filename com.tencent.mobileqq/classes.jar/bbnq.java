import org.json.JSONObject;

public class bbnq
{
  public String a;
  public String b;
  public String c;
  
  public static bbnq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      bbnq localbbnq = new bbnq();
      localbbnq.a = paramJSONObject.optString("apurl");
      localbbnq.c = paramJSONObject.optString("img");
      localbbnq.b = paramJSONObject.optString("rl");
      return localbbnq;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnq
 * JD-Core Version:    0.7.0.1
 */