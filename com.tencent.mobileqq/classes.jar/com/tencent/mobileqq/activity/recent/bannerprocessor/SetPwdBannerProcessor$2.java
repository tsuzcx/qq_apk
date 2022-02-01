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
    boolean bool3 = BannerManager.a().d(SetPwdBannerProcessor.a);
    boolean bool4 = PwdSetUtil.a((QQAppInterface)SetPwdBannerProcessor.e(this.this$0).getAppRuntime());
    boolean bool2 = true;
    boolean bool1;
    if ((bool4) && (!bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool4) || (!bool3)) {
      bool2 = false;
    }
    ThreadManager.getUIHandler().post(new SetPwdBannerProcessor.2.1(this, bool1, bool2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */