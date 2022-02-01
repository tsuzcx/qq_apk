package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$56
  extends CardObserver
{
  BaseChatPie$56(BaseChatPie paramBaseChatPie) {}
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.aL();
    }
  }
  
  public void onImpeach(boolean paramBoolean, String paramString)
  {
    ((AIOJubaoDialogHelper)this.a.a(70)).a();
    if (paramBoolean)
    {
      this.a.a.showDialog(232);
      return;
    }
    this.a.a.showDialog(233);
  }
  
  public void onSetCalReactiveDays(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.a.aL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.56
 * JD-Core Version:    0.7.0.1
 */