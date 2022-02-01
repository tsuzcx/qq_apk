package com.tencent.aelight.camera.aeeditor.module.text;

import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class AEEditorTextEditDialog$2
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  AEEditorTextEditDialog$2(AEEditorTextEditDialog paramAEEditorTextEditDialog) {}
  
  public void a()
  {
    AEEditorTextEditDialog.c(this.a);
    this.a.dismiss();
  }
  
  public void a(int paramInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(AEEditorTextEditDialog.a(this.a), "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.start();
    AEEditorTextEditDialog.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextEditDialog.2
 * JD-Core Version:    0.7.0.1
 */