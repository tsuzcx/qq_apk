package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.statistics.ReportController;

class VisitorsActivity$3
  implements Runnable
{
  VisitorsActivity$3(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    RedTouchItem localRedTouchItem = this.this$0.a.a(100601);
    if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.passThroughLevel > 0))
    {
      localRedTouchItem.passThroughLevel = 0;
      this.this$0.a.c();
      ReportController.b(this.this$0.app, "dc00898", "", "", "0X800760F", "0X800760F", 0, 0, "1", "", "", "");
      return;
    }
    ReportController.b(this.this$0.app, "dc00898", "", "", "0X800760F", "0X800760F", 0, 0, "2", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.3
 * JD-Core Version:    0.7.0.1
 */