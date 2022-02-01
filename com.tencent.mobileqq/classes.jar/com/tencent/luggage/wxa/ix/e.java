package com.tencent.luggage.wxa.ix;

import android.os.Message;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.n;
import com.tencent.luggage.wxa.iz.b;
import com.tencent.luggage.wxa.kx.j;
import com.tencent.luggage.wxa.nr.a.b;
import com.tencent.luggage.wxa.qz.o;

abstract class e
  extends f
{
  private final d a;
  private int b = 0;
  private final a.b c = new e.1(this);
  
  e(g paramg, d paramd)
  {
    super(paramg);
    this.a = paramd;
  }
  
  private void a(int paramInt)
  {
    this.b = (paramInt | this.b);
  }
  
  private void b(int paramInt)
  {
    this.b = ((paramInt ^ 0xFFFFFFFF) & this.b);
    if (this.b == 0) {
      d();
    }
  }
  
  private int g()
  {
    int j = 0;
    this.b = 0;
    Object localObject = this.a.aa();
    a locala = (a)this.a.b(a.class);
    int i = j;
    if (locala != null)
    {
      i = j;
      if (locala.a) {
        i = 1;
      }
    }
    if (i != 0)
    {
      if (com.tencent.luggage.wxa.nr.a.c((String)localObject))
      {
        a(1);
        com.tencent.luggage.wxa.nr.a.b.a((String)localObject, this.c);
      }
    }
    else {
      com.tencent.luggage.wxa.nr.a.b.d((String)localObject);
    }
    j();
    h();
    i();
    k();
    localObject = com.tencent.luggage.wxa.iu.c.i((String)localObject);
    i = e.2.a[localObject.ordinal()];
    if ((i == 1) || ((i == 2) || (i == 3))) {}
    try
    {
      if ((this.a.af() == null) || ((this.a.af().getWindowAndroid().g_()) && (this.a.ac() == null))) {
        break label201;
      }
      a(8);
    }
    catch (IllegalAccessError localIllegalAccessError)
    {
      label201:
      break label201;
    }
    a(4);
    break label201;
    a(16);
    return this.b;
  }
  
  private void h()
  {
    b localb = (b)this.a.c(b.class);
    if (localb != null)
    {
      boolean bool = localb.a();
      o.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        a(64);
      }
    }
  }
  
  private void i()
  {
    com.tencent.luggage.wxa.iz.a locala = (com.tencent.luggage.wxa.iz.a)this.a.c(com.tencent.luggage.wxa.iz.a.class);
    if (locala != null)
    {
      boolean bool = locala.a();
      o.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        a(128);
      }
    }
  }
  
  private void j()
  {
    boolean bool = ((a)this.a.b(a.class)).b;
    o.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      j localj = (j)this.a.c(j.class);
      if (localj != null)
      {
        int i;
        if ((localj.a()) && (localj.b())) {
          i = 1;
        } else {
          i = 0;
        }
        o.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", new Object[] { Boolean.valueOf(localj.a()), Boolean.valueOf(localj.b()) });
        if (i != 0) {
          a(32);
        }
      }
    }
  }
  
  private void k()
  {
    b localb = (b)this.a.c(b.class);
    if (localb != null)
    {
      boolean bool = localb.a();
      o.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        a(256);
      }
    }
  }
  
  public void a()
  {
    this.b = g();
    super.a();
    b(0);
  }
  
  public boolean a(Message paramMessage)
  {
    if (d.a.a(paramMessage.what) == d.a.h)
    {
      o.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
      b(32);
      return true;
    }
    if (d.a.a(paramMessage.what) == d.a.i)
    {
      o.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      b(64);
      return true;
    }
    if (d.a.a(paramMessage.what) == d.a.j)
    {
      o.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
      b(128);
      return true;
    }
    if (d.a.a(paramMessage.what) == d.a.k)
    {
      o.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
      b(256);
      return true;
    }
    return super.a(paramMessage);
  }
  
  public void b()
  {
    super.b();
    this.b = 0;
    com.tencent.luggage.wxa.nr.a.b.b(this.a.aa());
  }
  
  abstract void d();
  
  void e()
  {
    b(16);
  }
  
  boolean f()
  {
    return (this.b & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.e
 * JD-Core Version:    0.7.0.1
 */