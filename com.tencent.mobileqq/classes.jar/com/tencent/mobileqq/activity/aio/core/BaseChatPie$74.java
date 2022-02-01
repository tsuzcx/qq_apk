package com.tencent.mobileqq.activity.aio.core;

import aodo;
import bdcw;
import bhdj;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$74
  extends aodo
{
  BaseChatPie$74(BaseChatPie paramBaseChatPie) {}
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt)
  {
    if (((this.this$0.getActivity() instanceof SplashActivity)) && (SplashActivity.a != 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.tag, 2, "VideoRedbag, onCheckRealNameRsp in aio");
      }
    } while ((!paramBoolean) || (paramInt != bdcw.a));
    bhdj.a(this.this$0.getActivity(), 0, null, this.this$0.getActivity().getString(2131718857), 2131718859, 2131718858, new BaseChatPie.74.1(this), new BaseChatPie.74.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.74
 * JD-Core Version:    0.7.0.1
 */