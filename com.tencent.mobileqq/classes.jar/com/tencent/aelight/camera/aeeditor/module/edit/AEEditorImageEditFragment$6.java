package com.tencent.aelight.camera.aeeditor.module.edit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipPanel;
import com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar;

class AEEditorImageEditFragment$6
  implements View.OnClickListener
{
  AEEditorImageEditFragment$6(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEEditorImageEditFragment.c(this.a);
    AEEditorImageEditFragment.h(this.a).a(AEEditorImageEditFragment.d(this.a), AEEditorImageEditFragment.e(this.a), AEEditorImageEditFragment.g(this.a).getWidth(), AEEditorImageEditFragment.g(this.a).getHeight());
    this.a.f.a();
    AEReportUtils.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.6
 * JD-Core Version:    0.7.0.1
 */