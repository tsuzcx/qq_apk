package com.tencent.mm.appbrand.v8;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.BlockingDeque;

public class h
  implements d
{
  private d.a a = null;
  private final Looper b;
  private final h.a c;
  private l d = new l();
  
  private h(Looper paramLooper)
  {
    this.b = paramLooper;
    this.c = new h.a(this, paramLooper);
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    d.a locala = this.a;
    if (locala != null) {
      locala.a(paramV8ScriptException);
    }
  }
  
  public static d i()
  {
    Looper.prepare();
    return new h(Looper.myLooper());
  }
  
  public void a() {}
  
  public void a(d.a parama)
  {
    this.a = parama;
  }
  
  public void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    this.c.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Thread.currentThread().getId() == this.b.getThread().getId())
    {
      try
      {
        paramRunnable.run();
      }
      catch (V8ScriptException paramRunnable)
      {
        a(paramRunnable);
      }
      if (this.d.a) {
        this.d.b.remove(null);
      }
      return;
    }
    this.c.post(paramRunnable);
  }
  
  public boolean b()
  {
    return this.b.getThread().getId() == Thread.currentThread().getId();
  }
  
  @Nullable
  public String c()
  {
    return (String)this.d.b.peek();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.b.quitSafely();
  }
  
  public void g()
  {
    o.b("resumeLoopTasks", "should not to be here");
  }
  
  public boolean h()
  {
    o.b("doInnerLoopTask", "should not to be here");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */