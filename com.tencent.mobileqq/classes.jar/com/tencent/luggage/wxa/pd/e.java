package com.tencent.luggage.wxa.pd;

import android.os.Looper;
import com.tencent.luggage.wxa.ra.c;
import java.util.LinkedList;
import java.util.Queue;

public abstract class e<Task>
  extends c
{
  private final e<Task>.b a = new e.b(this, null);
  private final e<Task>.a b = new e.a(this, null);
  private final String c;
  private final Queue<Task> d = new LinkedList();
  
  protected e(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.c = paramString;
    a(this.a);
    a(this.b);
    b(this.a);
    c();
  }
  
  private void a()
  {
    synchronized (this.d)
    {
      Object localObject1 = this.d.poll();
      if (localObject1 != null)
      {
        a(this.b);
        a(localObject1);
      }
      return;
    }
  }
  
  protected abstract void a(Task paramTask);
  
  protected abstract boolean b(Task paramTask);
  
  public final void c(Task paramTask)
  {
    if (paramTask == null) {
      return;
    }
    if (b(paramTask)) {
      return;
    }
    synchronized (this.d)
    {
      this.d.offer(paramTask);
      c(1);
      return;
    }
  }
  
  protected final void d()
  {
    c(2);
  }
  
  protected void i()
  {
    super.i();
    synchronized (this.d)
    {
      this.d.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.e
 * JD-Core Version:    0.7.0.1
 */