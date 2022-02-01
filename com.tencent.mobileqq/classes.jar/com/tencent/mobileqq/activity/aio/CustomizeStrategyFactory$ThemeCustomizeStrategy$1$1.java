package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeCustomizeStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$ThemeCustomizeStrategy$1$1(CustomizeStrategyFactory.ThemeCustomizeStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      this.a.a.background = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy info.background=" + this.a.a.background);
      }
      CustomizeStrategyFactory.a().a(this.a.a);
      return;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeCustomizeStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */