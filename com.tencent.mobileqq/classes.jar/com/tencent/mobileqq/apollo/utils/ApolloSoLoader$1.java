package com.tencent.mobileqq.apollo.utils;

import anmq;
import anpq;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ApolloSoLoader$1
  implements Runnable
{
  public void run()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (!anpq.b())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      if (!anpq.c())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (anpq.d())
      {
        anmq.a(10, 100, 0, new Object[] { "so is complete" });
        anmq.a(10, 300);
      }
      anpq.a(true);
      anpq.a(0);
      anpq.b();
      anpq.c();
      if (anpq.d())
      {
        anmq.b(10);
        anmq.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      anpq.a(1);
      return;
    }
    finally
    {
      long l2;
      if (anpq.e())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      anpq.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */