package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.IndoorDataRequest;
import com.tencent.map.sdk.service.protocol.request.MapDataRequest;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetUnavailableException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class po
  extends qe
{
  private Context a;
  private qi b = new qi();
  private String c = "UNKNOW";
  private String d = "";
  private pm e;
  private jg f;
  
  public po(pn parampn)
  {
    this.a = parampn.ay;
    this.c = this.a.getClass().getSimpleName();
    this.a = this.a.getApplicationContext();
    this.e = parampn.az;
    this.f = parampn.aF;
  }
  
  public final byte[] a(String paramString)
  {
    if ((this.a == null) || (nl.a(paramString))) {
      return null;
    }
    if (!this.b.a(paramString)) {
      return null;
    }
    if ((this.e != null) && (nl.a(this.d)) && (!nl.a(this.e.k()))) {
      this.d = ("&eng_ver=" + this.e.k());
    }
    Object localObject2 = ((MapDataRequest)((ng)MapServiceManager.getService(ng.class)).c()).getIndoorMapUrl();
    Object localObject1 = paramString;
    if (paramString.startsWith((String)localObject2))
    {
      paramString = paramString.replace((CharSequence)localObject2, ((IndoorDataRequest)((nd)MapServiceManager.getService(nd.class)).c()).getIndoorMapUrl());
      localObject1 = paramString + "&apiKey=" + pz.a;
    }
    paramString = (na)MapServiceManager.getService(na.class);
    localObject2 = (nj)MapServiceManager.getService(nj.class);
    if ((!((String)localObject1).endsWith(".jpg")) && (!((String)localObject1).startsWith(paramString.d())) && (!((String)localObject1).startsWith(((nj)localObject2).d()))) {}
    for (paramString = (String)localObject1 + this.d + fz.a(this.c);; paramString = (String)localObject1)
    {
      try
      {
        localObject2 = NetManager.getInstance().doGet((String)localObject1, "androidsdk");
        if (localObject2 != null) {
          break label445;
        }
        return null;
      }
      catch (Exception localException)
      {
        if (!((String)localObject1).contains("/mvd_map")) {
          break label423;
        }
      }
      int i;
      if ((localException instanceof NetUnavailableException)) {
        i = ((NetUnavailableException)localException).errorCode;
      }
      for (;;)
      {
        localObject1 = this.f;
        long l = System.currentTimeMillis();
        paramString = paramString.substring(paramString.indexOf('?') + 1);
        if (((jg)localObject1).c.e == null) {
          ((jg)localObject1).c.e = new CopyOnWriteArraySet();
        }
        jg.g localg;
        if (((jg)localObject1).c.e.size() <= 9)
        {
          localg = new jg.g((byte)0);
          localg.a = (l - ((jg)localObject1).a);
          localg.b = paramString;
          localg.c = i;
          ((jg)localObject1).c.e.add(localg);
        }
        label423:
        return null;
        if ((localg instanceof qk))
        {
          i = ((qk)localg).statusCode;
          continue;
          label445:
          if (!paramString.contains("qt=rtt")) {
            this.b.b(paramString);
          }
          return localg.data;
        }
        else
        {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.po
 * JD-Core Version:    0.7.0.1
 */