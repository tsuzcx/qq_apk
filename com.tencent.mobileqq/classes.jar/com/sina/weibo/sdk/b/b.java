package com.sina.weibo.sdk.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public final class b
{
  private a P = null;
  
  private b()
  {
    if (this.P == null) {
      this.P = new a();
    }
  }
  
  public final void a(c paramc)
  {
    ThreadPoolExecutor localThreadPoolExecutor = this.P.N;
    if (paramc.R != c.b.aa)
    {
      int i = c.4.X[(paramc.R - 1)];
      if (i != 1)
      {
        if (i == 2) {
          throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
      }
      else {
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
    }
    paramc.R = c.b.ab;
    paramc.S.ae = paramc.V;
    paramc.S.priority = paramc.U;
    localThreadPoolExecutor.execute(paramc.T);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */