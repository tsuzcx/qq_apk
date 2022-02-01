package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AECMShowRequestController$1
  implements Runnable
{
  AECMShowRequestController$1(AECMShowRequestController paramAECMShowRequestController) {}
  
  public void run()
  {
    if (AECMShowRequestController.a(this.this$0) + 2 > 99)
    {
      AECMShowRequestController.a(this.this$0, 99);
      if (AECMShowRequestController.b(this.this$0) != null) {
        AECMShowRequestController.b(this.this$0).d(AECMShowRequestController.a(this.this$0));
      }
      ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.c(this.this$0));
      return;
    }
    AECMShowRequestController localAECMShowRequestController = this.this$0;
    AECMShowRequestController.a(localAECMShowRequestController, AECMShowRequestController.a(localAECMShowRequestController) + 2);
    if (AECMShowRequestController.b(this.this$0) != null) {
      AECMShowRequestController.b(this.this$0).d(AECMShowRequestController.a(this.this$0));
    }
    ThreadManager.getUIHandler().postDelayed(AECMShowRequestController.c(this.this$0), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.1
 * JD-Core Version:    0.7.0.1
 */