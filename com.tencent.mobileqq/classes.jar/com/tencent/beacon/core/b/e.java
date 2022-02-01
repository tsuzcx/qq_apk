package com.tencent.beacon.core.b;

import com.tencent.beacon.core.network.volley.Response.ErrorListener;
import com.tencent.beacon.core.network.volley.Response.Listener;
import com.tencent.beacon.core.network.volley.StringRequest;
import java.util.Map;

class e
  extends StringRequest
{
  e(f paramf, int paramInt, String paramString, Response.Listener paramListener, Response.ErrorListener paramErrorListener, Map paramMap)
  {
    super(paramInt, paramString, paramListener, paramErrorListener);
  }
  
  public Map<String, String> getParams()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.b.e
 * JD-Core Version:    0.7.0.1
 */