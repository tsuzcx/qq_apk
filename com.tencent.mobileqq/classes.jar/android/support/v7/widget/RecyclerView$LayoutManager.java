package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager
{
  private boolean mAutoMeasure = false;
  ChildHelper mChildHelper;
  private int mHeightSpec;
  boolean mIsAttachedToWindow = false;
  private boolean mMeasurementCacheEnabled = true;
  RecyclerView mRecyclerView;
  private boolean mRequestedSimpleAnimations = false;
  @Nullable
  RecyclerView.SmoothScroller mSmoothScroller;
  private int mWidthSpec;
  
  private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
  {
    Object localObject = RecyclerView.getChildViewHolderInt(paramView);
    if (localObject == null) {
      return;
    }
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
      if (i == 1073741824) {
        return paramInt1;
      }
    }
    else {
      paramInt2 = Math.min(paramInt1, paramInt2);
    }
    return Math.max(paramInt2, paramInt3);
  }
  
  private void detachViewInternal(int paramInt, View paramView)
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
  
  public static RecyclerView.LayoutManager.Properties getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = new RecyclerView.LayoutManager.Properties();
    paramContext.orientation = 1;
    paramContext.spanCount = 1;
    paramContext.reverseLayout = false;
    paramContext.stackFromEnd = false;
    return paramContext;
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
  
  private void onSmoothScrollerStopped(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    if (this.mSmoothScroller == paramSmoothScroller) {
      this.mSmoothScroller = null;
    }
  }
  
  private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if (localViewHolder.shouldIgnore()) {
        return;
      }
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!RecyclerView.access$3100(this.mRecyclerView).hasStableIds()))
      {
        removeViewAt(paramInt);
        paramRecycler.recycleViewHolderInternal(localViewHolder);
        return;
      }
      detachViewAt(paramInt);
      paramRecycler.scrapView(paramView);
      this.mRecyclerView.mViewInfoStore.onViewDetached(localViewHolder);
    }
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
  
  public void attachView(View paramView)
  {
    attachView(paramView, -1);
  }
  
  public void attachView(View paramView, int paramInt)
  {
    attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
  }
  
  public void attachView(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder == null) {
      return;
    }
    if (localViewHolder.isRemoved()) {
      this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
    } else {
      this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
    }
    this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
  }
  
  public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
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
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void detachAndScrapAttachedViews(RecyclerView.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      scrapOrRecycleView(paramRecycler, i, getChildAt(i));
      i -= 1;
    }
  }
  
  public void detachAndScrapView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, this.mChildHelper.indexOfChild(paramView), paramView);
  }
  
  public void detachAndScrapViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
  }
  
  public void detachView(View paramView)
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
    if (this.mRecyclerView.mItemAnimator != null)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if (paramView != null) {
        this.mRecyclerView.mItemAnimator.endAnimation(paramView);
      }
    }
  }
  
  @Nullable
  public View findContainingItemView(View paramView)
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
  
  public int getBottomDecorationHeight(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.bottom;
  }
  
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
    return (localRecyclerView != null) && (RecyclerView.access$5600(localRecyclerView));
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    paramRecycler = this.mRecyclerView;
    int j = 1;
    int i = j;
    if (paramRecycler != null)
    {
      if (RecyclerView.access$3100(paramRecycler) == null) {
        return 1;
      }
      i = j;
      if (canScrollHorizontally()) {
        i = RecyclerView.access$3100(this.mRecyclerView).getItemCount();
      }
    }
    return i;
  }
  
  public int getDecoratedBottom(View paramView)
  {
    return paramView.getBottom() + getBottomDecorationHeight(paramView);
  }
  
  public int getDecoratedLeft(View paramView)
  {
    return paramView.getLeft() - getLeftDecorationWidth(paramView);
  }
  
  public int getDecoratedMeasuredHeight(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
  }
  
  public int getDecoratedMeasuredWidth(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredWidth() + localRect.left + localRect.right;
  }
  
  public int getDecoratedRight(View paramView)
  {
    return paramView.getRight() + getRightDecorationWidth(paramView);
  }
  
  public int getDecoratedTop(View paramView)
  {
    return paramView.getTop() - getTopDecorationHeight(paramView);
  }
  
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
  
  public int getHeight()
  {
    return View.MeasureSpec.getSize(this.mHeightSpec);
  }
  
  public int getHeightMode()
  {
    return View.MeasureSpec.getMode(this.mHeightSpec);
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
  
  public int getItemViewType(View paramView)
  {
    return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
  }
  
  public int getLayoutDirection()
  {
    return ViewCompat.getLayoutDirection(this.mRecyclerView);
  }
  
  public int getLeftDecorationWidth(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.left;
  }
  
  public int getMinimumHeight()
  {
    return ViewCompat.getMinimumHeight(this.mRecyclerView);
  }
  
  public int getMinimumWidth()
  {
    return ViewCompat.getMinimumWidth(this.mRecyclerView);
  }
  
  public int getPaddingBottom()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingBottom();
    }
    return 0;
  }
  
  public int getPaddingEnd()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return ViewCompat.getPaddingEnd(localRecyclerView);
    }
    return 0;
  }
  
  public int getPaddingLeft()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingLeft();
    }
    return 0;
  }
  
  public int getPaddingRight()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingRight();
    }
    return 0;
  }
  
  public int getPaddingStart()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return ViewCompat.getPaddingStart(localRecyclerView);
    }
    return 0;
  }
  
  public int getPaddingTop()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingTop();
    }
    return 0;
  }
  
  public int getPosition(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
  }
  
  public int getRightDecorationWidth(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.right;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    paramRecycler = this.mRecyclerView;
    int j = 1;
    int i = j;
    if (paramRecycler != null)
    {
      if (RecyclerView.access$3100(paramRecycler) == null) {
        return 1;
      }
      i = j;
      if (canScrollVertically()) {
        i = RecyclerView.access$3100(this.mRecyclerView).getItemCount();
      }
    }
    return i;
  }
  
  public int getSelectionModeForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int getTopDecorationHeight(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.top;
  }
  
  public int getWidth()
  {
    return View.MeasureSpec.getSize(this.mWidthSpec);
  }
  
  public int getWidthMode()
  {
    return View.MeasureSpec.getMode(this.mWidthSpec);
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
  
  public void ignoreView(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    RecyclerView localRecyclerView = this.mRecyclerView;
    if ((localViewParent == localRecyclerView) && (localRecyclerView.indexOfChild(paramView) != -1))
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if (paramView == null) {
        return;
      }
      paramView.addFlags(128);
      this.mRecyclerView.mViewInfoStore.removeViewHolder(paramView);
      return;
    }
    throw new IllegalArgumentException("View should be fully attached to be ignored");
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
  
  public boolean isLayoutHierarchical(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
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
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public void measureChild(View paramView, int paramInt1, int paramInt2)
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
  
  public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
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
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.offsetChildrenHorizontal(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.offsetChildrenVertical(paramInt);
    }
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2) {}
  
  public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
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
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return null;
  }
  
  public void onInitializeAccessibilityEvent(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AccessibilityEvent paramAccessibilityEvent)
  {
    paramRecycler = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
    paramState = this.mRecyclerView;
    if (paramState != null)
    {
      if (paramRecycler == null) {
        return;
      }
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!ViewCompat.canScrollVertically(paramState, 1))
      {
        bool1 = bool2;
        if (!ViewCompat.canScrollVertically(this.mRecyclerView, -1))
        {
          bool1 = bool2;
          if (!ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
            if (ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
        }
      }
      paramRecycler.setScrollable(bool1);
      if (RecyclerView.access$3100(this.mRecyclerView) != null) {
        paramRecycler.setItemCount(RecyclerView.access$3100(this.mRecyclerView).getItemCount());
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityEvent);
  }
  
  void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityNodeInfoCompat);
  }
  
  public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if ((ViewCompat.canScrollVertically(this.mRecyclerView, -1)) || (ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)))
    {
      paramAccessibilityNodeInfoCompat.addAction(8192);
      paramAccessibilityNodeInfoCompat.setScrollable(true);
    }
    if ((ViewCompat.canScrollVertically(this.mRecyclerView, 1)) || (ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)))
    {
      paramAccessibilityNodeInfoCompat.addAction(4096);
      paramAccessibilityNodeInfoCompat.setScrollable(true);
    }
    paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramRecycler, paramState), getColumnCountForAccessibility(paramRecycler, paramState), isLayoutHierarchical(paramRecycler, paramState), getSelectionModeForAccessibility(paramRecycler, paramState)));
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
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
  
  void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (!this.mChildHelper.isHidden(localViewHolder.itemView))) {
      onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public View onInterceptFocusSearch(View paramView, int paramInt)
  {
    return null;
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsChanged(RecyclerView paramRecyclerView) {}
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    RecyclerView.access$5400(this.mRecyclerView, paramInt1, paramInt2);
  }
  
  public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.State paramState, View paramView1, View paramView2)
  {
    return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
  }
  
  @Deprecated
  public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
  {
    return (isSmoothScrolling()) || (paramRecyclerView.isComputingLayout());
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramInt, paramBundle);
  }
  
  public boolean performAccessibilityAction(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, Bundle paramBundle)
  {
    paramRecycler = this.mRecyclerView;
    if (paramRecycler == null) {
      return false;
    }
    if (paramInt != 4096) {
      if (paramInt != 8192) {
        paramInt = 0;
      }
    }
    int i;
    do
    {
      do
      {
        j = 0;
        break;
        if (ViewCompat.canScrollVertically(paramRecycler, -1)) {
          i = -(getHeight() - getPaddingTop() - getPaddingBottom());
        } else {
          i = 0;
        }
        paramInt = i;
      } while (!ViewCompat.canScrollHorizontally(this.mRecyclerView, -1));
      j = -(getWidth() - getPaddingLeft() - getPaddingRight());
      paramInt = i;
      break;
      if (ViewCompat.canScrollVertically(paramRecycler, 1)) {
        i = getHeight() - getPaddingTop() - getPaddingBottom();
      } else {
        i = 0;
      }
      paramInt = i;
    } while (!ViewCompat.canScrollHorizontally(this.mRecyclerView, 1));
    int j = getWidth() - getPaddingLeft() - getPaddingRight();
    paramInt = i;
    if ((paramInt == 0) && (j == 0)) {
      return false;
    }
    this.mRecyclerView.scrollBy(j, paramInt);
    return true;
  }
  
  public boolean performAccessibilityActionForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  boolean performAccessibilityActionForItem(View paramView, int paramInt, Bundle paramBundle)
  {
    return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramInt, paramBundle);
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
  
  public void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(getChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
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
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
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
  
  public void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    removeView(paramView);
    paramRecycler.recycleView(paramView);
  }
  
  public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
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
  
  public void removeDetachedView(View paramView)
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
  
  public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
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
    if ((i == 0) && (j == 0)) {
      return false;
    }
    if (paramBoolean)
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
  
  public void setAutoMeasureEnabled(boolean paramBoolean)
  {
    this.mAutoMeasure = paramBoolean;
  }
  
  void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
  {
    setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  void setMeasureSpecs(int paramInt1, int paramInt2)
  {
    this.mWidthSpec = paramInt1;
    this.mHeightSpec = paramInt2;
  }
  
  public void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerView.access$5700(this.mRecyclerView, paramInt1, paramInt2);
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
    int i6 = getChildCount();
    if (i6 == 0)
    {
      RecyclerView.access$5400(this.mRecyclerView, paramInt1, paramInt2);
      return;
    }
    int j = 0;
    int i2 = 2147483647;
    int m = 2147483647;
    int n = -2147483648;
    int i3;
    for (int i = -2147483648; j < i6; i = i3)
    {
      View localView = getChildAt(j);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int i1 = getDecoratedLeft(localView) - localLayoutParams.leftMargin;
      int i5 = getDecoratedRight(localView) + localLayoutParams.rightMargin;
      i3 = getDecoratedTop(localView) - localLayoutParams.topMargin;
      int i4 = getDecoratedBottom(localView) + localLayoutParams.bottomMargin;
      int k = i2;
      if (i1 < i2) {
        k = i1;
      }
      i1 = n;
      if (i5 > n) {
        i1 = i5;
      }
      n = m;
      if (i3 < m) {
        n = i3;
      }
      i3 = i;
      if (i4 > i) {
        i3 = i4;
      }
      j += 1;
      m = n;
      i2 = k;
      n = i1;
    }
    RecyclerView.access$5500(this.mRecyclerView).set(i2, m, n, i);
    setMeasuredDimension(RecyclerView.access$5500(this.mRecyclerView), paramInt1, paramInt2);
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
      this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      return;
    }
    this.mRecyclerView = paramRecyclerView;
    this.mChildHelper = paramRecyclerView.mChildHelper;
    this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824);
    this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824);
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
  
  public void stopIgnoringView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView == null) {
      return;
    }
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
 * Qualified Name:     android.support.v7.widget.RecyclerView.LayoutManager
 * JD-Core Version:    0.7.0.1
 */