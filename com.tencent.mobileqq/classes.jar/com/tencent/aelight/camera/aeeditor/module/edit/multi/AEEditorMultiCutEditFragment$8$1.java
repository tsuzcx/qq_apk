package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorMultiCutEditFragment$8$1
  implements PopupWindow.OnDismissListener
{
  AEEditorMultiCutEditFragment$8$1(AEEditorMultiCutEditFragment.8 param8) {}
  
  public void onDismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(AEEditorMultiCutEditFragment.q(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.8.1
 * JD-Core Version:    0.7.0.1
 */