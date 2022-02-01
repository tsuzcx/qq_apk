package com.tencent.ilive.opensdk.reporterinterface;

import org.json.JSONObject;

public abstract interface ICoreHttpResponse
{
  public static final int ERR_IO = -1;
  
  public abstract void onResponse(int paramInt, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.reporterinterface.ICoreHttpResponse
 * JD-Core Version:    0.7.0.1
 */