package com.tencent.av.ui;

import java.util.TimerTask;
import mls;
import mlt;

public class ScreenRecordHelper$1
  extends TimerTask
{
  public ScreenRecordHelper$1(mls parammls) {}
  
  public void run()
  {
    if (mls.a(this.this$0) != null)
    {
      mls.a(this.this$0, mls.a(this.this$0) + 1000L);
      mls.a(this.this$0).a(mls.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper.1
 * JD-Core Version:    0.7.0.1
 */