package androidx.recyclerview.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
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
    paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
    if (paramInt2 == 0) {
      return paramInt1 | i << 2;
    }
    return paramInt1 | i << 1 & 0xFFF3F3F3 | (i << 1 & 0xC0C0C) << 2;
  }
  
  @NonNull
  public static ItemTouchUIUtil getDefaultUIUtil()
  {
    return ItemTouchUIUtilImpl.INSTANCE;
  }
  
  private int getMaxDragScroll(RecyclerView paramRecyclerView)
  {
    if (this.mCachedMaxScrollSpeed == -1) {
      this.mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(2131297285);
    }
    return this.mCachedMaxScrollSpeed;
  }
  
  public static int makeFlag(int paramInt1, int paramInt2)
  {
    return paramInt2 << paramInt1 * 8;
  }
  
  public static int makeMovementFlags(int paramInt1, int paramInt2)
  {
    return makeFlag(0, paramInt2 | paramInt1) | makeFlag(1, paramInt2) | makeFlag(2, paramInt1);
  }
  
  public boolean canDropOver(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2)
  {
    return true;
  }
  
  public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
  {
    int m = paramViewHolder.itemView.getWidth();
    int n = paramViewHolder.itemView.getHeight();
    Object localObject2 = null;
    int i = -1;
    int i1 = paramInt1 - paramViewHolder.itemView.getLeft();
    int i2 = paramInt2 - paramViewHolder.itemView.getTop();
    int i3 = paramList.size();
    int j = 0;
    Object localObject1;
    int k;
    if (j < i3)
    {
      localObject1 = (RecyclerView.ViewHolder)paramList.get(j);
      if (i1 <= 0) {
        break label346;
      }
      k = ((RecyclerView.ViewHolder)localObject1).itemView.getRight() - (paramInt1 + m);
      if ((k >= 0) || (((RecyclerView.ViewHolder)localObject1).itemView.getRight() <= paramViewHolder.itemView.getRight())) {
        break label346;
      }
      k = Math.abs(k);
      if (k <= i) {
        break label346;
      }
      i = k;
      localObject2 = localObject1;
      label143:
      if (i1 >= 0) {
        break label359;
      }
      k = ((RecyclerView.ViewHolder)localObject1).itemView.getLeft() - paramInt1;
      if ((k <= 0) || (((RecyclerView.ViewHolder)localObject1).itemView.getLeft() >= paramViewHolder.itemView.getLeft())) {
        break label359;
      }
      k = Math.abs(k);
      if (k <= i) {
        break label359;
      }
      localObject2 = localObject1;
      i = k;
    }
    label346:
    label359:
    for (;;)
    {
      if (i2 < 0)
      {
        k = ((RecyclerView.ViewHolder)localObject1).itemView.getTop() - paramInt2;
        if ((k > 0) && (((RecyclerView.ViewHolder)localObject1).itemView.getTop() < paramViewHolder.itemView.getTop()))
        {
          k = Math.abs(k);
          if (k > i)
          {
            localObject2 = localObject1;
            i = k;
          }
        }
      }
      for (;;)
      {
        if (i2 > 0)
        {
          k = ((RecyclerView.ViewHolder)localObject1).itemView.getBottom() - (paramInt2 + n);
          if ((k < 0) && (((RecyclerView.ViewHolder)localObject1).itemView.getBottom() > paramViewHolder.itemView.getBottom()))
          {
            k = Math.abs(k);
            if (k > i) {
              i = k;
            }
          }
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          break;
          return localObject2;
          break label143;
          localObject1 = localObject2;
        }
      }
    }
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
    paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
    if (paramInt2 == 0) {
      return paramInt1 | i >> 2;
    }
    return paramInt1 | i >> 1 & 0xFFCFCFCF | (i >> 1 & 0x303030) >> 2;
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
    float f1 = 1.0F;
    paramInt3 = getMaxDragScroll(paramRecyclerView);
    int i = Math.abs(paramInt2);
    int j = (int)Math.signum(paramInt2);
    float f2 = Math.min(1.0F, i * 1.0F / paramInt1);
    paramInt1 = (int)(paramInt3 * j * sDragViewScrollCapInterpolator.getInterpolation(f2));
    if (paramLong > 2000L) {}
    for (;;)
    {
      f2 = paramInt1;
      paramInt3 = (int)(sDragScrollInterpolator.getInterpolation(f1) * f2);
      paramInt1 = paramInt3;
      if (paramInt3 == 0)
      {
        if (paramInt2 <= 0) {
          break;
        }
        paramInt1 = 1;
      }
      return paramInt1;
      f1 = (float)paramLong / 2000.0F;
    }
    return -1;
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
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
      int k = paramCanvas.save();
      onChildDrawOver(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
      paramCanvas.restoreToCount(k);
      i += 1;
    }
    if (paramViewHolder != null)
    {
      i = paramCanvas.save();
      onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
      paramCanvas.restoreToCount(i);
    }
    paramInt = 0;
    i = j - 1;
    if (i >= 0)
    {
      paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
      if ((paramCanvas.mEnded) && (!paramCanvas.mIsPendingCleanup)) {
        paramList.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break;
      if (!paramCanvas.mEnded)
      {
        paramInt = 1;
        continue;
        if (paramInt != 0) {
          paramRecyclerView.invalidate();
        }
        return;
      }
    }
  }
  
  public abstract boolean onMove(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2);
  
  public void onMoved(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, int paramInt1, @NonNull RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler)) {
      ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop(paramViewHolder1.itemView, paramViewHolder2.itemView, paramInt3, paramInt4);
    }
    do
    {
      do
      {
        return;
        if (localLayoutManager.canScrollHorizontally())
        {
          if (localLayoutManager.getDecoratedLeft(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingLeft()) {
            paramRecyclerView.scrollToPosition(paramInt2);
          }
          if (localLayoutManager.getDecoratedRight(paramViewHolder2.itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
            paramRecyclerView.scrollToPosition(paramInt2);
          }
        }
      } while (!localLayoutManager.canScrollVertically());
      if (localLayoutManager.getDecoratedTop(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingTop()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
    } while (localLayoutManager.getDecoratedBottom(paramViewHolder2.itemView) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    paramRecyclerView.scrollToPosition(paramInt2);
  }
  
  public void onSelectedChanged(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null) {
      ItemTouchUIUtilImpl.INSTANCE.onSelected(paramViewHolder.itemView);
    }
  }
  
  public abstract void onSwiped(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.Callback
 * JD-Core Version:    0.7.0.1
 */