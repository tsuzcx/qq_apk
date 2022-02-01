package com.tencent.aelight.camera.aeeditor.module.edit.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AEEditorCheckGroupView$1$onPreDraw$1
  implements View.OnClickListener
{
  AEEditorCheckGroupView$1$onPreDraw$1(AEEditorCheckGroupView.1 param1, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - AEEditorCheckGroupView.a(this.a.a) > 500) {
      AEEditorCheckGroupView.a(this.a.a, false, this.b, false, false, 12, null);
    } else {
      AEEditorCheckGroupView.a(this.a.a, false, this.b, true, false, 8, null);
    }
    AEEditorCheckGroupView.a(this.a.a, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView.1.onPreDraw.1
 * JD-Core Version:    0.7.0.1
 */