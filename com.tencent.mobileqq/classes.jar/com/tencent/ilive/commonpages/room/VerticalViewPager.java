package com.tencent.ilive.commonpages.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.tencent.ilive.interfaces.ILiveOnPageChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VerticalViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<VerticalViewPager.ItemInfo> COMPARATOR = new VerticalViewPager.1();
  private static final boolean DEBUG = false;
  private static final int DEFAULT_GUTTER_SIZE = 16;
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  private static final int DRAW_ORDER_DEFAULT = 0;
  private static final int DRAW_ORDER_FORWARD = 1;
  private static final int DRAW_ORDER_REVERSE = 2;
  private static final int INVALID_POINTER = -1;
  private static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final int MAX_SETTLE_DURATION = 600;
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  private static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "ViewPager";
  private static final boolean USE_CACHE = false;
  private static final Interpolator sInterpolator = new VerticalViewPager.2();
  private static final VerticalViewPager.ViewPositionComparator sPositionComparator = new VerticalViewPager.ViewPositionComparator();
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private VerticalViewPager.OnAdapterChangeListener mAdapterChangeListener;
  private EdgeEffectCompat mBottomEdge;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new VerticalViewPager.3(this);
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.402824E+038F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mIgnoreGutter;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private ViewPager.OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<VerticalViewPager.ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = 3.4028235E+38F;
  private int mLeftPageBounds;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets = false;
  private VerticalViewPager.PagerObserver mObserver;
  private int mOffscreenPageLimit = 1;
  private ILiveOnPageChangeListener mOnPageChangeListener;
  private int mPageMargin;
  private ViewPager.PageTransformer mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private int mRightPageBounds;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final VerticalViewPager.ItemInfo mTempItem = new VerticalViewPager.ItemInfo();
  private final Rect mTempRect = new Rect();
  private EdgeEffectCompat mTopEdge;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  protected boolean scrollForbidden = false;
  
  public VerticalViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public VerticalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(VerticalViewPager.ItemInfo paramItemInfo1, int paramInt, VerticalViewPager.ItemInfo paramItemInfo2)
  {
    int m = this.mAdapter.getCount();
    int i = getClientHeight();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramItemInfo2 == null) {
        break label409;
      }
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position)
      {
        f1 = paramItemInfo2.offset + paramItemInfo2.heightFactor + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramItemInfo1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(j);; paramItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramItemInfo2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramItemInfo2.position)
        {
          f3 += this.mAdapter.getPageWidth(k) + f2;
          k += 1;
        }
        paramItemInfo2.offset = f3;
        f1 = f3 + (paramItemInfo2.heightFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramItemInfo1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramItemInfo2.offset;
      i -= 1;
      while ((i >= paramItemInfo1.position) && (j >= 0))
      {
        for (paramItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(j);; paramItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramItemInfo2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramItemInfo2.position)
        {
          f3 -= this.mAdapter.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramItemInfo2.heightFactor + f2);
        paramItemInfo2.offset = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0)
    {
      f1 = paramItemInfo1.offset;
      this.mFirstOffset = f1;
      if (paramItemInfo1.position != m - 1) {
        break label550;
      }
      f1 = paramItemInfo1.offset + paramItemInfo1.heightFactor - 1.0F;
      label475:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(j);
      for (;;)
      {
        if (i > paramItemInfo2.position)
        {
          f1 -= this.mAdapter.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramItemInfo2.heightFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramItemInfo1.offset + paramItemInfo1.heightFactor + f2;
    int j = paramItemInfo1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramItemInfo1 = (VerticalViewPager.ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 = this.mAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m - 1) {
        this.mLastOffset = (paramItemInfo1.heightFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.heightFactor + f2;
      paramInt += 1;
      i += 1;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (this.mScrollState == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.mPopulatePending = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.mItems.size())
      {
        VerticalViewPager.ItemInfo localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(i);
        if (localItemInfo.scrolling)
        {
          localItemInfo.scrolling = false;
          j = 1;
        }
        i += 1;
      }
    }
    if (j != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
      }
    }
    else {
      return;
    }
    this.mEndScrollRunnable.run();
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          VerticalViewPager.ItemInfo localItemInfo1 = (VerticalViewPager.ItemInfo)this.mItems.get(0);
          VerticalViewPager.ItemInfo localItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1);
          paramInt2 = Math.max(localItemInfo1.position, Math.min(paramInt1, localItemInfo2.position));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.4F;; f = 0.6F)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
      break;
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        ViewCompat.setLayerType(getChildAt(i), j, null);
        i += 1;
        break;
      }
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private int getClientHeight()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private VerticalViewPager.ItemInfo infoForCurrentScrollPosition()
  {
    int i = getClientHeight();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label53:
    Object localObject2;
    VerticalViewPager.ItemInfo localItemInfo;
    if (i > 0)
    {
      f1 = getScrollY() / i;
      if (i <= 0) {
        break label214;
      }
      f2 = this.mPageMargin / i;
      f4 = 0.0F;
      f3 = 0.0F;
      k = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < this.mItems.size())
      {
        localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(i);
        if ((j != 0) || (localItemInfo.position == k + 1)) {
          break label249;
        }
        localItemInfo = this.mTempItem;
        localItemInfo.offset = (f4 + f3 + f2);
        localItemInfo.position = (k + 1);
        localItemInfo.heightFactor = this.mAdapter.getPageWidth(localItemInfo.position);
        i -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localItemInfo.offset;
      f4 = localItemInfo.heightFactor;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.mItems.size() - 1)) {
          break label219;
        }
        localObject2 = localItemInfo;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localItemInfo.position;
      f4 = localItemInfo.heightFactor;
      j = 0;
      i += 1;
      localObject1 = localItemInfo;
      break label53;
    }
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.mGutterSize) && (paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, i);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    boolean bool = false;
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      VerticalViewPager.ItemInfo localItemInfo = infoForCurrentScrollPosition();
      int j = getClientHeight();
      int k = this.mPageMargin;
      float f = this.mPageMargin / j;
      int i = localItemInfo.position;
      f = (paramInt / j - localItemInfo.offset) / (localItemInfo.heightFactor + f);
      paramInt = (int)((k + j) * f);
      this.mCalledSuper = false;
      onPageScrolled(i, f, paramInt);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean performDrag(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.mLastMotionY;
    this.mLastMotionY = paramFloat;
    float f2 = getScrollY() + (f1 - paramFloat);
    int k = getClientHeight();
    paramFloat = k * this.mFirstOffset;
    f1 = k;
    float f3 = this.mLastOffset;
    VerticalViewPager.ItemInfo localItemInfo1 = (VerticalViewPager.ItemInfo)this.mItems.get(0);
    VerticalViewPager.ItemInfo localItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (localItemInfo1.position != 0) {
      paramFloat = localItemInfo1.offset * k;
    }
    for (int i = 0;; i = 1)
    {
      if (localItemInfo2.position != this.mAdapter.getCount() - 1)
      {
        f1 = localItemInfo2.offset * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i != 0)
          {
            bool1 = this.mTopEdge.onPull(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.mLastMotionX += f1 - (int)f1;
          scrollTo(getScrollX(), (int)f1);
          pageScrolled((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.mBottomEdge.onPull(Math.abs(f2 - f1) / k);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingTop();
      int j = getPaddingBottom();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      f = getScrollY() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(getScrollX(), paramInt2);
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localItemInfo = infoForPosition(this.mCurItem);
        this.mScroller.startScroll(0, paramInt2, 0, (int)(localItemInfo.offset * paramInt1), paramInt3 - paramInt4);
      }
      return;
    }
    VerticalViewPager.ItemInfo localItemInfo = infoForPosition(this.mCurItem);
    if (localItemInfo != null) {}
    for (float f = Math.min(localItemInfo.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 == getScrollY()) {
        break;
      }
      completeScroll(false);
      scrollTo(getScrollX(), paramInt1);
      return;
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((VerticalViewPager.LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    VerticalViewPager.ItemInfo localItemInfo = infoForPosition(paramInt1);
    float f;
    if (localItemInfo != null) {
      f = getClientHeight();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(0, i, paramInt2);
        if (this.mOnPageChangeListener != null)
        {
          if (!paramBoolean2) {
            break label101;
          }
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        for (;;)
        {
          if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
            this.mInternalPageChangeListener.onPageSelected(paramInt1);
          }
          return;
          label101:
          if (paramInt1 == 0) {
            this.mOnPageChangeListener.onPageScrollTop();
          } else if (paramInt1 == this.mAdapter.getCount() - 1) {
            this.mOnPageChangeListener.onPageScrollBottom();
          }
        }
      }
      if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(paramInt1);
      }
      if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(paramInt1);
      }
      completeScroll(false);
      scrollTo(0, i);
      pageScrolled(i);
      return;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      if (paramInt == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      if (this.mOnPageChangeListener == null) {
        break;
      }
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.mDrawingOrderedChildren.add(localView);
          i += 1;
        }
        this.mDrawingOrderedChildren.clear();
      }
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  VerticalViewPager.ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    VerticalViewPager.ItemInfo localItemInfo = new VerticalViewPager.ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.heightFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size()))
    {
      this.mItems.add(localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(paramInt2, localItemInfo);
    return localItemInfo;
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      VerticalViewPager.LayoutParams localLayoutParams = (VerticalViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.isDecor |= paramView instanceof VerticalViewPager.Decor;
      if (this.mInLayout)
      {
        if ((localLayoutParams != null) && (localLayoutParams.isDecor)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.needsMeasure = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label329;
      }
      if (paramInt != 33) {
        break label265;
      }
      i = getChildRectInPagerCoordinates(this.mTempRect, localView).top;
      j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).top;
      if ((localObject != null) && (i >= j))
      {
        bool = pageUp();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label376;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label383;
      }
      if (localObject != this) {}
    }
    label265:
    label329:
    label376:
    label383:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 130)
        {
          i = getChildRectInPagerCoordinates(this.mTempRect, localView).bottom;
          j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).bottom;
          if ((localObject != null) && (i <= j))
          {
            bool = pageDown();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 33) || (paramInt == 1))
          {
            bool = pageUp();
            break label89;
          }
          if ((paramInt == 130) || (paramInt == 2))
          {
            bool = pageDown();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean beginFakeDrag()
  {
    if (this.mIsBeingDragged) {
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionY = 0.0F;
    this.mInitialMotionY = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      return true;
      this.mVelocityTracker.clear();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      if (paramView.getVisibility() != 0) {
        return false;
      }
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
          return true;
        }
        i -= 1;
      }
    }
    return (paramBoolean) && (ViewCompat.canScrollVertically(paramView, -paramInt1));
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof VerticalViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(m))
        {
          this.mScroller.abortAnimation();
          scrollTo(k, 0);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  void dataSetChanged()
  {
    int i2 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i2;
    int i;
    int j;
    int k;
    int n;
    int m;
    label67:
    Object localObject;
    int i1;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i2))
    {
      i = 1;
      j = this.mCurItem;
      k = 0;
      n = 0;
      m = i;
      i = j;
      j = k;
      k = n;
      if (k >= this.mItems.size()) {
        break label299;
      }
      localObject = (VerticalViewPager.ItemInfo)this.mItems.get(k);
      n = this.mAdapter.getItemPosition(((VerticalViewPager.ItemInfo)localObject).object);
      if (n != -1) {
        break label157;
      }
      n = k;
      i1 = j;
      k = m;
      j = i;
      i = i1;
      m = n;
    }
    for (;;)
    {
      n = k;
      i1 = j;
      k = m + 1;
      j = i;
      i = i1;
      m = n;
      break label67;
      i = 0;
      break;
      label157:
      if (n == -2)
      {
        this.mItems.remove(k);
        m = k - 1;
        k = j;
        if (j == 0)
        {
          this.mAdapter.startUpdate(this);
          k = 1;
        }
        this.mAdapter.destroyItem(this, ((VerticalViewPager.ItemInfo)localObject).position, ((VerticalViewPager.ItemInfo)localObject).object);
        if (this.mCurItem == ((VerticalViewPager.ItemInfo)localObject).position)
        {
          j = Math.max(0, Math.min(this.mCurItem, i2 - 1));
          i = k;
          k = 1;
        }
      }
      else
      {
        if (((VerticalViewPager.ItemInfo)localObject).position != n)
        {
          if (((VerticalViewPager.ItemInfo)localObject).position == this.mCurItem) {
            i = n;
          }
          ((VerticalViewPager.ItemInfo)localObject).position = n;
          n = i;
          i1 = 1;
          m = k;
          i = j;
          j = n;
          k = i1;
          continue;
          label299:
          if (j != 0) {
            this.mAdapter.finishUpdate(this);
          }
          Collections.sort(this.mItems, COMPARATOR);
          if (m != 0)
          {
            k = getChildCount();
            j = 0;
            while (j < k)
            {
              localObject = (VerticalViewPager.LayoutParams)getChildAt(j).getLayoutParams();
              if (!((VerticalViewPager.LayoutParams)localObject).isDecor) {
                ((VerticalViewPager.LayoutParams)localObject).heightFactor = 0.0F;
              }
              j += 1;
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
          }
          return;
        }
        n = i;
        i1 = m;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
      }
      j = i;
      n = 1;
      i = k;
      k = n;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  @SuppressLint({"WrongConstant"})
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int n;
      int j;
      if (!this.mTopEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight();
        m = getWidth();
        n = getPaddingLeft();
        int i1 = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), this.mFirstOffset * i);
        this.mTopEdge.setSize(m - n - i1, i);
        j = false | this.mTopEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.mBottomEdge.isFinished())
      {
        m = paramCanvas.save();
        k = getHeight();
        n = getWidth() - getPaddingLeft() - getPaddingRight();
        paramCanvas.rotate(180.0F);
        paramCanvas.translate(-n - getPaddingLeft(), -(this.mLastOffset + 1.0F) * k);
        this.mBottomEdge.setSize(n, k);
        bool = j | this.mBottomEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.mTopEdge.finish();
      this.mBottomEdge.finish();
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void endFakeDrag()
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    Object localObject = this.mVelocityTracker;
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
    int i = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.mActivePointerId);
    this.mPopulatePending = true;
    int j = getClientHeight();
    int k = getScrollY();
    localObject = infoForCurrentScrollPosition();
    setCurrentItemInternal(determineTargetPage(((VerticalViewPager.ItemInfo)localObject).position, (k / j - ((VerticalViewPager.ItemInfo)localObject).offset) / ((VerticalViewPager.ItemInfo)localObject).heightFactor, i, (int)(this.mLastMotionY - this.mInitialMotionY)), true, true, i);
    endDrag();
    this.mFakeDragging = false;
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return arrowScroll(17);
        return arrowScroll(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (paramKeyEvent.hasNoModifiers()) {
        return arrowScroll(2);
      }
    } while (!paramKeyEvent.hasModifiers(1));
    return arrowScroll(1);
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    this.mLastMotionY += paramFloat;
    float f2 = getScrollY() - paramFloat;
    int i = getClientHeight();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f1 = i;
    float f3 = this.mLastOffset;
    Object localObject = (VerticalViewPager.ItemInfo)this.mItems.get(0);
    VerticalViewPager.ItemInfo localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (((VerticalViewPager.ItemInfo)localObject).position != 0) {}
    for (paramFloat = ((VerticalViewPager.ItemInfo)localObject).offset * i;; paramFloat *= f4)
    {
      if (localItemInfo.position != this.mAdapter.getCount() - 1) {}
      for (f1 = localItemInfo.offset * i;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.mLastMotionY += paramFloat - (int)paramFloat;
          scrollTo(getScrollX(), (int)paramFloat);
          pageScrolled((int)paramFloat);
          long l = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, 0.0F, this.mLastMotionY, 0);
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((VerticalViewPager.LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  VerticalViewPager.ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return infoForChild(paramView);
  }
  
  VerticalViewPager.ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      VerticalViewPager.ItemInfo localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  VerticalViewPager.ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      VerticalViewPager.ItemInfo localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(i);
      if (localItemInfo.position == paramInt) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mTopEdge = new EdgeEffectCompat(localContext);
    this.mBottomEdge = new EdgeEffectCompat(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    ViewCompat.setAccessibilityDelegate(this, new VerticalViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  public boolean internalCanScrollVertically(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.mAdapter == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = getClientHeight();
      j = getScrollY();
      if (paramInt < 0)
      {
        if (j > (int)(i * this.mFirstOffset)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (j < (int)(i * this.mLastOffset)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  public void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k;
    int m;
    float f3;
    Object localObject;
    float f1;
    int n;
    int i;
    int i1;
    int j;
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      k = getScrollY();
      m = getHeight();
      f3 = this.mPageMargin / m;
      localObject = (VerticalViewPager.ItemInfo)this.mItems.get(0);
      f1 = ((VerticalViewPager.ItemInfo)localObject).offset;
      n = this.mItems.size();
      i = ((VerticalViewPager.ItemInfo)localObject).position;
      i1 = ((VerticalViewPager.ItemInfo)this.mItems.get(n - 1)).position;
      j = 0;
    }
    for (;;)
    {
      float f2;
      if (i < i1)
      {
        while ((i > ((VerticalViewPager.ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (VerticalViewPager.ItemInfo)((ArrayList)localObject).get(j);
        }
        if (i != ((VerticalViewPager.ItemInfo)localObject).position) {
          break label271;
        }
        f2 = (((VerticalViewPager.ItemInfo)localObject).offset + ((VerticalViewPager.ItemInfo)localObject).heightFactor) * m;
      }
      label271:
      float f4;
      for (f1 = ((VerticalViewPager.ItemInfo)localObject).offset + ((VerticalViewPager.ItemInfo)localObject).heightFactor + f3;; f1 += f4 + f3)
      {
        if (this.mPageMargin + f2 > k)
        {
          this.mMarginDrawable.setBounds(this.mLeftPageBounds, (int)f2, this.mRightPageBounds, (int)(this.mPageMargin + f2 + 0.5F));
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f2 <= k + m) {
          break;
        }
        return;
        f4 = this.mAdapter.getPageWidth(i);
        f2 = (f1 + f4) * m;
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.mIsBeingDragged) {
        return true;
      }
    } while (this.mIsUnableToDrag);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        float f2 = MotionEventCompat.getY(paramMotionEvent, i);
        float f1 = f2 - this.mLastMotionY;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getX(paramMotionEvent, i);
        float f5 = Math.abs(f3 - this.mInitialMotionX);
        if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionY, f1)) && (canScroll(this, false, (int)f1, (int)f3, (int)f2)))
        {
          this.mLastMotionX = f3;
          this.mLastMotionY = f2;
          this.mIsUnableToDrag = true;
          return false;
        }
        if ((f4 > this.mTouchSlop) && (0.5F * f4 > f5))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionY + this.mTouchSlop;
            label310:
            this.mLastMotionY = f1;
            this.mLastMotionX = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f2)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = this.mInitialMotionY - this.mTouchSlop;
          break label310;
          if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollY();
    int j = 0;
    int m = 0;
    View localView;
    VerticalViewPager.LayoutParams localLayoutParams;
    int i;
    int i5;
    int k;
    label154:
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label667;
      }
      localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isDecor) {
        break label667;
      }
      i = localLayoutParams.gravity;
      i5 = localLayoutParams.gravity;
      switch (i & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        i = paramInt2;
        k = paramInt2;
        switch (i5 & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = n;
          label204:
          paramInt3 += i4;
          localView.layout(i, paramInt3, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt3);
          j += 1;
          paramInt3 = k;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      k = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      paramInt2 = k;
      break;
      k = localView.getMeasuredWidth();
      i = paramInt2;
      k += paramInt2;
      break label154;
      i = Math.max((i2 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label154;
      k = localView.getMeasuredWidth();
      i = paramInt4 + localView.getMeasuredWidth();
      n = i2 - paramInt4 - k;
      paramInt4 = i;
      k = paramInt2;
      i = n;
      break label154;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label204;
      n = Math.max((i3 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label204;
      n = i3 - paramInt3 - localView.getMeasuredHeight();
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label204;
      i = i3 - paramInt1 - paramInt3;
      paramInt3 = 0;
      while (paramInt3 < i1)
      {
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.isDecor)
          {
            VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
            if (localItemInfo != null)
            {
              float f = i;
              k = (int)(localItemInfo.offset * f) + paramInt1;
              if (localLayoutParams.needsMeasure)
              {
                localLayoutParams.needsMeasure = false;
                m = View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - paramInt4, 1073741824);
                f = i;
                localView.measure(m, View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.heightFactor * f), 1073741824));
              }
              localView.layout(paramInt2, k, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + k);
            }
          }
        }
        paramInt3 += 1;
      }
      this.mLeftPageBounds = paramInt2;
      this.mRightPageBounds = (i2 - paramInt4);
      this.mDecorChildCount = j;
      if (this.mFirstLayout) {
        scrollToItem(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      return;
      label667:
      i = j;
      j = paramInt1;
      k = paramInt2;
      paramInt1 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = k;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt2 = getMeasuredHeight();
    this.mGutterSize = Math.min(paramInt2 / 10, this.mDefaultGutterSize);
    paramInt1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    VerticalViewPager.LayoutParams localLayoutParams;
    int m;
    int i1;
    label183:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.isDecor)
          {
            i = localLayoutParams.gravity & 0x7;
            m = localLayoutParams.gravity & 0x70;
            i1 = -2147483648;
            j = -2147483648;
            if ((m != 48) && (m != 80)) {
              break label333;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label532;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label526;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label333:
          m = 0;
          break label183;
          label339:
          n = 0;
          break label198;
          label345:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.isDecor))
            {
              float f = paramInt2;
              j = View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.heightFactor * f), 1073741824);
              localView.measure(this.mChildWidthMeasureSpec, j);
            }
          }
          paramInt1 += 1;
        }
        return;
      }
      label526:
      i = paramInt1;
      continue;
      label532:
      i1 = i;
      i = paramInt1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    View localView;
    if (this.mDecorChildCount > 0)
    {
      int i1 = getScrollY();
      i = getPaddingTop();
      int j = getPaddingBottom();
      int i2 = getHeight();
      int i3 = getChildCount();
      int n = 0;
      while (n < i3)
      {
        localView = getChildAt(n);
        VerticalViewPager.LayoutParams localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
        int m;
        int k;
        if (!localLayoutParams.isDecor)
        {
          m = i;
          k = j;
          n += 1;
          i = m;
          j = k;
        }
        else
        {
          switch (localLayoutParams.gravity & 0x70)
          {
          default: 
            k = i;
            m = j;
            j = i;
            i = m;
          }
          for (;;)
          {
            int i4 = k + i1 - localView.getTop();
            k = i;
            m = j;
            if (i4 == 0) {
              break;
            }
            localView.offsetTopAndBottom(i4);
            k = i;
            m = j;
            break;
            k = localView.getHeight();
            m = k + i;
            k = i;
            i = j;
            j = m;
            continue;
            k = Math.max((i2 - localView.getMeasuredHeight()) / 2, i);
            m = i;
            i = j;
            j = m;
            continue;
            k = i2 - j - localView.getMeasuredHeight();
            i4 = localView.getMeasuredHeight();
            m = i;
            i = j + i4;
            j = m;
          }
        }
      }
    }
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mInternalPageChangeListener != null) {
      this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mPageTransformer != null)
    {
      paramInt2 = getScrollY();
      i = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        if (((VerticalViewPager.LayoutParams)localView.getLayoutParams()).isDecor) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getTop() - paramInt2) / getClientHeight();
          this.mPageTransformer.transformPage(localView, paramFloat);
        }
      }
    }
    this.mCalledSuper = true;
  }
  
  public boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int k = -1;
    int j = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      k = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          continue;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof VerticalViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (VerticalViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    VerticalViewPager.SavedState localSavedState = new VerticalViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.adapterState = this.mAdapter.saveState();
    }
    return localSavedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4) {
      recomputeScrollPosition(paramInt2, paramInt4, this.mPageMargin, this.mPageMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.mFakeDragging) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0)) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = m;
    }
    for (;;)
    {
      if (i != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
      this.mScroller.abortAnimation();
      this.mPopulatePending = false;
      populate();
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = m;
      continue;
      float f2;
      if (!this.mIsBeingDragged)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        f1 = MotionEventCompat.getY(paramMotionEvent, i);
        float f3 = Math.abs(f1 - this.mLastMotionY);
        f2 = MotionEventCompat.getX(paramMotionEvent, i);
        float f4 = Math.abs(f2 - this.mLastMotionX);
        if ((f3 > this.mTouchSlop) && (f3 > f4))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          if (f1 - this.mInitialMotionY <= 0.0F) {
            break label378;
          }
        }
      }
      Object localObject;
      label378:
      for (f1 = this.mInitialMotionY + this.mTouchSlop;; f1 = this.mInitialMotionY - this.mTouchSlop)
      {
        this.mLastMotionY = f1;
        this.mLastMotionX = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i = m;
        if (!this.mIsBeingDragged) {
          break;
        }
        bool1 = false | performDrag(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)));
        break;
      }
      boolean bool1 = m;
      if (this.mIsBeingDragged)
      {
        localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        int j = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.mActivePointerId);
        this.mPopulatePending = true;
        m = getClientHeight();
        int n = getScrollY();
        localObject = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(((VerticalViewPager.ItemInfo)localObject).position, (n / m - ((VerticalViewPager.ItemInfo)localObject).offset) / ((VerticalViewPager.ItemInfo)localObject).heightFactor, j, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, j);
        this.mActivePointerId = -1;
        endDrag();
        boolean bool3 = this.mTopEdge.onRelease();
        boolean bool2 = this.mBottomEdge.onRelease() | bool3;
        continue;
        bool2 = m;
        if (this.mIsBeingDragged)
        {
          scrollToItem(this.mCurItem, true, 0, false);
          this.mActivePointerId = -1;
          endDrag();
          bool3 = this.mTopEdge.onRelease();
          bool2 = this.mBottomEdge.onRelease() | bool3;
          continue;
          int k = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, k);
          this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, k);
          k = m;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
          k = m;
        }
      }
    }
  }
  
  boolean pageDown()
  {
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageUp()
  {
    if (this.mCurItem > 0)
    {
      setCurrentItem(this.mCurItem - 1, true);
      return true;
    }
    return false;
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt)
  {
    int i;
    Object localObject2;
    if (this.mCurItem != paramInt) {
      if (this.mCurItem < paramInt)
      {
        i = 130;
        localObject2 = infoForPosition(this.mCurItem);
        this.mCurItem = paramInt;
      }
    }
    for (int j = i;; j = 2)
    {
      if (this.mAdapter == null) {
        sortChildDrawingOrder();
      }
      do
      {
        return;
        i = 33;
        break;
        if (this.mPopulatePending)
        {
          sortChildDrawingOrder();
          return;
        }
      } while (getWindowToken() == null);
      this.mAdapter.startUpdate(this);
      paramInt = this.mOffscreenPageLimit;
      int i3 = Math.max(0, this.mCurItem - paramInt);
      int i1 = this.mAdapter.getCount();
      int i2 = Math.min(i1 - 1, paramInt + this.mCurItem);
      Object localObject1;
      if (i1 != this.mExpectedAdapterCount) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + i1 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.mItems.size())
      {
        localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);
        if (((VerticalViewPager.ItemInfo)localObject1).position >= this.mCurItem) {
          if (((VerticalViewPager.ItemInfo)localObject1).position != this.mCurItem) {
            break label1274;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i1 > 0)) {}
        for (Object localObject3 = addNewItem(this.mCurItem, paramInt);; localObject3 = localObject1)
        {
          int n;
          label345:
          int i4;
          label358:
          float f3;
          int m;
          int k;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            n = paramInt - 1;
            if (n < 0) {
              break label641;
            }
            localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(n);
            i4 = getClientHeight();
            if (i4 > 0) {
              break label647;
            }
            f2 = 0.0F;
            i = this.mCurItem;
            f3 = 0.0F;
            m = i - 1;
            k = paramInt;
            localObject4 = localObject1;
            if (m >= 0)
            {
              if ((f3 < f2) || (m >= i3)) {
                break label802;
              }
              if (localObject4 != null) {
                break label668;
              }
            }
            f1 = ((VerticalViewPager.ItemInfo)localObject3).heightFactor;
            paramInt = k + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.mItems.size()) {
                break label922;
              }
              localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);
              label445:
              if (i4 > 0) {
                break label928;
              }
            }
          }
          label522:
          label668:
          label928:
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i4 + 2.0F)
          {
            i = this.mCurItem;
            i += 1;
            label464:
            if (i < i1)
            {
              if ((f1 < f2) || (i <= i2)) {
                break label1024;
              }
              if (localObject1 != null) {
                break label943;
              }
            }
            calculatePageOffsets((VerticalViewPager.ItemInfo)localObject3, k, (VerticalViewPager.ItemInfo)localObject2);
            localObject2 = this.mAdapter;
            paramInt = this.mCurItem;
            if (localObject3 == null) {
              break label1146;
            }
            localObject1 = ((VerticalViewPager.ItemInfo)localObject3).object;
            ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
            this.mAdapter.finishUpdate(this);
            i = getChildCount();
            paramInt = 0;
            while (paramInt < i)
            {
              localObject2 = getChildAt(paramInt);
              localObject1 = (VerticalViewPager.LayoutParams)((View)localObject2).getLayoutParams();
              ((VerticalViewPager.LayoutParams)localObject1).childIndex = paramInt;
              if ((!((VerticalViewPager.LayoutParams)localObject1).isDecor) && (((VerticalViewPager.LayoutParams)localObject1).heightFactor == 0.0F))
              {
                localObject2 = infoForChild((View)localObject2);
                if (localObject2 != null)
                {
                  ((VerticalViewPager.LayoutParams)localObject1).heightFactor = ((VerticalViewPager.ItemInfo)localObject2).heightFactor;
                  ((VerticalViewPager.LayoutParams)localObject1).position = ((VerticalViewPager.ItemInfo)localObject2).position;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label345;
            f2 = 2.0F - ((VerticalViewPager.ItemInfo)localObject3).heightFactor + getPaddingLeft() / i4;
            break label358;
            localObject1 = localObject4;
            paramInt = n;
            f1 = f3;
            i = k;
            if (m == localObject4.position)
            {
              localObject1 = localObject4;
              paramInt = n;
              f1 = f3;
              i = k;
              if (!localObject4.scrolling)
              {
                this.mItems.remove(n);
                this.mAdapter.destroyItem(this, m, localObject4.object);
                paramInt = n - 1;
                i = k - 1;
                if (paramInt < 0) {
                  break label793;
                }
                localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              m -= 1;
              localObject4 = localObject1;
              n = paramInt;
              f3 = f1;
              k = i;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              label802:
              if ((localObject4 != null) && (m == localObject4.position))
              {
                f1 = f3 + localObject4.heightFactor;
                paramInt = n - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);
                  i = k;
                }
                else
                {
                  localObject1 = null;
                  i = k;
                }
              }
              else
              {
                f1 = f3 + addNewItem(m, n + 1).heightFactor;
                i = k + 1;
                if (n >= 0)
                {
                  localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(n);
                  paramInt = n;
                }
                else
                {
                  localObject1 = null;
                  paramInt = n;
                }
              }
            }
            localObject1 = null;
            break label445;
          }
          label641:
          label647:
          label793:
          label922:
          label943:
          if ((i == ((VerticalViewPager.ItemInfo)localObject1).position) && (!((VerticalViewPager.ItemInfo)localObject1).scrolling))
          {
            this.mItems.remove(paramInt);
            this.mAdapter.destroyItem(this, i, ((VerticalViewPager.ItemInfo)localObject1).object);
            if (paramInt < this.mItems.size()) {
              localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);
            }
          }
          for (;;)
          {
            i += 1;
            break label464;
            localObject1 = null;
            continue;
            label1024:
            if ((localObject1 != null) && (i == ((VerticalViewPager.ItemInfo)localObject1).position))
            {
              f3 = ((VerticalViewPager.ItemInfo)localObject1).heightFactor;
              paramInt += 1;
              if (paramInt < this.mItems.size()) {}
              for (localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = addNewItem(i, paramInt);
            paramInt += 1;
            f3 = ((VerticalViewPager.ItemInfo)localObject1).heightFactor;
            if (paramInt < this.mItems.size()) {}
            for (localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            label1146:
            localObject1 = null;
            break label522;
            sortChildDrawingOrder();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = infoForAnyChild((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((VerticalViewPager.ItemInfo)localObject1).position == this.mCurItem)) {
                break label1262;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1256;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = infoForChild((View)localObject1);
                if ((localObject2 != null) && (((VerticalViewPager.ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(j))) {
                  break;
                }
                paramInt += 1;
              }
              label1256:
              break;
            }
            label1262:
            break;
          }
        }
        label1274:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        localObject = (VerticalViewPager.ItemInfo)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((VerticalViewPager.ItemInfo)localObject).position, ((VerticalViewPager.ItemInfo)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    boolean bool;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new VerticalViewPager.PagerObserver(this, null);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
      this.mPopulatePending = false;
      bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem < 0) {
        break label260;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    for (;;)
    {
      if ((this.mAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
        this.mAdapterChangeListener.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label260:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.mSetChildrenDrawingOrderEnabled == null)) {}
    try
    {
      this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.mOffscreenPageLimit;
      if ((i <= this.mCurItem + paramInt1) && (i >= this.mCurItem - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mItems.size())
      {
        ((VerticalViewPager.ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount()) {
        i = this.mAdapter.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.mCurItem != i) {
      paramBoolean2 = true;
    }
    if (this.mFirstLayout)
    {
      this.mCurItem = i;
      if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(i);
      }
      if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(i);
      }
      requestLayout();
      return;
    }
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  void setOnAdapterChangeListener(VerticalViewPager.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  public void setOnPageChangeListener(ILiveOnPageChangeListener paramILiveOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramILiveOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getHeight();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    label28:
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null) {
        break label75;
      }
      bool1 = true;
      if (this.mPageTransformer == null) {
        break label81;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label87;
      }
      i = 1;
      label37:
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        j = 2;
      }
    }
    label75:
    label81:
    label87:
    label92:
    for (this.mDrawingOrder = j;; this.mDrawingOrder = 0)
    {
      if (i != 0) {
        populate();
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
      i = 0;
      break label37;
    }
  }
  
  public void setScrollForbidden(boolean paramBoolean)
  {
    this.scrollForbidden = paramBoolean;
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientHeight();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 5.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager
 * JD-Core Version:    0.7.0.1
 */