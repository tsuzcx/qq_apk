package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;

class EditTextDialog$2
  implements View.OnClickListener
{
  EditTextDialog$2(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    EditTextDialog.a(this.a, true);
    if (this.a.z != null)
    {
      EditTextDialog.b(this.a, false);
      paramView = this.a;
      paramView.y = paramView.z;
      this.a.y.a(EditTextDialog.a(this.a), this.a.A);
      this.a.y.g(this.a.C);
      if ((this.a.y instanceof NormalTextItem)) {
        ((NormalTextItem)this.a.y).a(this.a.B);
      }
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.2
 * JD-Core Version:    0.7.0.1
 */