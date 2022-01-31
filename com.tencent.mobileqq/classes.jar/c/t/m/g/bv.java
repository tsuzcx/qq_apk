package c.t.m.g;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class bv
  implements cd, Runnable
{
  private static int b = -1;
  private static bv c = new bv();
  public bj a;
  private boolean d = false;
  private Handler e;
  private Map<String, br> f = new ConcurrentHashMap();
  private Runnable g = new bz(this);
  private Runnable h = new cb(this);
  private Runnable i = new cc(this);
  private Map<String, bv.a> j = new HashMap();
  
  private bv.a a(String paramString)
  {
    Object localObject3;
    if (this.j.isEmpty()) {
      try
      {
        Object localObject1 = ck.b("apnrecords", "");
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
                bv.a locala = new bv.a((byte)0);
                locala.b = localJSONObject.optInt("lastCode");
                locala.a = localJSONObject.optLong("lastReqTime");
                this.j.put(str, locala);
              }
            }
          }
        }
        localObject3 = (bv.a)this.j.get(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new bv.a((byte)0);
      this.j.put(paramString, localObject2);
    }
    return localObject2;
  }
  
  private static int c(int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = "http_platform_update_interval_succ";
      if (paramInt != 0) {
        break label48;
      }
      paramInt = 1800000;
    }
    for (;;)
    {
      return x.a.a(str, 60000, 3600000, paramInt);
      if ((paramInt == -4) || (paramInt == -3))
      {
        str = "http_platform_update_interval_nonet";
        break;
      }
      str = "http_platform_update_interval_fail";
      break;
      label48:
      if ((paramInt == -4) || (paramInt == -3)) {
        paramInt = 60000;
      } else {
        paramInt = 300000;
      }
    }
  }
  
  public static bv c()
  {
    return c;
  }
  
  public final void a()
  {
    ((br)this.f.get("accessscheduler")).a();
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.e.removeCallbacks(this.h);
      this.e.post(this.h);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    paramInt = x.a.a("detect_platform_update_random_interval", 0, 1440, 10);
    paramInt = new Random().nextInt(paramInt);
    int k = c(0);
    af.a().a(this.g, false, paramInt * 60 * 1000 + k);
  }
  
  public final void a(bj parambj)
  {
    this.a = parambj;
    parambj = new ca();
    this.f.put(parambj.c(), parambj);
    parambj = new bt();
    this.f.put(parambj.c(), parambj);
    parambj = new bw();
    this.f.put(parambj.c(), parambj);
  }
  
  public final void b()
  {
    ((br)this.f.get("settings")).b();
  }
  
  public final void d()
  {
    this.e = x.a.a("HttpPlatformConnection");
    this.e.post(this);
    this.a.c();
  }
  
  public final void run()
  {
    if (x.a.a("http_platform_start_update_on", 0, 1, 0) == 1)
    {
      b = 1;
      this.e.post(this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.bv
 * JD-Core Version:    0.7.0.1
 */