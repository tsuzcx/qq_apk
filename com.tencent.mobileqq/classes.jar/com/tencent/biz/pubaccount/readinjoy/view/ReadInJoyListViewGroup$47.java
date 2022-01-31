package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;
import pcz;

class ReadInJoyListViewGroup$47
  implements Runnable
{
  ReadInJoyListViewGroup$47(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (pcz.a(this.this$0.a()))
    {
      this.this$0.a(true);
      QLog.i("ReadInJoyListViewGroup", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + this.this$0.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.47
 * JD-Core Version:    0.7.0.1
 */