package com.tencent.mobileqq.apollo.utils;

import anaw;
import andw;
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
      andw.b();
      if (andw.c())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        andw.b(1);
        return;
      }
      if (!andw.a(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        andw.b(0);
        return;
      }
      if (!andw.a(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        andw.b(1);
        return;
      }
      boolean bool1 = andw.d();
      boolean bool2 = andw.e();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (andw.f()) {
            anaw.a(10, 100, new Object[] { "sava is not exist" });
          }
          andw.b(1);
        }
        if (!bool2)
        {
          if (andw.f()) {
            anaw.a(10, 100, new Object[] { "jsc is not exist" });
          }
          andw.b(0);
        }
        return;
      }
      if (!andw.g())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (andw.f())
      {
        anaw.a(10, 100, 0, new Object[] { "so is complete" });
        anaw.a(10, 300);
      }
      if (!andw.h())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      andw.a(true);
      andw.a(0);
      andw.c();
      andw.d();
      if (andw.f())
      {
        anaw.b(10);
        anaw.a(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      andw.a(1);
      return;
    }
    finally
    {
      long l2;
      if (andw.i())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      andw.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */