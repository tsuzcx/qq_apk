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
    if (AEEditorMultiCutEditFragment.a(this.a).a())
    {
      AEEditorMultiCutEditFragment.d(this.a, false);
      AEEditorMultiCutEditFragment.a(this.a).b();
      return;
    }
    AEEditorMultiCutEditFragment.d(this.a, true);
    AEEditorMultiCutEditFragment.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.12
 * JD-Core Version:    0.7.0.1
 */