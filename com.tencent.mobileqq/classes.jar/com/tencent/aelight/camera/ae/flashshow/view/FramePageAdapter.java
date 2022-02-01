package com.tencent.aelight.camera.ae.flashshow.view;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/view/FramePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/flashshow/view/FrameLayoutHolder;", "types", "", "", "typeBinder", "Lcom/tencent/aelight/camera/ae/flashshow/view/TypedHolderBinder;", "([Ljava/lang/Integer;Lcom/tencent/aelight/camera/ae/flashshow/view/TypedHolderBinder;)V", "[Ljava/lang/Integer;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FramePageAdapter
  extends RecyclerView.Adapter<FrameLayoutHolder>
{
  private final Integer[] a;
  private final TypedHolderBinder b;
  
  @NotNull
  public FrameLayoutHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return new FrameLayoutHolder(paramViewGroup);
  }
  
  public void a(@NotNull FrameLayoutHolder paramFrameLayoutHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramFrameLayoutHolder, "holder");
    this.b.a(paramFrameLayoutHolder, getItemViewType(paramInt));
  }
  
  public int getItemCount()
  {
    return this.a.length;
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.a[paramInt].intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FramePageAdapter
 * JD-Core Version:    0.7.0.1
 */