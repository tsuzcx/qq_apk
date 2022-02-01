package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.widget.QQToast;

class DiscussionInfoCardActivity$15
  extends TroopMngObserver
{
  DiscussionInfoCardActivity$15(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    this.a.e();
    if (paramBoolean)
    {
      if (paramBoolean1.booleanValue()) {
        DiscussionInfoCardActivity.u(this.a);
      }
    }
    else {
      QQToast.makeText(this.a, paramInt, 0).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.15
 * JD-Core Version:    0.7.0.1
 */