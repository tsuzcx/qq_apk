package com.tencent.featuretoggle.strategy;

import android.app.Activity;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.HeaderThreadUtil;
import com.tencent.featuretoggle.utils.LogUtils;

public class TogglePageStrategy
{
  private static volatile TogglePageStrategy a;
  
  public static TogglePageStrategy a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TogglePageStrategy();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && ((paramActivity.getChangingConfigurations() & 0x80) == 128)) {
      return;
    }
    if ((ToggleSetting.A() == 2) && (ToggleSetting.B())) {
      ReportController.a().a(2007);
    }
    ToggleSetting.a(0);
    HeaderThreadUtil.a().c(2);
    paramActivity = new StringBuilder();
    paramActivity.append("[Strategy] onResume ");
    paramActivity.append(paramString);
    LogUtils.e(paramActivity.toString(), new Object[0]);
  }
  
  public void b(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && ((paramActivity.getChangingConfigurations() & 0x80) == 128)) {
      return;
    }
    ToggleSetting.a(1);
    HeaderThreadUtil.a().c(2);
    paramActivity = HeaderThreadUtil.a().a(2, new Object());
    HeaderThreadUtil.a().a(paramActivity, 1000L);
    paramActivity = HeaderThreadUtil.a().a(2, null);
    HeaderThreadUtil.a().a(paramActivity, ToggleSetting.v());
    paramActivity = new StringBuilder();
    paramActivity.append("[Strategy] onPause ");
    paramActivity.append(paramString);
    LogUtils.e(paramActivity.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.strategy.TogglePageStrategy
 * JD-Core Version:    0.7.0.1
 */