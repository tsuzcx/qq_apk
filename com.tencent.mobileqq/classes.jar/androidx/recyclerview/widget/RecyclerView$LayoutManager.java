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
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramBoolean) || (localViewHolder.isRemoved()))
    {
      this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localViewHolder.wasReturnedFromScrap()) && (!localViewHolder.isScrap())) {
        break label128;
      }
      if (!localViewHolder.isScrap()) {
        break label120;
      }
      localViewHolder.unScrap();
      label68:
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (localLayoutParams.mPendingInvalidate)
      {
        localViewHolder.itemView.invalidate();
        localLayoutParams.mPendingInvalidate = false;
      }
      return;
      this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      break;
      label120:
      localViewHolder.clearReturnedFromScrapFlag();
      break label68;
      label128:
      if (paramView.getParent() == this.mRecyclerView)
      {
        int j = this.mChildHelper.indexOfChild(paramView);
        int i = paramInt;
        if (paramInt == -1) {
          i = this.mChildHelper.getChildCount();
        }
        if (j == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(paramView) + this.mRecyclerView.exceptionLabel());
        }
        if (j != i) {
          this.mRecyclerView.mLayout.moveView(j, i);
        }
      }
      else
      {
        this.mChildHelper.addView(paramView, paramInt, false);
        localLayoutParams.mInsetsDirty = true;
        if ((this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning())) {
          this.mSmoothScroller.onChildAttachedToWindow(paramView);
        }
      }
    }
  }
  
  public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i;
    switch (j)
    {
    default: 
      paramInt1 = Math.max(paramInt2, paramInt3);
    case 1073741824: 
      return paramInt1;
    }
    return Math.min(i, Math.max(paramInt2, paramInt3));
  }
  
  private void detachViewInternal(int paramInt, @NonNull View paramView)
  {
    this.mChildHelper.detachViewFromParent(paramInt);
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    int i = Math.max(0, paramInt1 - paramInt3);
    if (paramBoolean) {
      if (paramInt4 >= 0)
      {
        paramInt1 = 1073741824;
        paramInt3 = paramInt4;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
      if (paramInt4 == -1)
      {
        switch (paramInt2)
        {
        default: 
          paramInt2 = 0;
          paramInt1 = j;
        }
        for (;;)
        {
          paramInt3 = paramInt1;
          paramInt1 = paramInt2;
          break;
          paramInt1 = i;
          continue;
          paramInt2 = 0;
          paramInt1 = j;
        }
      }
      if (paramInt4 == -2)
      {
        paramInt3 = 0;
        paramInt1 = k;
        continue;
        if (paramInt4 >= 0)
        {
          paramInt1 = 1073741824;
          paramInt3 = paramInt4;
          continue;
        }
        if (paramInt4 == -1)
        {
          paramInt1 = paramInt2;
          paramInt3 = i;
          continue;
        }
        if (paramInt4 == -2)
        {
          if (paramInt2 != -2147483648)
          {
            paramInt1 = k;
            paramInt3 = i;
            if (paramInt2 != 1073741824) {
              continue;
            }
          }
          paramInt1 = -2147483648;
          paramInt3 = i;
          continue;
        }
      }
      paramInt3 = 0;
      paramInt1 = k;
    }
  }
  
  @Deprecated
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j = 1073741824;
    int i = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean) {
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = j;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      continue;
      paramInt2 = j;
      paramInt1 = paramInt3;
      if (paramInt3 < 0) {
        if (paramInt3 == -1)
        {
          paramInt1 = i;
          paramInt2 = j;
        }
        else if (paramInt3 == -2)
        {
          paramInt2 = -2147483648;
          paramInt1 = i;
        }
        else
        {
          paramInt2 = 0;
          paramInt1 = 0;
        }
      }
    }
  }
  
  private int[] getChildRectangleOnScreenScrollAmount(View paramView, Rect paramRect)
  {
    int i2 = getPaddingLeft();
    int m = getPaddingTop();
    int i3 = getWidth() - getPaddingRight();
    int i1 = getHeight();
    int i6 = getPaddingBottom();
    int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
    int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
    int i5 = i4 + paramRect.width();
    int i7 = paramRect.height();
    int i = Math.min(0, i4 - i2);
    int j = Math.min(0, n - m);
    int k = Math.max(0, i5 - i3);
    i1 = Math.max(0, n + i7 - (i1 - i6));
    if (getLayoutDirection() == 1) {
      if (k != 0)
      {
        i = k;
        if (j == 0) {
          break label199;
        }
      }
    }
    for (;;)
    {
      return new int[] { i, j };
      i = Math.max(i, i5 - i3);
      break;
      if (i != 0) {
        break;
      }
      for (;;)
      {
        i = Math.min(i4 - i2, k);
      }
      label199:
      j = Math.min(n - m, i1);
    }
  }
  
  public static RecyclerView.LayoutManager.Properties getProperties(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager.Properties localProperties = new RecyclerView.LayoutManager.Properties();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.f, paramInt1, paramInt2);
    localProperties.orientation = paramContext.getInt(R.styleable.a, 1);
    localProperties.spanCount = paramContext.getInt(R.styleable.k, 1);
    localProperties.reverseLayout = paramContext.getBoolean(R.styleable.j, false);
    localProperties.stackFromEnd = paramContext.getBoolean(R.styleable.l, false);
    paramContext.recycle();
    return localProperties;
  }
  
  private boolean isFocusedChildVisibleAfterScrolling(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = paramRecyclerView.getFocusedChild();
    if (paramRecyclerView == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    Rect localRect;
    do
    {
      return false;
      i = getPaddingLeft();
      j = getPaddingTop();
      k = getWidth();
      m = getPaddingRight();
      n = getHeight();
      i1 = getPaddingBottom();
      localRect = this.mRecyclerView.mTempRect;
      getDecoratedBoundsWithMargins(paramRecyclerView, localRect);
    } while ((localRect.left - paramInt1 >= k - m) || (localRect.right - paramInt1 <= i) || (localRect.top - paramInt2 >= n - i1) || (localRect.bottom - paramInt2 <= j));
    return true;
  }
  
  private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    boolean bool1;
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
        switch (i)
        {
        case 0: 
        default: 
          return false;
        case -2147483648: 
          bool1 = bool2;
        }
      } while (paramInt2 >= paramInt1);
      return false;
      bool1 = bool2;
    } while (paramInt2 == paramInt1);
    return false;
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
    if (this.mRecyclerView != null) {
      this.mRecyclerView.assertInLayoutOrScroll(paramString);
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.assertNotInLayoutOrScroll(paramString);
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
    }
    for (;;)
    {
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
      return;
      this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
    }
  }
  
  public void calculateItemDecorationsForChild(@NonNull View paramView, @NonNull Rect paramRect)
  {
    if (this.mRecyclerView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(this.mRecyclerView.getItemDecorInsetsForChild(paramView));
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
    if (this.mRecyclerView == null) {}
    do
    {
      return null;
      paramView = this.mRecyclerView.findContainingItemView(paramView);
    } while ((paramView == null) || (this.mChildHelper.isHidden(paramView)));
    return paramView;
  }
  
  @Nullable
  public View findViewByPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if (localViewHolder == null) {}
      while ((localViewHolder.getLayoutPosition() != paramInt) || (localViewHolder.shouldIgnore()) || ((!this.mRecyclerView.mState.isPreLayout()) && (localViewHolder.isRemoved())))
      {
        i += 1;
        break;
      }
      return localView;
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
    if (this.mChildHelper != null) {
      return this.mChildHelper.getChildAt(paramInt);
    }
    return null;
  }
  
  public int getChildCount()
  {
    if (this.mChildHelper != null) {
      return this.mChildHelper.getChildCount();
    }
    return 0;
  }
  
  public boolean getClipToPadding()
  {
    return (this.mRecyclerView != null) && (this.mRecyclerView.mClipToPadding);
  }
  
  public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
  {
    if ((this.mRecyclerView == null) || (this.mRecyclerView.mAdapter == null)) {}
    while (!canScrollHorizontally()) {
      return 1;
    }
    return this.mRecyclerView.mAdapter.getItemCount();
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
    int i = paramView.getMeasuredHeight();
    int j = localRect.top;
    return localRect.bottom + (i + j);
  }
  
  public int getDecoratedMeasuredWidth(@NonNull View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    int i = paramView.getMeasuredWidth();
    int j = localRect.left;
    return localRect.right + (i + j);
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
    if (this.mRecyclerView == null) {}
    View localView;
    do
    {
      return null;
      localView = this.mRecyclerView.getFocusedChild();
    } while ((localView == null) || (this.mChildHelper.isHidden(localView)));
    return localView;
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
    if (this.mRecyclerView != null) {}
    for (RecyclerView.Adapter localAdapter = this.mRecyclerView.getAdapter(); localAdapter != null; localAdapter = null) {
      return localAdapter.getItemCount();
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
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingBottom();
    }
    return 0;
  }
  
  @Px
  public int getPaddingEnd()
  {
    if (this.mRecyclerView != null) {
      return ViewCompat.getPaddingEnd(this.mRecyclerView);
    }
    return 0;
  }
  
  @Px
  public int getPaddingLeft()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingLeft();
    }
    return 0;
  }
  
  @Px
  public int getPaddingRight()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingRight();
    }
    return 0;
  }
  
  @Px
  public int getPaddingStart()
  {
    if (this.mRecyclerView != null) {
      return ViewCompat.getPaddingStart(this.mRecyclerView);
    }
    return 0;
  }
  
  @Px
  public int getPaddingTop()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingTop();
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
    if ((this.mRecyclerView == null) || (this.mRecyclerView.mAdapter == null)) {}
    while (!canScrollVertically()) {
      return 1;
    }
    return this.mRecyclerView.mAdapter.getItemCount();
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
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      int k = paramView.getWidth();
      int m = ((Rect)localObject).right;
      int n = paramView.getHeight();
      paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
    }
    for (;;)
    {
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
      return;
      paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    }
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
    boolean bool2 = false;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
        if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean hasFocus()
  {
    return (this.mRecyclerView != null) && (this.mRecyclerView.hasFocus());
  }
  
  public void ignoreView(@NonNull View paramView)
  {
    if ((paramView.getParent() != this.mRecyclerView) || (this.mRecyclerView.indexOfChild(paramView) == -1)) {
      throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
    }
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    paramView.addFlags(128);
    this.mRecyclerView.mViewInfoStore.removeViewHolder(paramView);
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
    return (this.mRecyclerView != null) && (this.mRecyclerView.isFocused());
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
    return (this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning());
  }
  
  public boolean isViewPartiallyVisible(@NonNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((this.mHorizontalBoundCheck.isViewWithinBoundFlags(paramView, 24579)) && (this.mVerticalBoundCheck.isViewWithinBoundFlags(paramView, 24579)))
    {
      paramBoolean2 = true;
      if (!paramBoolean1) {
        break label46;
      }
      paramBoolean1 = paramBoolean2;
    }
    label46:
    do
    {
      return paramBoolean1;
      paramBoolean2 = false;
      break;
      paramBoolean1 = bool;
    } while (!paramBoolean2);
    return false;
  }
  
  public void layoutDecorated(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public void layoutDecoratedWithMargins(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
  }
  
  public void measureChild(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int k = localRect.left;
    int m = localRect.right;
    int i = localRect.top;
    int j = localRect.bottom;
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), k + m + paramInt1 + (getPaddingLeft() + getPaddingRight()), localLayoutParams.width, canScrollHorizontally());
    paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), j + i + paramInt2 + (getPaddingTop() + getPaddingBottom()), localLayoutParams.height, canScrollVertically());
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
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), k + m + paramInt1 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, canScrollHorizontally());
    paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), j + i + paramInt2 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, canScrollVertically());
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  public void moveView(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if (localView == null) {
      throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.mRecyclerView.toString());
    }
    detachViewAt(paramInt1);
    attachView(localView, paramInt2);
  }
  
  public void offsetChildrenHorizontal(@Px int paramInt)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.offsetChildrenHorizontal(paramInt);
    }
  }
  
  public void offsetChildrenVertical(@Px int paramInt)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.offsetChildrenVertical(paramInt);
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
    boolean bool2 = true;
    if ((this.mRecyclerView == null) || (paramAccessibilityEvent == null)) {
      return;
    }
    boolean bool1 = bool2;
    if (!this.mRecyclerView.canScrollVertically(1))
    {
      bool1 = bool2;
      if (!this.mRecyclerView.canScrollVertically(-1))
      {
        bool1 = bool2;
        if (!this.mRecyclerView.canScrollHorizontally(-1)) {
          if (!this.mRecyclerView.canScrollHorizontally(1)) {
            break label106;
          }
        }
      }
    }
    label106:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.setScrollable(bool1);
      if (this.mRecyclerView.mAdapter == null) {
        break;
      }
      paramAccessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
      return;
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
    if (canScrollVertically())
    {
      i = getPosition(paramView);
      if (!canScrollHorizontally()) {
        break label51;
      }
    }
    label51:
    for (int j = getPosition(paramView);; j = 0)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
      return;
      i = 0;
      break;
    }
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
    if (this.mRecyclerView == null) {}
    int i;
    do
    {
      return false;
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        i = 0;
      }
    } while ((i == 0) && (paramInt == 0));
    this.mRecyclerView.smoothScrollBy(paramInt, i, null, -2147483648, true);
    return true;
    if (this.mRecyclerView.canScrollVertically(-1)) {}
    for (paramInt = -(getHeight() - getPaddingTop() - getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      int j;
      if (this.mRecyclerView.canScrollHorizontally(-1))
      {
        j = -(getWidth() - getPaddingLeft() - getPaddingRight());
        i = paramInt;
        paramInt = j;
        break;
        if (!this.mRecyclerView.canScrollVertically(1)) {
          break label203;
        }
      }
      label203:
      for (paramInt = getHeight() - getPaddingTop() - getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (this.mRecyclerView.canScrollHorizontally(1))
        {
          j = getWidth() - getPaddingLeft() - getPaddingRight();
          i = paramInt;
          paramInt = j;
          break;
        }
        paramInt = 0;
        break;
      }
    }
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
    if (this.mRecyclerView != null) {
      ViewCompat.postOnAnimation(this.mRecyclerView, paramRunnable);
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
    if (i >= 0)
    {
      View localView = paramRecycler.getScrapViewAt(i);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if (localViewHolder.shouldIgnore()) {}
      for (;;)
      {
        i -= 1;
        break;
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
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.removeCallbacks(paramRunnable);
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
    boolean bool = false;
    paramView = getChildRectangleOnScreenScrollAmount(paramView, paramRect);
    int i = paramView[0];
    int j = paramView[1];
    if (paramBoolean2)
    {
      paramBoolean2 = bool;
      if (!isFocusedChildVisibleAfterScrolling(paramRecyclerView, i, j)) {}
    }
    else if (i == 0)
    {
      paramBoolean2 = bool;
      if (j == 0) {}
    }
    else
    {
      if (!paramBoolean1) {
        break label74;
      }
      paramRecyclerView.scrollBy(i, j);
    }
    for (;;)
    {
      paramBoolean2 = true;
      return paramBoolean2;
      label74:
      paramRecyclerView.smoothScrollBy(i, j);
    }
  }
  
  public void requestLayout()
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.requestLayout();
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
      if (this.mRecyclerView != null) {
        this.mRecyclerView.mRecycler.updateViewCacheSize();
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
    int k = 2147483647;
    int j = -2147483648;
    int i5 = getChildCount();
    if (i5 == 0)
    {
      this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    int i = 0;
    int n = -2147483648;
    int i3 = 2147483647;
    while (i < i5)
    {
      View localView = getChildAt(i);
      Rect localRect = this.mRecyclerView.mTempRect;
      getDecoratedBoundsWithMargins(localView, localRect);
      int m = i3;
      if (localRect.left < i3) {
        m = localRect.left;
      }
      int i1 = n;
      if (localRect.right > n) {
        i1 = localRect.right;
      }
      int i2 = k;
      if (localRect.top < k) {
        i2 = localRect.top;
      }
      int i4 = j;
      if (localRect.bottom > j) {
        i4 = localRect.bottom;
      }
      i += 1;
      i3 = m;
      n = i1;
      k = i2;
      j = i4;
    }
    this.mRecyclerView.mTempRect.set(i3, k, n, j);
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
    }
    for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
    {
      this.mWidthMode = 1073741824;
      this.mHeightMode = 1073741824;
      return;
      this.mRecyclerView = paramRecyclerView;
      this.mChildHelper = paramRecyclerView.mChildHelper;
      this.mWidth = paramRecyclerView.getWidth();
    }
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
    if ((this.mSmoothScroller != null) && (paramSmoothScroller != this.mSmoothScroller) && (this.mSmoothScroller.isRunning())) {
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
    if (this.mSmoothScroller != null) {
      this.mSmoothScroller.stop();
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager
 * JD-Core Version:    0.7.0.1
 */