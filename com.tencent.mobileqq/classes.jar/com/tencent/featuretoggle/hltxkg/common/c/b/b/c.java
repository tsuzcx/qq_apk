package com.tencent.featuretoggle.hltxkg.common.c.b.b;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import com.tencent.featuretoggle.hltxkg.common.a.o;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.featuretoggle.hltxkg.common.c.c, Runnable
{
  private static int a = -1;
  private static c b = new c();
  private com.tencent.featuretoggle.hltxkg.common.c.b c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private Handler g;
  private Map<String, b> h = new ConcurrentHashMap();
  private Runnable i = new d(this);
  private Runnable j = new e(this);
  private Runnable k = new f(this);
  private Map<String, c.a> l = new HashMap();
  
  private c.a b(String paramString)
  {
    try
    {
      boolean bool = this.l.isEmpty();
      Object localObject3;
      if (bool) {
        try
        {
          Object localObject1 = j.b("apnrecords", "", true);
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
                  c.a locala = new c.a(this, (byte)0);
                  locala.b = localJSONObject.optInt("lastCode");
                  locala.a = localJSONObject.optLong("lastReqTime");
                  this.l.put(str, locala);
                }
              }
            }
          }
          localObject3 = (c.a)this.l.get(paramString);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new c.a(this, (byte)0);
        this.l.put(paramString, localObject2);
      }
      return localObject2;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static c c()
  {
    return b;
  }
  
  private void g()
  {
    try
    {
      if (!this.l.isEmpty())
      {
        JSONObject localJSONObject1 = new JSONObject();
        Iterator localIterator = this.l.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          c.a locala = (c.a)localEntry.getValue();
          JSONObject localJSONObject2 = new JSONObject();
          try
          {
            localJSONObject2.put("lastCode", locala.b);
            localJSONObject2.put("lastReqTime", locala.a);
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        j.a("apnrecords", localJSONObject1.toString(), true);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void a()
  {
    ((b)this.h.get("accessscheduler")).a();
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
      paramInt = i.a("detect_platform_update_random_interval", 0, 1440, 10);
      paramInt = new Random().nextInt(paramInt);
      o.a().a(this.i, paramInt * 60 * 1000 + 1000);
    }
  }
  
  public final void a(com.tencent.featuretoggle.hltxkg.common.c.b paramb)
  {
    this.c = paramb;
    paramb = new com.tencent.featuretoggle.hltxkg.common.c.b.b.d.a();
    this.h.put(paramb.c(), paramb);
    paramb = new com.tencent.featuretoggle.hltxkg.common.c.b.b.b.b();
    this.h.put(paramb.c(), paramb);
    paramb = new com.tencent.featuretoggle.hltxkg.common.c.b.b.c.a();
    this.h.put(paramb.c(), paramb);
  }
  
  public final void a(String paramString) {}
  
  public final void a(boolean paramBoolean) {}
  
  public final void b()
  {
    ((b)this.h.get("settings")).b();
  }
  
  public final void d()
  {
    this.g = com.tencent.featuretoggle.hltxkg.common.a.i();
    this.g.post(this);
    this.c.c();
  }
  
  public final com.tencent.featuretoggle.hltxkg.common.c.b e()
  {
    return this.c;
  }
  
  public final void run()
  {
    if (i.a("http_platform_start_update_on", 0, 1, 1) == 1)
    {
      a = 1;
      this.g.removeCallbacks(this.j);
      this.g.post(this.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.c
 * JD-Core Version:    0.7.0.1
 */