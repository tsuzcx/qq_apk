package com.tencent.mobileqq.activity.recent.bannerprocessor;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.os.MqqHandler;

class PushBannerProcessor$2
  implements Runnable
{
  PushBannerProcessor$2(PushBannerProcessor paramPushBannerProcessor) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)PushBannerProcessor.f(this.this$0).getAppRuntime();
      localObject = ((QQAppInterface)localObject).getConfig(((QQAppInterface)localObject).getCurrentAccountUin(), true);
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "initConfig config: %s", new Object[] { localObject }));
      }
      if (localObject != null)
      {
        PushBannerProcessor.g(this.this$0).sendEmptyMessage(2000);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */