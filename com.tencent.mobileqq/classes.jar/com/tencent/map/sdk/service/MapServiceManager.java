package com.tencent.map.sdk.service;

import android.content.Context;
import com.tencent.map.sdk.a.m;
import com.tencent.map.sdk.a.nb;
import com.tencent.map.sdk.a.nc;
import com.tencent.map.sdk.service.protocol.ServiceProtocol;
import com.tencent.map.sdk.service.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateReq;
import com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateRsp;
import com.tencent.map.sdk.service.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.map.sdk.service.protocol.jce.rtt.RttRequest;
import com.tencent.map.sdk.service.protocol.jce.rtt.RttResponse;
import com.tencent.map.sdk.service.protocol.jce.sso.CmdResult;
import com.tencent.map.sdk.service.protocol.jce.sso.Header;
import com.tencent.map.sdk.service.protocol.jce.sso.Package;
import com.tencent.map.sdk.service.protocol.jce.sso.Tag;
import com.tencent.map.sdk.service.protocol.jce.user.user_login_t;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.map.tools.net.NetManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapServiceManager
{
  private static volatile MapServiceManager b;
  private Map<Class, Object> a = new ConcurrentHashMap();
  private ServiceProtocol c = new nb();
  
  private MapServiceManager()
  {
    m.a(RttRequest.class);
    m.a(RttResponse.class);
    m.a(user_login_t.class);
    m.a(CmdResult.class);
    m.a(Header.class);
    m.a(Package.class);
    m.a(Tag.class);
    m.a(CSFileUpdateReq.class);
    m.a(FileUpdateReq.class);
    m.a(FileUpdateRsp.class);
    m.a(SCFileUpdateRsp.class);
  }
  
  private static void a()
  {
    if (b == null) {
      b = new MapServiceManager();
    }
  }
  
  public static <S extends nc> S getService(Class<S> paramClass)
  {
    a();
    Object localObject = b.a.get(paramClass);
    if ((localObject instanceof nc)) {
      return (nc)localObject;
    }
    localObject = b.c.newService(paramClass);
    b.a.put(paramClass, localObject);
    return localObject;
  }
  
  public static void setServiceNetAdapter(Context paramContext, AdapterType paramAdapterType)
  {
    NetManager.getInstance().setAdapter(paramContext, NetManager.buildAdapter(paramAdapterType));
  }
  
  public static void setServiceProtocol(ServiceProtocol paramServiceProtocol)
  {
    
    if (paramServiceProtocol != null)
    {
      b.c = paramServiceProtocol;
      b.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.service.MapServiceManager
 * JD-Core Version:    0.7.0.1
 */