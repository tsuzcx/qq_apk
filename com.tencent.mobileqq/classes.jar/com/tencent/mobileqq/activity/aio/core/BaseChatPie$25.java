package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$25
  extends CardObserver
{
  BaseChatPie$25(BaseChatPie paramBaseChatPie) {}
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" baechatpie onGetCalReactiveDays isAllow= ");
        localStringBuilder.append(paramBoolean2);
        QLog.d("interactive", 2, localStringBuilder.toString());
      }
      this.a.bc();
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    ((AIOJubaoDialogHelper)this.a.q(70)).a();
    if (paramBoolean)
    {
      this.a.f.showDialog(232);
      return;
    }
    this.a.f.showDialog(233);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.a.bc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.25
 * JD-Core Version:    0.7.0.1
 */