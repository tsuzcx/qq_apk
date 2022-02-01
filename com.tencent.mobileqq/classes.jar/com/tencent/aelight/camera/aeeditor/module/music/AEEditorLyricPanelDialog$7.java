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
    AEEditorLyricPanelDialog.f(this.this$0).c(2064187511);
    AEEditorLyricPanelDialog.f(this.this$0).b(1);
    AEEditorLyricPanelDialog.f(this.this$0).a(AEEditorLyricPanelDialog.g(this.this$0), 1, 0);
    ThreadManager.getUIHandler().postDelayed(AEEditorLyricPanelDialog.h(this.this$0), 3000L);
    AEEditorLyricPanelDialog.f(this.this$0).setOnDismissListener(new AEEditorLyricPanelDialog.7.1(this));
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_MUSIC_TAB", false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.7
 * JD-Core Version:    0.7.0.1
 */