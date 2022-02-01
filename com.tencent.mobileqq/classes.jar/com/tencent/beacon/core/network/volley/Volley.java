package com.tencent.beacon.core.network.volley;

import android.content.Context;

public class Volley
{
  private static final String DEFAULT_CACHE_DIR = "beacon_volley";
  
  public static RequestQueue newRequestQueue(Context paramContext)
  {
    return newRequestQueue(paramContext, null);
  }
  
  public static RequestQueue newRequestQueue(Context paramContext, BaseHttpStack paramBaseHttpStack)
  {
    if (paramBaseHttpStack == null) {}
    for (paramBaseHttpStack = new BasicNetwork(new HurlStack());; paramBaseHttpStack = new BasicNetwork(paramBaseHttpStack)) {
      return newRequestQueue(paramContext, paramBaseHttpStack);
    }
  }
  
  @Deprecated
  public static RequestQueue newRequestQueue(Context paramContext, HttpStack paramHttpStack)
  {
    if (paramHttpStack == null) {
      return newRequestQueue(paramContext, null);
    }
    return newRequestQueue(paramContext, new BasicNetwork(paramHttpStack));
  }
  
  private static RequestQueue newRequestQueue(Context paramContext, Network paramNetwork)
  {
    paramContext = new RequestQueue(new DiskBasedCache(new Volley.1(paramContext.getApplicationContext())), paramNetwork);
    paramContext.start();
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Volley
 * JD-Core Version:    0.7.0.1
 */