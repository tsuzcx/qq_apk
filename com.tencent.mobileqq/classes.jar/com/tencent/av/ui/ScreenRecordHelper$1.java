package com.tencent.av.ui;

import java.util.TimerTask;

class ScreenRecordHelper$1
  extends TimerTask
{
  ScreenRecordHelper$1(ScreenRecordHelper paramScreenRecordHelper) {}
  
  public void run()
  {
    if (ScreenRecordHelper.a(this.this$0) != null)
    {
      ScreenRecordHelper localScreenRecordHelper = this.this$0;
      ScreenRecordHelper.a(localScreenRecordHelper, ScreenRecordHelper.a(localScreenRecordHelper) + 1000L);
      ScreenRecordHelper.a(this.this$0).a(ScreenRecordHelper.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper.1
 * JD-Core Version:    0.7.0.1
 */