package com.tencent.aelight.camera.aeeditor.module.music;

import com.tencent.aelight.camera.log.AEQLog;

class AEEditorPanelDialogDelegate$1$1
  implements Runnable
{
  AEEditorPanelDialogDelegate$1$1(AEEditorPanelDialogDelegate.1 param1) {}
  
  public void run()
  {
    try
    {
      if (AEEditorPanelDialogDelegate.a(this.a.a) != null)
      {
        AEEditorPanelDialogDelegate.a(this.a.a).b();
        return;
      }
    }
    catch (Exception localException)
    {
      AEQLog.a("AEEditorLyricPanelDialog", "[dismiss], Dialog.dismiss() raised exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorPanelDialogDelegate.1.1
 * JD-Core Version:    0.7.0.1
 */