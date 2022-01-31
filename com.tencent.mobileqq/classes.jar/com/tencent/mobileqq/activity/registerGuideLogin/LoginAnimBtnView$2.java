package com.tencent.mobileqq.activity.registerGuideLogin;

import aher;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class LoginAnimBtnView$2
  implements Runnable
{
  LoginAnimBtnView$2(LoginAnimBtnView paramLoginAnimBtnView) {}
  
  public void run()
  {
    if (LoginAnimBtnView.a(this.this$0))
    {
      QLog.e("LoginAnimBtnView", 1, "loadLottieAnimation isDestroyed");
      return;
    }
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.this$0.getContext(), "login_btn_lottie_anim.json", new aher(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      LoginAnimBtnView.a(this.this$0, null);
      QLog.e("LoginAnimBtnView", 1, "loadVoiceAnimation fail.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.2
 * JD-Core Version:    0.7.0.1
 */