package com.tencent.mobileqq.apollo.utils;

import aixo;
import ajam;
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
      ajam.b();
      if (ajam.c())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        ajam.b(1);
        return;
      }
      if (!ajam.a(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        ajam.b(0);
        return;
      }
      if (!ajam.a(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        ajam.b(0);
        return;
      }
      boolean bool1 = ajam.d();
      boolean bool2 = ajam.e();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (ajam.f()) {
            aixo.a(10, 100, new Object[] { "sava is not exist" });
          }
          ajam.b(1);
        }
        if (!bool2)
        {
          if (ajam.f()) {
            aixo.a(10, 100, new Object[] { "jsc is not exist" });
          }
          ajam.b(0);
        }
        return;
      }
      if (!ajam.g())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (ajam.f())
      {
        aixo.a(10, 100, 0, new Object[] { "so is complete" });
        aixo.a(10, 300);
      }
      if (!ajam.h())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      ajam.a(true);
      ajam.a(0);
      ajam.c();
      ajam.d();
      if (ajam.f())
      {
        aixo.b(10);
        aixo.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      ajam.a(1);
      return;
    }
    finally
    {
      long l2;
      if (ajam.i())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      ajam.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */