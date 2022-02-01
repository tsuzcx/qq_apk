package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeCustomizeStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$ThemeCustomizeStrategy$1(CustomizeStrategyFactory.ThemeCustomizeStrategy paramThemeCustomizeStrategy, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy");
      }
      if ((CustomizeStrategyFactory.ThemeCustomizeStrategy.a(this.this$0) == null) || (TextUtils.isEmpty(this.a.templateId)))
      {
        CustomizeStrategyFactory.a().a(this.a);
        return;
      }
      String str = this.a.templateId + ".png";
      CustomizeStrategyFactory.ThemeCustomizeStrategy.a(this.this$0).getFilePath(str, new CustomizeStrategyFactory.ThemeCustomizeStrategy.1.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeCustomizeStrategy.1
 * JD-Core Version:    0.7.0.1
 */