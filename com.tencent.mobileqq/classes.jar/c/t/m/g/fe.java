package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

public final class fe
{
  public double a;
  public double b;
  public double c;
  public float d;
  public String e;
  public String f;
  
  fe() {}
  
  public fe(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getDouble("latitude");
      this.b = paramJSONObject.getDouble("longitude");
      this.c = paramJSONObject.getDouble("altitude");
      this.d = ((float)paramJSONObject.getDouble("accuracy"));
      this.e = paramJSONObject.optString("name");
      this.f = paramJSONObject.optString("addr");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fe
 * JD-Core Version:    0.7.0.1
 */