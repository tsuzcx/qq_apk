package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.graphics.Point;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.reorder.ClipItemLongClickListener;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderListener;
import com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class AEEditorMultiCutEditFragment$23
  implements ClipItemLongClickListener
{
  AEEditorMultiCutEditFragment$23(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(@Nullable CutModelKt paramCutModelKt)
  {
    Point localPoint;
    if (AEEditorMultiCutEditFragment.d(this.a) != null) {
      localPoint = AEEditorMultiCutEditFragment.d(this.a).getLastDownMotionEvent();
    } else {
      localPoint = null;
    }
    if ((localPoint != null) && (paramCutModelKt != null) && (AEEditorMultiCutEditFragment.f(this.a).size() > 1))
    {
      AEEditorMultiCutEditFragment.e(this.a).c();
      AEEditorMultiCutEditFragment.v(this.a).a(paramCutModelKt.getUuid(), localPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.23
 * JD-Core Version:    0.7.0.1
 */