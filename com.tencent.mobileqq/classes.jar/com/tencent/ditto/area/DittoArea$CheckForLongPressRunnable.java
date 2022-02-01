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
      DittoArea localDittoArea = this.this$0;
      localDittoArea.isPressed = false;
      DittoArea.access$000(localDittoArea, this.ev);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.area.DittoArea.CheckForLongPressRunnable
 * JD-Core Version:    0.7.0.1
 */