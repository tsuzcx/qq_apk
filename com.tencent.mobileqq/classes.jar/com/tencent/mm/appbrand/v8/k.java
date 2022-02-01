package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.SharedV8ArrayBuffer;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class k
  implements e
{
  private final AtomicInteger a;
  private final Map<Integer, k.a> b;
  private final n c;
  
  public k(n paramn)
  {
    this.c = paramn;
    this.a = new AtomicInteger(0);
    this.b = new HashMap();
  }
  
  public int a(int paramInt)
  {
    int i = this.a.addAndGet(1);
    k.a locala = new k.a(paramInt, this.c);
    this.b.put(Integer.valueOf(i), locala);
    o.d("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    return i;
  }
  
  public SharedV8ArrayBuffer b(int paramInt)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt)))
    {
      o.c("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    return ((k.a)this.b.get(Integer.valueOf(paramInt))).a();
  }
  
  public ByteBuffer c(int paramInt)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt)))
    {
      o.c("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    return ((k.a)this.b.get(Integer.valueOf(paramInt))).b();
  }
  
  public void d(int paramInt)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt)))
    {
      o.c("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    o.d("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    ((k.a)this.b.get(Integer.valueOf(paramInt))).c();
    this.b.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.k
 * JD-Core Version:    0.7.0.1
 */