package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowGridView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemHeight", "itemNum", "mContext", "init", "", "smoothScrollDownToPosition", "position", "Companion", "GridSpacingItemDecoration", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowGridView
  extends RecyclerView
{
  public static final AEFlashShowGridView.Companion a = new AEFlashShowGridView.Companion(null);
  private Context b;
  private int c;
  private int d;
  
  public AEFlashShowGridView(@NotNull Context paramContext)
  {
    super(paramContext);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    a(paramContext);
  }
  
  public AEFlashShowGridView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    a(paramContext);
  }
  
  public AEFlashShowGridView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    this.b = paramContext;
    float f = 64;
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    int i = AIOUtils.b(f, paramContext.getResources());
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    int m = AIOUtils.b(8.0F, paramContext.getResources());
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    int j = AIOUtils.b(20.0F, paramContext.getResources());
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    int n = AIOUtils.b(20.0F, paramContext.getResources());
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mContext.resources");
    int k = paramContext.getDisplayMetrics().widthPixels - n * 2;
    this.c = ((k - i) / (m + i) + 1);
    setPadding(n, 0, n, j * 2);
    m = this.c;
    k = (k - m * i) / (m - 1);
    setClipToPadding(false);
    setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(getContext(), this.c));
    addItemDecoration((RecyclerView.ItemDecoration)new AEFlashShowGridView.GridSpacingItemDecoration(this, this.c, k, j, false));
    this.d = i;
  }
  
  public final void a(int paramInt)
  {
    Context localContext = this.b;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    int i = AIOUtils.b(8.0F, localContext.getResources());
    i = (paramInt / this.c - 1) * (this.d + i);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    smoothScrollBy(0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowGridView
 * JD-Core Version:    0.7.0.1
 */