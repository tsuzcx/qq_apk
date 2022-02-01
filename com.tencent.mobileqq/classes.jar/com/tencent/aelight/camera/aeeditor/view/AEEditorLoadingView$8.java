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
    float f2 = AEEditorLoadingView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView, f1);
    int i = (int)(-90.0F * f2 + 90.0F);
    AEEditorLoadingView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).setPadding(0, i, 0, 0);
    i = (int)(f2 * 75.0F - 75.0F);
    AEEditorLoadingView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).setPadding(0, i, 0, 0);
    AEEditorLoadingView.c(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).setPadding(0, i, 0, 0);
    if (!this.jdField_a_of_type_Boolean)
    {
      paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorLoadingView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).getLayoutParams();
      paramValueAnimator.topMargin = (i + AEEditorLoadingView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView));
      AEEditorLoadingView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).setLayoutParams(paramValueAnimator);
      paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorLoadingView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).getLayoutParams();
      paramValueAnimator.width = ((int)(f1 * AEEditorLoadingView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView)));
      AEEditorLoadingView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView).setLayoutParams(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.8
 * JD-Core Version:    0.7.0.1
 */