package com.tencent.aelight.camera.aeeditor.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class AEEditorLoadingView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorLoadingView$8(AEEditorLoadingView paramAEEditorLoadingView, boolean paramBoolean) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    float f2 = AEEditorLoadingView.a(this.b, f1);
    int i = (int)(-90.0F * f2 + 90.0F);
    AEEditorLoadingView.f(this.b).setPadding(0, i, 0, 0);
    i = (int)(f2 * 75.0F - 75.0F);
    AEEditorLoadingView.g(this.b).setPadding(0, i, 0, 0);
    AEEditorLoadingView.h(this.b).setPadding(0, i, 0, 0);
    if (!this.a)
    {
      paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorLoadingView.i(this.b).getLayoutParams();
      paramValueAnimator.topMargin = (i + AEEditorLoadingView.j(this.b));
      AEEditorLoadingView.i(this.b).setLayoutParams(paramValueAnimator);
      paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorLoadingView.k(this.b).getLayoutParams();
      paramValueAnimator.width = ((int)(f1 * AEEditorLoadingView.l(this.b)));
      AEEditorLoadingView.k(this.b).setLayoutParams(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.8
 * JD-Core Version:    0.7.0.1
 */