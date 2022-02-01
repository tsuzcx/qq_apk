package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorMultiCutEditFragment$8
  implements Runnable
{
  AEEditorMultiCutEditFragment$8(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void run()
  {
    this.this$0.a.b(1);
    this.this$0.a.c(2064515127);
    this.this$0.a.a(AEEditorMultiCutEditFragment.a(this.this$0), 1, 3, 94, 0, false);
    ThreadManager.getUIHandler().postDelayed(AEEditorMultiCutEditFragment.a(this.this$0), 3000L);
    this.this$0.a.setOnDismissListener(new AEEditorMultiCutEditFragment.8.1(this));
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.8
 * JD-Core Version:    0.7.0.1
 */