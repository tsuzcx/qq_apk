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
    if (this.a != null)
    {
      if (nl.a(paramString)) {
        return null;
      }
      if (!this.b.a(paramString)) {
        return null;
      }
      if ((this.e != null) && (nl.a(this.d)) && (!nl.a(this.e.k())))
      {
        localObject1 = new StringBuilder("&eng_ver=");
        ((StringBuilder)localObject1).append(this.e.k());
        this.d = ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = ((MapDataRequest)((ng)MapServiceManager.getService(ng.class)).c()).getIndoorMapUrl();
      Object localObject1 = paramString;
      if (paramString.startsWith((String)localObject2))
      {
        paramString = paramString.replace((CharSequence)localObject2, ((IndoorDataRequest)((nd)MapServiceManager.getService(nd.class)).c()).getIndoorMapUrl());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&apiKey=");
        ((StringBuilder)localObject1).append(pz.a);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramString = (na)MapServiceManager.getService(na.class);
      localObject2 = (nj)MapServiceManager.getService(nj.class);
      if ((!((String)localObject1).endsWith(".jpg")) && (!((String)localObject1).startsWith(paramString.d())) && (!((String)localObject1).startsWith(((nj)localObject2).d())))
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append(this.d);
        paramString.append(fz.a(this.c));
        paramString = paramString.toString();
      }
      else
      {
        paramString = (String)localObject1;
      }
      try
      {
        localObject2 = NetManager.getInstance().doGet((String)localObject1, "androidsdk");
        if (localObject2 == null) {
          return null;
        }
        if (!paramString.contains("qt=rtt")) {
          this.b.b(paramString);
        }
        return ((NetResponse)localObject2).data;
      }
      catch (Exception localException)
      {
        if (((String)localObject1).contains("/mvd_map"))
        {
          int i = -1;
          if ((localException instanceof NetUnavailableException)) {
            i = ((NetUnavailableException)localException).errorCode;
          } else if ((localException instanceof qk)) {
            i = ((qk)localException).statusCode;
          }
          localObject1 = this.f;
          long l = System.currentTimeMillis();
          paramString = paramString.substring(paramString.indexOf('?') + 1);
          if (((jg)localObject1).c.e == null) {
            ((jg)localObject1).c.e = new CopyOnWriteArraySet();
          }
          if (((jg)localObject1).c.e.size() <= 9)
          {
            jg.g localg = new jg.g((byte)0);
            localg.a = (l - ((jg)localObject1).a);
            localg.b = paramString;
            localg.c = i;
            ((jg)localObject1).c.e.add(localg);
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.po
 * JD-Core Version:    0.7.0.1
 */