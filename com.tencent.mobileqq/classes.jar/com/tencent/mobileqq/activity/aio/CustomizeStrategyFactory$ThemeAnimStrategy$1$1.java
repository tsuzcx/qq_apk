package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeAnimStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$ThemeAnimStrategy$1$1(CustomizeStrategyFactory.ThemeAnimStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      this.a.a.animInfo = AnimationView.AnimationInfo.loadFromFolder(paramPathResult);
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_AIO_REDPACKET background=" + this.a.a.background + ",animInfo=" + this.a.a.animInfo);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeAnimStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */