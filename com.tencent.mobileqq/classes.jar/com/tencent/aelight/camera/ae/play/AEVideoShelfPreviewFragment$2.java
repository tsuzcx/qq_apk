package com.tencent.aelight.camera.ae.play;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.io.File;

class AEVideoShelfPreviewFragment$2
  implements DialogInterface.OnCancelListener
{
  AEVideoShelfPreviewFragment$2(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfPreviewFragment.access$100(this.this$0).cancelSave();
    paramDialogInterface = new File(AEVideoShelfPreviewFragment.access$100(this.this$0).getOutputVideoPath());
    if (paramDialogInterface.exists())
    {
      TTPTLogger.i(AEVideoShelfPreviewFragment.access$200(), "delete temp silent video");
      paramDialogInterface.delete();
    }
    AEVideoShelfPreviewFragment.access$302(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */