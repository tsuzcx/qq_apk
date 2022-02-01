package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;

class AEEditorMultiCutEditFragment$12
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$12(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    if (AEEditorMultiCutEditFragment.e(this.a).a())
    {
      AEEditorMultiCutEditFragment.e(this.a, false);
      AEEditorMultiCutEditFragment.e(this.a).c();
      return;
    }
    AEEditorMultiCutEditFragment.e(this.a, true);
    AEEditorMultiCutEditFragment.e(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.12
 * JD-Core Version:    0.7.0.1
 */