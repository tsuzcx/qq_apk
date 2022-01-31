package com.tencent.mobileqq.apollo.utils;

import alda;
import alfz;
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
      alfz.b();
      if (alfz.c())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        alfz.b(1);
        return;
      }
      if (!alfz.a(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        alfz.b(0);
        return;
      }
      if (!alfz.a(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        alfz.b(1);
        return;
      }
      boolean bool1 = alfz.d();
      boolean bool2 = alfz.e();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (alfz.f()) {
            alda.a(10, 100, new Object[] { "sava is not exist" });
          }
          alfz.b(1);
        }
        if (!bool2)
        {
          if (alfz.f()) {
            alda.a(10, 100, new Object[] { "jsc is not exist" });
          }
          alfz.b(0);
        }
        return;
      }
      if (!alfz.g())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (alfz.f())
      {
        alda.a(10, 100, 0, new Object[] { "so is complete" });
        alda.a(10, 300);
      }
      if (!alfz.h())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      alfz.a(true);
      alfz.a(0);
      alfz.c();
      alfz.d();
      if (alfz.f())
      {
        alda.b(10);
        alda.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      alfz.a(1);
      return;
    }
    finally
    {
      long l2;
      if (alfz.i())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      alfz.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */