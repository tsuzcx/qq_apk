package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public final class CacheStrategy
{
  public final Response cacheResponse;
  public final Request networkRequest;
  
  private CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    switch (paramResponse.code())
    {
    }
    do
    {
      return false;
    } while (((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) || (paramResponse.cacheControl().noStore()) || (paramRequest.cacheControl().noStore()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.CacheStrategy
 * JD-Core Version:    0.7.0.1
 */