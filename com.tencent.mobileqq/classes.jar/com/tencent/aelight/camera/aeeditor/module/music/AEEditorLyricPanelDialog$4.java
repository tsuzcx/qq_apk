package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class AEEditorLyricPanelDialog$4
  implements DialogInterface.OnShowListener
{
  AEEditorLyricPanelDialog$4(AEEditorLyricPanelDialog paramAEEditorLyricPanelDialog) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (AEEditorLyricPanelDialog.e(this.a) != null) {
      AEEditorLyricPanelDialog.e(this.a).onLyricPanelShow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.4
 * JD-Core Version:    0.7.0.1
 */