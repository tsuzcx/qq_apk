package c.t.m.g;

import org.json.JSONObject;

final class fd
{
  public String a;
  public String b;
  public int c;
  
  fd() {}
  
  public fd(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("bid", null);
    this.b = paramJSONObject.optString("floor", "1000");
    this.c = paramJSONObject.optInt("type", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fd
 * JD-Core Version:    0.7.0.1
 */