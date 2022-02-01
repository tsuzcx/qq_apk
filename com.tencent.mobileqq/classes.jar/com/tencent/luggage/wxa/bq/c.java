package com.tencent.luggage.wxa.bq;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.n;
import java.util.HashMap;
import java.util.Map;

public class c
  extends n
{
  static final int CTRL_INDEX = 78;
  static final String NAME = "onKeyboardInput";
  
  public void a(String paramString, h paramh)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", paramString);
    a(localHashMap).a(paramh).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.c
 * JD-Core Version:    0.7.0.1
 */