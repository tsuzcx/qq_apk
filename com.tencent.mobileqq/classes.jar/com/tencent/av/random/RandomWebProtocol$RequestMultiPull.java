package com.tencent.av.random;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import org.json.JSONObject;

class RandomWebProtocol$RequestMultiPull
  extends RandomWebProtocol.Request
{
  long jdField_b_of_type_Long;
  int c;
  int d;
  int e;
  String f;
  
  RandomWebProtocol$RequestMultiPull(RandomWebProtocol paramRandomWebProtocol, RandomWebProtocol.Request paramRequest, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, long paramLong)
  {
    super(paramRandomWebProtocol, paramRequest);
    this.a = 3;
    this.c = paramString1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = paramString2;
    this.e = paramInt3;
    this.jdField_b_of_type_Long = paramLong;
    this.d = ("[p]" + paramInt1 + paramInt2 + paramString2 + paramInt3 + paramLong);
  }
  
  String a()
  {
    this.a = null;
    try
    {
      this.a = new JSONObject().put("session_type", this.c).put("reqtype", this.d).put("groupid", this.jdField_b_of_type_Long);
      if (2 == this.d) {
        this.a.put("peer_enuin", ChatActivityUtils.b(RandomWebProtocol.a(), this.f)).put("peer_gender", this.e);
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RequestMultiPull
 * JD-Core Version:    0.7.0.1
 */