package com.tencent.aelight.camera.aeeditor.module.edit;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$13$1
  implements PopupWindow.OnDismissListener
{
  AEEditorVideoEditFragment$13$1(AEEditorVideoEditFragment.13 param13) {}
  
  public void onDismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(AEEditorVideoEditFragment.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.13.1
 * JD-Core Version:    0.7.0.1
 */