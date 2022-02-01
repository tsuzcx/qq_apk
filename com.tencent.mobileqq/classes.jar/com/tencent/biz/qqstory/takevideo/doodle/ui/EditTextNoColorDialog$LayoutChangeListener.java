package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class EditTextNoColorDialog$LayoutChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextNoColorDialog$LayoutChangeListener(EditTextNoColorDialog paramEditTextNoColorDialog) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom() - this.a.b > this.a.jdField_a_of_type_Int)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextNoColorDialog.LayoutChangeListener
 * JD-Core Version:    0.7.0.1
 */