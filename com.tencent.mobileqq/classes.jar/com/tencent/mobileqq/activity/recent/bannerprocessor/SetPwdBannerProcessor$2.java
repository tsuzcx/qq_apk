package com.tencent.mobileqq.activity.recent.bannerprocessor;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.login.PwdSetUtil;
import mqq.os.MqqHandler;

class SetPwdBannerProcessor$2
  implements Runnable
{
  SetPwdBannerProcessor$2(SetPwdBannerProcessor paramSetPwdBannerProcessor) {}
  
  public void run()
  {
    boolean bool2 = BannerManager.a().b(20);
    boolean bool3 = PwdSetUtil.a((QQAppInterface)SetPwdBannerProcessor.d(this.this$0).getAppRuntime());
    boolean bool1;
    if ((bool3) && (!bool2))
    {
      bool1 = true;
      if ((bool3) || (!bool2)) {
        break label69;
      }
    }
    label69:
    for (bool2 = true;; bool2 = false)
    {
      ThreadManager.getUIHandler().post(new SetPwdBannerProcessor.2.1(this, bool1, bool2));
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */