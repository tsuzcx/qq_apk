package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import c.t.m.g.dw;
import c.t.m.g.dx;
import c.t.m.g.ev;

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
      return (TencentHttpClient)ev.a(sCustFact.getTencentHttpClient(paramContext, sCustFact.getParams()), "http client should NOT be null");
    }
    return new dw(paramContext, paramBundle.getString("channelId"));
  }
  
  public TencentHttpClient getTencentHttpURLConnection()
  {
    if (sCustFact != null) {
      return (TencentHttpClient)ev.a(sCustFact.getTencentHttpURLConnection(), "http client should NOT be null");
    }
    return new dx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */