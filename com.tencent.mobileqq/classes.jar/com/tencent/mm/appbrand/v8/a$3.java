package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.util.SparseArray;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8Locker;
import com.eclipsesource.mmv8.utils.MemoryManager;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.CountDownLatch;

class a$3
  extends Thread
{
  a$3(a parama, String paramString, CountDownLatch paramCountDownLatch)
  {
    super(paramString);
  }
  
  public void run()
  {
    a.a(this.b, Process.myTid());
    a.p().run();
    o.d("MicroMsg.AbstractJSRuntime", "expansions file is ready");
    Object localObject = this.b;
    a.a((a)localObject, ((a)localObject).c());
    a.b(this.b).a(new a.3.1(this));
    this.a.countDown();
    a.c(this.b).countDown();
    long l = System.currentTimeMillis();
    o.d("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", new Object[] { Integer.valueOf(a.d(this.b)), Integer.valueOf(this.b.hashCode()), Integer.valueOf(a.b(this.b).hashCode()) });
    localObject = this.b;
    a.a((a)localObject, ((a)localObject).b());
    localObject = this.b;
    a.a((a)localObject, new ab(a.a((a)localObject)));
    a.e(this.b).a();
    localObject = this.b;
    a.a((a)localObject, a.a((a)localObject).createMemoryManager());
    l = System.currentTimeMillis() - l;
    o.d("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", new Object[] { Long.valueOf(l) });
    y.a(5, l, -1, null, -1, -1, -1);
    localObject = a.a(this.b).getV8Locker();
    if (((V8Locker)localObject).hasLock())
    {
      o.d("MicroMsg.AbstractJSRuntime", "has lock release");
      ((V8Locker)localObject).release();
    }
    ((V8Locker)localObject).acquire();
    a.b(this.b).a();
    a.f(this.b);
    a.g(this.b).release();
    a.e(this.b).b();
    try
    {
      a.h(this.b).clear();
      o.d("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(this.b.hashCode()) });
    }
    catch (Throwable localThrowable)
    {
      o.b("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", new Object[] { Integer.valueOf(this.b.hashCode()), localThrowable });
    }
    this.b.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a.3
 * JD-Core Version:    0.7.0.1
 */