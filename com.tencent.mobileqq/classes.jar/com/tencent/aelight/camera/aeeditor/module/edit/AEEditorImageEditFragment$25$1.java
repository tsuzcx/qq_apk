package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.tavcut.exporter.ImageExporter;
import java.util.ArrayList;

class AEEditorImageEditFragment$25$1
  implements DialogInterface.OnDismissListener
{
  AEEditorImageEditFragment$25$1(AEEditorImageEditFragment.25 param25) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AEEditorImageEditFragment.a(this.a.this$0).cancel();
    if (AEEditorImageEditFragment.a(this.a.this$0) + 1 < AEEditorImageEditFragment.a(this.a.this$0).size()) {
      AEEditorImageEditFragment.b(this.a.this$0, AEEditorImageEditFragment.a(this.a.this$0) + 1);
    }
    if ((AEEditorImageEditFragment.a(this.a.this$0) - 1 >= 0) && (AEEditorImageEditFragment.a(this.a.this$0) - 1 < AEEditorImageEditFragment.a(this.a.this$0).size())) {
      AEEditorImageEditFragment.b(this.a.this$0, AEEditorImageEditFragment.a(this.a.this$0) - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.25.1
 * JD-Core Version:    0.7.0.1
 */