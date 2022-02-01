package com.tencent.map.sdk.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class cn
  implements cv, Runnable
{
  private static int b = -1;
  private static cn c = new cn();
  public cb a;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private Handler g;
  private Map<String, cj> h = new ConcurrentHashMap();
  private Runnable i = new cr(this);
  private Runnable j = new ct(this);
  private Runnable k = new cu(this);
  private Map<String, cn.a> l = new HashMap();
  
  private cn.a a(String paramString)
  {
    Object localObject3;
    if (this.l.isEmpty()) {
      try
      {
        Object localObject1 = dc.b("apnrecords", "");
        if (!((String)localObject1).isEmpty())
        {
          localObject1 = new JSONObject((String)localObject1);
          localObject3 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            if (!TextUtils.isEmpty(str))
            {
              JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
              if (localJSONObject != null)
              {
                cn.a locala = new cn.a((byte)0);
                locala.b = localJSONObject.optInt("lastCode");
                locala.a = localJSONObject.optLong("lastReqTime");
                this.l.put(str, locala);
              }
            }
          }
        }
        localObject3 = (cn.a)this.l.get(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new cn.a((byte)0);
      this.l.put(paramString, localObject2);
    }
    return localObject2;
  }
  
  public static cn c()
  {
    return c;
  }
  
  public final void a()
  {
    ((cj)this.h.get("accessscheduler")).a();
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.g.removeCallbacks(this.j);
      this.g.post(this.j);
      return;
    }
    if ((paramInt == 2) && (!this.f))
    {
      this.f = true;
      paramInt = as.a("detect_platform_update_random_interval", 0, 1440, 10);
      paramInt = new Random().nextInt(paramInt);
      ay.a().a(this.i, false, paramInt * 60 * 1000 + 1000);
    }
  }
  
  public final void a(cb paramcb)
  {
    this.a = paramcb;
    paramcb = new cs();
    this.h.put(paramcb.c(), paramcb);
    paramcb = new cl();
    this.h.put(paramcb.c(), paramcb);
    paramcb = new co();
    this.h.put(paramcb.c(), paramcb);
  }
  
  public final void b()
  {
    ((cj)this.h.get("settings")).b();
  }
  
  public final void d()
  {
    this.g = ac.h();
    this.g.post(this);
    this.a.c();
  }
  
  public final void run()
  {
    if (as.a("http_platform_start_update_on", 0, 1, 1) == 1)
    {
      b = 1;
      this.g.removeCallbacks(this.j);
      this.g.post(this.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.cn
 * JD-Core Version:    0.7.0.1
 */