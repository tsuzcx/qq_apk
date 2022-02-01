package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.protocol.ServiceProtocol;

public final class nb
  extends ServiceProtocol
{
  public final <S extends nc> S a(String paramString)
  {
    if ("authorization".equals(paramString)) {
      paramString = new my();
    }
    for (;;)
    {
      if (paramString != null)
      {
        return paramString;
        if ("blockroutedata".equals(paramString))
        {
          paramString = new na();
          continue;
        }
        if ("indoordata".equals(paramString))
        {
          paramString = new nd();
          continue;
        }
        if ("mapdata".equals(paramString))
        {
          paramString = new ng();
          continue;
        }
        if ("overseadata".equals(paramString))
        {
          paramString = new nh();
          continue;
        }
        if ("rttdata".equals(paramString))
        {
          paramString = new ni();
          continue;
        }
        if ("sketchdata".equals(paramString))
        {
          paramString = new nj();
          continue;
        }
        if ("statistic".equals(paramString)) {
          paramString = new nk();
        }
      }
      else
      {
        return null;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nb
 * JD-Core Version:    0.7.0.1
 */