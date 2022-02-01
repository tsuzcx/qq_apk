package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DYAEEffectListHolder$scrollItemToCenter$1
  implements Runnable
{
  DYAEEffectListHolder$scrollItemToCenter$1(DYAEEffectListHolder paramDYAEEffectListHolder, int paramInt) {}
  
  public final void run()
  {
    DYAEEffectListHolder.a(this.this$0).setTargetPosition(this.a);
    DYAEEffectListHolder.b(this.this$0).getLayoutManager().startSmoothScroll(DYAEEffectListHolder.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.scrollItemToCenter.1
 * JD-Core Version:    0.7.0.1
 */