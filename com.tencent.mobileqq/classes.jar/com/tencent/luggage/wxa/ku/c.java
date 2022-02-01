package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.u;
import org.json.JSONObject;

abstract class c<T extends d>
  extends u
{
  private final T a;
  
  public c(@NonNull T paramT)
  {
    this.a = paramT;
    this.a.a(this);
  }
  
  public final String a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = this.a.a(paramc, paramJSONObject);
    return a(paramc, paramJSONObject.b, paramJSONObject.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.c
 * JD-Core Version:    0.7.0.1
 */