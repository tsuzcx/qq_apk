package com.tencent.beacon.core.network.volley;

import java.util.Map;
import org.apache.http.HttpResponse;

@Deprecated
public abstract interface HttpStack
{
  public abstract HttpResponse performRequest(Request<?> paramRequest, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.HttpStack
 * JD-Core Version:    0.7.0.1
 */