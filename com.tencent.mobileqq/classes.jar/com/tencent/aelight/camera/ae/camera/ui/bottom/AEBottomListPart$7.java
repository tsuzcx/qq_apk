package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.app.Activity;
import java.util.List;

class AEBottomListPart$7
  implements Runnable
{
  AEBottomListPart$7(AEBottomListPart paramAEBottomListPart, List paramList) {}
  
  public void run()
  {
    if ((AEBottomListPart.h(this.this$0) != null) && (!AEBottomListPart.i(this.this$0).isFinishing()))
    {
      if (AEBottomListPart.j(this.this$0)) {
        this.this$0.b.setVisibility(0);
      }
      this.this$0.c.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */