package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import java.util.Locale;

final class ScrollEventAdapter
  extends RecyclerView.OnScrollListener
{
  private static final int NO_POSITION = -1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
  private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
  private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
  private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
  private int mAdapterState;
  private ViewPager2.OnPageChangeCallback mCallback;
  private boolean mDataSetChangeHappened;
  private boolean mDispatchSelected;
  private int mDragStartPosition;
  private boolean mFakeDragging;
  @NonNull
  private final LinearLayoutManager mLayoutManager;
  @NonNull
  private final RecyclerView mRecyclerView;
  private boolean mScrollHappened;
  private int mScrollState;
  private ScrollEventAdapter.ScrollEventValues mScrollValues;
  private int mTarget;
  @NonNull
  private final ViewPager2 mViewPager;
  
  ScrollEventAdapter(@NonNull ViewPager2 paramViewPager2)
  {
    this.mViewPager = paramViewPager2;
    this.mRecyclerView = this.mViewPager.mRecyclerView;
    this.mLayoutManager = ((LinearLayoutManager)this.mRecyclerView.getLayoutManager());
    this.mScrollValues = new ScrollEventAdapter.ScrollEventValues();
    resetState();
  }
  
  private void dispatchScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager2.OnPageChangeCallback localOnPageChangeCallback = this.mCallback;
    if (localOnPageChangeCallback != null) {
      localOnPageChangeCallback.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void dispatchSelected(int paramInt)
  {
    ViewPager2.OnPageChangeCallback localOnPageChangeCallback = this.mCallback;
    if (localOnPageChangeCallback != null) {
      localOnPageChangeCallback.onPageSelected(paramInt);
    }
  }
  
  private void dispatchStateChanged(int paramInt)
  {
    if ((this.mAdapterState == 3) && (this.mScrollState == 0)) {
      return;
    }
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    ViewPager2.OnPageChangeCallback localOnPageChangeCallback = this.mCallback;
    if (localOnPageChangeCallback != null) {
      localOnPageChangeCallback.onPageScrollStateChanged(paramInt);
    }
  }
  
  private int getPosition()
  {
    return this.mLayoutManager.findFirstVisibleItemPosition();
  }
  
  private boolean isInAnyDraggingState()
  {
    int i = this.mAdapterState;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 4) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void resetState()
  {
    this.mAdapterState = 0;
    this.mScrollState = 0;
    this.mScrollValues.reset();
    this.mDragStartPosition = -1;
    this.mTarget = -1;
    this.mDispatchSelected = false;
    this.mScrollHappened = false;
    this.mFakeDragging = false;
    this.mDataSetChangeHappened = false;
  }
  
  private void startDrag(boolean paramBoolean)
  {
    this.mFakeDragging = paramBoolean;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 1;
    }
    this.mAdapterState = i;
    int i = this.mTarget;
    if (i != -1)
    {
      this.mDragStartPosition = i;
      this.mTarget = -1;
    }
    else if (this.mDragStartPosition == -1)
    {
      this.mDragStartPosition = getPosition();
    }
    dispatchStateChanged(1);
  }
  
  private void updateScrollEventValues()
  {
    ScrollEventAdapter.ScrollEventValues localScrollEventValues = this.mScrollValues;
    localScrollEventValues.mPosition = this.mLayoutManager.findFirstVisibleItemPosition();
    if (localScrollEventValues.mPosition == -1)
    {
      localScrollEventValues.reset();
      return;
    }
    View localView = this.mLayoutManager.findViewByPosition(localScrollEventValues.mPosition);
    if (localView == null)
    {
      localScrollEventValues.reset();
      return;
    }
    int i3 = this.mLayoutManager.getLeftDecorationWidth(localView);
    int i2 = this.mLayoutManager.getRightDecorationWidth(localView);
    int i1 = this.mLayoutManager.getTopDecorationHeight(localView);
    int n = this.mLayoutManager.getBottomDecorationHeight(localView);
    Object localObject = localView.getLayoutParams();
    int k = i3;
    int m = i2;
    int j = i1;
    int i = n;
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      k = i3 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      m = i2 + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      j = i1 + ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      i = n + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    i1 = localView.getHeight();
    n = m + (localView.getWidth() + k);
    if (this.mLayoutManager.getOrientation() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      k = localView.getLeft() - k - this.mRecyclerView.getPaddingLeft();
      i = k;
      j = n;
      if (this.mViewPager.isRtl())
      {
        i = -k;
        j = n;
      }
    }
    else
    {
      k = localView.getTop() - j - this.mRecyclerView.getPaddingTop();
      j = i1 + j + i;
      i = k;
    }
    localScrollEventValues.mOffsetPx = (-i);
    if (localScrollEventValues.mOffsetPx < 0)
    {
      if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
      }
      throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[] { Integer.valueOf(localScrollEventValues.mOffsetPx) }));
    }
    float f;
    if (j == 0) {
      f = 0.0F;
    } else {
      f = localScrollEventValues.mOffsetPx / j;
    }
    localScrollEventValues.mOffset = f;
  }
  
  double getRelativeScrollPosition()
  {
    updateScrollEventValues();
    double d1 = this.mScrollValues.mPosition;
    double d2 = this.mScrollValues.mOffset;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 + d2;
  }
  
  int getScrollState()
  {
    return this.mScrollState;
  }
  
  boolean isDragging()
  {
    return this.mScrollState == 1;
  }
  
  boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  boolean isIdle()
  {
    return this.mScrollState == 0;
  }
  
  void notifyBeginFakeDrag()
  {
    this.mAdapterState = 4;
    startDrag(true);
  }
  
  void notifyDataSetChangeHappened()
  {
    this.mDataSetChangeHappened = true;
  }
  
  void notifyEndFakeDrag()
  {
    if ((isDragging()) && (!this.mFakeDragging)) {
      return;
    }
    this.mFakeDragging = false;
    updateScrollEventValues();
    if (this.mScrollValues.mOffsetPx == 0)
    {
      if (this.mScrollValues.mPosition != this.mDragStartPosition) {
        dispatchSelected(this.mScrollValues.mPosition);
      }
      dispatchStateChanged(0);
      resetState();
      return;
    }
    dispatchStateChanged(2);
  }
  
  void notifyProgrammaticScroll(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    this.mAdapterState = i;
    int i = 0;
    this.mFakeDragging = false;
    if (this.mTarget != paramInt) {
      i = 1;
    }
    this.mTarget = paramInt;
    dispatchStateChanged(2);
    if (i != 0) {
      dispatchSelected(paramInt);
    }
  }
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    int i = this.mAdapterState;
    int j = 1;
    if (((i != 1) || (this.mScrollState != 1)) && (paramInt == 1))
    {
      startDrag(false);
      return;
    }
    if ((isInAnyDraggingState()) && (paramInt == 2))
    {
      if (this.mScrollHappened)
      {
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
      }
      return;
    }
    if ((isInAnyDraggingState()) && (paramInt == 0))
    {
      updateScrollEventValues();
      if (!this.mScrollHappened)
      {
        i = j;
        if (this.mScrollValues.mPosition != -1)
        {
          dispatchScrolled(this.mScrollValues.mPosition, 0.0F, 0);
          i = j;
        }
      }
      else if (this.mScrollValues.mOffsetPx == 0)
      {
        i = j;
        if (this.mDragStartPosition != this.mScrollValues.mPosition)
        {
          dispatchSelected(this.mScrollValues.mPosition);
          i = j;
        }
      }
      else
      {
        i = 0;
      }
      if (i != 0)
      {
        dispatchStateChanged(0);
        resetState();
      }
    }
    if ((this.mAdapterState == 2) && (paramInt == 0) && (this.mDataSetChangeHappened))
    {
      updateScrollEventValues();
      if (this.mScrollValues.mOffsetPx == 0)
      {
        if (this.mTarget != this.mScrollValues.mPosition)
        {
          if (this.mScrollValues.mPosition == -1) {
            paramInt = 0;
          } else {
            paramInt = this.mScrollValues.mPosition;
          }
          dispatchSelected(paramInt);
        }
        dispatchStateChanged(0);
        resetState();
      }
    }
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mScrollHappened = true;
    updateScrollEventValues();
    if (this.mDispatchSelected)
    {
      this.mDispatchSelected = false;
      if (paramInt2 <= 0) {
        if (paramInt2 == 0)
        {
          int i;
          if (paramInt1 < 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == this.mViewPager.isRtl()) {}
        }
        else
        {
          paramInt1 = 0;
          break label64;
        }
      }
      paramInt1 = 1;
      label64:
      if ((paramInt1 != 0) && (this.mScrollValues.mOffsetPx != 0)) {
        paramInt1 = this.mScrollValues.mPosition + 1;
      } else {
        paramInt1 = this.mScrollValues.mPosition;
      }
      this.mTarget = paramInt1;
      paramInt1 = this.mDragStartPosition;
      paramInt2 = this.mTarget;
      if (paramInt1 != paramInt2) {
        dispatchSelected(paramInt2);
      }
    }
    else if (this.mAdapterState == 0)
    {
      paramInt2 = this.mScrollValues.mPosition;
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = 0;
      }
      dispatchSelected(paramInt1);
    }
    if (this.mScrollValues.mPosition == -1) {
      paramInt1 = 0;
    } else {
      paramInt1 = this.mScrollValues.mPosition;
    }
    dispatchScrolled(paramInt1, this.mScrollValues.mOffset, this.mScrollValues.mOffsetPx);
    paramInt1 = this.mScrollValues.mPosition;
    paramInt2 = this.mTarget;
    if (((paramInt1 == paramInt2) || (paramInt2 == -1)) && (this.mScrollValues.mOffsetPx == 0) && (this.mScrollState != 1))
    {
      dispatchStateChanged(0);
      resetState();
    }
  }
  
  void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.mCallback = paramOnPageChangeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ScrollEventAdapter
 * JD-Core Version:    0.7.0.1
 */