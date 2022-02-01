package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.ValueAnimator;

class EditButtonManager$4
  implements Runnable
{
  EditButtonManager$4(EditButtonManager paramEditButtonManager, EditButtonManager.FunGroup paramFunGroup1, EditButtonManager.FunGroup paramFunGroup2) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    EditButtonManager.a((EditButtonManager)localObject, EditButtonManager.b((EditButtonManager)localObject));
    EditButtonManager.b(this.this$0, null);
    EditButtonManager.a(this.this$0).start();
    localObject = this.a;
    EditButtonManager.FunGroup localFunGroup = this.b;
    if ((localObject != localFunGroup) && (localFunGroup != null)) {
      EditButtonManager.a(this.this$0, localFunGroup, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.4
 * JD-Core Version:    0.7.0.1
 */