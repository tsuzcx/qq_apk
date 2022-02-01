package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView.State;

class GalleryLayoutManager$GallerySmoothScroller
  extends LinearSmoothScroller
{
  public GalleryLayoutManager$GallerySmoothScroller(GalleryLayoutManager paramGalleryLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public int a(View paramView)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollHorizontally()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      int i = localLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin;
      int n = localLayoutManager.getDecoratedRight(paramView);
      int i1 = localLayoutParams.rightMargin;
      int j = localLayoutManager.getPaddingLeft();
      int k = localLayoutManager.getWidth();
      int m = localLayoutManager.getPaddingRight();
      n = (int)((n + i1 - i) / 2.0F);
      return (int)((k - m - j) / 2.0F) - (i + n);
    }
    return 0;
  }
  
  public int b(View paramView)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollVertically()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      int i = localLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin;
      int n = localLayoutManager.getDecoratedBottom(paramView);
      int i1 = localLayoutParams.bottomMargin;
      int j = localLayoutManager.getPaddingTop();
      int k = localLayoutManager.getHeight();
      int m = localLayoutManager.getPaddingBottom();
      n = (int)((n + i1 - i) / 2.0F);
      return (int)((k - m - j) / 2.0F) - (i + n);
    }
    return 0;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    Object localObject = getLayoutManager();
    if ((localObject instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return ((RecyclerView.SmoothScroller.ScrollVectorProvider)localObject).computeScrollVectorForPosition(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
    ((StringBuilder)localObject).append(RecyclerView.SmoothScroller.ScrollVectorProvider.class.getCanonicalName());
    Log.w("GalleryLayoutManager", ((StringBuilder)localObject).toString());
    return null;
  }
  
  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    int i = a(paramView);
    int j = b(paramView);
    int k = calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      paramAction.update(-i, -j, k, this.mDecelerateInterpolator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.GalleryLayoutManager.GallerySmoothScroller
 * JD-Core Version:    0.7.0.1
 */