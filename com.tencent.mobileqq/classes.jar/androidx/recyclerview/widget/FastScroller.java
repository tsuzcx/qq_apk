package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

@VisibleForTesting
class FastScroller
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnItemTouchListener
{
  private static final int ANIMATION_STATE_FADING_IN = 1;
  private static final int ANIMATION_STATE_FADING_OUT = 3;
  private static final int ANIMATION_STATE_IN = 2;
  private static final int ANIMATION_STATE_OUT = 0;
  private static final int DRAG_NONE = 0;
  private static final int DRAG_X = 1;
  private static final int DRAG_Y = 2;
  private static final int[] EMPTY_STATE_SET = new int[0];
  private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
  private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
  private static final int HIDE_DURATION_MS = 500;
  private static final int[] PRESSED_STATE_SET = { 16842919 };
  private static final int SCROLLBAR_FULL_OPAQUE = 255;
  private static final int SHOW_DURATION_MS = 500;
  private static final int STATE_DRAGGING = 2;
  private static final int STATE_HIDDEN = 0;
  private static final int STATE_VISIBLE = 1;
  int mAnimationState = 0;
  private int mDragState = 0;
  private final Runnable mHideRunnable = new FastScroller.1(this);
  @VisibleForTesting
  float mHorizontalDragX;
  private final int[] mHorizontalRange = new int[2];
  @VisibleForTesting
  int mHorizontalThumbCenterX;
  private final StateListDrawable mHorizontalThumbDrawable;
  private final int mHorizontalThumbHeight;
  @VisibleForTesting
  int mHorizontalThumbWidth;
  private final Drawable mHorizontalTrackDrawable;
  private final int mHorizontalTrackHeight;
  private final int mMargin;
  private boolean mNeedHorizontalScrollbar = false;
  private boolean mNeedVerticalScrollbar = false;
  private final RecyclerView.OnScrollListener mOnScrollListener = new FastScroller.2(this);
  private RecyclerView mRecyclerView;
  private int mRecyclerViewHeight = 0;
  private int mRecyclerViewWidth = 0;
  private final int mScrollbarMinimumRange;
  final ValueAnimator mShowHideAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private int mState = 0;
  @VisibleForTesting
  float mVerticalDragY;
  private final int[] mVerticalRange = new int[2];
  @VisibleForTesting
  int mVerticalThumbCenterY;
  final StateListDrawable mVerticalThumbDrawable;
  @VisibleForTesting
  int mVerticalThumbHeight;
  private final int mVerticalThumbWidth;
  final Drawable mVerticalTrackDrawable;
  private final int mVerticalTrackWidth;
  
  FastScroller(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVerticalThumbDrawable = paramStateListDrawable1;
    this.mVerticalTrackDrawable = paramDrawable1;
    this.mHorizontalThumbDrawable = paramStateListDrawable2;
    this.mHorizontalTrackDrawable = paramDrawable2;
    this.mVerticalThumbWidth = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.mVerticalTrackWidth = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.mHorizontalThumbHeight = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.mHorizontalTrackHeight = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.mScrollbarMinimumRange = paramInt2;
    this.mMargin = paramInt3;
    this.mVerticalThumbDrawable.setAlpha(255);
    this.mVerticalTrackDrawable.setAlpha(255);
    this.mShowHideAnimator.addListener(new FastScroller.AnimatorListener(this));
    this.mShowHideAnimator.addUpdateListener(new FastScroller.AnimatorUpdater(this));
    attachToRecyclerView(paramRecyclerView);
  }
  
  private void cancelHide()
  {
    this.mRecyclerView.removeCallbacks(this.mHideRunnable);
  }
  
  private void destroyCallbacks()
  {
    this.mRecyclerView.removeItemDecoration(this);
    this.mRecyclerView.removeOnItemTouchListener(this);
    this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
    cancelHide();
  }
  
  private void drawHorizontalScrollbar(Canvas paramCanvas)
  {
    int i = this.mRecyclerViewHeight - this.mHorizontalThumbHeight;
    int j = this.mHorizontalThumbCenterX - this.mHorizontalThumbWidth / 2;
    this.mHorizontalThumbDrawable.setBounds(0, 0, this.mHorizontalThumbWidth, this.mHorizontalThumbHeight);
    this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
    paramCanvas.translate(0.0F, i);
    this.mHorizontalTrackDrawable.draw(paramCanvas);
    paramCanvas.translate(j, 0.0F);
    this.mHorizontalThumbDrawable.draw(paramCanvas);
    paramCanvas.translate(-j, -i);
  }
  
  private void drawVerticalScrollbar(Canvas paramCanvas)
  {
    int i = this.mRecyclerViewWidth - this.mVerticalThumbWidth;
    int j = this.mVerticalThumbCenterY - this.mVerticalThumbHeight / 2;
    this.mVerticalThumbDrawable.setBounds(0, 0, this.mVerticalThumbWidth, this.mVerticalThumbHeight);
    this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
    if (isLayoutRTL())
    {
      this.mVerticalTrackDrawable.draw(paramCanvas);
      paramCanvas.translate(this.mVerticalThumbWidth, j);
      paramCanvas.scale(-1.0F, 1.0F);
      this.mVerticalThumbDrawable.draw(paramCanvas);
      paramCanvas.scale(1.0F, 1.0F);
      paramCanvas.translate(-this.mVerticalThumbWidth, -j);
      return;
    }
    paramCanvas.translate(i, 0.0F);
    this.mVerticalTrackDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, j);
    this.mVerticalThumbDrawable.draw(paramCanvas);
    paramCanvas.translate(-i, -j);
  }
  
  private int[] getHorizontalRange()
  {
    this.mHorizontalRange[0] = this.mMargin;
    this.mHorizontalRange[1] = (this.mRecyclerViewWidth - this.mMargin);
    return this.mHorizontalRange;
  }
  
  private int[] getVerticalRange()
  {
    this.mVerticalRange[0] = this.mMargin;
    this.mVerticalRange[1] = (this.mRecyclerViewHeight - this.mMargin);
    return this.mVerticalRange;
  }
  
  private void horizontalScrollTo(float paramFloat)
  {
    int[] arrayOfInt = getHorizontalRange();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.mHorizontalThumbCenterX - paramFloat) < 2.0F) {
      return;
    }
    int i = scrollTo(this.mHorizontalDragX, paramFloat, arrayOfInt, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
    if (i != 0) {
      this.mRecyclerView.scrollBy(i, 0);
    }
    this.mHorizontalDragX = paramFloat;
  }
  
  private boolean isLayoutRTL()
  {
    return ViewCompat.getLayoutDirection(this.mRecyclerView) == 1;
  }
  
  private void resetHideDelay(int paramInt)
  {
    cancelHide();
    this.mRecyclerView.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private int scrollTo(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i == 0) {}
    do
    {
      return 0;
      paramFloat1 = (paramFloat2 - paramFloat1) / i;
      paramInt1 -= paramInt3;
      paramInt3 = (int)(paramFloat1 * paramInt1);
      paramInt2 += paramInt3;
    } while ((paramInt2 >= paramInt1) || (paramInt2 < 0));
    return paramInt3;
  }
  
  private void setupCallbacks()
  {
    this.mRecyclerView.addItemDecoration(this);
    this.mRecyclerView.addOnItemTouchListener(this);
    this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
  }
  
  private void verticalScrollTo(float paramFloat)
  {
    int[] arrayOfInt = getVerticalRange();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.mVerticalThumbCenterY - paramFloat) < 2.0F) {
      return;
    }
    int i = scrollTo(this.mVerticalDragY, paramFloat, arrayOfInt, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
    if (i != 0) {
      this.mRecyclerView.scrollBy(0, i);
    }
    this.mVerticalDragY = paramFloat;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null) {
        destroyCallbacks();
      }
      this.mRecyclerView = paramRecyclerView;
    } while (this.mRecyclerView == null);
    setupCallbacks();
  }
  
  @VisibleForTesting
  Drawable getHorizontalThumbDrawable()
  {
    return this.mHorizontalThumbDrawable;
  }
  
  @VisibleForTesting
  Drawable getHorizontalTrackDrawable()
  {
    return this.mHorizontalTrackDrawable;
  }
  
  @VisibleForTesting
  Drawable getVerticalThumbDrawable()
  {
    return this.mVerticalThumbDrawable;
  }
  
  @VisibleForTesting
  Drawable getVerticalTrackDrawable()
  {
    return this.mVerticalTrackDrawable;
  }
  
  @VisibleForTesting
  void hide(int paramInt)
  {
    switch (this.mAnimationState)
    {
    default: 
      return;
    case 1: 
      this.mShowHideAnimator.cancel();
    }
    this.mAnimationState = 3;
    this.mShowHideAnimator.setFloatValues(new float[] { ((Float)this.mShowHideAnimator.getAnimatedValue()).floatValue(), 0.0F });
    this.mShowHideAnimator.setDuration(paramInt);
    this.mShowHideAnimator.start();
  }
  
  public boolean isDragging()
  {
    return this.mState == 2;
  }
  
  @VisibleForTesting
  boolean isPointInsideHorizontalThumb(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.mRecyclerViewHeight - this.mHorizontalThumbHeight) && (paramFloat1 >= this.mHorizontalThumbCenterX - this.mHorizontalThumbWidth / 2) && (paramFloat1 <= this.mHorizontalThumbCenterX + this.mHorizontalThumbWidth / 2);
  }
  
  @VisibleForTesting
  boolean isPointInsideVerticalThumb(float paramFloat1, float paramFloat2)
  {
    if (isLayoutRTL())
    {
      if (paramFloat1 > this.mVerticalThumbWidth / 2) {}
    }
    else {
      while (paramFloat1 >= this.mRecyclerViewWidth - this.mVerticalThumbWidth)
      {
        if ((paramFloat2 < this.mVerticalThumbCenterY - this.mVerticalThumbHeight / 2) || (paramFloat2 > this.mVerticalThumbCenterY + this.mVerticalThumbHeight / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  @VisibleForTesting
  boolean isVisible()
  {
    return this.mState == 1;
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((this.mRecyclerViewWidth != this.mRecyclerView.getWidth()) || (this.mRecyclerViewHeight != this.mRecyclerView.getHeight()))
    {
      this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
      this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
      setState(0);
    }
    do
    {
      do
      {
        return;
      } while (this.mAnimationState == 0);
      if (this.mNeedVerticalScrollbar) {
        drawVerticalScrollbar(paramCanvas);
      }
    } while (!this.mNeedHorizontalScrollbar);
    drawHorizontalScrollbar(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent)
  {
    if (this.mState == 1)
    {
      bool1 = isPointInsideVerticalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool2 = isPointInsideHorizontalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool1) || (bool2))) {
        if (bool2)
        {
          this.mDragState = 1;
          this.mHorizontalDragX = ((int)paramMotionEvent.getX());
          setState(2);
        }
      }
    }
    while (this.mState == 2)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        return true;
        if (bool1)
        {
          this.mDragState = 2;
          this.mVerticalDragY = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent)
  {
    if (this.mState == 0) {}
    do
    {
      do
      {
        boolean bool1;
        boolean bool2;
        do
        {
          return;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          bool1 = isPointInsideVerticalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
          bool2 = isPointInsideHorizontalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
        } while ((!bool1) && (!bool2));
        if (bool2)
        {
          this.mDragState = 1;
          this.mHorizontalDragX = ((int)paramMotionEvent.getX());
        }
        for (;;)
        {
          setState(2);
          return;
          if (bool1)
          {
            this.mDragState = 2;
            this.mVerticalDragY = ((int)paramMotionEvent.getY());
          }
        }
        if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
        {
          this.mVerticalDragY = 0.0F;
          this.mHorizontalDragX = 0.0F;
          setState(1);
          this.mDragState = 0;
          return;
        }
      } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
      show();
      if (this.mDragState == 1) {
        horizontalScrollTo(paramMotionEvent.getX());
      }
    } while (this.mDragState != 2);
    verticalScrollTo(paramMotionEvent.getY());
  }
  
  void requestRedraw()
  {
    this.mRecyclerView.invalidate();
  }
  
  void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
      cancelHide();
    }
    if (paramInt == 0)
    {
      requestRedraw();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label80;
      }
      this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
      resetHideDelay(1200);
    }
    for (;;)
    {
      this.mState = paramInt;
      return;
      show();
      break;
      label80:
      if (paramInt == 1) {
        resetHideDelay(1500);
      }
    }
  }
  
  public void show()
  {
    switch (this.mAnimationState)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.mShowHideAnimator.cancel();
    }
    this.mAnimationState = 1;
    this.mShowHideAnimator.setFloatValues(new float[] { ((Float)this.mShowHideAnimator.getAnimatedValue()).floatValue(), 1.0F });
    this.mShowHideAnimator.setDuration(500L);
    this.mShowHideAnimator.setStartDelay(0L);
    this.mShowHideAnimator.start();
  }
  
  void updateScrollPosition(int paramInt1, int paramInt2)
  {
    int i = this.mRecyclerView.computeVerticalScrollRange();
    int j = this.mRecyclerViewHeight;
    boolean bool;
    int k;
    int m;
    if ((i - j > 0) && (this.mRecyclerViewHeight >= this.mScrollbarMinimumRange))
    {
      bool = true;
      this.mNeedVerticalScrollbar = bool;
      k = this.mRecyclerView.computeHorizontalScrollRange();
      m = this.mRecyclerViewWidth;
      if ((k - m <= 0) || (this.mRecyclerViewWidth < this.mScrollbarMinimumRange)) {
        break label117;
      }
      bool = true;
      label78:
      this.mNeedHorizontalScrollbar = bool;
      if ((this.mNeedVerticalScrollbar) || (this.mNeedHorizontalScrollbar)) {
        break label123;
      }
      if (this.mState != 0) {
        setState(0);
      }
    }
    label117:
    label123:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label78;
      if (this.mNeedVerticalScrollbar)
      {
        this.mVerticalThumbCenterY = ((int)((paramInt2 + j / 2.0F) * j / i));
        this.mVerticalThumbHeight = Math.min(j, j * j / i);
      }
      if (this.mNeedHorizontalScrollbar)
      {
        this.mHorizontalThumbCenterX = ((int)((paramInt1 + m / 2.0F) * m / k));
        this.mHorizontalThumbWidth = Math.min(m, m * m / k);
      }
    } while ((this.mState != 0) && (this.mState != 1));
    setState(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.FastScroller
 * JD-Core Version:    0.7.0.1
 */