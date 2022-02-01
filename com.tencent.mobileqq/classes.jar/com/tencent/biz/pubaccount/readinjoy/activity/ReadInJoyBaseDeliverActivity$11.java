package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ActionSheet.OnDismissListener;
import mqq.os.MqqHandler;

class ReadInJoyBaseDeliverActivity$11
  implements ActionSheet.OnDismissListener
{
  ReadInJoyBaseDeliverActivity$11(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onDismiss()
  {
    if ((!this.a.a) && (this.a.j != -1)) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyBaseDeliverActivity.11.1(this), 300L);
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.11
 * JD-Core Version:    0.7.0.1
 */