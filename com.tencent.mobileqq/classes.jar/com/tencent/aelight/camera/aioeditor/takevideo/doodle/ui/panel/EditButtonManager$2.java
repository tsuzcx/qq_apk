package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.Log;
import android.view.View;

class EditButtonManager$2
  implements ValueAnimator.AnimatorUpdateListener
{
  EditButtonManager$2(EditButtonManager paramEditButtonManager, boolean paramBoolean, EditButtonManager.FunButton paramFunButton1, EditButtonManager.FunGroup paramFunGroup1, EditButtonManager.FunButton paramFunButton2, EditButtonManager.FunGroup paramFunGroup2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("onAnimation Update, value = ");
    paramValueAnimator.append(f1);
    Log.d("[EditButton]", paramValueAnimator.toString());
    if (this.a)
    {
      this.b.b.getMeasuredWidth();
      int i;
      if (this.c != null)
      {
        i = this.d.b.getMeasuredWidth();
        this.c.a.getLayoutParams().width = ((int)(i * (2.0F - f1)));
        this.c.a.requestLayout();
      }
      if (this.e != null)
      {
        int j = this.b.b.getMeasuredWidth();
        i = j;
        if (j <= 0) {
          i = this.e.b.getMeasuredWidth();
        }
        this.e.a.getLayoutParams().width = ((int)(i * (f1 + 1.0F)));
        this.e.a.requestLayout();
      }
    }
    else
    {
      EditButtonManager.c(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.2
 * JD-Core Version:    0.7.0.1
 */