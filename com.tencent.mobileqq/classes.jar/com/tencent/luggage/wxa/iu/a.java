package com.tencent.luggage.wxa.iu;

import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c.b;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.on.j;
import com.tencent.luggage.wxa.qz.ag;
import com.tencent.luggage.wxa.qz.o;

public class a
  implements c.b
{
  private final d a;
  private final com.tencent.luggage.wxa.on.c b;
  private final com.tencent.luggage.wxa.jx.c c;
  
  public a(d paramd, com.tencent.luggage.wxa.jx.c paramc, com.tencent.luggage.wxa.on.c paramc1)
  {
    this.a = paramd;
    this.c = paramc;
    this.b = paramc1;
  }
  
  private void b(ah paramah, com.tencent.luggage.wxa.jx.c.a parama)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject2 = ((d)localObject1).al();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((com.tencent.luggage.wxa.ix.c)localObject2).j())
        {
          i = 1;
          localObject1 = localObject2;
          break label53;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    int i = 0;
    label53:
    if (i == 0)
    {
      parama.a("fail:interrupted");
      return;
    }
    if ((!this.c.d()) && (!this.c.e())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      o.b("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { paramah.d(), this.c.getAppId() });
      parama.a("fail:interrupted");
      return;
    }
    localObject1 = ((com.tencent.luggage.wxa.ix.c)localObject1).a();
    boolean bool2 = this.b.a(this.c, paramah.getClass());
    boolean bool1;
    if ((b.c != localObject1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Object localObject2 = (j)this.c.a(j.class);
    if ((localObject2 != null) && (((j)localObject2).a(paramah))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      o.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), paramah.d(), localObject1, Boolean.valueOf(bool2) });
      if (ag.a()) {
        if (paramah.d().equals("onInitialRenderingCacheReady")) {
          o.e("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { paramah.d(), Integer.valueOf(paramah.c().length()) });
        } else {
          o.e("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramah.d(), paramah.c() });
        }
      }
    }
    if (!bool1)
    {
      parama.a("fail:access denied");
      return;
    }
    parama.a();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(ah paramah, com.tencent.luggage.wxa.jx.c.a parama)
  {
    try
    {
      b(paramah, parama);
      return;
    }
    catch (NullPointerException parama)
    {
      o.a("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { paramah.d() });
    }
  }
  
  public void a(m paramm, String paramString1, int paramInt, String paramString2) {}
  
  @CallSuper
  public boolean a(m paramm, String paramString, int paramInt, com.tencent.luggage.wxa.jx.c.a parama)
  {
    paramString = this.b.a(this.c, paramm, paramString, paramInt, new a.1(this, parama, paramm));
    if (-2 == paramString.a) {
      return true;
    }
    if (paramString.a != 0)
    {
      parama.a(paramm.b(paramString.b));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.a
 * JD-Core Version:    0.7.0.1
 */