package com.tencent.aelight.camera.aeeditor.module.edit;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$14$1
  implements PopupWindow.OnDismissListener
{
  AEEditorVideoEditFragment$14$1(AEEditorVideoEditFragment.14 param14) {}
  
  public void onDismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(AEEditorVideoEditFragment.b(this.a.this$0));
    if (this.a.a) {
      ThreadManager.getUIHandler().postDelayed(new AEEditorVideoEditFragment.14.1.1(this), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.14.1
 * JD-Core Version:    0.7.0.1
 */