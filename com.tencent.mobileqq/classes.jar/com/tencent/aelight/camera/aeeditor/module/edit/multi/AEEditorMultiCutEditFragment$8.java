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
    this.this$0.i.b(1);
    this.this$0.i.c(2064187469);
    this.this$0.i.a(AEEditorMultiCutEditFragment.p(this.this$0), 1, 3, 94, 0, false);
    ThreadManager.getUIHandler().postDelayed(AEEditorMultiCutEditFragment.q(this.this$0), 3000L);
    this.this$0.i.setOnDismissListener(new AEEditorMultiCutEditFragment.8.1(this));
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.8
 * JD-Core Version:    0.7.0.1
 */