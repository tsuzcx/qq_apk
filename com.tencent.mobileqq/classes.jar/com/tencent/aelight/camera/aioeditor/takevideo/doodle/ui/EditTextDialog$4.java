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
      paramView = paramDynamicTextItem.b(paramInt);
      if (paramView != null)
      {
        this.a.d.setText(paramView);
        this.a.d.setSelection(this.a.d.length());
        if (paramView.equals(DynamicTextBuilder.a(paramDynamicTextItem.k(), paramInt)))
        {
          this.a.d.setOnClickListener(EditTextDialog.b(this.a));
          this.a.d.setSelectAllOnFocus(true);
          if (this.a.d.hasFocus()) {
            this.a.d.selectAll();
          }
        }
        else
        {
          this.a.d.setOnClickListener(null);
        }
        if (this.a.c != null) {
          this.a.c.a(34);
        }
      }
    }
    else
    {
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.4
 * JD-Core Version:    0.7.0.1
 */