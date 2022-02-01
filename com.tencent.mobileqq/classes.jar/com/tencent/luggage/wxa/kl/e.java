package com.tencent.luggage.wxa.kl;

import org.json.JSONObject;

public class e
{
  public String a;
  public boolean b;
  private JSONObject c;
  
  public JSONObject a()
  {
    if (this.c == null)
    {
      this.c = new JSONObject();
      this.c.put("uuid", this.a);
      this.c.put("isPrimary", this.b);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kl.e
 * JD-Core Version:    0.7.0.1
 */