package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$TabItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$TabItemHolder;", "context", "Landroid/content/Context;", "color", "Landroid/content/res/ColorStateList;", "textSizePx", "", "tabWidthPx", "", "(Landroid/content/Context;Landroid/content/res/ColorStateList;FI)V", "getColor", "()Landroid/content/res/ColorStateList;", "getContext", "()Landroid/content/Context;", "selected", "getSelected", "()I", "setSelected", "(I)V", "getTabWidthPx", "getTextSizePx", "()F", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowSwitchLayout$TabItemAdapter
  extends RecyclerView.Adapter<FlashShowSwitchLayout.TabItemHolder>
{
  private int a;
  @NotNull
  private final Context b;
  @NotNull
  private final ColorStateList c;
  private final float d;
  private final int e;
  
  public FlashShowSwitchLayout$TabItemAdapter(@NotNull Context paramContext, @NotNull ColorStateList paramColorStateList, float paramFloat, int paramInt)
  {
    this.b = paramContext;
    this.c = paramColorStateList;
    this.d = paramFloat;
    this.e = paramInt;
  }
  
  @NotNull
  public FlashShowSwitchLayout.TabItemHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = new TextView(this.b);
    paramViewGroup.setTextSize(0, this.d);
    paramViewGroup.setTextColor(this.c);
    paramViewGroup.setShadowLayer(1.5F, -1.0F, 1.0F, -3355444);
    paramViewGroup.setGravity(17);
    paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(this.e, -2));
    return new FlashShowSwitchLayout.TabItemHolder(paramViewGroup);
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(@NotNull FlashShowSwitchLayout.TabItemHolder paramTabItemHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTabItemHolder, "holder");
    paramTabItemHolder.a().setText((CharSequence)FlashShowSwitchLayout.a.a()[paramInt]);
    TextView localTextView = paramTabItemHolder.a();
    boolean bool;
    if (paramInt == this.a) {
      bool = true;
    } else {
      bool = false;
    }
    localTextView.setSelected(bool);
    paramTabItemHolder.a().setTextSize(14.0F);
    if (paramTabItemHolder.a().isSelected())
    {
      paramTabItemHolder.a().setTypeface(Typeface.DEFAULT_BOLD);
      return;
    }
    paramTabItemHolder.a().setTypeface(Typeface.DEFAULT);
  }
  
  public int getItemCount()
  {
    return FlashShowSwitchLayout.a.a().length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.TabItemAdapter
 * JD-Core Version:    0.7.0.1
 */