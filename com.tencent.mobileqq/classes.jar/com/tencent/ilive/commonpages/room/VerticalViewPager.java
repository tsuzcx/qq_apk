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
        f1 = paramItemInfo2.offset + paramItemInfo2.heightFactor + f2;
        i += 1;
        j = 0;
        while ((i <= paramItemInfo1.position) && (j < this.mItems.size()))
        {
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
      f1 = paramItemInfo1.offset + paramItemInfo1.heightFactor - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.mLastOffset = f1;
    j = paramInt - 1;
    float f1 = f3;
    while (j >= 0)
    {
      paramItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(j);
      while (i > paramItemInfo2.position)
      {
        f1 -= this.mAdapter.getPageWidth(i) + f2;
        i -= 1;
      }
      f1 -= paramItemInfo2.heightFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      j -= 1;
      i -= 1;
    }
    f1 = paramItemInfo1.offset + paramItemInfo1.heightFactor + f2;
    j = paramItemInfo1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramItemInfo1 = (VerticalViewPager.ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 += this.mAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m) {
        this.mLastOffset = (paramItemInfo1.heightFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.heightFactor + f2;
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
      VerticalViewPager.ItemInfo localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(i);
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
      VerticalViewPager.ItemInfo localItemInfo = (VerticalViewPager.ItemInfo)this.mItems.get(0);
      Object localObject = this.mItems;
      localObject = (VerticalViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.position, Math.min(paramInt1, ((VerticalViewPager.ItemInfo)localObject).position));
    }
    return paramInt2;
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
  
  private int getClientHeight()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private void handlePopulateStageOne(VerticalViewPager.ItemInfo paramItemInfo1, int paramInt1, int paramInt2, int paramInt3, VerticalViewPager.ItemInfo paramItemInfo2, int paramInt4)
  {
    if (paramItemInfo1 != null)
    {
      int k = paramInt2 - 1;
      Object localObject1;
      if (k >= 0) {
        localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(k);
      } else {
        localObject1 = null;
      }
      int n = getClientHeight();
      float f4 = 0.0F;
      float f3;
      if (n <= 0) {
        f3 = 0.0F;
      } else {
        f3 = 2.0F - paramItemInfo1.heightFactor + getPaddingLeft() / n;
      }
      int m = this.mCurItem - 1;
      float f2 = 0.0F;
      int j = paramInt2;
      Object localObject2 = localObject1;
      float f1;
      int i;
      while (m >= 0)
      {
        if ((f2 >= f3) && (m < paramInt1))
        {
          if (localObject2 == null) {
            break;
          }
          f1 = f2;
          localObject1 = localObject2;
          i = j;
          paramInt2 = k;
          if (m != localObject2.position) {
            break label392;
          }
          f1 = f2;
          localObject1 = localObject2;
          i = j;
          paramInt2 = k;
          if (localObject2.scrolling) {
            break label392;
          }
          this.mItems.remove(k);
          this.mAdapter.destroyItem(this, m, localObject2.object);
          k -= 1;
          j -= 1;
          f1 = f2;
          i = j;
          paramInt2 = k;
          if (k >= 0)
          {
            localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(k);
            f1 = f2;
            i = j;
            paramInt2 = k;
            break label392;
          }
        }
        do
        {
          do
          {
            localObject1 = null;
            break label392;
            if ((localObject2 == null) || (m != localObject2.position)) {
              break;
            }
            f2 += localObject2.heightFactor;
            k -= 1;
            f1 = f2;
            i = j;
            paramInt2 = k;
          } while (k < 0);
          localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(k);
          f1 = f2;
          i = j;
          paramInt2 = k;
          break;
          f2 += addNewItem(m, k + 1).heightFactor;
          j += 1;
          f1 = f2;
          i = j;
          paramInt2 = k;
        } while (k < 0);
        localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(k);
        paramInt2 = k;
        i = j;
        f1 = f2;
        label392:
        m -= 1;
        f2 = f1;
        localObject2 = localObject1;
        j = i;
        k = paramInt2;
      }
      f2 = paramItemInfo1.heightFactor;
      paramInt2 = j + 1;
      if (f2 < 2.0F)
      {
        if (paramInt2 < this.mItems.size()) {
          localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt2);
        } else {
          localObject1 = null;
        }
        if (n <= 0) {
          f3 = f4;
        } else {
          f3 = getPaddingRight() / n + 2.0F;
        }
        i = this.mCurItem + 1;
        for (localObject2 = localObject1; i < paramInt4; localObject2 = localObject1)
        {
          if ((f2 >= f3) && (i > paramInt3))
          {
            if (localObject2 == null) {
              break;
            }
            f1 = f2;
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (i != localObject2.position) {
              break label765;
            }
            f1 = f2;
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (localObject2.scrolling) {
              break label765;
            }
            this.mItems.remove(paramInt2);
            this.mAdapter.destroyItem(this, i, localObject2.object);
            f1 = f2;
            paramInt1 = paramInt2;
            if (paramInt2 < this.mItems.size())
            {
              localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt2);
              f1 = f2;
              paramInt1 = paramInt2;
              break label765;
            }
          }
          do
          {
            do
            {
              localObject1 = null;
              break label765;
              if ((localObject2 == null) || (i != localObject2.position)) {
                break;
              }
              f2 += localObject2.heightFactor;
              paramInt2 += 1;
              f1 = f2;
              paramInt1 = paramInt2;
            } while (paramInt2 >= this.mItems.size());
            localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt2);
            f1 = f2;
            paramInt1 = paramInt2;
            break;
            localObject1 = addNewItem(i, paramInt2);
            paramInt2 += 1;
            f2 += ((VerticalViewPager.ItemInfo)localObject1).heightFactor;
            f1 = f2;
            paramInt1 = paramInt2;
          } while (paramInt2 >= this.mItems.size());
          localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt2);
          paramInt1 = paramInt2;
          f1 = f2;
          label765:
          i += 1;
          f2 = f1;
          paramInt2 = paramInt1;
        }
      }
      calculatePageOffsets(paramItemInfo1, j, paramItemInfo2);
    }
  }
  
  private VerticalViewPager.ItemInfo infoForCurrentScrollPosition()
  {
    int i = getClientHeight();
    float f1;
    if (i > 0) {
      f1 = getScrollY() / i;
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
      VerticalViewPager.ItemInfo localItemInfo2 = (VerticalViewPager.ItemInfo)this.mItems.get(i);
      int m = i;
      VerticalViewPager.ItemInfo localItemInfo1 = localItemInfo2;
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
          localItemInfo1.heightFactor = this.mAdapter.getPageWidth(localItemInfo1.position);
          m = i - 1;
        }
      }
      f3 = localItemInfo1.offset;
      f4 = localItemInfo1.heightFactor;
      if ((j == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (m == this.mItems.size() - 1) {
          return localItemInfo1;
        }
        k = localItemInfo1.position;
        f4 = localItemInfo1.heightFactor;
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
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.mGutterSize) && (paramFloat2 < 0.0F));
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
      this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, i);
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
    VerticalViewPager.ItemInfo localItemInfo = infoForCurrentScrollPosition();
    int j = getClientHeight();
    int k = this.mPageMargin;
    float f2 = k;
    float f1 = j;
    f2 /= f1;
    int i = localItemInfo.position;
    f1 = (paramInt / f1 - localItemInfo.offset) / (localItemInfo.heightFactor + f2);
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
    float f1 = this.mLastMotionY;
    this.mLastMotionY = paramFloat;
    float f2 = getScrollY() + (f1 - paramFloat);
    float f3 = getClientHeight();
    paramFloat = this.mFirstOffset * f3;
    f1 = this.mLastOffset * f3;
    Object localObject1 = this.mItems;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    localObject1 = (VerticalViewPager.ItemInfo)((ArrayList)localObject1).get(0);
    Object localObject2 = this.mItems;
    int i = ((ArrayList)localObject2).size();
    int j = 1;
    localObject2 = (VerticalViewPager.ItemInfo)((ArrayList)localObject2).get(i - 1);
    if (((VerticalViewPager.ItemInfo)localObject1).position != 0)
    {
      paramFloat = ((VerticalViewPager.ItemInfo)localObject1).offset * f3;
      i = 0;
    }
    else
    {
      i = 1;
    }
    if (((VerticalViewPager.ItemInfo)localObject2).position != this.mAdapter.getCount() - 1)
    {
      f1 = ((VerticalViewPager.ItemInfo)localObject2).offset * f3;
      j = 0;
    }
    if (f2 < paramFloat)
    {
      if (i != 0) {
        bool1 = this.mTopEdge.onPull(Math.abs(paramFloat - f2) / f3);
      }
    }
    else
    {
      bool1 = bool3;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (j != 0) {
          bool1 = this.mBottomEdge.onPull(Math.abs(f2 - f1) / f3);
        }
        paramFloat = f1;
      }
    }
    f1 = this.mLastMotionX;
    i = (int)paramFloat;
    this.mLastMotionX = (f1 + (paramFloat - i));
    scrollTo(getScrollX(), i);
    pageScrolled(i);
    return bool1;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    VerticalViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingTop();
      int j = getPaddingBottom();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      paramInt2 = (int)(getScrollY() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3));
      scrollTo(getScrollX(), paramInt2);
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localItemInfo = infoForPosition(this.mCurItem);
        this.mScroller.startScroll(0, paramInt2, 0, (int)(localItemInfo.offset * paramInt1), paramInt3 - paramInt4);
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
      paramInt1 = (int)(f * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 != getScrollY())
      {
        completeScroll(false);
        scrollTo(getScrollX(), paramInt1);
      }
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
    Object localObject = infoForPosition(paramInt1);
    int i;
    if (localObject != null) {
      i = (int)(getClientHeight() * Math.max(this.mFirstOffset, Math.min(((VerticalViewPager.ItemInfo)localObject).offset, this.mLastOffset)));
    } else {
      i = 0;
    }
    if (paramBoolean1)
    {
      smoothScrollTo(0, i, paramInt2);
      localObject = this.mOnPageChangeListener;
      if (localObject != null) {
        if (paramBoolean2) {
          ((ILiveOnPageChangeListener)localObject).onPageSelected(paramInt1);
        } else if (paramInt1 == 0) {
          ((ILiveOnPageChangeListener)localObject).onPageScrollTop();
        } else if (paramInt1 == this.mAdapter.getCount() - 1) {
          this.mOnPageChangeListener.onPageScrollBottom();
        }
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
          ((ILiveOnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.mInternalPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      completeScroll(false);
      scrollTo(0, i);
      pageScrolled(i);
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      enableLayers(bool);
    }
    ILiveOnPageChangeListener localILiveOnPageChangeListener = this.mOnPageChangeListener;
    if (localILiveOnPageChangeListener != null) {
      localILiveOnPageChangeListener.onPageScrollStateChanged(paramInt);
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
          VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
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
  
  VerticalViewPager.ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    VerticalViewPager.ItemInfo localItemInfo = new VerticalViewPager.ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.heightFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.mItems.size()))
    {
      this.mItems.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(localItemInfo);
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
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (VerticalViewPager.LayoutParams)localLayoutParams;
    paramLayoutParams.isDecor |= paramView instanceof VerticalViewPager.Decor;
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
      if (paramInt == 33)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView1).top;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).top;
        if ((localObject != null) && (i >= j)) {
          bool = pageUp();
        } else {
          bool = localView1.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 130)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView1).bottom;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).bottom;
        if ((localObject != null) && (i <= j))
        {
          bool = pageDown();
        }
        else
        {
          bool = localView1.requestFocus();
          continue;
          if ((paramInt != 33) && (paramInt != 1))
          {
            if ((paramInt == 130) || (paramInt == 2)) {
              bool = pageDown();
            }
          }
          else {
            bool = pageUp();
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
    this.mLastMotionY = 0.0F;
    this.mInitialMotionY = 0.0F;
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
    boolean bool1 = paramView instanceof ViewGroup;
    boolean bool2 = false;
    if (bool1)
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
        int m = paramInt3 + k;
        if ((m >= localView.getTop()) && (m < localView.getBottom()))
        {
          int n = paramInt2 + j;
          if ((n >= localView.getLeft()) && (n < localView.getRight()) && (canScroll(localView, true, paramInt1, n - localView.getLeft(), m - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (ViewCompat.canScrollVertically(paramView, -paramInt1)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
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
      localObject = (VerticalViewPager.ItemInfo)this.mItems.get(k);
      int i3 = this.mAdapter.getItemPosition(((VerticalViewPager.ItemInfo)localObject).object);
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
          this.mAdapter.destroyItem(this, ((VerticalViewPager.ItemInfo)localObject).position, ((VerticalViewPager.ItemInfo)localObject).object);
          k = n;
          j = m;
          if (this.mCurItem == ((VerticalViewPager.ItemInfo)localObject).position)
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
          if (((VerticalViewPager.ItemInfo)localObject).position == i3) {
            break;
          }
          if (((VerticalViewPager.ItemInfo)localObject).position == this.mCurItem) {
            i = i3;
          }
          ((VerticalViewPager.ItemInfo)localObject).position = i3;
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
        localObject = (VerticalViewPager.LayoutParams)getChildAt(j).getLayoutParams();
        if (!((VerticalViewPager.LayoutParams)localObject).isDecor) {
          ((VerticalViewPager.LayoutParams)localObject).heightFactor = 0.0F;
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
  
  @SuppressLint({"WrongConstant"})
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
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
    int m = ViewCompat.getOverScrollMode(this);
    int k = 0;
    int i = 0;
    if (m != 0) {
      if (m == 1)
      {
        PagerAdapter localPagerAdapter = this.mAdapter;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.mTopEdge.finish();
        this.mBottomEdge.finish();
        break label248;
      }
    }
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
    boolean bool;
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
    label248:
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
      int i = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.mActivePointerId);
      this.mPopulatePending = true;
      int j = getClientHeight();
      int k = getScrollY();
      localObject = infoForCurrentScrollPosition();
      setCurrentItemInternal(determineTargetPage(((VerticalViewPager.ItemInfo)localObject).position, (k / j - ((VerticalViewPager.ItemInfo)localObject).offset) / ((VerticalViewPager.ItemInfo)localObject).heightFactor, i, (int)(this.mLastMotionY - this.mInitialMotionY)), true, true, i);
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
            if (paramKeyEvent.hasNoModifiers()) {
              return arrowScroll(2);
            }
            if (paramKeyEvent.hasModifiers(1)) {
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
      this.mLastMotionY += paramFloat;
      float f2 = getScrollY() - paramFloat;
      float f3 = getClientHeight();
      paramFloat = this.mFirstOffset * f3;
      float f1 = this.mLastOffset * f3;
      Object localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(0);
      Object localObject2 = this.mItems;
      localObject2 = (VerticalViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (((VerticalViewPager.ItemInfo)localObject1).position != 0) {
        paramFloat = ((VerticalViewPager.ItemInfo)localObject1).offset * f3;
      }
      if (((VerticalViewPager.ItemInfo)localObject2).position != this.mAdapter.getCount() - 1) {
        f1 = ((VerticalViewPager.ItemInfo)localObject2).offset * f3;
      }
      if (f2 >= paramFloat)
      {
        paramFloat = f2;
        if (f2 > f1) {
          paramFloat = f1;
        }
      }
      f1 = this.mLastMotionY;
      int i = (int)paramFloat;
      this.mLastMotionY = (f1 + (paramFloat - i));
      scrollTo(getScrollX(), i);
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, 0.0F, this.mLastMotionY, 0);
      this.mVelocityTracker.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalViewPager.LayoutParams(getContext(), paramAttributeSet);
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
    this.mDefaultGutterSize = ((int)(f * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new VerticalViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  public boolean internalCanScrollVertically(int paramInt)
  {
    PagerAdapter localPagerAdapter = this.mAdapter;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localPagerAdapter == null) {
      return false;
    }
    int i = getClientHeight();
    int j = getScrollY();
    if (paramInt < 0)
    {
      if (j > (int)(i * this.mFirstOffset)) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (j < (int)(i * this.mLastOffset)) {
        bool1 = true;
      }
    }
    return bool1;
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
      int k = getScrollY();
      int m = getHeight();
      float f1 = this.mPageMargin;
      float f5 = m;
      float f2 = f1 / f5;
      Object localObject = this.mItems;
      int j = 0;
      localObject = (VerticalViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((VerticalViewPager.ItemInfo)localObject).offset;
      int n = this.mItems.size();
      int i = ((VerticalViewPager.ItemInfo)localObject).position;
      int i1 = ((VerticalViewPager.ItemInfo)this.mItems.get(n - 1)).position;
      while (i < i1)
      {
        while ((i > ((VerticalViewPager.ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (VerticalViewPager.ItemInfo)((ArrayList)localObject).get(j);
        }
        float f3;
        if (i == ((VerticalViewPager.ItemInfo)localObject).position)
        {
          f3 = (((VerticalViewPager.ItemInfo)localObject).offset + ((VerticalViewPager.ItemInfo)localObject).heightFactor) * f5;
          f1 = ((VerticalViewPager.ItemInfo)localObject).offset + ((VerticalViewPager.ItemInfo)localObject).heightFactor + f2;
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
          this.mMarginDrawable.setBounds(this.mLeftPageBounds, (int)f3, this.mRightPageBounds, (int)(i2 + f3 + 0.5F));
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
            float f2 = MotionEventCompat.getY(paramMotionEvent, i);
            f1 = f2 - this.mLastMotionY;
            float f4 = Math.abs(f1);
            float f3 = MotionEventCompat.getX(paramMotionEvent, i);
            float f5 = Math.abs(f3 - this.mInitialMotionX);
            if (this.scrollForbidden)
            {
              float f6 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
              if ((f4 >= f6) || (f5 >= f6))
              {
                this.mIsBeingDragged = true;
                break label491;
              }
            }
            if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionY, f1)) && (canScroll(this, false, (int)f1, (int)f3, (int)f2)))
            {
              this.mLastMotionX = f3;
              this.mLastMotionY = f2;
              this.mIsUnableToDrag = true;
              return false;
            }
            if ((f4 > this.mTouchSlop) && (f4 * 0.5F > f5))
            {
              this.mIsBeingDragged = true;
              requestParentDisallowInterceptTouchEvent(true);
              setScrollState(1);
              if (f1 > 0.0F) {
                f1 = this.mInitialMotionY + this.mTouchSlop;
              } else {
                f1 = this.mInitialMotionY - this.mTouchSlop;
              }
              this.mLastMotionY = f1;
              this.mLastMotionX = f3;
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
        }
      }
      label491:
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
    int i = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollY();
    int k = 0;
    int m = 0;
    View localView;
    int j;
    VerticalViewPager.LayoutParams localLayoutParams;
    while (m < i3)
    {
      localView = getChildAt(m);
      int i2 = paramInt1;
      j = paramInt2;
      int i1 = paramInt4;
      int n = i;
      paramInt3 = k;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
        i2 = paramInt1;
        j = paramInt2;
        i1 = paramInt4;
        n = i;
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
                j = paramInt2;
              }
              else
              {
                paramInt3 = i4 - i - localView.getMeasuredWidth();
                i += localView.getMeasuredWidth();
                j = paramInt2;
              }
            }
            else
            {
              j = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              j += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i4 - localView.getMeasuredWidth()) / 2, paramInt2);
            j = paramInt2;
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
          paramInt2 += i6;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = k + 1;
          n = i;
          i1 = paramInt4;
          i2 = paramInt1;
        }
      }
      m += 1;
      paramInt1 = i2;
      paramInt2 = j;
      paramInt4 = i1;
      i = n;
      k = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i3)
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
            float f = i5 - paramInt1 - paramInt4;
            j = (int)(localItemInfo.offset * f) + paramInt1;
            if (localLayoutParams.needsMeasure)
            {
              localLayoutParams.needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec(i4 - paramInt2 - i, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(f * localLayoutParams.heightFactor), 1073741824));
            }
            localView.layout(paramInt2, j, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + j);
          }
        }
      }
      paramInt3 += 1;
    }
    this.mLeftPageBounds = paramInt2;
    this.mRightPageBounds = (i4 - i);
    this.mDecorChildCount = k;
    if (this.mFirstLayout) {
      scrollToItem(this.mCurItem, false, 0, false);
    }
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredHeight();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int i4 = getChildCount();
    paramInt1 = paramInt1 - i - j;
    int k = 0;
    View localView;
    VerticalViewPager.LayoutParams localLayoutParams;
    for (;;)
    {
      int i1 = 1;
      int i3 = 1073741824;
      if (k >= i4) {
        break;
      }
      localView = getChildAt(k);
      i = paramInt2;
      j = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt2;
        j = paramInt1;
        if (localLayoutParams != null)
        {
          i = paramInt2;
          j = paramInt1;
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
            int m = i1;
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
                break label259;
              }
            }
            i = -2147483648;
            label259:
            int i2;
            if (localLayoutParams.width != -2)
            {
              if (localLayoutParams.width != -1) {
                j = localLayoutParams.width;
              } else {
                j = paramInt2;
              }
              i1 = 1073741824;
              i2 = j;
            }
            else
            {
              i2 = paramInt2;
              i1 = j;
            }
            if (localLayoutParams.height != -2)
            {
              if (localLayoutParams.height != -1) {
                i = localLayoutParams.height;
              } else {
                i = paramInt1;
              }
            }
            else
            {
              j = paramInt1;
              i3 = i;
              i = j;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), View.MeasureSpec.makeMeasureSpec(i, i3));
            if (n != 0)
            {
              j = paramInt1 - localView.getMeasuredHeight();
              i = paramInt2;
            }
            else
            {
              i = paramInt2;
              j = paramInt1;
              if (m != 0)
              {
                i = paramInt2 - localView.getMeasuredWidth();
                j = paramInt1;
              }
            }
          }
        }
      }
      k += 1;
      paramInt2 = i;
      paramInt1 = j;
    }
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
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
        localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.isDecor))
        {
          j = View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.heightFactor), 1073741824);
          localView.measure(this.mChildWidthMeasureSpec, j);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = this.mDecorChildCount;
    int i1 = 0;
    if (i > 0)
    {
      int i2 = getScrollY();
      i = getPaddingTop();
      int j = getPaddingBottom();
      int i3 = getHeight();
      int i4 = getChildCount();
      int m = 0;
      while (m < i4)
      {
        localObject = getChildAt(m);
        VerticalViewPager.LayoutParams localLayoutParams = (VerticalViewPager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.isDecor)
        {
          int k = localLayoutParams.gravity & 0x70;
          if (k != 16)
          {
            int n;
            if (k != 48)
            {
              if (k != 80)
              {
                n = i;
                k = i;
                i = n;
              }
              else
              {
                k = i3 - j - ((View)localObject).getMeasuredHeight();
                j += ((View)localObject).getMeasuredHeight();
              }
            }
            else
            {
              n = ((View)localObject).getHeight() + i;
              k = i;
              i = n;
            }
          }
          else
          {
            k = Math.max((i3 - ((View)localObject).getMeasuredHeight()) / 2, i);
          }
          k = k + i2 - ((View)localObject).getTop();
          if (k != 0) {
            ((View)localObject).offsetTopAndBottom(k);
          }
        }
        m += 1;
      }
    }
    Object localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((ILiveOnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.mInternalPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mPageTransformer != null)
    {
      paramInt2 = getScrollY();
      i = getChildCount();
      paramInt1 = i1;
      while (paramInt1 < i)
      {
        localObject = getChildAt(paramInt1);
        if (!((VerticalViewPager.LayoutParams)((View)localObject).getLayoutParams()).isDecor)
        {
          paramFloat = (((View)localObject).getTop() - paramInt2) / getClientHeight();
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
        VerticalViewPager.ItemInfo localItemInfo = infoForChild(localView);
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
    if (!(paramParcelable instanceof VerticalViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (VerticalViewPager.SavedState)paramParcelable;
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
    VerticalViewPager.SavedState localSavedState = new VerticalViewPager.SavedState(super.onSaveInstanceState());
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
    if (paramInt2 != paramInt4)
    {
      paramInt1 = this.mPageMargin;
      recomputeScrollPosition(paramInt2, paramInt4, paramInt1, paramInt1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.scrollForbidden) {
      return true;
    }
    if (this.mFakeDragging) {
      return true;
    }
    int j = paramMotionEvent.getAction();
    boolean bool1 = false;
    if ((j == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
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
      j = paramMotionEvent.getAction() & 0xFF;
      float f1;
      int i;
      if (j != 0)
      {
        boolean bool3;
        boolean bool2;
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 5)
              {
                if (j != 6) {
                  break label630;
                }
                onSecondaryPointerUp(paramMotionEvent);
                this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
                break label630;
              }
              j = MotionEventCompat.getActionIndex(paramMotionEvent);
              this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, j);
              this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, j);
              break label630;
            }
            if (!this.mIsBeingDragged) {
              break label630;
            }
            scrollToItem(this.mCurItem, true, 0, false);
            this.mActivePointerId = -1;
            endDrag();
            bool3 = this.mTopEdge.onRelease();
            bool2 = this.mBottomEdge.onRelease();
          }
          else
          {
            if (!this.mIsBeingDragged)
            {
              j = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
              f1 = MotionEventCompat.getY(paramMotionEvent, j);
              float f3 = Math.abs(f1 - this.mLastMotionY);
              float f2 = MotionEventCompat.getX(paramMotionEvent, j);
              float f4 = Math.abs(f2 - this.mLastMotionX);
              if ((f3 > this.mTouchSlop) && (f3 > f4))
              {
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                f3 = this.mInitialMotionY;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + this.mTouchSlop;
                } else {
                  f1 = f3 - this.mTouchSlop;
                }
                this.mLastMotionY = f1;
                this.mLastMotionX = f2;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            if (!this.mIsBeingDragged) {
              break label630;
            }
            bool1 = false | performDrag(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)));
            break label630;
          }
        }
        else
        {
          if (!this.mIsBeingDragged) {
            break label630;
          }
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          i = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.mActivePointerId);
          this.mPopulatePending = true;
          j = getClientHeight();
          int k = getScrollY();
          localObject = infoForCurrentScrollPosition();
          setCurrentItemInternal(determineTargetPage(((VerticalViewPager.ItemInfo)localObject).position, (k / j - ((VerticalViewPager.ItemInfo)localObject).offset) / ((VerticalViewPager.ItemInfo)localObject).heightFactor, i, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, i);
          this.mActivePointerId = -1;
          endDrag();
          bool3 = this.mTopEdge.onRelease();
          bool2 = this.mBottomEdge.onRelease();
        }
        i = bool3 | bool2;
      }
      else
      {
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      }
      label630:
      if (i != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
    }
    return false;
  }
  
  boolean pageDown()
  {
    PagerAdapter localPagerAdapter = this.mAdapter;
    if ((localPagerAdapter != null) && (this.mCurItem < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageUp()
  {
    int i = this.mCurItem;
    if (i > 0)
    {
      setCurrentItem(i - 1, true);
      return true;
    }
    return false;
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  public void populate(int paramInt)
  {
    int i = this.mCurItem;
    Object localObject4 = null;
    if (i != paramInt)
    {
      if (i < paramInt) {
        i = 130;
      } else {
        i = 33;
      }
      localObject2 = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
    }
    else
    {
      i = 2;
      localObject2 = null;
    }
    if (this.mAdapter == null)
    {
      sortChildDrawingOrder();
      return;
    }
    if (this.mPopulatePending)
    {
      sortChildDrawingOrder();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.mAdapter.startUpdate(this);
    paramInt = this.mOffscreenPageLimit;
    int k = this.mCurItem;
    int j = 0;
    k = Math.max(0, k - paramInt);
    int m = this.mAdapter.getCount();
    int n = Math.min(m - 1, this.mCurItem + paramInt);
    if (m == this.mExpectedAdapterCount)
    {
      paramInt = 0;
      while (paramInt < this.mItems.size())
      {
        localObject1 = (VerticalViewPager.ItemInfo)this.mItems.get(paramInt);
        if (((VerticalViewPager.ItemInfo)localObject1).position >= this.mCurItem)
        {
          if (((VerticalViewPager.ItemInfo)localObject1).position != this.mCurItem) {
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
        if (m > 0) {
          localObject3 = addNewItem(this.mCurItem, paramInt);
        }
      }
      handlePopulateStageOne((VerticalViewPager.ItemInfo)localObject3, k, paramInt, n, (VerticalViewPager.ItemInfo)localObject2, m);
      localObject2 = this.mAdapter;
      paramInt = this.mCurItem;
      if (localObject3 != null) {
        localObject1 = ((VerticalViewPager.ItemInfo)localObject3).object;
      } else {
        localObject1 = null;
      }
      ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
      this.mAdapter.finishUpdate(this);
      k = getChildCount();
      paramInt = 0;
      while (paramInt < k)
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
      sortChildDrawingOrder();
      if (hasFocus())
      {
        localObject2 = findFocus();
        localObject1 = localObject4;
        if (localObject2 != null) {
          localObject1 = infoForAnyChild((View)localObject2);
        }
        paramInt = j;
        if (localObject1 != null)
        {
          if (((VerticalViewPager.ItemInfo)localObject1).position != this.mCurItem) {
            paramInt = j;
          }
        }
        else {
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = infoForChild((View)localObject1);
            if ((localObject2 != null) && (((VerticalViewPager.ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(i))) {
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
      label524:
      break label524;
    }
    Object localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.mExpectedAdapterCount);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(m);
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
    Object localObject = this.mAdapter;
    if (localObject != null)
    {
      ((PagerAdapter)localObject).unregisterDataSetObserver(this.mObserver);
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
    localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new VerticalViewPager.PagerObserver(this, null);
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
    VerticalViewPager.OnAdapterChangeListener localOnAdapterChangeListener = this.mAdapterChangeListener;
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
          ((VerticalViewPager.ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
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
            ((ILiveOnPageChangeListener)localObject).onPageSelected(i);
          }
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
      paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 5.0F) * 100.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager
 * JD-Core Version:    0.7.0.1
 */