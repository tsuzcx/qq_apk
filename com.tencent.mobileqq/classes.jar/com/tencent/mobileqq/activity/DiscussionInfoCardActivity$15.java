package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;

class DiscussionInfoCardActivity$15
  extends BizTroopObserver
{
  DiscussionInfoCardActivity$15(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onTransferDiscussionToGroup(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    this.a.e();
    if (paramBoolean)
    {
      if (paramBoolean1.booleanValue()) {
        DiscussionInfoCardActivity.e(this.a);
      }
      return;
    }
    QQToast.a(this.a, paramInt, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.15
 * JD-Core Version:    0.7.0.1
 */