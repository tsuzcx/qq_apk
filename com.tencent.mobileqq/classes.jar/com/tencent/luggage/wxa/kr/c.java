package com.tencent.luggage.wxa.kr;

import com.tencent.luggage.wxa.jx.a;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  private final d a = new d();
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    return paramString;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    this.a.a(paramc, paramJSONObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.c
 * JD-Core Version:    0.7.0.1
 */