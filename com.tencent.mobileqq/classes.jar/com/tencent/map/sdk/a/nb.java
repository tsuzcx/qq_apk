package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.protocol.ServiceProtocol;

public final class nb
  extends ServiceProtocol
{
  public final <S extends nc> S a(String paramString)
  {
    if ("authorization".equals(paramString)) {
      paramString = new my();
    } else if ("blockroutedata".equals(paramString)) {
      paramString = new na();
    } else if ("indoordata".equals(paramString)) {
      paramString = new nd();
    } else if ("mapdata".equals(paramString)) {
      paramString = new ng();
    } else if ("overseadata".equals(paramString)) {
      paramString = new nh();
    } else if ("rttdata".equals(paramString)) {
      paramString = new ni();
    } else if ("sketchdata".equals(paramString)) {
      paramString = new nj();
    } else if ("statistic".equals(paramString)) {
      paramString = new nk();
    } else {
      paramString = null;
    }
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nb
 * JD-Core Version:    0.7.0.1
 */