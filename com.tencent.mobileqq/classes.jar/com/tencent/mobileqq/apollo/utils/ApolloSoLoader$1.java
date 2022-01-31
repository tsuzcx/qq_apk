package com.tencent.mobileqq.apollo.utils;

import ajlo;
import ajom;
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
      ajom.b();
      if (ajom.c())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        ajom.b(1);
        return;
      }
      if (!ajom.a(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        ajom.b(0);
        return;
      }
      if (!ajom.a(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        ajom.b(1);
        return;
      }
      boolean bool1 = ajom.d();
      boolean bool2 = ajom.e();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (ajom.f()) {
            ajlo.a(10, 100, new Object[] { "sava is not exist" });
          }
          ajom.b(1);
        }
        if (!bool2)
        {
          if (ajom.f()) {
            ajlo.a(10, 100, new Object[] { "jsc is not exist" });
          }
          ajom.b(0);
        }
        return;
      }
      if (!ajom.g())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (ajom.f())
      {
        ajlo.a(10, 100, 0, new Object[] { "so is complete" });
        ajlo.a(10, 300);
      }
      if (!ajom.h())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      ajom.a(true);
      ajom.a(0);
      ajom.c();
      ajom.d();
      if (ajom.f())
      {
        ajlo.b(10);
        ajlo.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      ajom.a(1);
      return;
    }
    finally
    {
      long l2;
      if (ajom.i())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      ajom.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */