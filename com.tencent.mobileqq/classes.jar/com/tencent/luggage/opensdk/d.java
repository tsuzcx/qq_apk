package com.tencent.luggage.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static ConcurrentHashMap<String, d.a> a = new ConcurrentHashMap();
  private static final ConcurrentHashMap<Class<? extends BaseResp>, d.b> b = new ConcurrentHashMap();
  private static final ConcurrentHashMap<String, d.a> c = new ConcurrentHashMap();
  private static IWXAPI d = null;
  private static final Random e = new Random(42L);
  
  public static void a(IWXAPI paramIWXAPI)
  {
    d = paramIWXAPI;
  }
  
  public static void a(Class<? extends BaseResp> paramClass, d.b paramb)
  {
    b.put(paramClass, paramb);
  }
  
  public static boolean a()
  {
    return d.isWXAppInstalled();
  }
  
  public static boolean a(@Nullable Context paramContext, Intent paramIntent)
  {
    if (d == null) {
      return false;
    }
    Context localContext;
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if (!paramContext.isFinishing())
      {
        localContext = paramContext;
        if (!paramContext.isDestroyed()) {}
      }
      else
      {
        localContext = r.a();
      }
    }
    else
    {
      localContext = paramContext;
      if (paramContext == null) {
        localContext = r.a();
      }
    }
    paramContext = new boolean[1];
    paramContext[0] = 0;
    d.handleIntent(paramIntent, new d.1(localContext, paramContext, paramIntent));
    return paramContext[0];
  }
  
  public static <REQ extends BaseReq, RESP extends BaseResp> boolean a(String paramString, REQ paramREQ, d.a<RESP> parama)
  {
    if (d == null)
    {
      o.b("Luggage.OpenSDKApiClient", "send open sdk request failed, not initilized");
      return false;
    }
    if (af.c(paramString))
    {
      o.d("Luggage.OpenSDKApiClient", "oriKey is empty, return");
      return false;
    }
    c.put(paramString, parama);
    paramREQ.transaction = "";
    return d.sendReq(paramREQ);
  }
  
  private static String[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("`-`-`-`");
    if (paramString != null)
    {
      if (paramString.length != 2) {
        return null;
      }
      return paramString;
    }
    return null;
  }
  
  public static boolean b()
  {
    return d != null;
  }
  
  private static boolean b(BaseResp paramBaseResp)
  {
    if (!af.c(paramBaseResp.transaction))
    {
      localObject1 = a(paramBaseResp.transaction);
      if (localObject1 != null)
      {
        paramBaseResp.transaction = localObject1[0];
        localObject1 = (d.a)a.remove(localObject1[1]);
        if (localObject1 == null) {
          return false;
        }
      }
    }
    try
    {
      ((d.a)localObject1).a(paramBaseResp);
      return true;
    }
    catch (ClassCastException paramBaseResp)
    {
      Object localObject2;
      return true;
    }
    return false;
    localObject2 = (d.b)b.get(paramBaseResp.getClass());
    if (localObject2 == null) {
      return false;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ((d.b)localObject2).a(paramBaseResp);
      localObject1 = localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      label91:
      break label91;
    }
    if (af.c((String)localObject1)) {
      return false;
    }
    localObject1 = (d.a)c.remove(localObject1);
    if (localObject1 == null) {
      return false;
    }
    ((d.a)localObject1).a(paramBaseResp);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.d
 * JD-Core Version:    0.7.0.1
 */