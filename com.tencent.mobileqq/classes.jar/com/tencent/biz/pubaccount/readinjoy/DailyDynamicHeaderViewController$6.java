package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$6
  extends ReadInJoyObserver
{
  DailyDynamicHeaderViewController$6(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((DailyDynamicHeaderViewController.a(this.a) == -1) || (DailyDynamicHeaderViewController.a(this.a) == 0))
      {
        DailyDynamicHeaderViewController.a(this.a, 0);
        return;
      }
      DailyDynamicHeaderViewController.a(this.a, 4);
      return;
    }
    DailyDynamicHeaderViewController.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.6
 * JD-Core Version:    0.7.0.1
 */