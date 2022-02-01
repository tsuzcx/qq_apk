package com.tencent.mobileqq.apollo.utils;

import anis;
import anmb;
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
      if (!anmb.b())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      if (!anmb.c())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (anmb.d())
      {
        anis.a(10, 100, 0, new Object[] { "so is complete" });
        anis.a(10, 300);
      }
      anmb.a(true);
      anmb.a(0);
      anmb.b();
      anmb.c();
      if (anmb.d())
      {
        anis.b(10);
        anis.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      anmb.a(1);
      return;
    }
    finally
    {
      long l2;
      if (anmb.e())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      anmb.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */