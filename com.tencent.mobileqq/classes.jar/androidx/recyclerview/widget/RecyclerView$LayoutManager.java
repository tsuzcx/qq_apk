package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.recyclerview.R.styleable;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager
{
  boolean mAutoMeasure = false;
  ChildHelper mChildHelper;
  private int mHeight;
  private int mHeightMode;
  ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
  private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new RecyclerView.LayoutManager.1(this);
  boolean mIsAttachedToWindow = false;
  private boolean mItemPrefetchEnabled = true;
  private boolean mMeasurementCacheEnabled = true;
  int mPrefetchMaxCountObserved;
  boolean mPrefetchMaxObservedInInitialPrefetch;
  RecyclerView mRecyclerView;
  boolean mRequestedSimpleAnimations = false;
  @Nullable
  RecyclerView.SmoothScroller mSmoothScroller;
  ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
  private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new RecyclerView.LayoutManager.2(this);
  private int mWidth;
  private int mWidthMode;
  
  private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
  {
    Object localObject = RecyclerView.getChildViewHolderInt(paramView);
    if ((!paramBoolean) && (!((RecyclerView.ViewHolder)localObject).isRemoved())) {
      this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout((RecyclerView.ViewHolder)localObject);
    } else {
      this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout((RecyclerView.ViewHolder)localObject);
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (!((RecyclerView.ViewHolder)localObject).isScrap()))
    {
      if (paramView.getParent() == this.mRecyclerView)
      {
        int j = this.mChildHelper.indexOfChild(paramView);
        int i = paramInt;
        if (paramInt == -1) {
          i = this.mChildHelper.getChildCount();
        }
        if (j != -1)
        {
          if (j != i) {
            this.mRecyclerView.mLayout.moveView(j, i);
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
          ((StringBuilder)localObject).append(this.mRecyclerView.indexOfChild(paramView));
          ((StringBuilder)localObject).append(this.mRecyclerView.exceptionLabel());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.mChildHelper.addView(paramView, paramInt, false);
        localLayoutParams.mInsetsDirty = true;
        RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
        if ((localSmoothScroller != null) && (localSmoothScroller.isRunning())) {
          this.mSmoothScroller.onChildAttachedToWindow(paramView);
        }
      }
    }
    else
    {
      if (((RecyclerView.ViewHolder)localObject).isScrap()) {
        ((RecyclerView.ViewHolder)localObject).unScrap();
      } else {
        ((RecyclerView.ViewHolder)localObject).clearReturnedFromScrapFlag();
      }
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    if (localLayoutParams.mPendingInvalidate)
    {
      ((RecyclerView.ViewHolder)localObject).itemView.invalidate();
      localLayoutParams.mPendingInvalidate = false;
    }
  }
  
  public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i != -2147483648)
    {
      if (i != 1073741824) {
        paramInt1 = Math.max(paramInt2, paramInt3);
      }
      return paramInt1;
    }
    return Math.min(paramInt1, Math.max(paramInt2, paramInt3));
  }
  
  private void detachViewInternal(int paramInt, @NonNull View paramView)
  {
    this.mChildHelper.detachViewFromParent(paramInt);
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    int i = Math.max(0, paramInt1 - paramInt3);
    if (paramBoolean)
    {
      if (paramInt4 < 0)
      {
        if (paramInt4 != -1) {
          break label120;
        }
        if ((paramInt2 != -2147483648) && ((paramInt2 == 0) || (paramInt2 != 1073741824)))
        {
          paramInt2 = 0;
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = i;
        }
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        break label125;
      }
    }
    else {
      if (paramInt4 < 0) {
        break label74;
      }
    }
    paramInt3 = paramInt4;
    paramInt1 = 1073741824;
    break label125;
    label74:
    if (paramInt4 == -1)
    {
      paramInt1 = paramInt2;
      paramInt3 = i;
    }
    else if (paramInt4 == -2)
    {
      if (paramInt2 != -2147483648)
      {
        paramInt3 = i;
        paramInt1 = j;
        if (paramInt2 != 1073741824) {}
      }
      else
      {
        paramInt1 = -2147483648;
        paramInt3 = i;
      }
    }
    else
    {
      label120:
      paramInt3 = 0;
      paramInt1 = j;
    }
    label125:
    return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
  }
  
  @Deprecated
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 0;
    paramInt1 = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean) {
      if (paramInt3 >= 0) {
        break label34;
      }
    }
    label34:
    do
    {
      paramInt1 = 0;
      paramInt2 = i;
      break;
      if (paramInt3 >= 0) {
        paramInt1 = paramInt3;
      }
      while (paramInt3 == -1)
      {
        paramInt2 = 1073741824;
        break;
      }
    } while (paramInt3 != -2);
    paramInt2 = -2147483648;
    return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
  }
  
  private int[] getChildRectangleOnScreenScrollAmount(View paramView, Rect paramRect)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int i5 = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    int i6 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
    int i2 = paramView.getTop() + paramRect.top - paramView.getScrollY();
    int i7 = paramRect.width();
    int i3 = paramRect.height();
    int i4 = i6 - i;
    i = Math.min(0, i4);
    int m = i2 - j;
    j = Math.min(0, m);
    i5 = i7 + i6 - (k - i5);
    k = Math.max(0, i5);
    n = Math.max(0, i3 + i2 - (n - i1));
    if (getLayoutDirection() == 1)
    {
      if (k != 0) {
        i = k;
      } else {
        i = Math.max(i, i5);
      }
    }
    else if (i == 0) {
      i = Math.min(i4, k);
    }
    if (j == 0) {
      j = Math.min(m, n);
    }
    return new int[] { i, j };
  }
  
  public static RecyclerView.LayoutManager.Properties getProperties(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager.Properties localProperties = new RecyclerView.LayoutManager.Properties();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
    localProperties.orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
    localProperties.spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
    localProperties.reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
    localProperties.stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
    paramContext.recycle();
    return localProperties;
  }
  
  private boolean isFocusedChildVisibleAfterScrolling(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = paramRecyclerView.getFocusedChild();
    if (paramRecyclerView == null) {
      return false;
    }
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    Rect localRect = this.mRecyclerView.mTempRect;
    getDecoratedBoundsWithMargins(paramRecyclerView, localRect);
    if ((localRect.left - paramInt1 < k - m) && (localRect.right - paramInt1 > i) && (localRect.top - paramInt2 < n - i1)) {
      return localRect.bottom - paramInt2 > j;
    }
    return false;
  }
  
  private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
      return false;
    }
    if (i != -2147483648)
    {
      if (i != 0)
      {
        if (i != 1073741824) {
          return false;
        }
        if (paramInt2 == paramInt1) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    bool1 = bool2;
    if (paramInt2 >= paramInt1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.shouldIgnore()) {
      return;
    }
    if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!this.mRecyclerView.mAdapter.hasStableIds()))
    {
      removeViewAt(paramInt);
      paramRecycler.recycleViewHolderInternal(localViewHolder);
      return;
    }
    detachViewAt(paramInt);
    paramRecycler.scrapView(paramView);
    this.mRecyclerView.mViewInfoStore.onViewDetached(localViewHolder);
  }
  
  public void addDisappearingView(View paramView)
  {
    addDisappearingView(paramView, -1);
  }
  
  public void addDisappearingView(View paramView, int paramInt)
  {
    addViewInt(paramView, paramInt, true);
  }
  
  public void addView(View paramView)
  {
    addView(paramView, -1);
  }
  
  public void addView(View paramView, int paramInt)
  {
    addViewInt(paramView, paramInt, false);
  }
  
  public void assertInLayoutOrScroll(String paramString)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.assertInLayoutOrScroll(paramString);
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public void attachView(@NonNull View paramView)
  {
    attachView(paramView, -1);
  }
  
  public void attachView(@NonNull View paramView, int paramInt)
  {
    attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
  }
  
  public void attachView(@NonNull View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.isRemoved()) {
      this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
    } else {
      this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
    }
    this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
  }
  
  public void calculateItemDecorationsForChild(@NonNull View paramView, @NonNull Rect paramRect)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(localRecyclerView.getItemDecorInsetsForChild(paramView));
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {}
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {}
  
  public int computeHorizontalScrollExtent(@NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollOffset(@NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollRange(@NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollExtent(@NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollOffset(@NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollRange(@NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void detachAndScrapAttachedViews(@NonNull RecyclerView.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      scrapOrRecycleView(paramRecycler, i, getChildAt(i));
      i -= 1;
    }
  }
  
  public void detachAndScrapView(@NonNull View paramView, @NonNull RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, this.mChildHelper.indexOfChild(paramView), paramView);
  }
  
  public void detachAndScrapViewAt(int paramInt, @NonNull RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
  }
  
  public void detachView(@NonNull View paramView)
  {
    int i = this.mChildHelper.indexOfChild(paramView);
    if (i >= 0) {
      detachViewInternal(i, paramView);
    }
  }
  
  public void detachViewAt(int paramInt)
  {
    detachViewInternal(paramInt, getChildAt(paramInt));
  }
  
  void dispatchAttachedToWindow(RecyclerView paramRecyclerView)
  {
    this.mIsAttachedToWindow = true;
    onAttachedToWindow(paramRecyclerView);
  }
  
  void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    this.mIsAttachedToWindow = false;
    onDetachedFromWindow(paramRecyclerView, paramRecycler);
  }
  
  public void endAnimation(View paramView)
  {
    if (this.mRecyclerView.mItemAnimator != null) {
      this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(paramView));
    }
  }
  
  @Nullable
  public View findContainingItemView(@NonNull View paramView)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView == null) {
      return null;
    }
    paramView = localRecyclerView.findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    if (this.mChildHelper.isHidden(paramView)) {
      return null;
    }
    return paramView;
  }
  
  @Nullable
  public View findViewByPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if ((localViewHolder != null) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.shouldIgnore()) && ((this.mRecyclerView.mState.isPreLayout()) || (!localViewHolder.isRemoved()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
      return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new RecyclerView.LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    return -1;
  }
  
  public int getBottomDecorationHeight(@NonNull View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.bottom;
  }
  
  @Nullable
  public View getChildAt(int paramInt)
  {
    ChildHelper localChildHelper = this.mChildHelper;
    if (localChildHelper != null) {
      return localChildHelper.getChildAt(paramInt);
    }
    return null;
  }
  
  public int getChildCount()
  {
    ChildHelper localChildHelper = this.mChildHelper;
    if (localChildHelper != null) {
      return localChildHelper.getChildCount();
    }
    return 0;
  }
  
  public boolean getClipToPadding()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    return (localRecyclerView != null) && (localRecyclerView.mClipToPadding);
  }
  
  public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
  {
    paramRecycler = this.mRecyclerView;
    int j = 1;
    int i = j;
    if (paramRecycler != null)
    {
      if (paramRecycler.mAdapter == null) {
        return 1;
      }
      i = j;
      if (canScrollHorizontally()) {
        i = this.mRecyclerView.mAdapter.getItemCount();
      }
    }
    return i;
  }
  
  public int getDecoratedBottom(@NonNull View paramView)
  {
    return paramView.getBottom() + getBottomDecorationHeight(paramView);
  }
  
  public void getDecoratedBoundsWithMargins(@NonNull View paramView, @NonNull Rect paramRect)
  {
    RecyclerView.getDecoratedBoundsWithMarginsInt(paramView, paramRect);
  }
  
  public int getDecoratedLeft(@NonNull View paramView)
  {
    return paramView.getLeft() - getLeftDecorationWidth(paramView);
  }
  
  public int getDecoratedMeasuredHeight(@NonNull View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
  }
  
  public int getDecoratedMeasuredWidth(@NonNull View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredWidth() + localRect.left + localRect.right;
  }
  
  public int getDecoratedRight(@NonNull View paramView)
  {
    return paramView.getRight() + getRightDecorationWidth(paramView);
  }
  
  public int getDecoratedTop(@NonNull View paramView)
  {
    return paramView.getTop() - getTopDecorationHeight(paramView);
  }
  
  @Nullable
  public View getFocusedChild()
  {
    Object localObject = this.mRecyclerView;
    if (localObject == null) {
      return null;
    }
    localObject = ((RecyclerView)localObject).getFocusedChild();
    if (localObject != null)
    {
      if (this.mChildHelper.isHidden((View)localObject)) {
        return null;
      }
      return localObject;
    }
    return null;
  }
  
  @Px
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getHeightMode()
  {
    return this.mHeightMode;
  }
  
  public int getItemCount()
  {
    Object localObject = this.mRecyclerView;
    if (localObject != null) {
      localObject = ((RecyclerView)localObject).getAdapter();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return ((RecyclerView.Adapter)localObject).getItemCount();
    }
    return 0;
  }
  
  public int getItemViewType(@NonNull View paramView)
  {
    return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
  }
  
  public int getLayoutDirection()
  {
    return ViewCompat.getLayoutDirection(this.mRecyclerView);
  }
  
  public int getLeftDecorationWidth(@NonNull View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.left;
  }
  
  @Px
  public int getMinimumHeight()
  {
    return ViewCompat.getMinimumHeight(this.mRecyclerView);
  }
  
  @Px
  public int getMinimumWidth()
  {
    return ViewCompat.getMinimumWidth(this.mRecyclerView);
  }
  
  @Px
  public int getPaddingBottom()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingBottom();
    }
    return 0;
  }
  
  @Px
  public int getPaddingEnd()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return ViewCompat.getPaddingEnd(localRecyclerView);
    }
    return 0;
  }
  
  @Px
  public int getPaddingLeft()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingLeft();
    }
    return 0;
  }
  
  @Px
  public int getPaddingRight()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingRight();
    }
    return 0;
  }
  
  @Px
  public int getPaddingStart()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return ViewCompat.getPaddingStart(localRecyclerView);
    }
    return 0;
  }
  
  @Px
  public int getPaddingTop()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingTop();
    }
    return 0;
  }
  
  public int getPosition(@NonNull View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
  }
  
  public int getRightDecorationWidth(@NonNull View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.right;
  }
  
  public int getRowCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
  {
    paramRecycler = this.mRecyclerView;
    int j = 1;
    int i = j;
    if (paramRecycler != null)
    {
      if (paramRecycler.mAdapter == null) {
        return 1;
      }
      i = j;
      if (canScrollVertically()) {
        i = this.mRecyclerView.mAdapter.getItemCount();
      }
    }
    return i;
  }
  
  public int getSelectionModeForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int getTopDecorationHeight(@NonNull View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.top;
  }
  
  public void getTransformedBoundingBox(@NonNull View paramView, boolean paramBoolean, @NonNull Rect paramRect)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      paramRect.set(-((Rect)localObject).left, -((Rect)localObject).top, paramView.getWidth() + ((Rect)localObject).right, paramView.getHeight() + ((Rect)localObject).bottom);
    }
    else
    {
      paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    }
    if (this.mRecyclerView != null)
    {
      localObject = paramView.getMatrix();
      if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
      {
        RectF localRectF = this.mRecyclerView.mTempRectF;
        localRectF.set(paramRect);
        ((Matrix)localObject).mapRect(localRectF);
        paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
      }
    }
    paramRect.offset(paramView.getLeft(), paramView.getTop());
  }
  
  @Px
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getWidthMode()
  {
    return this.mWidthMode;
  }
  
  boolean hasFlexibleChildInBothOrientations()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
      if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean hasFocus()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    return (localRecyclerView != null) && (localRecyclerView.hasFocus());
  }
  
  public void ignoreView(@NonNull View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    RecyclerView localRecyclerView = this.mRecyclerView;
    if ((localViewParent == localRecyclerView) && (localRecyclerView.indexOfChild(paramView) != -1))
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.addFlags(128);
      this.mRecyclerView.mViewInfoStore.removeViewHolder(paramView);
      return;
    }
    paramView = new StringBuilder();
    paramView.append("View should be fully attached to be ignored");
    paramView.append(this.mRecyclerView.exceptionLabel());
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.mIsAttachedToWindow;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return this.mAutoMeasure;
  }
  
  public boolean isFocused()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    return (localRecyclerView != null) && (localRecyclerView.isFocused());
  }
  
  public final boolean isItemPrefetchEnabled()
  {
    return this.mItemPrefetchEnabled;
  }
  
  public boolean isLayoutHierarchical(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
  {
    return false;
  }
  
  public boolean isMeasurementCacheEnabled()
  {
    return this.mMeasurementCacheEnabled;
  }
  
  public boolean isSmoothScrolling()
  {
    RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
    return (localSmoothScroller != null) && (localSmoothScroller.isRunning());
  }
  
  public boolean isViewPartiallyVisible(@NonNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mHorizontalBoundCheck.isViewWithinBoundFlags(paramView, 24579)) && (this.mVerticalBoundCheck.isViewWithinBoundFlags(paramView, 24579))) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    if (paramBoolean1) {
      return paramBoolean2;
    }
    return paramBoolean2 ^ true;
  }
  
  public void layoutDecorated(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public void layoutDecoratedWithMargins(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    paramView.layout(paramInt1 + localRect.left + localLayoutParams.leftMargin, paramInt2 + localRect.top + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
  }
  
  public void measureChild(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int k = localRect.left;
    int m = localRect.right;
    int i = localRect.top;
    int j = localRect.bottom;
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + (paramInt1 + (k + m)), localLayoutParams.width, canScrollHorizontally());
    paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + (paramInt2 + (i + j)), localLayoutParams.height, canScrollVertically());
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  public void measureChildWithMargins(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int k = localRect.left;
    int m = localRect.right;
    int i = localRect.top;
    int j = localRect.bottom;
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + (paramInt1 + (k + m)), localLayoutParams.width, canScrollHorizontally());
    paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + (paramInt2 + (i + j)), localLayoutParams.height, canScrollVertically());
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  public void moveView(int paramInt1, int paramInt2)
  {
    Object localObject = getChildAt(paramInt1);
    if (localObject != null)
    {
      detachViewAt(paramInt1);
      attachView((View)localObject, paramInt2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot move a child from non-existing index:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(this.mRecyclerView.toString());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void offsetChildrenHorizontal(@Px int paramInt)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.offsetChildrenHorizontal(paramInt);
    }
  }
  
  public void offsetChildrenVertical(@Px int paramInt)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.offsetChildrenVertical(paramInt);
    }
  }
  
  public void onAdapterChanged(@Nullable RecyclerView.Adapter paramAdapter1, @Nullable RecyclerView.Adapter paramAdapter2) {}
  
  public boolean onAddFocusables(@NonNull RecyclerView paramRecyclerView, @NonNull ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  @CallSuper
  public void onAttachedToWindow(RecyclerView paramRecyclerView) {}
  
  @Deprecated
  public void onDetachedFromWindow(RecyclerView paramRecyclerView) {}
  
  @CallSuper
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    onDetachedFromWindow(paramRecyclerView);
  }
  
  @Nullable
  public View onFocusSearchFailed(@NonNull View paramView, int paramInt, @NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
  {
    return null;
  }
  
  public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    paramRecycler = this.mRecyclerView;
    if (paramRecycler != null)
    {
      if (paramAccessibilityEvent == null) {
        return;
      }
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!paramRecycler.canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.mRecyclerView.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.mRecyclerView.canScrollHorizontally(-1)) {
            if (this.mRecyclerView.canScrollHorizontally(1)) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
        }
      }
      paramAccessibilityEvent.setScrollable(bool1);
      if (this.mRecyclerView.mAdapter != null) {
        paramAccessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
      }
    }
  }
  
  void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityNodeInfoCompat);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
    {
      paramAccessibilityNodeInfoCompat.addAction(8192);
      paramAccessibilityNodeInfoCompat.setScrollable(true);
    }
    if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
    {
      paramAccessibilityNodeInfoCompat.addAction(4096);
      paramAccessibilityNodeInfoCompat.setScrollable(true);
    }
    paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramRecycler, paramState), getColumnCountForAccessibility(paramRecycler, paramState), isLayoutHierarchical(paramRecycler, paramState), getSelectionModeForAccessibility(paramRecycler, paramState)));
  }
  
  void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (!this.mChildHelper.isHidden(localViewHolder.itemView))) {
      onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    int i;
    if (canScrollVertically()) {
      i = getPosition(paramView);
    } else {
      i = 0;
    }
    int j;
    if (canScrollHorizontally()) {
      j = getPosition(paramView);
    } else {
      j = 0;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
  }
  
  @Nullable
  public View onInterceptFocusSearch(@NonNull View paramView, int paramInt)
  {
    return null;
  }
  
  public void onItemsAdded(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsChanged(@NonNull RecyclerView paramRecyclerView) {}
  
  public void onItemsMoved(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onItemsRemoved(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {}
  
  public void onMeasure(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
  }
  
  @Deprecated
  public boolean onRequestChildFocus(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView1, @Nullable View paramView2)
  {
    return (isSmoothScrolling()) || (paramRecyclerView.isComputingLayout());
  }
  
  public boolean onRequestChildFocus(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState, @NonNull View paramView1, @Nullable View paramView2)
  {
    return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  @Nullable
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  void onSmoothScrollerStopped(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    if (this.mSmoothScroller == paramSmoothScroller) {
      this.mSmoothScroller = null;
    }
  }
  
  boolean performAccessibilityAction(int paramInt, @Nullable Bundle paramBundle)
  {
    return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramInt, paramBundle);
  }
  
  public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, int paramInt, @Nullable Bundle paramBundle)
  {
    paramRecycler = this.mRecyclerView;
    if (paramRecycler == null) {
      return false;
    }
    if (paramInt != 4096)
    {
      if (paramInt != 8192)
      {
        paramInt = 0;
        i = 0;
        break label169;
      }
      if (paramRecycler.canScrollVertically(-1)) {
        paramInt = -(getHeight() - getPaddingTop() - getPaddingBottom());
      } else {
        paramInt = 0;
      }
      i = paramInt;
      if (!this.mRecyclerView.canScrollHorizontally(-1)) {
        break label167;
      }
      i = -(getWidth() - getPaddingLeft() - getPaddingRight());
    }
    else
    {
      if (paramRecycler.canScrollVertically(1)) {
        paramInt = getHeight() - getPaddingTop() - getPaddingBottom();
      } else {
        paramInt = 0;
      }
      i = paramInt;
      if (!this.mRecyclerView.canScrollHorizontally(1)) {
        break label167;
      }
      i = getWidth() - getPaddingLeft() - getPaddingRight();
    }
    int j = paramInt;
    paramInt = i;
    int i = j;
    break label169;
    label167:
    paramInt = 0;
    label169:
    if ((i == 0) && (paramInt == 0)) {
      return false;
    }
    this.mRecyclerView.smoothScrollBy(paramInt, i, null, -2147483648, true);
    return true;
  }
  
  boolean performAccessibilityActionForItem(@NonNull View paramView, int paramInt, @Nullable Bundle paramBundle)
  {
    return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramInt, paramBundle);
  }
  
  public boolean performAccessibilityActionForItem(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull View paramView, int paramInt, @Nullable Bundle paramBundle)
  {
    return false;
  }
  
  public void postOnAnimation(Runnable paramRunnable)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      ViewCompat.postOnAnimation(localRecyclerView, paramRunnable);
    }
  }
  
  public void removeAllViews()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      this.mChildHelper.removeViewAt(i);
      i -= 1;
    }
  }
  
  public void removeAndRecycleAllViews(@NonNull RecyclerView.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
        removeAndRecycleViewAt(i, paramRecycler);
      }
      i -= 1;
    }
  }
  
  void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
  {
    int j = paramRecycler.getScrapCount();
    int i = j - 1;
    while (i >= 0)
    {
      View localView = paramRecycler.getScrapViewAt(i);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if (!localViewHolder.shouldIgnore())
      {
        localViewHolder.setIsRecyclable(false);
        if (localViewHolder.isTmpDetached()) {
          this.mRecyclerView.removeDetachedView(localView, false);
        }
        if (this.mRecyclerView.mItemAnimator != null) {
          this.mRecyclerView.mItemAnimator.endAnimation(localViewHolder);
        }
        localViewHolder.setIsRecyclable(true);
        paramRecycler.quickRecycleScrapView(localView);
      }
      i -= 1;
    }
    paramRecycler.clearScrap();
    if (j > 0) {
      this.mRecyclerView.invalidate();
    }
  }
  
  public void removeAndRecycleView(@NonNull View paramView, @NonNull RecyclerView.Recycler paramRecycler)
  {
    removeView(paramView);
    paramRecycler.recycleView(paramView);
  }
  
  public void removeAndRecycleViewAt(int paramInt, @NonNull RecyclerView.Recycler paramRecycler)
  {
    View localView = getChildAt(paramInt);
    removeViewAt(paramInt);
    paramRecycler.recycleView(localView);
  }
  
  public boolean removeCallbacks(Runnable paramRunnable)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public void removeDetachedView(@NonNull View paramView)
  {
    this.mRecyclerView.removeDetachedView(paramView, false);
  }
  
  public void removeView(View paramView)
  {
    this.mChildHelper.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null) {
      this.mChildHelper.removeViewAt(paramInt);
    }
  }
  
  public boolean requestChildRectangleOnScreen(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean)
  {
    return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
  }
  
  public boolean requestChildRectangleOnScreen(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramView = getChildRectangleOnScreenScrollAmount(paramView, paramRect);
    int i = paramView[0];
    int j = paramView[1];
    if (((paramBoolean2) && (!isFocusedChildVisibleAfterScrolling(paramRecyclerView, i, j))) || ((i == 0) && (j == 0))) {
      return false;
    }
    if (paramBoolean1)
    {
      paramRecyclerView.scrollBy(i, j);
      return true;
    }
    paramRecyclerView.smoothScrollBy(i, j);
    return true;
  }
  
  public void requestLayout()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.requestLayout();
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    this.mRequestedSimpleAnimations = true;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void scrollToPosition(int paramInt) {}
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  @Deprecated
  public void setAutoMeasureEnabled(boolean paramBoolean)
  {
    this.mAutoMeasure = paramBoolean;
  }
  
  void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
  {
    setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  public final void setItemPrefetchEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mItemPrefetchEnabled)
    {
      this.mItemPrefetchEnabled = paramBoolean;
      this.mPrefetchMaxCountObserved = 0;
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.mRecycler.updateViewCacheSize();
      }
    }
  }
  
  void setMeasureSpecs(int paramInt1, int paramInt2)
  {
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    this.mWidthMode = View.MeasureSpec.getMode(paramInt1);
    if ((this.mWidthMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
      this.mWidth = 0;
    }
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
    this.mHeightMode = View.MeasureSpec.getMode(paramInt2);
    if ((this.mHeightMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
      this.mHeight = 0;
    }
  }
  
  public void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerView.access$300(this.mRecyclerView, paramInt1, paramInt2);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = paramRect.width();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = paramRect.height();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    setMeasuredDimension(chooseSize(paramInt1, i + j + k, getMinimumWidth()), chooseSize(paramInt2, m + n + i1, getMinimumHeight()));
  }
  
  void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
  {
    int i4 = getChildCount();
    if (i4 == 0)
    {
      this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    int j = 0;
    int i2 = 2147483647;
    int m = 2147483647;
    int n = -2147483648;
    int i3;
    for (int i = -2147483648; j < i4; i = i3)
    {
      View localView = getChildAt(j);
      Rect localRect = this.mRecyclerView.mTempRect;
      getDecoratedBoundsWithMargins(localView, localRect);
      int k = i2;
      if (localRect.left < i2) {
        k = localRect.left;
      }
      int i1 = n;
      if (localRect.right > n) {
        i1 = localRect.right;
      }
      n = m;
      if (localRect.top < m) {
        n = localRect.top;
      }
      i3 = i;
      if (localRect.bottom > i) {
        i3 = localRect.bottom;
      }
      j += 1;
      m = n;
      i2 = k;
      n = i1;
    }
    this.mRecyclerView.mTempRect.set(i2, m, n, i);
    setMeasuredDimension(this.mRecyclerView.mTempRect, paramInt1, paramInt2);
  }
  
  public void setMeasurementCacheEnabled(boolean paramBoolean)
  {
    this.mMeasurementCacheEnabled = paramBoolean;
  }
  
  void setRecyclerView(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      this.mRecyclerView = null;
      this.mChildHelper = null;
      this.mWidth = 0;
      this.mHeight = 0;
    }
    else
    {
      this.mRecyclerView = paramRecyclerView;
      this.mChildHelper = paramRecyclerView.mChildHelper;
      this.mWidth = paramRecyclerView.getWidth();
      this.mHeight = paramRecyclerView.getHeight();
    }
    this.mWidthMode = 1073741824;
    this.mHeightMode = 1073741824;
  }
  
  boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (paramView.isLayoutRequested()) || (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height));
  }
  
  boolean shouldMeasureTwice()
  {
    return false;
  }
  
  boolean shouldReMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
  }
  
  public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
    if ((localSmoothScroller != null) && (paramSmoothScroller != localSmoothScroller) && (localSmoothScroller.isRunning())) {
      this.mSmoothScroller.stop();
    }
    this.mSmoothScroller = paramSmoothScroller;
    this.mSmoothScroller.start(this.mRecyclerView, this);
  }
  
  public void stopIgnoringView(@NonNull View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    paramView.stopIgnoring();
    paramView.resetInternal();
    paramView.addFlags(4);
  }
  
  void stopSmoothScroller()
  {
    RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
    if (localSmoothScroller != null) {
      localSmoothScroller.stop();
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager
 * JD-Core Version:    0.7.0.1
 */