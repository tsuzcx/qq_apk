package com.tencent.mobileqq.activity.aio;

import afsa;
import afsb;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$ThemeCustomizeStrategy$1
  implements Runnable
{
  public CustomizeStrategyFactory$ThemeCustomizeStrategy$1(afsa paramafsa, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy");
      }
      if ((afsa.a(this.this$0) == null) || (TextUtils.isEmpty(this.a.templateId)))
      {
        CustomizeStrategyFactory.a().a(this.a);
        return;
      }
      String str = this.a.templateId + ".png";
      afsa.a(this.this$0).b(str, new afsb(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeCustomizeStrategy.1
 * JD-Core Version:    0.7.0.1
 */