package com.tencent.biz.pubaccount.subscript;

import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

class SubscriptFeedsActivity$1
  implements XListView.DrawFinishedListener
{
  SubscriptFeedsActivity$1(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void drawFinished()
  {
    if ((!this.a.c) && (this.a.d))
    {
      this.a.c = true;
      PublicTracker.a("SUBSCRIPT_FEEDS_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.1
 * JD-Core Version:    0.7.0.1
 */