package com.tencent.gdtad.basics.motivevideo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.gdtad.log.GdtLog;

class GdtMotiveVideoDialog$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtMotiveVideoDialog$3(GdtMotiveVideoDialog paramGdtMotiveVideoDialog, ViewGroup paramViewGroup, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGlobalLayout: l=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    localStringBuilder.append(",t=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getTop());
    localStringBuilder.append(",r=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getRight());
    localStringBuilder.append(",b=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewViewGroup.getBottom());
    GdtLog.a("GdtMotiveVideoDialog", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGlobalLayout: ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewView);
    GdtLog.a("GdtMotiveVideoDialog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.3
 * JD-Core Version:    0.7.0.1
 */