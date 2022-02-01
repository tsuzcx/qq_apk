package com.tencent.av.random;

import org.json.JSONObject;

class RandomWebProtocol$RequestMultiKickReport
  extends RandomWebProtocol.RequestMultiReport
{
  int c;
  
  JSONObject a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ret", this.c);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RequestMultiKickReport
 * JD-Core Version:    0.7.0.1
 */