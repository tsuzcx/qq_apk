package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.biz.qqstory.support.logging.SLog;

class EditTextDialog$5
  implements View.OnFocusChangeListener
{
  EditTextDialog$5(EditTextDialog paramEditTextDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a(this.a.a.b(), true);
    }
    paramView = new StringBuilder();
    paramView.append("onFocusChange:");
    paramView.append(paramBoolean);
    SLog.b("EditTextDialog", paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.5
 * JD-Core Version:    0.7.0.1
 */