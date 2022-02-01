package com.tencent.luggage.wxa.a;

import java.util.HashMap;
import java.util.Map;

class l$d
{
  private static final Map<String, Integer> a = new HashMap(13);
  
  static
  {
    Map localMap = a;
    Integer localInteger1 = Integer.valueOf(400);
    localMap.put("normal", localInteger1);
    localMap = a;
    Integer localInteger2 = Integer.valueOf(700);
    localMap.put("bold", localInteger2);
    a.put("bolder", Integer.valueOf(1));
    a.put("lighter", Integer.valueOf(-1));
    a.put("100", Integer.valueOf(100));
    a.put("200", Integer.valueOf(200));
    a.put("300", Integer.valueOf(300));
    a.put("400", localInteger1);
    a.put("500", Integer.valueOf(500));
    a.put("600", Integer.valueOf(600));
    a.put("700", localInteger2);
    a.put("800", Integer.valueOf(800));
    a.put("900", Integer.valueOf(900));
  }
  
  static Integer a(String paramString)
  {
    return (Integer)a.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.d
 * JD-Core Version:    0.7.0.1
 */