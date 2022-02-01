package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8ScriptException;
import com.eclipsesource.mmv8.utils.MemoryManager;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements c
{
  private static final AtomicInteger e = new AtomicInteger(0);
  private static Runnable f = new a.1();
  String a;
  byte[] b;
  String c;
  boolean d;
  private MultiContextV8 g;
  private d h;
  private CountDownLatch i;
  private MemoryManager j;
  private ab k;
  private f l;
  private volatile int m = -1;
  private final boolean n;
  private final boolean o;
  private final SparseArray<h> p;
  private final ConcurrentLinkedQueue<Runnable> q;
  @NonNull
  private c.a r;
  
  a(@Nullable c.a parama)
  {
    if (parama != null)
    {
      this.a = parama.a;
      this.b = parama.b;
      this.n = parama.a();
      this.d = parama.e;
      this.o = parama.f;
      this.c = parama.h;
    }
    else
    {
      this.n = false;
      this.o = false;
    }
    c.a locala;
    if (parama == null) {
      locala = new c.a();
    } else {
      locala = parama;
    }
    this.r = locala;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", new Object[] { Boolean.valueOf(this.n), Boolean.valueOf(this.o) });
    if (parama != null) {
      parama = parama.toString();
    } else {
      parama = "";
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "hy: config: %s", new Object[] { parama });
    this.p = new SparseArray();
    this.q = new ConcurrentLinkedQueue();
    q();
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    synchronized (this.p)
    {
      h localh = (h)this.p.get(paramV8ScriptException.getContextTag());
      if (localh != null)
      {
        localh.a(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
        return;
      }
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
      return;
    }
  }
  
  private void q()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.i = new CountDownLatch(1);
    new a.3(this, String.format(Locale.US, "JSRuntimeLooper#%d", new Object[] { Integer.valueOf(e.getAndIncrement()) }), localCountDownLatch).start();
    try
    {
      localCountDownLatch.await(5000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", new Object[] { localInterruptedException });
    }
  }
  
  private void r()
  {
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.q.poll();
      if (localRunnable == null) {
        break;
      }
      try
      {
        localRunnable.run();
      }
      catch (UndeclaredThrowableException localUndeclaredThrowableException)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AbstractJSRuntime", "doPostedCleanUpJob UndeclaredThrowableException: %s %s", new Object[] { localUndeclaredThrowableException, localUndeclaredThrowableException.getCause() });
      }
      catch (V8ScriptException localV8ScriptException)
      {
        a(localV8ScriptException);
      }
    }
  }
  
  private void s()
  {
    if ((this.h == null) && (this.i != null))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
      try
      {
        this.i.await(30000L, TimeUnit.MILLISECONDS);
      }
      catch (InterruptedException localInterruptedException)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", new Object[] { localInterruptedException });
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
    }
    if (this.h == null)
    {
      f.run();
      if (this.h != null) {
        return;
      }
      throw new IllegalStateException("JSRuntime not ready!");
    }
  }
  
  @NonNull
  public c.a a()
  {
    return this.r;
  }
  
  public void a(int paramInt)
  {
    int i1 = this.m;
    if (i1 > 0) {
      try
      {
        Process.setThreadPriority(i1, paramInt);
        com.tencent.luggage.wxa.qz.o.e("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1) });
        return;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.AbstractJSRuntime", localException, "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1) });
      }
    }
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.m < 0)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.m), Long.valueOf(Thread.currentThread().getId()) });
    synchronized (this.p)
    {
      this.p.put(paramInt, paramh);
      return;
    }
  }
  
  void a(f paramf)
  {
    this.l = paramf;
  }
  
  public void a(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    s();
    this.h.a(paramRunnable, paramLong, paramBoolean);
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    s();
    this.h.a(paramRunnable, paramBoolean);
  }
  
  public void a(String paramString)
  {
    new o(this.g, this).a(paramString);
  }
  
  abstract MultiContextV8 b();
  
  public n b(int paramInt)
  {
    return new n(this, e(), new a.2(this, paramInt));
  }
  
  public void b(Runnable paramRunnable)
  {
    this.q.add(paramRunnable);
  }
  
  abstract d c();
  
  abstract void d();
  
  public f e()
  {
    if (this.l == null) {
      if (this.n)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
        this.l = new NativeBufferJNI();
      }
      else
      {
        this.l = new v();
      }
    }
    return this.l;
  }
  
  public String f()
  {
    return this.h.c();
  }
  
  public void g()
  {
    this.h.d();
  }
  
  public void h()
  {
    this.h.e();
  }
  
  public void i()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.h.f();
    this.m = -1;
  }
  
  public boolean j()
  {
    return this.h.b();
  }
  
  public boolean k()
  {
    return this.o;
  }
  
  public long l()
  {
    return this.g.getIsolatePtr();
  }
  
  public long m()
  {
    return this.g.getUVLoopPtr();
  }
  
  public void n()
  {
    this.h.g();
  }
  
  public boolean o()
  {
    return this.h.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */