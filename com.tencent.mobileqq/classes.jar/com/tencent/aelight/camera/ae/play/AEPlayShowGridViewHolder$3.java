package com.tencent.aelight.camera.ae.play;

import android.widget.ProgressBar;

class AEPlayShowGridViewHolder$3
  implements Runnable
{
  AEPlayShowGridViewHolder$3(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, int paramInt) {}
  
  public void run()
  {
    if (AEPlayShowGridViewHolder.access$200(this.this$0).getVisibility() != 0) {
      AEPlayShowGridViewHolder.access$200(this.this$0).setVisibility(0);
    }
    AEPlayShowGridViewHolder.access$200(this.this$0).setProgress(this.val$progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.3
 * JD-Core Version:    0.7.0.1
 */