package com.tencent.aelight.camera.aeeditor.module.music;

import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorLyricPanelDialog$7
  implements Runnable
{
  AEEditorLyricPanelDialog$7(AEEditorLyricPanelDialog paramAEEditorLyricPanelDialog) {}
  
  public void run()
  {
    AEEditorLyricPanelDialog localAEEditorLyricPanelDialog = this.this$0;
    AEEditorLyricPanelDialog.a(localAEEditorLyricPanelDialog, new AEEditorQcircleBubbleView(localAEEditorLyricPanelDialog.getContext()));
    AEEditorLyricPanelDialog.a(this.this$0).c(2064515169);
    AEEditorLyricPanelDialog.a(this.this$0).b(1);
    AEEditorLyricPanelDialog.a(this.this$0).a(AEEditorLyricPanelDialog.a(this.this$0), 1, 0);
    ThreadManager.getUIHandler().postDelayed(AEEditorLyricPanelDialog.a(this.this$0), 3000L);
    AEEditorLyricPanelDialog.a(this.this$0).setOnDismissListener(new AEEditorLyricPanelDialog.7.1(this));
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_MUSIC_TAB", false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.7
 * JD-Core Version:    0.7.0.1
 */