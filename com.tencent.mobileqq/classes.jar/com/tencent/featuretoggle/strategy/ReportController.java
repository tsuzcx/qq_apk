package com.tencent.featuretoggle.strategy;

import android.os.SystemClock;
import com.tencent.featuretoggle.ToggleConfig;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.HeaderThreadUtil;
import com.tencent.featuretoggle.utils.LogUtils;
import java.security.SecureRandom;

public class ReportController
{
  private static volatile ReportController a;
  private SecureRandom b = new SecureRandom();
  
  public static ReportController a()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new ReportController();
          }
        }
        finally {}
      }
      ReportController localReportController = a;
      return localReportController;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        long l3 = this.b.nextInt(10000) - 5000;
        if (paramInt != 2001) {
          l2 = 0L;
        }
        switch (paramInt)
        {
        case 2009: 
          if (ToggleSetting.a() != null) {
            HeaderThreadUtil.a().a(1005, ToggleSetting.a().j());
          }
          break;
        case 2008: 
          HeaderThreadUtil.a().c(1004);
          HeaderThreadUtil.a().b(1004);
          break;
        case 2006: 
          long l4 = SystemClock.elapsedRealtime() - ToggleSetting.e();
          l1 = l2;
          if (l4 >= 0L)
          {
            l1 = l2;
            if (l4 < ToggleSetting.x()) {
              l1 = ToggleSetting.x() - l4 + l3;
            }
          }
          HeaderThreadUtil.a().c(1002);
          HeaderThreadUtil.a().a(1002, l1);
          LogUtils.e("Next time to push toggle event is :%d s", new Object[] { Long.valueOf(l1 / 1000L) });
          break;
        case 2005: 
          l1 = SystemClock.elapsedRealtime() - ToggleSetting.d();
          if ((l1 < 0L) || (l1 >= ToggleSetting.w())) {
            break label352;
          }
          l1 = l3 + (ToggleSetting.w() - l1);
          break label354;
          HeaderThreadUtil.a().c(1001);
          HeaderThreadUtil.a().a(1001, l2);
          LogUtils.b("Next time to obtain the toggle is :%d s", new Object[] { Long.valueOf(l2 / 1000L) });
          break;
        case 2004: 
          if (SystemClock.elapsedRealtime() - ToggleSetting.d() < 10000L) {
            break;
          }
        case 2007: 
          HeaderThreadUtil.a().b(1001);
          continue;
          HeaderThreadUtil.a().a(1001, 100L);
          HeaderThreadUtil.a().a(1002, 300L);
          HeaderThreadUtil.a().a(1003, 500L);
          return;
        }
      }
      finally {}
      continue;
      label352:
      long l1 = 0L;
      label354:
      long l2 = l1;
      if (l1 < 0L) {
        l2 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.strategy.ReportController
 * JD-Core Version:    0.7.0.1
 */