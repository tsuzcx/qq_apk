package androidx.recyclerview.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R.dimen;
import java.util.List;

public abstract class ItemTouchHelper$Callback
{
  private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
  public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
  public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
  private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
  static final int RELATIVE_DIR_FLAGS = 3158064;
  private static final Interpolator sDragScrollInterpolator = new ItemTouchHelper.Callback.1();
  private static final Interpolator sDragViewScrollCapInterpolator = new ItemTouchHelper.Callback.2();
  private int mCachedMaxScrollSpeed = -1;
  
  public static int convertToRelativeDirection(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0xC0C0C;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 &= (i ^ 0xFFFFFFFF);
    if (paramInt2 == 0) {}
    for (paramInt2 = i << 2;; paramInt2 = (paramInt2 & 0xC0C0C) << 2)
    {
      return paramInt1 | paramInt2;
      paramInt2 = i << 1;
      paramInt1 |= 0xFFF3F3F3 & paramInt2;
    }
  }
  
  @NonNull
  public static ItemTouchUIUtil getDefaultUIUtil()
  {
    return ItemTouchUIUtilImpl.INSTANCE;
  }
  
  private int getMaxDragScroll(RecyclerView paramRecyclerView)
  {
    if (this.mCachedMaxScrollSpeed == -1) {
      this.mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
    }
    return this.mCachedMaxScrollSpeed;
  }
  
  public static int makeFlag(int paramInt1, int paramInt2)
  {
    return paramInt2 << paramInt1 * 8;
  }
  
  public static int makeMovementFlags(int paramInt1, int paramInt2)
  {
    int i = makeFlag(0, paramInt2 | paramInt1);
    paramInt2 = makeFlag(1, paramInt2);
    return makeFlag(2, paramInt1) | paramInt2 | i;
  }
  
  public boolean canDropOver(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2)
  {
    return true;
  }
  
  public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
  {
    int n = paramViewHolder.itemView.getWidth();
    int i1 = paramViewHolder.itemView.getHeight();
    int i2 = paramInt1 - paramViewHolder.itemView.getLeft();
    int i3 = paramInt2 - paramViewHolder.itemView.getTop();
    int i4 = paramList.size();
    Object localObject2 = null;
    int i = -1;
    int k = 0;
    while (k < i4)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramList.get(k);
      if (i2 > 0)
      {
        j = localViewHolder.itemView.getRight() - (paramInt1 + n);
        if ((j < 0) && (localViewHolder.itemView.getRight() > paramViewHolder.itemView.getRight()))
        {
          j = Math.abs(j);
          if (j > i)
          {
            localObject2 = localViewHolder;
            break label146;
          }
        }
      }
      int j = i;
      label146:
      Object localObject1 = localObject2;
      i = j;
      int m;
      if (i2 < 0)
      {
        m = localViewHolder.itemView.getLeft() - paramInt1;
        localObject1 = localObject2;
        i = j;
        if (m > 0)
        {
          localObject1 = localObject2;
          i = j;
          if (localViewHolder.itemView.getLeft() < paramViewHolder.itemView.getLeft())
          {
            m = Math.abs(m);
            localObject1 = localObject2;
            i = j;
            if (m > j)
            {
              i = m;
              localObject1 = localViewHolder;
            }
          }
        }
      }
      localObject2 = localObject1;
      j = i;
      if (i3 < 0)
      {
        m = localViewHolder.itemView.getTop() - paramInt2;
        localObject2 = localObject1;
        j = i;
        if (m > 0)
        {
          localObject2 = localObject1;
          j = i;
          if (localViewHolder.itemView.getTop() < paramViewHolder.itemView.getTop())
          {
            m = Math.abs(m);
            localObject2 = localObject1;
            j = i;
            if (m > i)
            {
              j = m;
              localObject2 = localViewHolder;
            }
          }
        }
      }
      if (i3 > 0)
      {
        i = localViewHolder.itemView.getBottom() - (paramInt2 + i1);
        if ((i < 0) && (localViewHolder.itemView.getBottom() > paramViewHolder.itemView.getBottom()))
        {
          i = Math.abs(i);
          if (i > j)
          {
            localObject2 = localViewHolder;
            break label404;
          }
        }
      }
      i = j;
      label404:
      k += 1;
    }
    return localObject2;
  }
  
  public void clearView(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    ItemTouchUIUtilImpl.INSTANCE.clearView(paramViewHolder.itemView);
  }
  
  public int convertToAbsoluteDirection(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0x303030;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 &= (i ^ 0xFFFFFFFF);
    if (paramInt2 == 0) {}
    for (paramInt2 = i >> 2;; paramInt2 = (paramInt2 & 0x303030) >> 2)
    {
      return paramInt1 | paramInt2;
      paramInt2 = i >> 1;
      paramInt1 |= 0xFFCFCFCF & paramInt2;
    }
  }
  
  final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
  }
  
  public long getAnimationDuration(@NonNull RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
  {
    paramRecyclerView = paramRecyclerView.getItemAnimator();
    if (paramRecyclerView == null)
    {
      if (paramInt == 8) {
        return 200L;
      }
      return 250L;
    }
    if (paramInt == 8) {
      return paramRecyclerView.getMoveDuration();
    }
    return paramRecyclerView.getRemoveDuration();
  }
  
  public int getBoundingBoxMargin()
  {
    return 0;
  }
  
  public float getMoveThreshold(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.5F;
  }
  
  public abstract int getMovementFlags(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder);
  
  public float getSwipeEscapeVelocity(float paramFloat)
  {
    return paramFloat;
  }
  
  public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.5F;
  }
  
  public float getSwipeVelocityThreshold(float paramFloat)
  {
    return paramFloat;
  }
  
  boolean hasDragFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return (getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF0000) != 0;
  }
  
  boolean hasSwipeFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return (getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF00) != 0;
  }
  
  public int interpolateOutOfBoundsScroll(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    paramInt3 = getMaxDragScroll(paramRecyclerView);
    int i = Math.abs(paramInt2);
    int j = (int)Math.signum(paramInt2);
    float f2 = i;
    float f1 = 1.0F;
    f2 = Math.min(1.0F, f2 * 1.0F / paramInt1);
    paramInt1 = (int)(j * paramInt3 * sDragViewScrollCapInterpolator.getInterpolation(f2));
    if (paramLong <= 2000L) {
      f1 = (float)paramLong / 2000.0F;
    }
    paramInt3 = (int)(paramInt1 * sDragScrollInterpolator.getInterpolation(f1));
    paramInt1 = paramInt3;
    if (paramInt3 == 0)
    {
      if (paramInt2 > 0) {
        return 1;
      }
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return true;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return true;
  }
  
  public void onChildDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    ItemTouchUIUtilImpl.INSTANCE.onDraw(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public void onChildDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    ItemTouchUIUtilImpl.INSTANCE.onDrawOver(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
      localRecoverAnimation.update();
      int k = paramCanvas.save();
      onChildDraw(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
      paramCanvas.restoreToCount(k);
      i += 1;
    }
    if (paramViewHolder != null)
    {
      i = paramCanvas.save();
      onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
      paramCanvas.restoreToCount(i);
    }
  }
  
  void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
  {
    int k = paramList.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
      int m = paramCanvas.save();
      onChildDrawOver(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (paramViewHolder != null)
    {
      i = paramCanvas.save();
      onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
      paramCanvas.restoreToCount(i);
    }
    paramInt = k - 1;
    i = j;
    while (paramInt >= 0)
    {
      paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
      if ((paramCanvas.mEnded) && (!paramCanvas.mIsPendingCleanup)) {
        paramList.remove(paramInt);
      } else if (!paramCanvas.mEnded) {
        i = 1;
      }
      paramInt -= 1;
    }
    if (i != 0) {
      paramRecyclerView.invalidate();
    }
  }
  
  public abstract boolean onMove(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2);
  
  public void onMoved(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, int paramInt1, @NonNull RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler))
    {
      ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop(paramViewHolder1.itemView, paramViewHolder2.itemView, paramInt3, paramInt4);
      return;
    }
    if (localLayoutManager.canScrollHorizontally())
    {
      if (localLayoutManager.getDecoratedLeft(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingLeft()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
      if (localLayoutManager.getDecoratedRight(paramViewHolder2.itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
    }
    if (localLayoutManager.canScrollVertically())
    {
      if (localLayoutManager.getDecoratedTop(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingTop()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
      if (localLayoutManager.getDecoratedBottom(paramViewHolder2.itemView) >= paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
    }
  }
  
  public void onSelectedChanged(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null) {
      ItemTouchUIUtilImpl.INSTANCE.onSelected(paramViewHolder.itemView);
    }
  }
  
  public abstract void onSwiped(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.Callback
 * JD-Core Version:    0.7.0.1
 */