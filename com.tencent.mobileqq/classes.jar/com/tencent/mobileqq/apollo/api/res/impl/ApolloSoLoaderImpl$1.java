package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

final class ApolloSoLoaderImpl$1
  implements Runnable
{
  public void run()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (BaseApplicationImpl.sProcessId == 1)
        {
          bool = true;
          ApolloSoLoaderImpl.access$002(bool);
        }
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if (localAppRuntime == null) {
            break label484;
          }
          bool = ((IApolloManagerService)localAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).isApolloFuncOpen(BaseApplicationImpl.getContext());
          if ((!ApolloSoLoaderImpl.access$000()) || (!bool)) {
            break label490;
          }
          bool = true;
          ApolloSoLoaderImpl.access$102(bool);
          if ((ApolloSoLoaderImpl.access$100()) && (ApolloSoLoaderImpl.sIsBeginTrace))
          {
            TraceReportUtil.a(10);
            TraceReportUtil.a(10, 100);
            ApolloSoLoaderImpl.sIsBeginTrace = false;
          }
          if (ApolloSoLoaderImpl.access$200()) {
            continue;
          }
          QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
          return;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("ApolloSoLoader", 1, "[loadSo] error!", localThrowable1);
        }
        bool = false;
        continue;
        if (!ApolloSoLoaderImpl.access$300())
        {
          QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
          return;
        }
        if (ApolloSoLoaderImpl.access$100())
        {
          TraceReportUtil.a(10, 100, 0, new Object[] { "so is complete" });
          TraceReportUtil.a(10, 300);
        }
        ApolloSoLoaderImpl.access$402(true);
        ApolloSoLoaderImpl.notifyResult(0);
        ApolloSoLoaderImpl.access$500();
        ApolloSoLoaderImpl.access$600();
        if (ApolloSoLoaderImpl.access$100())
        {
          TraceReportUtil.b(10);
          TraceReportUtil.a(10, false);
        }
        QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
        return;
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable2);
        ApolloSoLoaderImpl.notifyResult(1);
        return;
      }
      finally
      {
        long l2;
        if (ApolloSoLoaderImpl.access$400())
        {
          l2 = System.currentTimeMillis();
          QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
        }
        ApolloSoLoaderImpl.access$700().set(false);
      }
      label484:
      boolean bool = false;
      continue;
      label490:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl.1
 * JD-Core Version:    0.7.0.1
 */