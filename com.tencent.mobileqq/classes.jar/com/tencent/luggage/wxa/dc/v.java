package com.tencent.luggage.wxa.dc;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class v
  implements b
{
  public static final v a = new v();
  
  public <Resp extends gu> Resp a(String paramString1, @Nullable String paramString2, a parama, Class<Resp> paramClass)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    try
    {
      r.a(paramString1, paramString2, (gt)parama, paramClass, new v.1(this, localAtomicReference, localCountDownLatch));
    }
    catch (IOException paramString2)
    {
      label45:
      break label45;
    }
    localAtomicReference.set(null);
    localCountDownLatch.countDown();
    try
    {
      localCountDownLatch.await(60L, TimeUnit.SECONDS);
      return (gu)localAtomicReference.get();
    }
    catch (Exception paramString2)
    {
      label77:
      break label77;
    }
    o.b("Luggage.WxaSessionKeyCgiService", "sync %s await failed", new Object[] { paramString1 });
    return null;
  }
  
  public <Resp extends gu> d<Resp> b(String paramString1, @Nullable String paramString2, a parama, Class<Resp> paramClass)
  {
    return r.a(paramString1, paramString2, (gt)parama, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.v
 * JD-Core Version:    0.7.0.1
 */