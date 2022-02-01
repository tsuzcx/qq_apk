package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;
import ptu;

class ReadInJoyListViewGroup$49
  implements Runnable
{
  ReadInJoyListViewGroup$49(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (ptu.a(this.this$0.a()))
    {
      this.this$0.a(true);
      QLog.i("ReadInJoyListViewGroup", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + this.this$0.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.49
 * JD-Core Version:    0.7.0.1
 */