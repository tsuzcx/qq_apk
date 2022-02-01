package com.tencent.hippy.qq.tuwen.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import com.tencent.hippy.qq.tuwen.util.ReflectWrapper;
import com.tencent.hippy.qq.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.mtt.hippy.views.list.HippyListView.OnScrollEvent;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Recycler;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NSHippyListView
  extends HippyTKDListView
  implements NestedScrollingChild3
{
  private static final String TAG = "NSHippyListView";
  private NSHippyListView.AdjustHeightObserver adjustHeightObserver;
  private int mMaxFlingVelocity;
  private int mMinFlingVelocity;
  private final int[] mNestedOffsets = new int[2];
  private final int[] mReusableIntPair = new int[2];
  private final int[] mReusableIntPair2 = new int[2];
  private final int[] mScrollOffset = new int[2];
  private NestedScrollingChildHelper mScrollingChildHelper;
  private boolean needAdjustHeight;
  private ReflectWrapper reflectWrapper;
  private final int[] tmpResult = new int[2];
  
  public NSHippyListView(Context paramContext)
  {
    super(paramContext);
    init();
    QLog.d("NSHippyListView", 1, "NSHippyListView new instance");
  }
  
  private int adjustVelocity(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean)
    {
      i = paramInt;
      if (Math.abs(paramInt) >= this.mMinFlingVelocity) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  private int calTouchAxes(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (Math.abs(paramInt1) > this.mTouchSlop))
    {
      int i = this.mTouchSlop;
      if (paramInt1 < 0) {}
      for (paramInt1 = -1;; paramInt1 = 1) {
        return paramInt1 * i + paramInt2;
      }
    }
    return 2147483647;
  }
  
  private boolean callSuperOnTouchEvent(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 1) && (paramInt != 3);
  }
  
  private int computeDistanceWhenSpringBackOnLeftOrTop(int paramInt1, int paramInt2)
  {
    int j = getSpringBackMaxDistance();
    int i = paramInt1;
    if (paramInt2 + paramInt1 <= -j) {
      i = -paramInt2 - j;
    }
    return i;
  }
  
  private int computeDistanceWhenSpringBackOnRightOrBottom(int paramInt1, int paramInt2, Scroller paramScroller, int paramInt3)
  {
    if (this.mState.mTotalHeight <= paramInt3) {}
    for (paramInt3 = 0;; paramInt3 = this.mState.mTotalHeight - paramInt3)
    {
      int j = getSpringBackMaxDistance();
      int i = paramInt1;
      if (paramInt2 + paramInt1 >= paramInt3 + j)
      {
        i = paramInt3 + -paramInt2 + j;
        finishScroller(paramScroller);
      }
      return i;
    }
  }
  
  private int computeDistanceWithoutOverScrollWhenReachRightOrBottom(int paramInt1, int paramInt2, Scroller paramScroller, int paramInt3)
  {
    if (this.mState.mTotalHeight <= paramInt3) {}
    for (paramInt1 = 0;; paramInt1 = this.mState.mTotalHeight - paramInt3 - paramInt2)
    {
      finishScroller(paramScroller);
      return paramInt1;
    }
  }
  
  private int computeDx(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (this.mOffsetX + paramInt < 0) {
      i = computeDxWhenReachLeftEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2, paramBoolean3);
    }
    do
    {
      return i;
      i = paramInt;
    } while (this.mOffsetX + paramInt <= this.mState.mTotalHeight - getWidth());
    return computeDxWhenReachRightEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2);
  }
  
  private int[] computeDxDy(int paramInt1, int paramInt2, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    int[] arrayOfInt = this.tmpResult;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    boolean bool = changeUpOverScrollEnableOnComputeDxDy(paramInt1, paramInt2, paramBoolean1, paramScroller, paramBoolean2, this.mUpOverScrollEnabled);
    int i = paramInt1;
    if (paramInt1 != 0) {
      i = computeDx(paramInt1, paramBoolean1, paramScroller, paramBoolean2, bool);
    }
    paramInt1 = paramInt2;
    if (paramInt2 != 0) {
      paramInt1 = computeDy(paramInt2, paramBoolean1, paramScroller, paramBoolean2, bool);
    }
    arrayOfInt[0] = i;
    arrayOfInt[1] = paramInt1;
    return arrayOfInt;
  }
  
  private int computeDxWhenReachLeftEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      if (this.mOffsetX >= 0) {
        break label53;
      }
      paramInt = computeLeftOrTopWhenOverScroll(paramInt, paramBoolean2);
    }
    label53:
    for (;;)
    {
      int i = paramInt;
      if (paramBoolean1) {
        i = computeDistanceWhenSpringBackOnLeftOrTop(paramInt, this.mOffsetX);
      }
      return i;
      paramInt = -this.mOffsetX;
      finishScroller(paramScroller);
      return paramInt;
    }
  }
  
  private int computeDxWhenReachRightEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    if (this.mDownOverScrollEnabled)
    {
      if (this.mOffsetX <= this.mState.mTotalHeight - getWidth()) {
        break label74;
      }
      paramInt = computeRightOrBottomWhenOverScroll(paramInt, paramBoolean2);
    }
    label74:
    for (;;)
    {
      int i = paramInt;
      if (paramBoolean1) {
        i = computeDistanceWhenSpringBackOnRightOrBottom(paramInt, this.mOffsetX, paramScroller, getWidth());
      }
      return i;
      return computeDistanceWithoutOverScrollWhenReachRightOrBottom(paramInt, this.mOffsetX, paramScroller, getWidth());
    }
  }
  
  private int computeDy(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (this.mOffsetY + paramInt <= 0) {
      i = computeDyWhenReadTopEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2, paramBoolean3);
    }
    do
    {
      return i;
      if (this.mOffsetY + paramInt > this.mState.mTotalHeight - getHeight()) {
        return computeDyWhenReachBottomEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2);
      }
      i = paramInt;
    } while (!needStopAtTitle());
    return computeDyWhenNeedStopAtTitle(paramInt);
  }
  
  private int computeDyWhenNeedStopAtTitle(int paramInt)
  {
    Integer localInteger2 = (Integer)this.reflectWrapper.invokeMethodWithPrimaryType(this, "getStopPosition", new Object[0]);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = paramInt;
    if (this.mOffsetY + paramInt < localInteger1.intValue()) {
      i = localInteger1.intValue() - this.mOffsetY;
    }
    return i;
  }
  
  private int computeDyWhenReachBottomEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    if (this.mDownOverScrollEnabled)
    {
      if (this.mOffsetY <= this.mState.mTotalHeight - getHeight()) {
        break label74;
      }
      paramInt = computeRightOrBottomWhenOverScroll(paramInt, paramBoolean2);
    }
    label74:
    for (;;)
    {
      int i = paramInt;
      if (paramBoolean1) {
        i = computeDistanceWhenSpringBackOnRightOrBottom(paramInt, this.mOffsetY, paramScroller, getHeight());
      }
      return i;
      return computeDistanceWithoutOverScrollWhenReachRightOrBottom(paramInt, this.mOffsetY, paramScroller, getHeight());
    }
  }
  
  private int computeDyWhenReadTopEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      if (this.mOffsetY >= 0) {
        break label65;
      }
      paramInt = computeLeftOrTopWhenOverScroll(paramInt, paramBoolean2);
    }
    label65:
    for (;;)
    {
      int i = paramInt;
      if (paramBoolean1) {
        i = computeDistanceWhenSpringBackOnLeftOrTop(paramInt, this.mOffsetY);
      }
      return i;
      i = this.mOffsetY;
      int j = -this.mOffsetY;
      notifyReachTopEdgeEvent(paramScroller, paramInt + i);
      return j;
    }
  }
  
  private static int computeLeftOrTopWhenOverScroll(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      i = paramInt;
      if (paramBoolean) {
        i = paramInt / 3;
      }
    }
    return i;
  }
  
  private static int computeRightOrBottomWhenOverScroll(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramBoolean) {
        i = paramInt / 3;
      }
    }
    return i;
  }
  
  private void doScrollBy(int paramInt1, int paramInt2)
  {
    if (scrollBy(paramInt1, paramInt2, null)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void finishScroller(Scroller paramScroller)
  {
    if (paramScroller != null) {
      paramScroller.forceFinished(true);
    }
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null) {
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return this.mScrollingChildHelper;
  }
  
  private void init()
  {
    setOverScrollEnabled(false);
    this.reflectWrapper = new ReflectWrapper();
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    setNestedScrollingEnabled(true);
    setFieldValue("mViewFlinger", new NSHippyListView.MyViewFlinger(this));
    setNeedAdjustHeight(true);
  }
  
  private boolean needStopAtTitle()
  {
    return (Boolean.TRUE.equals(getFieldValue("mStopAtTitle"))) && (this.mNeedStopAtTitleIndex != -1);
  }
  
  private void notifyReachTopEdgeEvent(Scroller paramScroller, int paramInt)
  {
    if ((paramScroller != null) && (paramScroller.isFling())) {
      onFlingToTopEdge(paramScroller.getCurrVelocity(), paramInt);
    }
    while (!Boolean.TRUE.equals(getFieldValue("mIsTouching"))) {
      return;
    }
    onScrollToTopEdge();
  }
  
  private void onTouchMove(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool3 = false;
    if ((!this.mBlockScroll) && (this.mLayout.canScrollHorizontally())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (!this.mBlockScroll)
      {
        bool2 = bool3;
        if (this.mLayout.canScrollVertically()) {
          bool2 = true;
        }
      }
      setFieldValue("mTouchEventState", Integer.valueOf(2));
      setFieldValue("mIsTouching", Boolean.valueOf(true));
      int i = (int)(paramMotionEvent.getX(paramInt) + 0.5F);
      paramInt = (int)(paramMotionEvent.getY(paramInt) + 0.5F);
      if (this.mScrollState != 1) {
        processTouchMoveOnNotDragState(i, paramInt, bool1, bool2);
      }
      if (this.mScrollState == 1) {
        processTouchMoveOnDragState(i, paramInt, bool1, bool2);
      }
      return;
    }
  }
  
  private void onTouchUpOrCancel(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    this.mVelocityTracker.addMovement(paramMotionEvent2);
    setFieldValue("mTouchEventState", Integer.valueOf(1));
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
    performFling();
    tryNotifyTouchEvent(paramMotionEvent1);
    handleCustomClickEvent(paramMotionEvent1);
    this.mVelocityTracker.clear();
    releaseGlows(true, true);
    stopNestedScroll(0);
  }
  
  private void performFling()
  {
    float f2 = 0.0F;
    int j = 1;
    float f1;
    if (this.mLayout.canScrollHorizontally())
    {
      f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
      if (this.mLayout.canScrollVertically()) {
        f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
      }
      if (TKDTuWenCommentUtil.isAllZero(new double[] { f1, f2 })) {
        break label115;
      }
      i = 1;
      label72:
      if ((i == 0) || (!fling((int)f1, (int)f2))) {
        break label120;
      }
    }
    label115:
    label120:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        reflectResetStopAtTitle();
        reflectSetScrollState(0);
        handleOnTouchUpEventWhenStartFling(f1, f2);
      }
      return;
      f1 = 0.0F;
      break;
      i = 0;
      break label72;
    }
  }
  
  private void processTouchMoveOnDragState(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.mLastTouchX - paramInt1;
    int i = this.mLastTouchY - paramInt2;
    this.mReusableIntPair[0] = 0;
    this.mReusableIntPair[1] = 0;
    int k;
    int m;
    if (paramBoolean1)
    {
      k = j;
      if (!paramBoolean2) {
        break label199;
      }
      m = i;
      label47:
      if (!dispatchNestedPreScroll(k, m, this.mReusableIntPair, this.mScrollOffset, 0)) {
        break label217;
      }
      j -= this.mReusableIntPair[0];
      i -= this.mReusableIntPair[1];
      int[] arrayOfInt = this.mNestedOffsets;
      arrayOfInt[0] += this.mScrollOffset[0];
      arrayOfInt = this.mNestedOffsets;
      arrayOfInt[1] += this.mScrollOffset[1];
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    label169:
    label199:
    label211:
    label217:
    for (;;)
    {
      this.mLastTouchX = (paramInt1 - this.mScrollOffset[0]);
      this.mLastTouchY = (paramInt2 - this.mScrollOffset[1]);
      if (paramBoolean1) {
        if (!paramBoolean2) {
          break label211;
        }
      }
      for (;;)
      {
        doScrollBy(j, i);
        tryNotifyFooter();
        onTouchMove(paramInt1, paramInt2);
        return;
        k = 0;
        break;
        m = 0;
        break label47;
        j = 0;
        break label169;
        i = 0;
      }
    }
  }
  
  private void processTouchMoveOnNotDragState(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = this.mInitialTouchX;
    int j = this.mInitialTouchY;
    int i = 0;
    k = calTouchAxes(paramBoolean1, paramInt1 - k, this.mInitialTouchX);
    paramInt1 = i;
    if (k != 2147483647)
    {
      this.mLastTouchX = k;
      paramInt1 = 1;
    }
    paramInt2 = calTouchAxes(paramBoolean2, paramInt2 - j, this.mInitialTouchY);
    if (paramInt2 != 2147483647)
    {
      this.mLastTouchY = paramInt2;
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      Object localObject = getFieldValue("mDisallowParentInterceptTouchEventWhenDrag");
      if (Boolean.TRUE.equals(localObject)) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      reflectSetScrollState(1);
    }
  }
  
  private boolean reflectEnableTouchListener()
  {
    Boolean localBoolean = (Boolean)getFieldValue("mEnableRecyclerViewTouchListener");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  private boolean registerAdjustHeightObserver()
  {
    if (this.adjustHeightObserver != null) {}
    RecyclerViewBase.Adapter localAdapter;
    do
    {
      return false;
      localAdapter = getAdapter();
    } while (localAdapter == null);
    this.adjustHeightObserver = new NSHippyListView.AdjustHeightObserver(this, null);
    localAdapter.registerAdapterDataObserver(this.adjustHeightObserver);
    return true;
  }
  
  private void resetNestedOffsets(int paramInt)
  {
    if (paramInt == 0)
    {
      int[] arrayOfInt = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      arrayOfInt[0] = 0;
    }
  }
  
  private boolean scrollByInternal2(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    stopScroll();
    this.mReusableIntPair[0] = 0;
    this.mReusableIntPair[1] = 0;
    this.mReusableIntPair2[0] = paramInt1;
    this.mReusableIntPair2[1] = paramInt2;
    scrollStep(paramInt1, paramInt2, false, this.mReusableIntPair, this.mReusableIntPair2);
    int i = this.mReusableIntPair[0];
    int j = this.mReusableIntPair[1];
    int m = this.mReusableIntPair2[0];
    int k = this.mReusableIntPair2[1];
    reflectInvalidateDecorations();
    this.mReusableIntPair[0] = 0;
    this.mReusableIntPair[1] = 0;
    dispatchNestedScroll(i, j, m, k, this.mScrollOffset, 0, this.mReusableIntPair);
    m -= this.mReusableIntPair[0];
    k -= this.mReusableIntPair[1];
    if (!TKDTuWenCommentUtil.isAllZero(new double[] { i, j, this.mReusableIntPair[0], this.mReusableIntPair[1] })) {}
    for (boolean bool = true;; bool = false)
    {
      this.mLastTouchX -= this.mScrollOffset[0];
      this.mLastTouchY -= this.mScrollOffset[1];
      int[] arrayOfInt = this.mNestedOffsets;
      arrayOfInt[0] += this.mScrollOffset[0];
      arrayOfInt = this.mNestedOffsets;
      arrayOfInt[1] += this.mScrollOffset[1];
      invalidateRefreshHeader();
      reflectPullGlows(m, k);
      reflectNotifyScrollListener(paramInt1, paramInt2);
      if (checkShouldInvalidateInScroll()) {
        invalidate();
      }
      reflectPullGlows(m, k);
      awakenScrollBars();
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = i;
        paramArrayOfInt[1] = j;
      }
      return bool;
    }
  }
  
  private void scrollStep(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (this.mAdapter == null) {
      return;
    }
    eatRequestLayout();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      int[] arrayOfInt = computeDxDy(paramInt1, paramInt2, paramBoolean, null, true);
      paramInt1 = arrayOfInt[0];
      paramInt2 = arrayOfInt[1];
      paramArrayOfInt1[0] = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
      paramArrayOfInt1[1] = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
      paramArrayOfInt2[0] -= paramArrayOfInt1[0];
      paramArrayOfInt2[1] -= paramArrayOfInt1[1];
    }
    resumeRequestLayout(false);
  }
  
  private void setupStartNestedScroll(int paramInt)
  {
    int i = 0;
    if (this.mLayout.canScrollHorizontally()) {
      i = 1;
    }
    int j = i;
    if (this.mLayout.canScrollVertically()) {
      j = i | 0x2;
    }
    startNestedScroll(j, paramInt);
  }
  
  private void tryNotifyFooter()
  {
    if ((this.needNotifyFooter) && (!this.checkNotifyFooterOnRelease) && ((!shouldPrebindItem()) || (this.mOffsetY + getHeight() >= getTotalHeight())))
    {
      this.needNotifyFooter = false;
      if (this.mRecycler != null) {
        this.mRecycler.notifyLastFooterAppeared();
      }
    }
  }
  
  private void tryNotifyTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((reflectEnableTouchListener()) && (Math.abs(paramMotionEvent.getX() - this.mInitialTouchX) < this.mTouchSlop) && (Math.abs(paramMotionEvent.getY() - this.mInitialTouchY) < this.mTouchSlop) && (paramMotionEvent.getActionMasked() == 1)) {
      notifyRecyclerViewTouchEvent(paramMotionEvent);
    }
  }
  
  private void unregisterAdjustHeightObserver()
  {
    if (this.adjustHeightObserver == null) {
      return;
    }
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if (localAdapter != null) {
      localAdapter.unregisterAdapterDataObserver(this.adjustHeightObserver);
    }
    this.adjustHeightObserver = null;
  }
  
  public void cancelTouch()
  {
    super.cancelTouch();
    stopNestedScroll(0);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public final void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, @NonNull int[] paramArrayOfInt2)
  {
    getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    paramInt1 = adjustVelocity(bool1, paramInt1);
    paramInt2 = adjustVelocity(bool2, paramInt2);
    if (TKDTuWenCommentUtil.isAllZero(new double[] { paramInt1, paramInt2 })) {}
    while (dispatchNestedPreFling(paramInt1, paramInt2)) {
      return false;
    }
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      dispatchNestedFling(paramInt1, paramInt2, bool1);
      if (!bool1) {
        break;
      }
      setupStartNestedScroll(1);
      paramInt1 = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt1, this.mMaxFlingVelocity));
      paramInt2 = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt2, this.mMaxFlingVelocity));
      this.mViewFlinger.fling(paramInt1, paramInt2);
      return true;
    }
  }
  
  @Nullable
  <T> T getFieldValue(String paramString)
  {
    return this.reflectWrapper.getFieldValue(this, paramString);
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean isFling()
  {
    Scroller localScroller = this.mViewFlinger.getScroller();
    return (localScroller != null) && (localScroller.isFling()) && (!localScroller.isFinished());
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.needAdjustHeight) && (this.adjustHeightObserver != null)) {
      NSHippyListView.AdjustHeightObserver.access$000(this.adjustHeightObserver);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = this.mScrollState;
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (i)
    {
    default: 
      return bool;
    case 0: 
      if (j == 2) {
        stopNestedScroll(1);
      }
      paramMotionEvent = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      paramMotionEvent[0] = 0;
      setupStartNestedScroll(0);
      return bool;
    }
    stopNestedScroll(0);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = paramMotionEvent.getActionMasked();
    resetNestedOffsets(j);
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
    if (callSuperOnTouchEvent(j)) {}
    for (boolean bool = super.onTouchEvent(paramMotionEvent);; bool = false)
    {
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        if (i == 0) {
          this.mVelocityTracker.addMovement(localMotionEvent);
        }
        localMotionEvent.recycle();
        return bool;
        setupStartNestedScroll(0);
        continue;
        j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
        if (j >= 0)
        {
          onTouchMove(paramMotionEvent, j);
        }
        else
        {
          bool = false;
          i = 1;
          continue;
          onTouchUpOrCancel(paramMotionEvent, localMotionEvent);
          i = 1;
        }
      }
    }
  }
  
  void reflectInvalidateDecorations()
  {
    List localList = (List)getFieldValue("mItemDecorations");
    if ((localList != null) && (!localList.isEmpty())) {
      invalidate();
    }
  }
  
  void reflectNotifyScrollListener(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    RecyclerViewBase.OnScrollListener localOnScrollListener;
    do
    {
      return;
      localOnScrollListener = (RecyclerViewBase.OnScrollListener)getFieldValue("mScrollListener");
    } while (localOnScrollListener == null);
    localOnScrollListener.onScrolled(paramInt1, paramInt2);
  }
  
  void reflectPullGlows(int paramInt1, int paramInt2)
  {
    this.reflectWrapper.invokeMethodWithPrimaryType(this, "pullGlows", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  void reflectResetStopAtTitle()
  {
    this.reflectWrapper.invokeMethodWithPrimaryType(this, "resetStopAtTitle", new Object[0]);
  }
  
  void reflectSetScrollState(int paramInt)
  {
    this.reflectWrapper.invokeMethodWithPrimaryType(this, "setScrollState", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        break label62;
      }
      if (!bool2) {
        break label67;
      }
    }
    for (;;)
    {
      scrollBy(paramInt1, paramInt2, null);
      return;
      label62:
      paramInt1 = 0;
      break;
      label67:
      paramInt2 = 0;
    }
  }
  
  public boolean scrollBy(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (checkShouldConsumePendingUpdates()) {
      consumePendingUpdateOperations();
    }
    if (checkShouldStopScroll()) {
      return false;
    }
    return scrollByInternal2(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public void sendOnScrollEvent()
  {
    long l;
    if (this.mScrollEventEnable)
    {
      l = System.currentTimeMillis();
      if (l - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {}
    }
    else
    {
      return;
    }
    this.mLastScrollEventTimeStamp = l;
    getOnScrollEvent().send(this, generateScrollEvent());
  }
  
  public void setAdapter(RecyclerViewBase.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
    unregisterAdjustHeightObserver();
    if (this.needAdjustHeight) {
      registerAdjustHeightObserver();
    }
  }
  
  void setFieldValue(String paramString, Object paramObject)
  {
    this.reflectWrapper.setFieldValue(this, paramString, paramObject);
  }
  
  public void setNeedAdjustHeight(boolean paramBoolean)
  {
    this.needAdjustHeight = paramBoolean;
    if (paramBoolean)
    {
      if (registerAdjustHeightObserver()) {
        NSHippyListView.AdjustHeightObserver.access$000(this.adjustHeightObserver);
      }
      return;
    }
    unregisterAdjustHeightObserver();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    smoothScrollBy(paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.mLayout.canScrollHorizontally()) {
      paramInt1 = 0;
    }
    if (!this.mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if (TKDTuWenCommentUtil.isAllZero(new double[] { paramInt1, paramInt2 })) {
      return;
    }
    if (paramBoolean3) {
      setupStartNestedScroll(1);
    }
    super.smoothScrollBy(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopFling()
  {
    this.mViewFlinger.getScroller().abortAnimation();
    stopNestedScroll(1);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.view.NSHippyListView
 * JD-Core Version:    0.7.0.1
 */