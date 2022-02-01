package com.tencent.gdtad.api.motivevideo;

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
    GdtLog.a("GdtMotiveVideoDialog", "onGlobalLayout: l=" + this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + ",t=" + this.jdField_a_of_type_AndroidViewViewGroup.getTop() + ",r=" + this.jdField_a_of_type_AndroidViewViewGroup.getRight() + ",b=" + this.jdField_a_of_type_AndroidViewViewGroup.getBottom());
    GdtLog.a("GdtMotiveVideoDialog", "onGlobalLayout: " + this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoDialog.3
 * JD-Core Version:    0.7.0.1
 */