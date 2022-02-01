package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qcircle.tavcut.exporter.ImageExporter;
import java.util.ArrayList;

class AEEditorImageEditFragment$25$1
  implements DialogInterface.OnDismissListener
{
  AEEditorImageEditFragment$25$1(AEEditorImageEditFragment.25 param25) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AEEditorImageEditFragment.z(this.a.this$0).cancel();
    if (AEEditorImageEditFragment.e(this.a.this$0) + 1 < AEEditorImageEditFragment.r(this.a.this$0).size()) {
      AEEditorImageEditFragment.b(this.a.this$0, AEEditorImageEditFragment.e(this.a.this$0) + 1);
    }
    if ((AEEditorImageEditFragment.e(this.a.this$0) - 1 >= 0) && (AEEditorImageEditFragment.e(this.a.this$0) - 1 < AEEditorImageEditFragment.r(this.a.this$0).size())) {
      AEEditorImageEditFragment.b(this.a.this$0, AEEditorImageEditFragment.e(this.a.this$0) - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.25.1
 * JD-Core Version:    0.7.0.1
 */