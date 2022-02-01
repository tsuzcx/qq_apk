package com.tencent.mobileqq.activity.aio.core;

import anaz;
import bbwb;
import bfur;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$75
  extends anaz
{
  BaseChatPie$75(BaseChatPie paramBaseChatPie) {}
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt)
  {
    if (((this.this$0.getActivity() instanceof SplashActivity)) && (SplashActivity.a != 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.tag, 2, "VideoRedbag, onCheckRealNameRsp in aio");
      }
    } while ((!paramBoolean) || (paramInt != bbwb.a));
    bfur.a(this.this$0.getActivity(), 0, null, this.this$0.getActivity().getString(2131718471), 2131718473, 2131718472, new BaseChatPie.75.1(this), new BaseChatPie.75.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.75
 * JD-Core Version:    0.7.0.1
 */