package com.tencent.mobileqq.activity.aio.core;

import agfq;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$71
  extends CardObserver
{
  BaseChatPie$71(BaseChatPie paramBaseChatPie) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.access$3500(this.this$0, paramBoolean, paramObject);
  }
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.this$0.refreshTitleReativeIcon();
    }
  }
  
  public void onImpeach(boolean paramBoolean, String paramString)
  {
    ((agfq)this.this$0.getHelper(70)).a();
    if (paramBoolean)
    {
      this.this$0.mActivity.showDialog(232);
      return;
    }
    this.this$0.mActivity.showDialog(233);
  }
  
  public void onSetCalReactiveDays(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.this$0.refreshTitleReativeIcon();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.71
 * JD-Core Version:    0.7.0.1
 */