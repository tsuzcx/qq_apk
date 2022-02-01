package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.widget.EdgeEffectCompat;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<ViewPager.ItemInfo> COMPARATOR = new ViewPager.1();
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
  private static final Interpolator sInterpolator = new ViewPager.2();
  private static final ViewPager.ViewPositionComparator sPositionComparator = new ViewPager.ViewPositionComparator();
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private ViewPager.OnAdapterChangeListener mAdapterChangeListener;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private boolean mEdgeEffectEnabled;
  private final Runnable mEndScrollRunnable = new ViewPager.3(this);
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
  private final ArrayList<ViewPager.ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = 3.4028235E+38F;
  private EdgeEffectCompat mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets = false;
  private ViewPager.PagerObserver mObserver;
  private int mOffscreenPageLimit = 1;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
  private int mPageMargin;
  private ViewPager.PageTransformer mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private EdgeEffectCompat mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final ViewPager.ItemInfo mTempItem = new ViewPager.ItemInfo();
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ViewPager.ItemInfo paramItemInfo1, int paramInt, ViewPager.ItemInfo paramItemInfo2)
  {
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0) {
      f2 = this.mPageMargin / i;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position)
      {
        f1 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f2;
        i += 1;
        j = 0;
        while ((i <= paramItemInfo1.position) && (j < this.mItems.size()))
        {
          for (paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j))
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
          while (k < paramItemInfo2.position)
          {
            f3 += this.mAdapter.getPageWidth(k) + f2;
            k += 1;
          }
          paramItemInfo2.offset = f3;
          f1 = f3 + (paramItemInfo2.widthFactor + f2);
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
          for (paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j))
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
          f1 = f3 - (paramItemInfo2.widthFactor + f2);
          paramItemInfo2.offset = f1;
          i = k - 1;
        }
      }
    }
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0) {
      f1 = paramItemInfo1.offset;
    } else {
      f1 = -3.402824E+038F;
    }
    this.mFirstOffset = f1;
    int j = paramItemInfo1.position;
    m -= 1;
    if (j == m) {
      f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.mLastOffset = f1;
    j = paramInt - 1;
    float f1 = f3;
    while (j >= 0)
    {
      paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);
      while (i > paramItemInfo2.position)
      {
        f1 -= this.mAdapter.getPageWidth(i) + f2;
        i -= 1;
      }
      f1 -= paramItemInfo2.widthFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      j -= 1;
      i -= 1;
    }
    f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f2;
    j = paramItemInfo1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramItemInfo1 = (ViewPager.ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 += this.mAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m) {
        this.mLastOffset = (paramItemInfo1.widthFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.widthFactor + f2;
      i += 1;
      paramInt += 1;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (this.mScrollState == 2) {
      i = 1;
    } else {
      i = 0;
    }
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
    int j = i;
    int i = k;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (localItemInfo.scrolling)
      {
        localItemInfo.scrolling = false;
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        return;
      }
      this.mEndScrollRunnable.run();
    }
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f;
      if (paramInt1 >= this.mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      }
      paramInt1 = (int)(paramInt1 + paramFloat + f);
    }
    paramInt2 = paramInt1;
    if (this.mItems.size() > 0)
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(0);
      Object localObject = this.mItems;
      localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.position, Math.min(paramInt1, ((ViewPager.ItemInfo)localObject).position));
    }
    return paramInt2;
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    Object localObject = this.mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt);
        }
        i += 1;
      }
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      int j;
      if (paramBoolean) {
        j = 2;
      } else {
        j = 0;
      }
      ViewCompat.setLayerType(getChildAt(i), j, null);
      i += 1;
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ViewPager.ItemInfo infoForCurrentScrollPosition()
  {
    int i = getClientWidth();
    float f1;
    if (i > 0) {
      f1 = getScrollX() / i;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i > 0) {
      f2 = this.mPageMargin / i;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i = 0;
    int j = 1;
    int k = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(i);
      int m = i;
      ViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (j == 0)
      {
        int n = localItemInfo2.position;
        k += 1;
        m = i;
        localItemInfo1 = localItemInfo2;
        if (n != k)
        {
          localItemInfo1 = this.mTempItem;
          localItemInfo1.offset = (f3 + f4 + f2);
          localItemInfo1.position = k;
          localItemInfo1.widthFactor = this.mAdapter.getPageWidth(localItemInfo1.position);
          m = i - 1;
        }
      }
      f3 = localItemInfo1.offset;
      f4 = localItemInfo1.widthFactor;
      if ((j == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (m == this.mItems.size() - 1) {
          return localItemInfo1;
        }
        k = localItemInfo1.position;
        f4 = localItemInfo1.widthFactor;
        i = m + 1;
        j = 0;
        localObject = localItemInfo1;
      }
      else
      {
        return localItemInfo1;
      }
    }
    return localObject;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      paramMotionEvent = this.mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (this.mCalledSuper) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    ViewPager.ItemInfo localItemInfo = infoForCurrentScrollPosition();
    int j = getClientWidth();
    int k = this.mPageMargin;
    float f2 = k;
    float f1 = j;
    f2 /= f1;
    int i = localItemInfo.position;
    f1 = (paramInt / f1 - localItemInfo.offset) / (localItemInfo.widthFactor + f2);
    paramInt = (int)((j + k) * f1);
    this.mCalledSuper = false;
    onPageScrolled(i, f1, paramInt);
    if (this.mCalledSuper) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean performDrag(float paramFloat)
  {
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = this.mFirstOffset * f3;
    f1 = this.mLastOffset * f3;
    Object localObject1 = this.mItems;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    localObject1 = (ViewPager.ItemInfo)((ArrayList)localObject1).get(0);
    Object localObject2 = this.mItems;
    int i = ((ArrayList)localObject2).size();
    int j = 1;
    localObject2 = (ViewPager.ItemInfo)((ArrayList)localObject2).get(i - 1);
    if (((ViewPager.ItemInfo)localObject1).position != 0)
    {
      paramFloat = ((ViewPager.ItemInfo)localObject1).offset * f3;
      i = 0;
    }
    else
    {
      i = 1;
    }
    if (((ViewPager.ItemInfo)localObject2).position != this.mAdapter.getCount() - 1)
    {
      f1 = ((ViewPager.ItemInfo)localObject2).offset * f3;
      j = 0;
    }
    if (f2 < paramFloat)
    {
      bool1 = bool3;
      if (i != 0)
      {
        bool1 = bool3;
        if (this.mEdgeEffectEnabled) {
          bool1 = this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / f3);
        }
      }
    }
    else
    {
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (j != 0)
        {
          bool1 = bool2;
          if (this.mEdgeEffectEnabled) {
            bool1 = this.mRightEdge.onPull(Math.abs(f2 - f1) / f3);
          }
        }
        paramFloat = f1;
      }
    }
    f1 = this.mLastMotionX;
    i = (int)paramFloat;
    this.mLastMotionX = (f1 + (paramFloat - i));
    scrollTo(i, getScrollY());
    pageScrolled(i);
    return bool1;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      paramInt2 = (int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3));
      scrollTo(paramInt2, getScrollY());
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localItemInfo = infoForPosition(this.mCurItem);
        this.mScroller.startScroll(paramInt2, 0, (int)(localItemInfo.offset * paramInt1), 0, paramInt3 - paramInt4);
      }
    }
    else
    {
      localItemInfo = infoForPosition(this.mCurItem);
      float f;
      if (localItemInfo != null) {
        f = Math.min(localItemInfo.offset, this.mLastOffset);
      } else {
        f = 0.0F;
      }
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      }
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((ViewPager.LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = infoForPosition(paramInt1);
    int i;
    if (localObject != null) {
      i = (int)(getClientWidth() * Math.max(this.mFirstOffset, Math.min(((ViewPager.ItemInfo)localObject).offset, this.mLastOffset)));
    } else {
      i = 0;
    }
    if (paramBoolean1)
    {
      smoothScrollTo(i, 0, paramInt2);
      if (paramBoolean2)
      {
        localObject = this.mOnPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
      if (paramBoolean2)
      {
        localObject = this.mInternalPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
    }
    else
    {
      if (paramBoolean2)
      {
        localObject = this.mOnPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
      if (paramBoolean2)
      {
        localObject = this.mInternalPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      completeScroll(false);
      scrollTo(i, 0);
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    Object localObject = this.mPageTransformer;
    int i = 0;
    if (localObject != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      enableLayers(bool);
    }
    localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
    }
    localObject = this.mOnPageChangeListeners;
    if (localObject != null)
    {
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrderPrivate()
  {
    if (this.mDrawingOrder != 0)
    {
      Object localObject = this.mDrawingOrderedChildren;
      if (localObject == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = getChildAt(i);
        this.mDrawingOrderedChildren.add(localObject);
        i += 1;
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
          ViewPager.ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      if (paramArrayList != null) {
        paramArrayList.add(this);
      }
    }
  }
  
  ViewPager.ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ViewPager.ItemInfo localItemInfo = new ViewPager.ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.mItems.size()))
    {
      this.mItems.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(localItemInfo);
    return localItemInfo;
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (ViewPager.LayoutParams)localLayoutParams;
    paramLayoutParams.isDecor |= paramView instanceof ViewPager.Decor;
    if (this.mInLayout)
    {
      if ((paramLayoutParams != null) && (paramLayoutParams.isDecor)) {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      paramLayoutParams.needsMeasure = true;
      addViewInLayout(paramView, paramInt, localLayoutParams);
      return;
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    boolean bool = false;
    View localView1 = null;
    Object localObject;
    int i;
    if (localView2 == this)
    {
      localObject = localView1;
    }
    else
    {
      if (localView2 != null)
      {
        for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
          if (localObject == this)
          {
            i = 1;
            break label70;
          }
        }
        i = 0;
        label70:
        if (i == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localView2.getClass().getSimpleName());
          for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent())
          {
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject.getClass().getSimpleName());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("arrowScroll tried to find focus based on non-child current focused view ");
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          Log.e("ViewPager", ((StringBuilder)localObject).toString());
          localObject = localView1;
          break label198;
        }
      }
      localObject = localView2;
    }
    label198:
    localView1 = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
    int j;
    if ((localView1 != null) && (localView1 != localObject)) {
      if (paramInt == 17)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView1).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
        if ((localObject != null) && (i >= j)) {
          bool = pageLeft();
        } else {
          bool = localView1.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView1).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
        if ((localObject != null) && (i <= j))
        {
          bool = pageRight();
        }
        else
        {
          bool = localView1.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = pageRight();
            }
          }
          else {
            bool = pageLeft();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean beginFakeDrag()
  {
    if (this.mIsBeingDragged) {
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    Object localObject = this.mVelocityTracker;
    if (localObject == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    long l = SystemClock.uptimeMillis();
    localObject = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.mVelocityTracker.addMovement((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    this.mFakeDragBeginTime = l;
    return true;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        int m = paramInt2 + j;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt3 + k;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    return (paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void clearOnPageChangeListeners()
  {
    List localList = this.mOnPageChangeListeners;
    if (localList != null) {
      localList.clear();
    }
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
        if (!pageScrolled(k))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  void dataSetChanged()
  {
    int i4 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i4;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i4)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = this.mCurItem;
    int i1 = i;
    int i = j;
    int k = 0;
    j = 0;
    Object localObject;
    while (k < this.mItems.size())
    {
      localObject = (ViewPager.ItemInfo)this.mItems.get(k);
      int i3 = this.mAdapter.getItemPosition(((ViewPager.ItemInfo)localObject).object);
      int m;
      int n;
      int i2;
      if (i3 == -1)
      {
        m = k;
        n = j;
        i2 = i;
      }
      else
      {
        if (i3 == -2)
        {
          this.mItems.remove(k);
          n = k - 1;
          m = j;
          if (j == 0)
          {
            this.mAdapter.startUpdate(this);
            m = 1;
          }
          this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object);
          k = n;
          j = m;
          if (this.mCurItem == ((ViewPager.ItemInfo)localObject).position)
          {
            i = Math.max(0, Math.min(this.mCurItem, i4 - 1));
            j = m;
            k = n;
          }
        }
        for (;;)
        {
          i1 = 1;
          m = k;
          n = j;
          i2 = i;
          break;
          m = k;
          n = j;
          i2 = i;
          if (((ViewPager.ItemInfo)localObject).position == i3) {
            break;
          }
          if (((ViewPager.ItemInfo)localObject).position == this.mCurItem) {
            i = i3;
          }
          ((ViewPager.ItemInfo)localObject).position = i3;
        }
      }
      k = m + 1;
      j = n;
      i = i2;
    }
    if (j != 0) {
      this.mAdapter.finishUpdate(this);
    }
    Collections.sort(this.mItems, COMPARATOR);
    if (i1 != 0)
    {
      k = getChildCount();
      j = 0;
      while (j < k)
      {
        localObject = (ViewPager.LayoutParams)getChildAt(j).getLayoutParams();
        if (!((ViewPager.LayoutParams)localObject).isDecor) {
          ((ViewPager.LayoutParams)localObject).widthFactor = 0.0F;
        }
        j += 1;
      }
      setCurrentItemInternal(i, false, true);
      requestLayout();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    double d = paramFloat - 0.5F;
    Double.isNaN(d);
    return (float)Math.sin((float)(d * 0.47123891676382D));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.mEdgeEffectEnabled) {
      return;
    }
    int k = 0;
    int i = 0;
    int m = ViewCompat.getOverScrollMode(this);
    if (m != 0) {
      if (m == 1)
      {
        PagerAdapter localPagerAdapter = this.mAdapter;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
        break label264;
      }
    }
    int j;
    if (!this.mLeftEdge.isFinished())
    {
      k = paramCanvas.save();
      i = getHeight() - getPaddingTop() - getPaddingBottom();
      m = getWidth();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * m);
      this.mLeftEdge.setSize(i, m);
      j = false | this.mLeftEdge.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
    k = j;
    boolean bool;
    if (!this.mRightEdge.isFinished())
    {
      m = paramCanvas.save();
      k = getWidth();
      int n = getHeight();
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * k);
      this.mRightEdge.setSize(n - i1 - i2, k);
      bool = j | this.mRightEdge.draw(paramCanvas);
      paramCanvas.restoreToCount(m);
    }
    label264:
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void endFakeDrag()
  {
    if (this.mFakeDragging)
    {
      Object localObject = this.mVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
      int i = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
      this.mPopulatePending = true;
      int j = getClientWidth();
      int k = getScrollX();
      localObject = infoForCurrentScrollPosition();
      setCurrentItemInternal(determineTargetPage(((ViewPager.ItemInfo)localObject).position, (k / j - ((ViewPager.ItemInfo)localObject).offset) / ((ViewPager.ItemInfo)localObject).widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
      endDrag();
      this.mFakeDragging = false;
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if (i != 21)
      {
        if (i != 22)
        {
          if ((i == 61) && (Build.VERSION.SDK_INT >= 11))
          {
            if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
              return arrowScroll(2);
            }
            if (KeyEventCompat.hasModifiers(paramKeyEvent, 1)) {
              return arrowScroll(1);
            }
          }
        }
        else {
          return arrowScroll(66);
        }
      }
      else {
        return arrowScroll(17);
      }
    }
    return false;
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (this.mFakeDragging)
    {
      this.mLastMotionX += paramFloat;
      float f2 = getScrollX() - paramFloat;
      float f3 = getClientWidth();
      paramFloat = this.mFirstOffset * f3;
      float f1 = this.mLastOffset * f3;
      Object localObject1 = (ViewPager.ItemInfo)this.mItems.get(0);
      Object localObject2 = this.mItems;
      localObject2 = (ViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (((ViewPager.ItemInfo)localObject1).position != 0) {
        paramFloat = ((ViewPager.ItemInfo)localObject1).offset * f3;
      }
      if (((ViewPager.ItemInfo)localObject2).position != this.mAdapter.getCount() - 1) {
        f1 = ((ViewPager.ItemInfo)localObject2).offset * f3;
      }
      if (f2 >= paramFloat)
      {
        paramFloat = f2;
        if (f2 > f1) {
          paramFloat = f1;
        }
      }
      f1 = this.mLastMotionX;
      int i = (int)paramFloat;
      this.mLastMotionX = (f1 + (paramFloat - i));
      scrollTo(i, getScrollY());
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((ViewPager.LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
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
  
  ViewPager.ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return infoForChild(paramView);
  }
  
  ViewPager.ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  ViewPager.ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
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
    setEdgeEffectEnabled(false);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(f * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new ViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f1 = this.mPageMargin;
      float f5 = m;
      float f2 = f1 / f5;
      Object localObject = this.mItems;
      int j = 0;
      localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((ViewPager.ItemInfo)localObject).offset;
      int n = this.mItems.size();
      int i = ((ViewPager.ItemInfo)localObject).position;
      int i1 = ((ViewPager.ItemInfo)this.mItems.get(n - 1)).position;
      while (i < i1)
      {
        while ((i > ((ViewPager.ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(j);
        }
        float f3;
        if (i == ((ViewPager.ItemInfo)localObject).position)
        {
          f3 = (((ViewPager.ItemInfo)localObject).offset + ((ViewPager.ItemInfo)localObject).widthFactor) * f5;
          f1 = ((ViewPager.ItemInfo)localObject).offset + ((ViewPager.ItemInfo)localObject).widthFactor + f2;
        }
        else
        {
          float f4 = this.mAdapter.getPageWidth(i);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        int i2 = this.mPageMargin;
        if (i2 + f3 > k)
        {
          this.mMarginDrawable.setBounds((int)f3, this.mTopPageBounds, (int)(i2 + f3 + 0.5F), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f3 > k + m) {
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i != 3) && (i != 1))
    {
      if (i != 0)
      {
        if (this.mIsBeingDragged) {
          return true;
        }
        if (this.mIsUnableToDrag) {
          return false;
        }
      }
      float f1;
      if (i != 0)
      {
        if (i != 2)
        {
          if (i == 6) {
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
        else
        {
          i = this.mActivePointerId;
          if (i != -1)
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
            float f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = f2 - this.mLastMotionX;
            float f4 = Math.abs(f1);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i);
            float f5 = Math.abs(f3 - this.mInitialMotionY);
            if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
            {
              this.mLastMotionX = f2;
              this.mLastMotionY = f3;
              this.mIsUnableToDrag = true;
              return false;
            }
            if ((f4 > this.mTouchSlop) && (f4 * 0.5F > f5))
            {
              this.mIsBeingDragged = true;
              setScrollState(1);
              if (f1 > 0.0F) {
                f1 = this.mInitialMotionX + this.mTouchSlop;
              } else {
                f1 = this.mInitialMotionX - this.mTouchSlop;
              }
              this.mLastMotionX = f1;
              this.mLastMotionY = f3;
              setScrollingCacheEnabled(true);
            }
            else if (f5 > this.mTouchSlop)
            {
              this.mIsUnableToDrag = true;
            }
            if ((this.mIsBeingDragged) && (performDrag(f2))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
        }
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
    }
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    this.mActivePointerId = -1;
    paramMotionEvent = this.mVelocityTracker;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.mVelocityTracker = null;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i4 = paramInt3 - paramInt1;
    int i5 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int j = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    int i;
    ViewPager.LayoutParams localLayoutParams;
    while (m < i3)
    {
      localView = getChildAt(m);
      i = paramInt2;
      int i2 = j;
      int i1 = paramInt1;
      int n = paramInt4;
      paramInt3 = k;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt2;
        i2 = j;
        i1 = paramInt1;
        n = paramInt4;
        paramInt3 = k;
        if (localLayoutParams.isDecor)
        {
          paramInt3 = localLayoutParams.gravity & 0x7;
          n = localLayoutParams.gravity & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i = paramInt2;
              }
              else
              {
                paramInt3 = i4 - j - localView.getMeasuredWidth();
                j += localView.getMeasuredWidth();
                i = paramInt2;
              }
            }
            else
            {
              i = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i4 - localView.getMeasuredWidth()) / 2, paramInt2);
            i = paramInt2;
          }
          if (n != 16)
          {
            if (n != 48)
            {
              if (n != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i5 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              n = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = n + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i5 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt3 += i6;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = k + 1;
          n = paramInt4;
          i1 = paramInt1;
          i2 = j;
        }
      }
      m += 1;
      paramInt2 = i;
      j = i2;
      paramInt1 = i1;
      paramInt4 = n;
      k = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i3)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.isDecor)
        {
          ViewPager.ItemInfo localItemInfo = infoForChild(localView);
          if (localItemInfo != null)
          {
            float f = i4 - paramInt2 - j;
            i = (int)(localItemInfo.offset * f) + paramInt2;
            if (localLayoutParams.needsMeasure)
            {
              localLayoutParams.needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * localLayoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i5 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i, paramInt1, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.mTopPageBounds = paramInt1;
    this.mBottomPageBounds = (i5 - paramInt4);
    this.mDecorChildCount = k;
    if (this.mFirstLayout) {
      scrollToItem(this.mCurItem, false, 0, false);
    }
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    int i = getPaddingLeft();
    int j = getPaddingRight();
    paramInt2 = getMeasuredHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int i4 = getChildCount();
    paramInt2 = paramInt2 - k - m;
    paramInt1 = paramInt1 - i - j;
    k = 0;
    View localView;
    ViewPager.LayoutParams localLayoutParams;
    for (;;)
    {
      int i1 = 1;
      int i3 = 1073741824;
      if (k >= i4) {
        break;
      }
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.isDecor)
          {
            i = localLayoutParams.gravity & 0x7;
            j = localLayoutParams.gravity & 0x70;
            int n;
            if ((j != 48) && (j != 80)) {
              n = 0;
            } else {
              n = 1;
            }
            m = i1;
            if (i != 3) {
              if (i == 5) {
                m = i1;
              } else {
                m = 0;
              }
            }
            i = -2147483648;
            if (n != 0)
            {
              j = 1073741824;
            }
            else
            {
              j = i;
              if (m != 0)
              {
                i1 = 1073741824;
                j = i;
                i = i1;
                break label269;
              }
            }
            i = -2147483648;
            label269:
            int i2;
            if (localLayoutParams.width != -2)
            {
              if (localLayoutParams.width != -1) {
                j = localLayoutParams.width;
              } else {
                j = paramInt1;
              }
              i1 = 1073741824;
              i2 = j;
            }
            else
            {
              i2 = paramInt1;
              i1 = j;
            }
            if (localLayoutParams.height != -2)
            {
              if (localLayoutParams.height != -1) {
                i = localLayoutParams.height;
              } else {
                i = paramInt2;
              }
            }
            else
            {
              j = paramInt2;
              i3 = i;
              i = j;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), View.MeasureSpec.makeMeasureSpec(i, i3));
            if (n != 0)
            {
              j = paramInt2 - localView.getMeasuredHeight();
              i = paramInt1;
            }
            else
            {
              i = paramInt1;
              j = paramInt2;
              if (m != 0)
              {
                i = paramInt1 - localView.getMeasuredWidth();
                j = paramInt2;
              }
            }
          }
        }
      }
      k += 1;
      paramInt1 = i;
      paramInt2 = j;
    }
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.mInLayout = true;
    populate();
    paramInt2 = 0;
    this.mInLayout = false;
    i = getChildCount();
    while (paramInt2 < i)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.isDecor)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = this.mDecorChildCount;
    int i1 = 0;
    int j;
    if (i > 0)
    {
      int i2 = getScrollX();
      i = getPaddingLeft();
      j = getPaddingRight();
      int i3 = getWidth();
      int i4 = getChildCount();
      int m = 0;
      while (m < i4)
      {
        localObject = getChildAt(m);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.isDecor)
        {
          int k = localLayoutParams.gravity & 0x7;
          if (k != 1)
          {
            int n;
            if (k != 3)
            {
              if (k != 5)
              {
                n = i;
                k = i;
                i = n;
              }
              else
              {
                k = i3 - j - ((View)localObject).getMeasuredWidth();
                j += ((View)localObject).getMeasuredWidth();
              }
            }
            else
            {
              n = ((View)localObject).getWidth() + i;
              k = i;
              i = n;
            }
          }
          else
          {
            k = Math.max((i3 - ((View)localObject).getMeasuredWidth()) / 2, i);
          }
          k = k + i2 - ((View)localObject).getLeft();
          if (k != 0) {
            ((View)localObject).offsetLeftAndRight(k);
          }
        }
        m += 1;
      }
    }
    Object localObject = this.mOnPageChangeListeners;
    if (localObject != null)
    {
      j = ((List)localObject).size();
      i = 0;
      while (i < j)
      {
        localObject = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.mInternalPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mPageTransformer != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = i1;
      while (paramInt1 < i)
      {
        localObject = getChildAt(paramInt1);
        if (!((ViewPager.LayoutParams)((View)localObject).getLayoutParams()).isDecor)
        {
          paramFloat = (((View)localObject).getLeft() - paramInt2) / getClientWidth();
          this.mPageTransformer.transformPage((View)localObject, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i = getChildCount();
    int k = -1;
    int j;
    if ((paramInt & 0x2) != 0)
    {
      k = i;
      i = 0;
      j = 1;
    }
    else
    {
      i -= 1;
      j = -1;
    }
    while (i != k)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i += j;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    PagerAdapter localPagerAdapter = this.mAdapter;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    PagerAdapter localPagerAdapter = this.mAdapter;
    if (localPagerAdapter != null) {
      localSavedState.adapterState = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.mPageMargin;
      recomputeScrollPosition(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mFakeDragging) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    int k = 0;
    if ((i == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.mAdapter;
    if (localObject != null)
    {
      if (((PagerAdapter)localObject).getCount() == 0) {
        return false;
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      i = paramMotionEvent.getAction() & 0xFF;
      float f1;
      int j;
      if (i != 0)
      {
        boolean bool3;
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                if (i != 6)
                {
                  i = k;
                  break label657;
                }
                onSecondaryPointerUp(paramMotionEvent);
                this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
                i = k;
                break label657;
              }
              i = MotionEventCompat.getActionIndex(paramMotionEvent);
              this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
              this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
              i = k;
              break label657;
            }
            i = k;
            if (!this.mIsBeingDragged) {
              break label657;
            }
            scrollToItem(this.mCurItem, true, 0, false);
            this.mActivePointerId = -1;
            endDrag();
            i = k;
            if (!this.mEdgeEffectEnabled) {
              break label657;
            }
            bool3 = this.mLeftEdge.onRelease();
          }
        }
        for (boolean bool2 = this.mRightEdge.onRelease();; bool2 = this.mRightEdge.onRelease())
        {
          i = bool3 | bool2;
          break;
          if (!this.mIsBeingDragged)
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
            f1 = MotionEventCompat.getX(paramMotionEvent, i);
            float f3 = Math.abs(f1 - this.mLastMotionX);
            float f2 = MotionEventCompat.getY(paramMotionEvent, i);
            float f4 = Math.abs(f2 - this.mLastMotionY);
            i = this.mTouchSlop;
            if ((f3 > i) && (f3 > f4))
            {
              this.mIsBeingDragged = true;
              f3 = this.mInitialMotionX;
              if (f1 - f3 > 0.0F) {
                f1 = f3 + i;
              } else {
                f1 = f3 - i;
              }
              this.mLastMotionX = f1;
              this.mLastMotionY = f2;
              setScrollState(1);
              setScrollingCacheEnabled(true);
            }
          }
          i = k;
          if (!this.mIsBeingDragged) {
            break;
          }
          boolean bool1 = false | performDrag(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)));
          break;
          bool1 = k;
          if (!this.mIsBeingDragged) {
            break;
          }
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          j = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
          this.mPopulatePending = true;
          int m = getClientWidth();
          int n = getScrollX();
          localObject = infoForCurrentScrollPosition();
          setCurrentItemInternal(determineTargetPage(((ViewPager.ItemInfo)localObject).position, (n / m - ((ViewPager.ItemInfo)localObject).offset) / ((ViewPager.ItemInfo)localObject).widthFactor, j, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, j);
          this.mActivePointerId = -1;
          endDrag();
          j = k;
          if (!this.mEdgeEffectEnabled) {
            break;
          }
          bool3 = this.mLeftEdge.onRelease();
        }
      }
      else
      {
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        setScrollState(1);
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        j = k;
      }
      label657:
      if (j != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
    }
    return false;
  }
  
  boolean pageLeft()
  {
    int i = this.mCurItem;
    if (i > 0)
    {
      setCurrentItem(i - 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageRight()
  {
    PagerAdapter localPagerAdapter = this.mAdapter;
    if ((localPagerAdapter != null) && (this.mCurItem < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
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
    int i = this.mCurItem;
    int m;
    if (i != paramInt)
    {
      if (i < paramInt) {
        i = 66;
      } else {
        i = 17;
      }
      localObject2 = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
      m = i;
    }
    else
    {
      m = 2;
      localObject2 = null;
    }
    if (this.mAdapter == null)
    {
      sortChildDrawingOrderPrivate();
      return;
    }
    if (this.mPopulatePending)
    {
      sortChildDrawingOrderPrivate();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.mAdapter.startUpdate(this);
    paramInt = this.mOffscreenPageLimit;
    int i3 = Math.max(0, this.mCurItem - paramInt);
    int i1 = this.mAdapter.getCount();
    int i2 = Math.min(i1 - 1, this.mCurItem + paramInt);
    if (i1 == this.mExpectedAdapterCount)
    {
      paramInt = 0;
      while (paramInt < this.mItems.size())
      {
        localObject1 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
        if (((ViewPager.ItemInfo)localObject1).position >= this.mCurItem)
        {
          if (((ViewPager.ItemInfo)localObject1).position != this.mCurItem) {
            break;
          }
          break label210;
        }
        paramInt += 1;
      }
      localObject1 = null;
      label210:
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (i1 > 0) {
          localObject3 = addNewItem(this.mCurItem, paramInt);
        }
      }
      if (localObject3 != null)
      {
        i = paramInt - 1;
        if (i >= 0) {
          localObject1 = (ViewPager.ItemInfo)this.mItems.get(i);
        } else {
          localObject1 = null;
        }
        float f3 = ((ViewPager.ItemInfo)localObject3).widthFactor;
        float f4 = getPaddingLeft() / getClientWidth();
        int n = this.mCurItem - 1;
        float f2 = 0.0F;
        float f1;
        int k;
        Object localObject4;
        while (n >= 0)
        {
          if ((f2 >= 2.0F - f3 + f4) && (n < i3))
          {
            if (localObject1 == null) {
              break;
            }
            f1 = f2;
            k = paramInt;
            localObject4 = localObject1;
            j = i;
            if (n != ((ViewPager.ItemInfo)localObject1).position) {
              break label584;
            }
            f1 = f2;
            k = paramInt;
            localObject4 = localObject1;
            j = i;
            if (((ViewPager.ItemInfo)localObject1).scrolling) {
              break label584;
            }
            this.mItems.remove(i);
            this.mAdapter.destroyItem(this, n, ((ViewPager.ItemInfo)localObject1).object);
            i -= 1;
            paramInt -= 1;
            f1 = f2;
            j = paramInt;
            k = i;
            if (i >= 0)
            {
              localObject1 = (ViewPager.ItemInfo)this.mItems.get(i);
              f1 = f2;
              break label573;
            }
          }
          else if ((localObject1 != null) && (n == ((ViewPager.ItemInfo)localObject1).position))
          {
            f2 += ((ViewPager.ItemInfo)localObject1).widthFactor;
            i -= 1;
            f1 = f2;
            j = paramInt;
            k = i;
            if (i >= 0)
            {
              localObject1 = (ViewPager.ItemInfo)this.mItems.get(i);
              f1 = f2;
              break label573;
            }
          }
          else
          {
            f2 += addNewItem(n, i + 1).widthFactor;
            paramInt += 1;
            f1 = f2;
            j = paramInt;
            k = i;
            if (i >= 0)
            {
              localObject1 = (ViewPager.ItemInfo)this.mItems.get(i);
              f1 = f2;
              break label573;
            }
          }
          localObject1 = null;
          i = k;
          paramInt = j;
          label573:
          j = i;
          localObject4 = localObject1;
          k = paramInt;
          label584:
          n -= 1;
          f2 = f1;
          paramInt = k;
          localObject1 = localObject4;
          i = j;
        }
        f2 = ((ViewPager.ItemInfo)localObject3).widthFactor;
        int j = paramInt + 1;
        if (f2 < 2.0F)
        {
          if (j < this.mItems.size()) {
            localObject1 = (ViewPager.ItemInfo)this.mItems.get(j);
          } else {
            localObject1 = null;
          }
          f3 = getPaddingRight() / getClientWidth();
          i = this.mCurItem;
          localObject4 = localObject1;
          for (;;)
          {
            k = i + 1;
            if (k >= i1) {
              break;
            }
            if ((f2 >= f3 + 2.0F) && (k > i2))
            {
              if (localObject4 == null) {
                break;
              }
              f1 = f2;
              i = j;
              localObject1 = localObject4;
              if (k != localObject4.position) {
                break label957;
              }
              f1 = f2;
              i = j;
              localObject1 = localObject4;
              if (localObject4.scrolling) {
                break label957;
              }
              this.mItems.remove(j);
              this.mAdapter.destroyItem(this, k, localObject4.object);
              f1 = f2;
              i = j;
              if (j < this.mItems.size())
              {
                localObject1 = (ViewPager.ItemInfo)this.mItems.get(j);
                f1 = f2;
                i = j;
                break label957;
              }
            }
            do
            {
              do
              {
                localObject1 = null;
                break label957;
                if ((localObject4 == null) || (k != localObject4.position)) {
                  break;
                }
                f2 += localObject4.widthFactor;
                j += 1;
                f1 = f2;
                i = j;
              } while (j >= this.mItems.size());
              localObject1 = (ViewPager.ItemInfo)this.mItems.get(j);
              f1 = f2;
              i = j;
              break;
              localObject1 = addNewItem(k, j);
              j += 1;
              f2 += ((ViewPager.ItemInfo)localObject1).widthFactor;
              f1 = f2;
              i = j;
            } while (j >= this.mItems.size());
            localObject1 = (ViewPager.ItemInfo)this.mItems.get(j);
            i = j;
            f1 = f2;
            label957:
            f2 = f1;
            j = i;
            localObject4 = localObject1;
            i = k;
          }
        }
        calculatePageOffsets((ViewPager.ItemInfo)localObject3, paramInt, (ViewPager.ItemInfo)localObject2);
      }
      localObject2 = this.mAdapter;
      paramInt = this.mCurItem;
      if (localObject3 != null) {
        localObject1 = ((ViewPager.ItemInfo)localObject3).object;
      } else {
        localObject1 = null;
      }
      ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
      this.mAdapter.finishUpdate(this);
      i = getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = getChildAt(paramInt);
        localObject1 = (ViewPager.LayoutParams)((View)localObject2).getLayoutParams();
        ((ViewPager.LayoutParams)localObject1).childIndex = paramInt;
        if ((!((ViewPager.LayoutParams)localObject1).isDecor) && (((ViewPager.LayoutParams)localObject1).widthFactor == 0.0F))
        {
          localObject2 = infoForChild((View)localObject2);
          if (localObject2 != null)
          {
            ((ViewPager.LayoutParams)localObject1).widthFactor = ((ViewPager.ItemInfo)localObject2).widthFactor;
            ((ViewPager.LayoutParams)localObject1).position = ((ViewPager.ItemInfo)localObject2).position;
          }
        }
        paramInt += 1;
      }
      sortChildDrawingOrderPrivate();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = infoForAnyChild((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 == null) || (((ViewPager.ItemInfo)localObject1).position != this.mCurItem))
        {
          paramInt = 0;
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = infoForChild((View)localObject1);
            if ((localObject2 != null) && (((ViewPager.ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(m))) {
              return;
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    try
    {
      localObject1 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label1254:
      break label1254;
    }
    Object localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.mExpectedAdapterCount);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.mAdapter.getClass());
    localObject1 = new IllegalStateException(((StringBuilder)localObject2).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.mOnPageChangeListeners;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
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
    EventCollector.getInstance().onSetViewPagerAdapter(this);
    Object localObject = this.mAdapter;
    if (localObject != null)
    {
      ((PagerAdapter)localObject).unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        localObject = (ViewPager.ItemInfo)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new ViewPager.PagerObserver(this, null);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0)
      {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      }
      else if (!bool)
      {
        populate();
      }
      else
      {
        requestLayout();
      }
    }
    ViewPager.OnAdapterChangeListener localOnAdapterChangeListener = this.mAdapterChangeListener;
    if ((localOnAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
      localOnAdapterChangeListener.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 7)
    {
      if (this.mSetChildrenDrawingOrderEnabled == null) {
        try
        {
          this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
      try
      {
        this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception localException)
      {
        Log.e("ViewPager", "Error changing children drawing order", localException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, this.mFirstLayout ^ true, false);
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
    Object localObject = this.mAdapter;
    if ((localObject != null) && (((PagerAdapter)localObject).getCount() > 0))
    {
      if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      paramBoolean2 = true;
      int i;
      if (paramInt1 < 0)
      {
        i = 0;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 >= this.mAdapter.getCount()) {
          i = this.mAdapter.getCount() - 1;
        }
      }
      paramInt1 = this.mOffscreenPageLimit;
      int j = this.mCurItem;
      if ((i > j + paramInt1) || (i < j - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < this.mItems.size())
        {
          ((ViewPager.ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
          paramInt1 += 1;
        }
      }
      if (this.mCurItem == i) {
        paramBoolean2 = false;
      }
      if (this.mFirstLayout)
      {
        this.mCurItem = i;
        if (paramBoolean2)
        {
          localObject = this.mOnPageChangeListener;
          if (localObject != null) {
            ((ViewPager.OnPageChangeListener)localObject).onPageSelected(i);
          }
        }
        if ((paramBoolean2) && (this.mOnPageChangeListeners != null)) {
          dispatchOnPageSelected(i);
        }
        if (paramBoolean2)
        {
          localObject = this.mInternalPageChangeListener;
          if (localObject != null) {
            ((ViewPager.OnPageChangeListener)localObject).onPageSelected(i);
          }
        }
        requestLayout();
        return;
      }
      populate(i);
      scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  void setEdgeEffectEnabled(boolean paramBoolean)
  {
    if (this.mEdgeEffectEnabled != paramBoolean)
    {
      if (paramBoolean)
      {
        Context localContext = getContext();
        this.mLeftEdge = new EdgeEffectCompat(localContext);
        this.mRightEdge = new EdgeEffectCompat(localContext);
      }
      else
      {
        this.mLeftEdge = null;
        this.mRightEdge = null;
      }
      this.mEdgeEffectEnabled = paramBoolean;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("ViewPager", localStringBuilder.toString());
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  void setOnAdapterChangeListener(ViewPager.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
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
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      int j = 1;
      boolean bool1;
      if (paramPageTransformer != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (this.mPageTransformer != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      int i;
      if (bool1 != bool2) {
        i = 1;
      } else {
        i = 0;
      }
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (bool1)
      {
        if (paramBoolean) {
          j = 2;
        }
        this.mDrawingOrder = j;
      }
      else
      {
        this.mDrawingOrder = 0;
      }
      if (i != 0) {
        populate();
      }
    }
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
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f2 = Math.abs(k);
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0)
    {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
    }
    else
    {
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.7.0.1
 */