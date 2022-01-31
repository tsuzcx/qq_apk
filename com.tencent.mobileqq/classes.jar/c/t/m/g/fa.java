package c.t.m.g;

import org.json.JSONObject;

final class fa
{
  public String a;
  public String b;
  public int c;
  
  fa() {}
  
  public fa(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("bid", null);
    this.b = paramJSONObject.optString("floor", "1000");
    this.c = paramJSONObject.optInt("type", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.fa
 * JD-Core Version:    0.7.0.1
 */