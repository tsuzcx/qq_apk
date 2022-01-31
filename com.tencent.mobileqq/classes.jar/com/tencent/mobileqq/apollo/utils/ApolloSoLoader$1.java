package com.tencent.mobileqq.apollo.utils;

import ajlq;
import ajoo;
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
      ajoo.b();
      if (ajoo.c())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        ajoo.b(1);
        return;
      }
      if (!ajoo.a(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        ajoo.b(0);
        return;
      }
      if (!ajoo.a(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        ajoo.b(1);
        return;
      }
      boolean bool1 = ajoo.d();
      boolean bool2 = ajoo.e();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (ajoo.f()) {
            ajlq.a(10, 100, new Object[] { "sava is not exist" });
          }
          ajoo.b(1);
        }
        if (!bool2)
        {
          if (ajoo.f()) {
            ajlq.a(10, 100, new Object[] { "jsc is not exist" });
          }
          ajoo.b(0);
        }
        return;
      }
      if (!ajoo.g())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (ajoo.f())
      {
        ajlq.a(10, 100, 0, new Object[] { "so is complete" });
        ajlq.a(10, 300);
      }
      if (!ajoo.h())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      ajoo.a(true);
      ajoo.a(0);
      ajoo.c();
      ajoo.d();
      if (ajoo.f())
      {
        ajlq.b(10);
        ajlq.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      ajoo.a(1);
      return;
    }
    finally
    {
      long l2;
      if (ajoo.i())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      ajoo.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */