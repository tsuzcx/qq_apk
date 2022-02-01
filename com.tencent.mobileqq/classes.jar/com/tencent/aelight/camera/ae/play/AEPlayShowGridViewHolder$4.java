package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.widget.ProgressBar;
import com.tencent.mobileqq.widget.QQToast;

class AEPlayShowGridViewHolder$4
  implements Runnable
{
  AEPlayShowGridViewHolder$4(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, boolean paramBoolean) {}
  
  public void run()
  {
    AEPlayShowGridViewHolder.access$200(this.this$0).setVisibility(8);
    if (!this.val$isSuccess) {
      QQToast.makeText(AEPlayShowGridViewHolder.access$300(), AEPlayShowGridViewHolder.access$300().getString(2131915235), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.4
 * JD-Core Version:    0.7.0.1
 */