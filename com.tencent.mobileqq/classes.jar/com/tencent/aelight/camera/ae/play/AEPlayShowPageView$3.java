package com.tencent.aelight.camera.ae.play;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import com.tencent.aelight.camera.log.AEQLog;

class AEPlayShowPageView$3
  implements Runnable
{
  AEPlayShowPageView$3(AEPlayShowPageView paramAEPlayShowPageView, int paramInt) {}
  
  public void run()
  {
    AEQLog.a("AEPlayShowPart", "in........");
    if (AEPlayShowPageView.access$100(this.this$0) != null)
    {
      View localView = AEPlayShowPageView.access$100(this.this$0).findViewByPosition(this.val$pos);
      if (localView != null)
      {
        AEPlayShowPageView.access$200(this.this$0);
        localView.performClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPageView.3
 * JD-Core Version:    0.7.0.1
 */