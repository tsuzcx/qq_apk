package com.tencent.aelight.camera.ae.play;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;

class AEVideoShelfEditFragment$2
  implements DialogInterface.OnCancelListener
{
  AEVideoShelfEditFragment$2(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfEditFragment.access$400(this.this$0).cancelSave();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.2
 * JD-Core Version:    0.7.0.1
 */