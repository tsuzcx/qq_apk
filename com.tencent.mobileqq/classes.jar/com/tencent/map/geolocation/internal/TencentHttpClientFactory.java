package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import c.t.m.g.ds;
import c.t.m.g.dt;
import c.t.m.g.f.a;

public abstract class TencentHttpClientFactory
{
  private static TencentHttpClientFactory sCustFact;
  
  public static TencentHttpClientFactory getInstance()
  {
    new TencentHttpClientFactory()
    {
      public final Bundle getParams()
      {
        return null;
      }
    };
  }
  
  public static void setTencentHttpClientFactory(TencentHttpClientFactory paramTencentHttpClientFactory)
  {
    sCustFact = paramTencentHttpClientFactory;
  }
  
  public abstract Bundle getParams();
  
  public TencentHttpClient getTencentHttpClient(Context paramContext, Bundle paramBundle)
  {
    if (sCustFact != null) {
      return (TencentHttpClient)f.a.b(sCustFact.getTencentHttpClient(paramContext, sCustFact.getParams()), "http client should NOT be null");
    }
    return new ds(paramContext, paramBundle.getString("channelId"));
  }
  
  public TencentHttpClient getTencentHttpURLConnection()
  {
    if (sCustFact != null) {
      return (TencentHttpClient)f.a.b(sCustFact.getTencentHttpURLConnection(), "http client should NOT be null");
    }
    return new dt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */