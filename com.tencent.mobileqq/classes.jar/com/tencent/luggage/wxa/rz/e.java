package com.tencent.luggage.wxa.rz;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.luggage.wxa.sg.h;
import java.util.concurrent.Executor;

public final class e
{
  private static Executor a;
  
  private static void a()
  {
    try
    {
      a = (Executor)com.tencent.luggage.wxa.sl.c.a(AsyncTask.class, "THREAD_POOL_EXECUTOR");
      com.tencent.luggage.wxa.sl.c.a(AsyncTask.class, "THREAD_POOL_EXECUTOR", new e.2());
      return;
    }
    catch (Exception localException)
    {
      c.c.c("ThreadModuleBoot", localException.toString(), new Object[0]);
    }
  }
  
  public static void a(Context paramContext, e.a parama)
  {
    parama.a(new e.1());
    parama = parama.a(new a.a());
    com.tencent.luggage.wxa.sc.b.a = new com.tencent.luggage.wxa.sb.a(paramContext, parama);
    h.a = h.a(parama);
    f.a(paramContext, parama);
    if (parama.h) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rz.e
 * JD-Core Version:    0.7.0.1
 */