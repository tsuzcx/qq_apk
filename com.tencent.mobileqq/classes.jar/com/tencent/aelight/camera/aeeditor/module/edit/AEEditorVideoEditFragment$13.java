package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$13
  implements Runnable
{
  AEEditorVideoEditFragment$13(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void run()
  {
    this.this$0.W.b(1);
    this.this$0.W.c(2064187457);
    this.this$0.W.a(this.this$0.C, 4, 1);
    ThreadManager.getUIHandler().postDelayed(AEEditorVideoEditFragment.o(this.this$0), 3000L);
    this.this$0.W.setOnDismissListener(new AEEditorVideoEditFragment.13.1(this));
    this.this$0.J();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.13
 * JD-Core Version:    0.7.0.1
 */