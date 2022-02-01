package com.tencent.aelight.camera.ae.play;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AETakeFacePhotoPreviewFragment$3
  implements DialogInterface.OnDismissListener
{
  AETakeFacePhotoPreviewFragment$3(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AETakeFacePhotoPreviewFragment.access$300(this.this$0);
    AEVideoShelfEditFragment.keepScreenOn(this.this$0.getBaseActivity(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */