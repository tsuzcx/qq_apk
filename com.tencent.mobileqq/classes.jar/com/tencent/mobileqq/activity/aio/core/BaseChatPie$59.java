package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$59
  extends ShortVideoObserver
{
  BaseChatPie$59(BaseChatPie paramBaseChatPie) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (((this.a.a() instanceof SplashActivity)) && (SplashActivity.currentFragment != 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "VideoRedbag, onCheckRealNameRsp in aio");
      }
    } while ((!paramBoolean) || (paramInt != RedBagVideoManager.a));
    DialogUtil.a(this.a.a(), 0, null, this.a.a().getString(2131719382), 2131719384, 2131719383, new BaseChatPie.59.1(this), new BaseChatPie.59.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.59
 * JD-Core Version:    0.7.0.1
 */