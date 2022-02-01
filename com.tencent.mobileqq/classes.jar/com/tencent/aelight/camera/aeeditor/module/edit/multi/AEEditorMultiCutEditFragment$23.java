package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.graphics.Point;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.reorder.ClipItemLongClickListener;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderListener;
import com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class AEEditorMultiCutEditFragment$23
  implements ClipItemLongClickListener
{
  AEEditorMultiCutEditFragment$23(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(@Nullable CutModelKt paramCutModelKt)
  {
    Point localPoint;
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      localPoint = AEEditorMultiCutEditFragment.a(this.a).a();
    } else {
      localPoint = null;
    }
    if ((localPoint != null) && (paramCutModelKt != null) && (AEEditorMultiCutEditFragment.a(this.a).size() > 1))
    {
      AEEditorMultiCutEditFragment.a(this.a).b();
      AEEditorMultiCutEditFragment.a(this.a).a(paramCutModelKt.getUuid(), localPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.23
 * JD-Core Version:    0.7.0.1
 */