package com.tencent.av.random;

import org.json.JSONObject;

abstract class RandomWebProtocol$RequestMultiReport
  extends RandomWebProtocol.Request
{
  long b;
  int d;
  int e;
  
  String a()
  {
    this.a = new JSONObject();
    try
    {
      this.a.put("reqtype", this.d).put("session_type", this.e).put("groupid", this.b);
      a(this.a);
      return super.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  abstract JSONObject a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RequestMultiReport
 * JD-Core Version:    0.7.0.1
 */