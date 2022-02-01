package com.tencent.av.random;

import org.json.JSONObject;

class RandomWebProtocol$RequestMulti
  extends RandomWebProtocol.Request
{
  boolean jdField_b_of_type_Boolean;
  int c;
  
  RandomWebProtocol$RequestMulti(RandomWebProtocol paramRandomWebProtocol, RandomWebProtocol.Request paramRequest, String paramString, boolean paramBoolean, int paramInt)
  {
    super(paramRandomWebProtocol, paramRequest);
    this.a = 2;
    this.c = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.c = paramInt;
    this.d = "[m] RequestMulti";
  }
  
  String a()
  {
    this.a = null;
    try
    {
      this.a = new JSONObject().put("session_type", this.c);
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
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RequestMulti
 * JD-Core Version:    0.7.0.1
 */