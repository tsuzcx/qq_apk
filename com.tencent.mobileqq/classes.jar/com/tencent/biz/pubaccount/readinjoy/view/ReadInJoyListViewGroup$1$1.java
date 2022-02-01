package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo;

class ReadInJoyListViewGroup$1$1
  implements Runnable
{
  ReadInJoyListViewGroup$1$1(ReadInJoyListViewGroup.1 param1) {}
  
  public void run()
  {
    if (((this.a.this$0.a() == 0) || (DailyModeConfigHandler.c(this.a.this$0.a()))) && (!this.a.a)) {
      ReadinjoySPEventReport.a().a.a(8, this.a.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.1.1
 * JD-Core Version:    0.7.0.1
 */