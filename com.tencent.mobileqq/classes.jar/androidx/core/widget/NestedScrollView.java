package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements NestedScrollingChild3, NestedScrollingParent3, ScrollingView
{
  private static final NestedScrollView.AccessibilityDelegate ACCESSIBILITY_DELEGATE = new NestedScrollView.AccessibilityDelegate();
  static final int ANIMATED_SCROLL_GAP = 250;
  private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
  private static final int INVALID_POINTER = -1;
  static final float MAX_SCROLL_FACTOR = 0.5F;
  private static final int[] SCROLLVIEW_STYLEABLE = { 16843130 };
  private static final String TAG = "NestedScrollView";
  private int mActivePointerId = -1;
  private final NestedScrollingChildHelper mChildHelper;
  private View mChildToScrollTo = null;
  private EdgeEffect mEdgeGlowBottom;
  private EdgeEffect mEdgeGlowTop;
  private boolean mFillViewport;
  private boolean mIsBeingDragged = false;
  private boolean mIsLaidOut = false;
  private boolean mIsLayoutDirty = true;
  private int mLastMotionY;
  private long mLastScroll;
  private int mLastScrollerY;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private int mNestedYOffset;
  private NestedScrollView.OnScrollChangeListener mOnScrollChangeListener;
  private final NestedScrollingParentHelper mParentHelper;
  private NestedScrollView.SavedState mSavedState;
  private final int[] mScrollConsumed = new int[2];
  private final int[] mScrollOffset = new int[2];
  private OverScroller mScroller;
  private boolean mSmoothScrollingEnabled = true;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private float mVerticalScrollFactor;
  
  public NestedScrollView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScrollView();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, SCROLLVIEW_STYLEABLE, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.mParentHelper = new NestedScrollingParentHelper(this);
    this.mChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
  }
  
  private void abortAnimatedScroll()
  {
    this.mScroller.abortAnimation();
    stopNestedScroll(1);
  }
  
  private boolean canScroll()
  {
    int i = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      bool1 = bool2;
      if (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin > getHeight() - getPaddingTop() - getPaddingBottom()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      if (paramInt2 + paramInt1 > paramInt3) {
        return paramInt3 - paramInt2;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private void doScrollY(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.mSmoothScrollingEnabled)
      {
        smoothScrollBy(0, paramInt);
        return;
      }
      scrollBy(0, paramInt);
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    recycleVelocityTracker();
    stopNestedScroll(0);
    EdgeEffect localEdgeEffect = this.mEdgeGlowTop;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      this.mEdgeGlowBottom.onRelease();
    }
  }
  
  private void ensureGlows()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.mEdgeGlowTop == null)
      {
        Context localContext = getContext();
        this.mEdgeGlowTop = new EdgeEffect(localContext);
        this.mEdgeGlowBottom = new EdgeEffect(localContext);
      }
    }
    else
    {
      this.mEdgeGlowTop = null;
      this.mEdgeGlowBottom = null;
    }
  }
  
  private View findFocusableViewInBounds(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    int i1 = localArrayList.size();
    Object localObject2 = null;
    int k = 0;
    int j;
    for (int m = 0; k < i1; m = j)
    {
      View localView = (View)localArrayList.get(k);
      int n = localView.getTop();
      int i2 = localView.getBottom();
      Object localObject1 = localObject2;
      j = m;
      if (paramInt1 < i2)
      {
        localObject1 = localObject2;
        j = m;
        if (n < paramInt2)
        {
          int i;
          if ((paramInt1 < n) && (i2 < paramInt2)) {
            i = 1;
          } else {
            i = 0;
          }
          if (localObject2 == null)
          {
            localObject1 = localView;
            j = i;
          }
          else
          {
            if (((paramBoolean) && (n < localObject2.getTop())) || ((!paramBoolean) && (i2 > localObject2.getBottom()))) {
              n = 1;
            } else {
              n = 0;
            }
            if (m != 0)
            {
              localObject1 = localObject2;
              j = m;
              if (i == 0) {
                break label232;
              }
              localObject1 = localObject2;
              j = m;
              if (n == 0) {
                break label232;
              }
            }
            else
            {
              if (i != 0)
              {
                localObject1 = localView;
                j = 1;
                break label232;
              }
              localObject1 = localObject2;
              j = m;
              if (n == 0) {
                break label232;
              }
            }
            localObject1 = localView;
            j = m;
          }
        }
      }
      label232:
      k += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (this.mVerticalScrollFactor == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.mVerticalScrollFactor = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return this.mVerticalScrollFactor;
  }
  
  private boolean inChild(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      i = getScrollY();
      View localView = getChildAt(0);
      bool1 = bool2;
      if (paramInt2 >= localView.getTop() - i)
      {
        bool1 = bool2;
        if (paramInt2 < localView.getBottom() - i)
        {
          bool1 = bool2;
          if (paramInt1 >= localView.getLeft())
          {
            bool1 = bool2;
            if (paramInt1 < localView.getRight()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void initOrResetVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void initScrollView()
  {
    this.mScroller = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isOffScreen(View paramView)
  {
    return isWithinDeltaOfScreen(paramView, 0, getHeight()) ^ true;
  }
  
  private static boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2));
  }
  
  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    return (this.mTempRect.bottom + paramInt1 >= getScrollY()) && (this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void onNestedScrollInternal(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt)
  {
    int i = getScrollY();
    scrollBy(0, paramInt1);
    i = getScrollY() - i;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[1] += i;
    }
    this.mChildHelper.dispatchNestedScroll(0, i, 0, paramInt1 - i, null, paramInt2, paramArrayOfInt);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mLastMotionY = ((int)paramMotionEvent.getY(i));
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      paramMotionEvent = this.mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private void recycleVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void runAnimatedScroll(boolean paramBoolean)
  {
    if (paramBoolean) {
      startNestedScroll(2, 1);
    } else {
      stopNestedScroll(1);
    }
    this.mLastScrollerY = getScrollY();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getHeight();
    int i = getScrollY();
    j += i;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    View localView = findFocusableViewInBounds(bool1, paramInt2, paramInt3);
    Object localObject = localView;
    if (localView == null) {
      localObject = this;
    }
    if ((paramInt2 >= i) && (paramInt3 <= j))
    {
      bool1 = bool2;
    }
    else
    {
      if (bool1) {
        paramInt2 -= i;
      } else {
        paramInt2 = paramInt3 - j;
      }
      doScrollY(paramInt2);
      bool1 = true;
    }
    if (localObject != findFocus()) {
      ((View)localObject).requestFocus(paramInt1);
    }
    return bool1;
  }
  
  private void scrollToChild(View paramView)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private boolean scrollToChildRect(Rect paramRect, boolean paramBoolean)
  {
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramBoolean)
      {
        scrollBy(0, i);
        return bool;
      }
      smoothScrollBy(0, i);
    }
    return bool;
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = localLayoutParams.topMargin;
      int k = localLayoutParams.bottomMargin;
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, Math.max(0, i + j + k - (m - n - i1))));
      this.mScroller.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1, paramInt3);
      runAnimatedScroll(paramBoolean);
    }
    else
    {
      if (!this.mScroller.isFinished()) {
        abortAnimatedScroll();
      }
      scrollBy(paramInt1, paramInt2);
    }
    this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int j = getMaxScrollAmount();
    if ((localView2 != null) && (isWithinDeltaOfScreen(localView2, j, getHeight())))
    {
      localView2.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView2, this.mTempRect);
      doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      localView2.requestFocus(paramInt);
    }
    else
    {
      int i;
      if ((paramInt == 33) && (getScrollY() < j))
      {
        i = getScrollY();
      }
      else
      {
        i = j;
        if (paramInt == 130)
        {
          i = j;
          if (getChildCount() > 0)
          {
            localView2 = getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView2.getLayoutParams();
            i = Math.min(localView2.getBottom() + localLayoutParams.bottomMargin - (getScrollY() + getHeight() - getPaddingBottom()), j);
          }
        }
      }
      if (i == 0) {
        return false;
      }
      if (paramInt != 130) {
        i = -i;
      }
      doScrollY(i);
    }
    if ((localView1 != null) && (localView1.isFocused()) && (isOffScreen(localView1)))
    {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    }
    return true;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    if (this.mScroller.isFinished()) {
      return;
    }
    this.mScroller.computeScrollOffset();
    int j = this.mScroller.getCurrY();
    int i = j - this.mLastScrollerY;
    this.mLastScrollerY = j;
    int[] arrayOfInt = this.mScrollConsumed;
    int k = 0;
    arrayOfInt[1] = 0;
    dispatchNestedPreScroll(0, i, arrayOfInt, null, 1);
    j = i - this.mScrollConsumed[1];
    int m = getScrollRange();
    i = j;
    if (j != 0)
    {
      i = getScrollY();
      overScrollByCompat(0, j, getScrollX(), i, 0, m, 0, 0, false);
      i = getScrollY() - i;
      j -= i;
      arrayOfInt = this.mScrollConsumed;
      arrayOfInt[1] = 0;
      dispatchNestedScroll(0, i, 0, j, this.mScrollOffset, 1, arrayOfInt);
      i = j - this.mScrollConsumed[1];
    }
    if (i != 0)
    {
      int n = getOverScrollMode();
      if (n != 0)
      {
        j = k;
        if (n == 1)
        {
          j = k;
          if (m <= 0) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j != 0)
      {
        ensureGlows();
        if (i < 0)
        {
          if (this.mEdgeGlowTop.isFinished()) {
            this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
          }
        }
        else if (this.mEdgeGlowBottom.isFinished()) {
          this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
        }
      }
      abortAnimatedScroll();
    }
    if (!this.mScroller.isFinished())
    {
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    stopNestedScroll(1);
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    int i = getChildCount();
    int m = 0;
    if (i == 0) {
      return 0;
    }
    int n = getHeight();
    int j = getScrollY();
    int k = j + n;
    int i1 = getVerticalFadingEdgeLength();
    i = j;
    if (paramRect.top > 0) {
      i = j + i1;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    if (paramRect.bottom < localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin) {
      j = k - i1;
    } else {
      j = k;
    }
    if ((paramRect.bottom > j) && (paramRect.top > i))
    {
      if (paramRect.height() > n) {
        i = paramRect.top - i;
      } else {
        i = paramRect.bottom - j;
      }
      return Math.min(i + 0, localView.getBottom() + localLayoutParams.bottomMargin - k);
    }
    k = m;
    if (paramRect.top < i)
    {
      k = m;
      if (paramRect.bottom < j)
      {
        if (paramRect.height() > n) {
          i = 0 - (j - paramRect.bottom);
        } else {
          i = 0 - (i - paramRect.top);
        }
        k = Math.max(i, -getScrollY());
      }
    }
    return k;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0) {
      return i;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    j = localView.getBottom() + localLayoutParams.bottomMargin;
    int k = getScrollY();
    int m = Math.max(0, j - i);
    if (k < 0) {
      return j - k;
    }
    i = j;
    if (k > m) {
      i = j + (k - m);
    }
    return i;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.mChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.mChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return this.mChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt1, int paramInt5, @NonNull int[] paramArrayOfInt2)
  {
    this.mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return this.mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mEdgeGlowTop != null)
    {
      int i3 = getScrollY();
      boolean bool = this.mEdgeGlowTop.isFinished();
      int n = 0;
      int i4;
      int i;
      int i2;
      int i1;
      int j;
      int m;
      int k;
      if (!bool)
      {
        i4 = paramCanvas.save();
        i = getWidth();
        i2 = getHeight();
        i1 = Math.min(0, i3);
        if ((Build.VERSION.SDK_INT >= 21) && (!getClipToPadding()))
        {
          j = 0;
        }
        else
        {
          i -= getPaddingLeft() + getPaddingRight();
          j = getPaddingLeft() + 0;
        }
        m = i2;
        k = i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          m = i2;
          k = i1;
          if (getClipToPadding())
          {
            m = i2 - (getPaddingTop() + getPaddingBottom());
            k = i1 + getPaddingTop();
          }
        }
        paramCanvas.translate(j, k);
        this.mEdgeGlowTop.setSize(i, m);
        if (this.mEdgeGlowTop.draw(paramCanvas)) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        paramCanvas.restoreToCount(i4);
      }
      if (!this.mEdgeGlowBottom.isFinished())
      {
        i4 = paramCanvas.save();
        k = getWidth();
        i1 = getHeight();
        i2 = Math.max(getScrollRange(), i3) + i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          j = n;
          i = k;
          if (!getClipToPadding()) {}
        }
        else
        {
          i = k - (getPaddingLeft() + getPaddingRight());
          j = 0 + getPaddingLeft();
        }
        m = i2;
        k = i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          m = i2;
          k = i1;
          if (getClipToPadding())
          {
            k = i1 - (getPaddingTop() + getPaddingBottom());
            m = i2 - getPaddingBottom();
          }
        }
        paramCanvas.translate(j - i, m);
        paramCanvas.rotate(180.0F, i, 0.0F);
        this.mEdgeGlowBottom.setSize(i, k);
        if (this.mEdgeGlowBottom.draw(paramCanvas)) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        paramCanvas.restoreToCount(i4);
      }
    }
  }
  
  public boolean executeKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    this.mTempRect.setEmpty();
    boolean bool3 = canScroll();
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 130;
    if (!bool3)
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          View localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130)) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    if (paramKeyEvent.getAction() == 0)
    {
      int j = paramKeyEvent.getKeyCode();
      if (j != 19)
      {
        if (j != 20)
        {
          if (j != 62) {
            return false;
          }
          if (paramKeyEvent.isShiftPressed()) {
            i = 33;
          }
          pageScroll(i);
          return false;
        }
        if (!paramKeyEvent.isAltPressed()) {
          return arrowScroll(130);
        }
        return fullScroll(130);
      }
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33);
      }
      bool1 = fullScroll(33);
    }
    return bool1;
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.mScroller.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      runAnimatedScroll(true);
    }
  }
  
  public boolean fullScroll(int paramInt)
  {
    int i;
    if (paramInt == 130) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getHeight();
    Object localObject = this.mTempRect;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = j;
    if (i != 0)
    {
      i = getChildCount();
      if (i > 0)
      {
        localObject = getChildAt(i - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        this.mTempRect.bottom = (((View)localObject).getBottom() + localLayoutParams.bottomMargin + getPaddingBottom());
        localObject = this.mTempRect;
        ((Rect)localObject).top = (((Rect)localObject).bottom - j);
      }
    }
    return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = localView.getBottom() + localLayoutParams.bottomMargin - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(getHeight() * 0.5F);
  }
  
  public int getNestedScrollAxes()
  {
    return this.mParentHelper.getNestedScrollAxes();
  }
  
  int getScrollRange()
  {
    int j = getChildCount();
    int i = 0;
    if (j > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      i = Math.max(0, localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin - (getHeight() - getPaddingTop() - getPaddingBottom()));
    }
    return i;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return hasNestedScrollingParent(0);
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return this.mChildHelper.hasNestedScrollingParent(paramInt);
  }
  
  public boolean isFillViewport()
  {
    return this.mFillViewport;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.mChildHelper.isNestedScrollingEnabled();
  }
  
  public boolean isSmoothScrollingEnabled()
  {
    return this.mSmoothScrollingEnabled;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin, 0));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mIsLaidOut = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0)
    {
      if (paramMotionEvent.getAction() != 8) {
        return false;
      }
      if (!this.mIsBeingDragged)
      {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F)
        {
          int i = (int)(f * getVerticalScrollFactorCompat());
          int j = getScrollRange();
          int m = getScrollY();
          int k = m - i;
          if (k < 0)
          {
            i = 0;
          }
          else
          {
            i = k;
            if (k > j) {
              i = j;
            }
          }
          if (i != m)
          {
            super.scrollTo(getScrollX(), i);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    i &= 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              break label342;
            }
            onSecondaryPointerUp(paramMotionEvent);
            break label342;
          }
        }
        else
        {
          i = this.mActivePointerId;
          if (i == -1) {
            break label342;
          }
          int j = paramMotionEvent.findPointerIndex(i);
          if (j == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(i);
            paramMotionEvent.append(" in onInterceptTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
            break label342;
          }
          i = (int)paramMotionEvent.getY(j);
          if ((Math.abs(i - this.mLastMotionY) <= this.mTouchSlop) || ((0x2 & getNestedScrollAxes()) != 0)) {
            break label342;
          }
          this.mIsBeingDragged = true;
          this.mLastMotionY = i;
          initVelocityTrackerIfNotExists();
          this.mVelocityTracker.addMovement(paramMotionEvent);
          this.mNestedYOffset = 0;
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label342;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label342;
        }
      }
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      recycleVelocityTracker();
      if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      stopNestedScroll(0);
    }
    else
    {
      i = (int)paramMotionEvent.getY();
      if (!inChild((int)paramMotionEvent.getX(), i))
      {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
      }
      else
      {
        this.mLastMotionY = i;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mScroller.computeScrollOffset();
        this.mIsBeingDragged = (this.mScroller.isFinished() ^ true);
        startNestedScroll(2, 0);
      }
    }
    label342:
    return this.mIsBeingDragged;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    this.mIsLayoutDirty = false;
    View localView = this.mChildToScrollTo;
    if ((localView != null) && (isViewDescendantOf(localView, this))) {
      scrollToChild(this.mChildToScrollTo);
    }
    this.mChildToScrollTo = null;
    if (!this.mIsLaidOut)
    {
      if (this.mSavedState != null)
      {
        scrollTo(getScrollX(), this.mSavedState.scrollPosition);
        this.mSavedState = null;
      }
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        paramInt1 = localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      }
      int i = getPaddingTop();
      int j = getPaddingBottom();
      paramInt3 = getScrollY();
      paramInt1 = clamp(paramInt3, paramInt4 - paramInt2 - i - j, paramInt1);
      if (paramInt1 != paramInt3) {
        scrollTo(getScrollX(), paramInt1);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    this.mIsLaidOut = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.mFillViewport) {
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = localView.getMeasuredHeight();
      int i = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - localLayoutParams.topMargin - localLayoutParams.bottomMargin;
      if (paramInt2 < i) {
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      }
    }
  }
  
  public boolean onNestedFling(@NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      dispatchNestedFling(0.0F, paramFloat2, true);
      fling((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScrollInternal(paramInt4, 0, null);
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    onNestedScrollInternal(paramInt4, paramInt5, null);
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
  {
    onNestedScrollInternal(paramInt4, paramInt5, paramArrayOfInt);
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    this.mParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    startNestedScroll(2, paramInt2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    if (paramInt == 2)
    {
      i = 130;
    }
    else
    {
      i = paramInt;
      if (paramInt == 1) {
        i = 33;
      }
    }
    View localView;
    if (paramRect == null) {
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
    } else {
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
    }
    if (localView == null) {
      return false;
    }
    if (isOffScreen(localView)) {
      return false;
    }
    return localView.requestFocus(i, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NestedScrollView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NestedScrollView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mSavedState = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NestedScrollView.SavedState localSavedState = new NestedScrollView.SavedState(super.onSaveInstanceState());
    localSavedState.scrollPosition = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    NestedScrollView.OnScrollChangeListener localOnScrollChangeListener = this.mOnScrollChangeListener;
    if (localOnScrollChangeListener != null) {
      localOnScrollChangeListener.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if (localView != null)
    {
      if (this == localView) {
        return;
      }
      if (isWithinDeltaOfScreen(localView, 0, paramInt4))
      {
        localView.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(localView, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      }
    }
  }
  
  public boolean onStartNestedScroll(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    return onStartNestedScroll(paramView1, paramView2, paramInt, 0);
  }
  
  public boolean onStartNestedScroll(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void onStopNestedScroll(@NonNull View paramView)
  {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(@NonNull View paramView, int paramInt)
  {
    this.mParentHelper.onStopNestedScroll(paramView, paramInt);
    stopNestedScroll(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.mNestedYOffset = 0;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(0.0F, this.mNestedYOffset);
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i == 6)
              {
                onSecondaryPointerUp(paramMotionEvent);
                this.mLastMotionY = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
              }
            }
            else
            {
              i = paramMotionEvent.getActionIndex();
              this.mLastMotionY = ((int)paramMotionEvent.getY(i));
              this.mActivePointerId = paramMotionEvent.getPointerId(i);
            }
          }
          else
          {
            if ((this.mIsBeingDragged) && (getChildCount() > 0) && (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
            this.mActivePointerId = -1;
            endDrag();
          }
        }
        else
        {
          int k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (k == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(this.mActivePointerId);
            paramMotionEvent.append(" in onTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
          }
          else
          {
            int m = (int)paramMotionEvent.getY(k);
            int j = this.mLastMotionY - m;
            i = j;
            if (!this.mIsBeingDragged)
            {
              i = j;
              if (Math.abs(j) > this.mTouchSlop)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
                this.mIsBeingDragged = true;
                if (j > 0) {
                  i = j - this.mTouchSlop;
                } else {
                  i = j + this.mTouchSlop;
                }
              }
            }
            j = i;
            if (this.mIsBeingDragged)
            {
              i = j;
              if (dispatchNestedPreScroll(0, j, this.mScrollConsumed, this.mScrollOffset, 0))
              {
                i = j - this.mScrollConsumed[1];
                this.mNestedYOffset += this.mScrollOffset[1];
              }
              this.mLastMotionY = (m - this.mScrollOffset[1]);
              int n = getScrollY();
              m = getScrollRange();
              j = getOverScrollMode();
              if ((j != 0) && ((j != 1) || (m <= 0))) {
                j = 0;
              } else {
                j = 1;
              }
              if ((overScrollByCompat(0, i, 0, getScrollY(), 0, m, 0, 0, true)) && (!hasNestedScrollingParent(0))) {
                this.mVelocityTracker.clear();
              }
              int i1 = getScrollY() - n;
              localObject = this.mScrollConsumed;
              localObject[1] = 0;
              dispatchNestedScroll(0, i1, 0, i - i1, this.mScrollOffset, 0, (int[])localObject);
              i1 = this.mLastMotionY;
              localObject = this.mScrollOffset;
              this.mLastMotionY = (i1 - localObject[1]);
              this.mNestedYOffset += localObject[1];
              if (j != 0)
              {
                i -= this.mScrollConsumed[1];
                ensureGlows();
                j = n + i;
                if (j < 0)
                {
                  EdgeEffectCompat.onPull(this.mEdgeGlowTop, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
                  if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                  }
                }
                else if (j > m)
                {
                  EdgeEffectCompat.onPull(this.mEdgeGlowBottom, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
                  if (!this.mEdgeGlowTop.isFinished()) {
                    this.mEdgeGlowTop.onRelease();
                  }
                }
                paramMotionEvent = this.mEdgeGlowTop;
                if ((paramMotionEvent != null) && ((!paramMotionEvent.isFinished()) || (!this.mEdgeGlowBottom.isFinished()))) {
                  ViewCompat.postInvalidateOnAnimation(this);
                }
              }
            }
          }
        }
      }
      else
      {
        paramMotionEvent = this.mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
        i = (int)paramMotionEvent.getYVelocity(this.mActivePointerId);
        if (Math.abs(i) >= this.mMinimumVelocity)
        {
          i = -i;
          float f = i;
          if (!dispatchNestedPreFling(0.0F, f))
          {
            dispatchNestedFling(0.0F, f, true);
            fling(i);
          }
        }
        else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))
        {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        this.mActivePointerId = -1;
        endDrag();
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      boolean bool = this.mScroller.isFinished() ^ true;
      this.mIsBeingDragged = bool;
      if (bool)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!this.mScroller.isFinished()) {
        abortAnimatedScroll();
      }
      this.mLastMotionY = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      startNestedScroll(2, 0);
    }
    paramMotionEvent = this.mVelocityTracker;
    if (paramMotionEvent != null) {
      paramMotionEvent.addMovement(localMotionEvent);
    }
    localMotionEvent.recycle();
    return true;
  }
  
  boolean overScrollByCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = getOverScrollMode();
    int i = computeHorizontalScrollRange();
    int j = computeHorizontalScrollExtent();
    boolean bool2 = false;
    if (i > j) {
      i = 1;
    } else {
      i = 0;
    }
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      j = 1;
    } else {
      j = 0;
    }
    if ((k != 0) && ((k != 1) || (i == 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((k != 0) && ((k != 1) || (j == 0))) {
      j = 0;
    } else {
      j = 1;
    }
    paramInt3 += paramInt1;
    if (i == 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = paramInt7;
    }
    paramInt4 += paramInt2;
    if (j == 0) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt8;
    }
    paramInt7 = -paramInt1;
    paramInt1 += paramInt5;
    paramInt5 = -paramInt2;
    paramInt6 = paramInt2 + paramInt6;
    if (paramInt3 > paramInt1) {}
    for (;;)
    {
      paramBoolean = true;
      paramInt2 = paramInt1;
      break label198;
      if (paramInt3 >= paramInt7) {
        break;
      }
      paramInt1 = paramInt7;
    }
    paramInt2 = paramInt3;
    paramBoolean = false;
    label198:
    if (paramInt4 > paramInt6) {}
    for (paramInt1 = paramInt6;; paramInt1 = paramInt5)
    {
      bool1 = true;
      break label233;
      if (paramInt4 >= paramInt5) {
        break;
      }
    }
    boolean bool1 = false;
    paramInt1 = paramInt4;
    label233:
    if ((bool1) && (!hasNestedScrollingParent(1))) {
      this.mScroller.springBack(paramInt2, paramInt1, 0, 0, 0, getScrollRange());
    }
    onOverScrolled(paramInt2, paramInt1, paramBoolean, bool1);
    if (!paramBoolean)
    {
      paramBoolean = bool2;
      if (!bool1) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean pageScroll(int paramInt)
  {
    int i;
    if (paramInt == 130) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getHeight();
    if (i != 0)
    {
      this.mTempRect.top = (getScrollY() + j);
      i = getChildCount();
      if (i > 0)
      {
        localObject = getChildAt(i - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        i = ((View)localObject).getBottom() + localLayoutParams.bottomMargin + getPaddingBottom();
        if (this.mTempRect.top + j > i) {
          this.mTempRect.top = (i - j);
        }
      }
    }
    else
    {
      this.mTempRect.top = (getScrollY() - j);
      if (this.mTempRect.top < 0) {
        this.mTempRect.top = 0;
      }
    }
    Object localObject = this.mTempRect;
    ((Rect)localObject).bottom = (((Rect)localObject).top + j);
    return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.mIsLayoutDirty) {
      scrollToChild(paramView2);
    } else {
      this.mChildToScrollTo = paramView2;
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return scrollToChildRect(paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.mIsLayoutDirty = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i2 = getWidth();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      int i5 = localView.getWidth();
      int i6 = localLayoutParams.leftMargin;
      int i7 = localLayoutParams.rightMargin;
      int i = getHeight();
      int j = getPaddingTop();
      int k = getPaddingBottom();
      int m = localView.getHeight();
      int n = localLayoutParams.topMargin;
      int i1 = localLayoutParams.bottomMargin;
      paramInt1 = clamp(paramInt1, i2 - i3 - i4, i5 + i6 + i7);
      paramInt2 = clamp(paramInt2, i - j - k, m + n + i1);
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.mFillViewport)
    {
      this.mFillViewport = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.mChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnScrollChangeListener(@Nullable NestedScrollView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.mOnScrollChangeListener = paramOnScrollChangeListener;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollingEnabled = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, 250, false);
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInt3, false);
  }
  
  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 250, false);
  }
  
  public final void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollTo(paramInt1, paramInt2, paramInt3, false);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY(), paramInt3, paramBoolean);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    smoothScrollTo(paramInt1, paramInt2, 250, paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return startNestedScroll(paramInt, 0);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return this.mChildHelper.startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopNestedScroll()
  {
    stopNestedScroll(0);
  }
  
  public void stopNestedScroll(int paramInt)
  {
    this.mChildHelper.stopNestedScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */