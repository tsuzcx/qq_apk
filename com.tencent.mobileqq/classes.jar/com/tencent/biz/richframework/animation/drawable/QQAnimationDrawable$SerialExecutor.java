package com.tencent.biz.richframework.animation.drawable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class QQAnimationDrawable$SerialExecutor
  implements Executor
{
  final QQAnimationDrawable.Task<Runnable> a = new QQAnimationDrawable.Task(30);
  Runnable b;
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.a.b();
      this.b = localRunnable;
      if (localRunnable != null) {
        QQAnimationDrawable.h.execute(this.b);
      }
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    try
    {
      this.a.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.a.a(new QQAnimationDrawable.SerialExecutor.1(this, paramRunnable));
      if (this.b == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.SerialExecutor
 * JD-Core Version:    0.7.0.1
 */