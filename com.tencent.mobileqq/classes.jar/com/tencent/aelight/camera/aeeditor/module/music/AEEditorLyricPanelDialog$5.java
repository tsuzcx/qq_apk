package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AEEditorLyricPanelDialog$5
  implements DialogInterface.OnDismissListener
{
  AEEditorLyricPanelDialog$5(AEEditorLyricPanelDialog paramAEEditorLyricPanelDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (AEEditorLyricPanelDialog.e(this.a) != null) {
      AEEditorLyricPanelDialog.e(this.a).onLyricPanelHide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.5
 * JD-Core Version:    0.7.0.1
 */