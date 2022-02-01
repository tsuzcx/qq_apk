package com.tencent.av.ui;

import java.util.TimerTask;
import mjw;
import mjx;

public class ScreenRecordHelper$1
  extends TimerTask
{
  public ScreenRecordHelper$1(mjw parammjw) {}
  
  public void run()
  {
    if (mjw.a(this.this$0) != null)
    {
      mjw.a(this.this$0, mjw.a(this.this$0) + 1000L);
      mjw.a(this.this$0).a(mjw.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper.1
 * JD-Core Version:    0.7.0.1
 */