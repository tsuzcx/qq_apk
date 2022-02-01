package com.tencent.aelight.camera.ae.play;

import android.widget.RelativeLayout;

class AEVideoShelfEditFragment$OffscreenCaptureRunnable
  implements Runnable
{
  private AEVideoShelfEditFragment$OffscreenCaptureRunnable(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void run()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.this$0.getBaseActivity());
    AEVideoShelfEditFragment.access$3500(localRelativeLayout, AEVideoShelfEditFragment.access$000(this.this$0).getLeft(), AEVideoShelfEditFragment.access$000(this.this$0).getTop(), AEVideoShelfEditFragment.access$200(this.this$0), AEVideoShelfEditFragment.access$300(this.this$0));
    int i = 0;
    while (i < AEVideoShelfEditFragment.access$1000(this.this$0).getItemCount())
    {
      if (i == 0)
      {
        AEVideoShelfEditFragment.access$3400(this.this$0, i);
      }
      else
      {
        AEVideoShelfEditFragment.access$3600(this.this$0, localRelativeLayout, i);
        AEVideoShelfEditFragment.access$3700(this.this$0, localRelativeLayout, i);
      }
      i += 1;
    }
    localRelativeLayout.removeAllViews();
    if (AEVideoShelfEditFragment.access$1000(this.this$0) != null) {
      AEVideoShelfEditFragment.access$1000(this.this$0).setOnVideoNodeClickedListener(AEVideoShelfEditFragment.access$3800(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.OffscreenCaptureRunnable
 * JD-Core Version:    0.7.0.1
 */