package com.tencent.luggage.wxa.mn;

import com.tencent.luggage.wxa.pc.g;
import org.json.JSONException;
import org.json.JSONObject;

public class e$f
{
  public int a;
  public float b;
  public float c;
  
  public e$f() {}
  
  public e$f(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.a = paramInt;
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.a);
      localJSONObject.put("x", g.a(this.b));
      localJSONObject.put("y", g.a(this.c));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.a = paramInt;
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.e.f
 * JD-Core Version:    0.7.0.1
 */