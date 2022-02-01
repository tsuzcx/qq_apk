package com.tencent.luggage.wxa.kl;

import org.json.JSONObject;

public class c
{
  public String a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  private JSONObject g;
  
  public JSONObject a()
  {
    if (this.g == null)
    {
      this.g = new JSONObject();
      this.g.put("uuid", this.a);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("read", this.b);
      boolean bool;
      if ((!this.c) && (!this.d)) {
        bool = false;
      } else {
        bool = true;
      }
      localJSONObject.put("write", bool);
      localJSONObject.put("notify", this.e);
      localJSONObject.put("indicate", this.f);
      this.g.put("properties", localJSONObject);
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kl.c
 * JD-Core Version:    0.7.0.1
 */