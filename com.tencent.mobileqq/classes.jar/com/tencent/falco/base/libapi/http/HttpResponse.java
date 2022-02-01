package com.tencent.falco.base.libapi.http;

import org.json.JSONObject;

public abstract interface HttpResponse
{
  public static final int ERR_IO = -1;
  
  public abstract void onResponse(int paramInt, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.http.HttpResponse
 * JD-Core Version:    0.7.0.1
 */