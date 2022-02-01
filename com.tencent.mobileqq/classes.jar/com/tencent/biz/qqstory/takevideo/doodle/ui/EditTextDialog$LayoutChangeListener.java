package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;

class EditTextDialog$LayoutChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextDialog$LayoutChangeListener(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LayoutChangeListener
 * JD-Core Version:    0.7.0.1
 */