package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.widget.EditText;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView.OnClickListener;
import com.tencent.widget.XPanelContainer;

class EditTextDialog$4
  implements EditTextPreView.OnClickListener
{
  EditTextDialog$4(EditTextDialog paramEditTextDialog) {}
  
  public void a(View paramView, DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if ((paramDynamicTextItem != null) && (paramInt > -1))
    {
      paramView = paramDynamicTextItem.a(paramInt);
      if (paramView != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.length());
        if (paramView.equals(DynamicTextBuilder.a(paramDynamicTextItem.c(), paramInt)))
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(EditTextDialog.a(this.a));
          this.a.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
          if (this.a.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
            this.a.jdField_a_of_type_AndroidWidgetEditText.selectAll();
          }
        }
        else
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
        }
        if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
          this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(34);
        }
      }
    }
    else
    {
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.4
 * JD-Core Version:    0.7.0.1
 */