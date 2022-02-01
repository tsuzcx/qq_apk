package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class EditTextNoColorDialog$InitialLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextNoColorDialog$InitialLayoutListener(EditTextNoColorDialog paramEditTextNoColorDialog) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom();
    if (this.a.b < 0)
    {
      this.a.b = i;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener.a();
    }
    do
    {
      do
      {
        return;
      } while (this.a.b - i <= this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.a.b = i;
      this.a.jdField_a_of_type_AndroidViewViewGroup.requestLayout();
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener == null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener.a(true, null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextNoColorDialog.InitialLayoutListener
 * JD-Core Version:    0.7.0.1
 */