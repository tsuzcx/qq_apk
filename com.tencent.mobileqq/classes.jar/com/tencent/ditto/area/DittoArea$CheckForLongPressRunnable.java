package com.tencent.ditto.area;

import android.view.MotionEvent;

final class DittoArea$CheckForLongPressRunnable
  implements Runnable
{
  public MotionEvent ev;
  
  private DittoArea$CheckForLongPressRunnable(DittoArea paramDittoArea) {}
  
  public void run()
  {
    if (this.this$0.isPressed)
    {
      this.this$0.isPressed = false;
      DittoArea.access$000(this.this$0, this.ev);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.area.DittoArea.CheckForLongPressRunnable
 * JD-Core Version:    0.7.0.1
 */