package com.tencent.av.ui;

import java.util.TimerTask;
import miu;
import miv;

public class ScreenRecordHelper$1
  extends TimerTask
{
  public ScreenRecordHelper$1(miu parammiu) {}
  
  public void run()
  {
    if (miu.a(this.this$0) != null)
    {
      miu.a(this.this$0, miu.a(this.this$0) + 1000L);
      miu.a(this.this$0).a(miu.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper.1
 * JD-Core Version:    0.7.0.1
 */