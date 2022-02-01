package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHighlightBgView", "Landroid/view/View;", "mSlowScroller", "com/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$mSlowScroller$1", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$mSlowScroller$1;", "mTabListView", "Landroidx/recyclerview/widget/RecyclerView;", "tabSwitchListener", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$OnTabSwitchListener;", "getTabSwitchListener", "()Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$OnTabSwitchListener;", "setTabSwitchListener", "(Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$OnTabSwitchListener;)V", "createHighlightBgView", "color", "cornerRadius", "", "createTabListView", "itemSizePx", "Landroid/content/res/ColorStateList;", "textSizePx", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCurrentItem", "position", "smooth", "", "toPx", "Companion", "OnTabSwitchListener", "TabItemAdapter", "TabItemHolder", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowSwitchLayout
  extends FrameLayout
{
  public static final FlashShowSwitchLayout.Companion a = new FlashShowSwitchLayout.Companion(null);
  @NotNull
  private static final String[] f = { "照片", "视频" };
  private View b;
  private RecyclerView c;
  @Nullable
  private FlashShowSwitchLayout.OnTabSwitchListener d;
  private final FlashShowSwitchLayout.mSlowScroller.1 e = new FlashShowSwitchLayout.mSlowScroller.1(this, getContext());
  
  public FlashShowSwitchLayout(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlashShowSwitchLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlashShowSwitchLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private final int a(int paramInt)
  {
    float f1 = paramInt;
    Resources localResources = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "resources");
    return (int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics());
  }
  
  private final View a(Context paramContext, int paramInt, float paramFloat)
  {
    paramContext = new View(paramContext);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramFloat);
    localGradientDrawable.setColor(paramInt);
    ViewCompat.setBackground(paramContext, (Drawable)localGradientDrawable);
    return paramContext;
  }
  
  private final RecyclerView a(Context paramContext, int paramInt, ColorStateList paramColorStateList, float paramFloat)
  {
    RecyclerView localRecyclerView = new RecyclerView(paramContext);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(paramContext, 0, false));
    localRecyclerView.setAdapter((RecyclerView.Adapter)new FlashShowSwitchLayout.TabItemAdapter(paramContext, paramColorStateList, paramFloat, paramInt));
    String[] arrayOfString = f;
    localRecyclerView.setPadding((arrayOfString.length - 1) * paramInt, 0, (arrayOfString.length - 1) * paramInt, 0);
    new LinearSnapHelper().attachToRecyclerView(localRecyclerView);
    localRecyclerView.setClipToPadding(false);
    localRecyclerView.addOnScrollListener((RecyclerView.OnScrollListener)new FlashShowSwitchLayout.createTabListView..inlined.apply.lambda.1(this, paramContext, paramColorStateList, paramFloat, paramInt));
    return localRecyclerView;
  }
  
  private final void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = a(paramContext, -1, a(28));
    paramAttributeSet = this.b;
    if (paramAttributeSet == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mHighlightBgView");
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(a(48), a(28));
    localLayoutParams.gravity = 17;
    addView(paramAttributeSet, (ViewGroup.LayoutParams)localLayoutParams);
    this.c = a(paramContext, a(45), new ColorStateList((int[][])new int[][] { { 16842913 }, new int[0] }, new int[] { -16777216, -1 }), a(14));
    paramContext = this.c;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTabListView");
    }
    paramContext = (View)paramContext;
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    FlashShowSwitchLayout.TabItemHolder.a.a((Function1)new FlashShowSwitchLayout.init.3(this));
  }
  
  @Nullable
  public final FlashShowSwitchLayout.OnTabSwitchListener getTabSwitchListener()
  {
    return this.d;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(a(45) * (f.length * 2 - 1), 1073741824), paramInt2);
  }
  
  public final void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTabListView");
    }
    RecyclerView.Adapter localAdapter = localRecyclerView.getAdapter();
    Object localObject = localAdapter;
    if (!(localAdapter instanceof FlashShowSwitchLayout.TabItemAdapter)) {
      localObject = null;
    }
    localObject = (FlashShowSwitchLayout.TabItemAdapter)localObject;
    if (localObject != null)
    {
      ((FlashShowSwitchLayout.TabItemAdapter)localObject).a(paramInt);
      ((FlashShowSwitchLayout.TabItemAdapter)localObject).notifyDataSetChanged();
    }
    if (paramBoolean)
    {
      this.e.setTargetPosition(paramInt);
      localObject = localRecyclerView.getLayoutManager();
      if (localObject != null) {
        ((RecyclerView.LayoutManager)localObject).startSmoothScroll((RecyclerView.SmoothScroller)this.e);
      }
    }
    else
    {
      localRecyclerView.scrollToPosition(paramInt);
      localObject = this.d;
      if (localObject != null) {
        ((FlashShowSwitchLayout.OnTabSwitchListener)localObject).a(paramInt);
      }
    }
  }
  
  public final void setTabSwitchListener(@Nullable FlashShowSwitchLayout.OnTabSwitchListener paramOnTabSwitchListener)
  {
    this.d = paramOnTabSwitchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout
 * JD-Core Version:    0.7.0.1
 */