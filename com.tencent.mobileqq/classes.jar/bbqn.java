import org.json.JSONObject;

public class bbqn
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public bbqn() {}
  
  public bbqn(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("serverip", "");
    this.b = paramJSONObject.optString("serverport", "");
    this.c = paramJSONObject.optString("checkkey", "");
    this.d = paramJSONObject.optString("exists", "");
    this.e = paramJSONObject.optString("uin", "");
    this.f = paramJSONObject.optString("vid", "");
    this.g = paramJSONObject.optString("fid", "");
    this.h = paramJSONObject.optString("complete", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqn
 * JD-Core Version:    0.7.0.1
 */