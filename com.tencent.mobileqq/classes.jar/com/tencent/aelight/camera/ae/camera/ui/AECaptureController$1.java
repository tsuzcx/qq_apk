package com.tencent.aelight.camera.ae.camera.ui;

import android.view.View;
import android.view.ViewGroup;

class AECaptureController$1
  implements Runnable
{
  AECaptureController$1(AECaptureController paramAECaptureController, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    if ((AECaptureController.a(this.this$0) == null) && (AECaptureController.a(this.this$0) != null))
    {
      localObject = this.this$0;
      AECaptureController.a((AECaptureController)localObject, AECaptureController.a((AECaptureController)localObject).findViewById(2064122738));
    }
    if (AECaptureController.a(this.this$0) != null)
    {
      localObject = AECaptureController.a(this.this$0);
      int i;
      if (this.a) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.AECaptureController.1
 * JD-Core Version:    0.7.0.1
 */