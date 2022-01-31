package com.tencent.mobileqq.apollo.utils;

import alhp;
import alko;
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
      alko.b();
      if (alko.c())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        alko.b(1);
        return;
      }
      if (!alko.a(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        alko.b(0);
        return;
      }
      if (!alko.a(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        alko.b(1);
        return;
      }
      boolean bool1 = alko.d();
      boolean bool2 = alko.e();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (alko.f()) {
            alhp.a(10, 100, new Object[] { "sava is not exist" });
          }
          alko.b(1);
        }
        if (!bool2)
        {
          if (alko.f()) {
            alhp.a(10, 100, new Object[] { "jsc is not exist" });
          }
          alko.b(0);
        }
        return;
      }
      if (!alko.g())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (alko.f())
      {
        alhp.a(10, 100, 0, new Object[] { "so is complete" });
        alhp.a(10, 300);
      }
      if (!alko.h())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      alko.a(true);
      alko.a(0);
      alko.c();
      alko.d();
      if (alko.f())
      {
        alhp.b(10);
        alhp.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      alko.a(1);
      return;
    }
    finally
    {
      long l2;
      if (alko.i())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      alko.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */