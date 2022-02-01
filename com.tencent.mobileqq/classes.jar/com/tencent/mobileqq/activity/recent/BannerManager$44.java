package com.tencent.mobileqq.activity.recent;

import aljw;
import aqzw;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.os.MqqHandler;

public class BannerManager$44
  implements Runnable
{
  public BannerManager$44(aljw paramaljw) {}
  
  public void run()
  {
    try
    {
      Object localObject = aljw.a(this.this$0).app;
      aqzw localaqzw = ((QQAppInterface)localObject).a(((QQAppInterface)localObject).getCurrentAccountUin(), true);
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "initConfig config: %s", new Object[] { localaqzw }));
      }
      if (localaqzw != null)
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(1010);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.44
 * JD-Core Version:    0.7.0.1
 */