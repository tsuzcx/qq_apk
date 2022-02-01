package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "selectableView", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/SelectableThumbClipView;", "(Lcom/tencent/aelight/camera/aeeditor/view/reorder/SelectableThumbClipView;)V", "contentView", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "getContentView", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "durationView", "Landroid/widget/TextView;", "getDurationView", "()Landroid/widget/TextView;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderVH
  extends RecyclerView.ViewHolder
{
  private final SelectableThumbClipView a;
  
  public ReorderVH(@NotNull SelectableThumbClipView paramSelectableThumbClipView)
  {
    super((View)paramSelectableThumbClipView);
    this.a = paramSelectableThumbClipView;
  }
  
  @NotNull
  public final ThumbClipView a()
  {
    return this.a.getThumbView();
  }
  
  @NotNull
  public final TextView b()
  {
    return this.a.getDurationView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderVH
 * JD-Core Version:    0.7.0.1
 */