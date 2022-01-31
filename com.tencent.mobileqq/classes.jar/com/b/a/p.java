package com.b.a;

import android.os.Handler;
import java.util.concurrent.Executor;

public class p
{
  private final Executor a;
  
  public p(Handler paramHandler)
  {
    this.a = new e(this, paramHandler);
  }
  
  public p(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  public void a(m<?> paramm, o<?> paramo)
  {
    a(paramm, paramo, null);
  }
  
  public void a(m<?> paramm, o<?> paramo, Runnable paramRunnable)
  {
    paramm.p();
    paramm.a("post-response");
    this.a.execute(new f(this, paramm, paramo, paramRunnable));
  }
  
  public void a(m<?> paramm, t paramt)
  {
    paramm.a("post-error");
    paramt = o.a(paramt);
    this.a.execute(new f(this, paramm, paramt, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.b.a.p
 * JD-Core Version:    0.7.0.1
 */