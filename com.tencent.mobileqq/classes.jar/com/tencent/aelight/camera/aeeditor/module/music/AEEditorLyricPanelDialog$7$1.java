package com.tencent.aelight.camera.aeeditor.module.music;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorLyricPanelDialog$7$1
  implements PopupWindow.OnDismissListener
{
  AEEditorLyricPanelDialog$7$1(AEEditorLyricPanelDialog.7 param7) {}
  
  public void onDismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(AEEditorLyricPanelDialog.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.7.1
 * JD-Core Version:    0.7.0.1
 */