package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.protocol.ServiceProtocol;
import java.util.HashMap;
import java.util.Map;

public final class nf
  extends ServiceProtocol
{
  public final Map<String, ne> a = new HashMap();
  
  public nf()
  {
    this.a.put("authorization", new my());
    this.a.put("indoordata", new nd());
    this.a.put("overseadata", new nh());
    this.a.put("mapdata", new ng());
    this.a.put("blockroutedata", new na());
    this.a.put("rttdata", new ni());
    this.a.put("sketchdata", new nj());
    this.a.put("statistic", new nk());
  }
  
  public final <S extends nc> S a(String paramString)
  {
    paramString = (nc)this.a.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nf
 * JD-Core Version:    0.7.0.1
 */