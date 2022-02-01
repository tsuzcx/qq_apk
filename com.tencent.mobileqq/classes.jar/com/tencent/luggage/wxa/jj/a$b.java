package com.tencent.luggage.wxa.jj;

import org.json.JSONObject;

public class a$b
  extends a.i
{
  public a$b(JSONObject paramJSONObject, a.i parami, boolean paramBoolean)
  {
    super(paramJSONObject, parami, paramBoolean);
    parami = paramJSONObject;
    if (paramJSONObject == null) {
      parami = a.i.p;
    }
    if (parami.optJSONObject("window") == null) {
      paramJSONObject = a.i.p;
    }
  }
  
  public a$b(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this(paramJSONObject, null, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.a.b
 * JD-Core Version:    0.7.0.1
 */