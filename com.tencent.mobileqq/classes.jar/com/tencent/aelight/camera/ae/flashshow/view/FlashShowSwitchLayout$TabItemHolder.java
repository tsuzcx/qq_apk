package com.tencent.aelight.camera.ae.flashshow.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$TabItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "getTextView", "()Landroid/widget/TextView;", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowSwitchLayout$TabItemHolder
  extends RecyclerView.ViewHolder
{
  public static final FlashShowSwitchLayout.TabItemHolder.Companion a = new FlashShowSwitchLayout.TabItemHolder.Companion(null);
  @Nullable
  private static Function1<? super Integer, Unit> c;
  @NotNull
  private final TextView b;
  
  public FlashShowSwitchLayout$TabItemHolder(@NotNull TextView paramTextView)
  {
    super((View)paramTextView);
    this.b = paramTextView;
    this.itemView.setOnClickListener((View.OnClickListener)new FlashShowSwitchLayout.TabItemHolder.1(this));
  }
  
  @NotNull
  public final TextView a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.TabItemHolder
 * JD-Core Version:    0.7.0.1
 */