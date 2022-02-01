package com.tencent.hippy.qq.tuwen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView.OnNestedScrollingListener;
import mqq.util.WeakReference;

public class NSRIJCommentListView
  extends ReadInJoyCommentListView
  implements NestedScrollingParent3, AbsListView.OnNestedScrollingListener
{
  private static final int DOWN = 1;
  private static final String TAG = "NSRIJCommentListView";
  private static final int UP = -1;
  private boolean forbidScroll;
  private boolean hasHideHippyHeaderAndFooter;
  private WeakReference<NSHippyListView> hippyListViewWeakRef;
  private final int[] mReusableIntPair = new int[2];
  private NestedScrollingParentHelper parentHelper;
  
  public NSRIJCommentListView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public NSRIJCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NSRIJCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnNestedScrollingListener(this);
  }
  
  private NSHippyListView findHippyListView()
  {
    if (this.hippyListViewWeakRef != null)
    {
      localNSHippyListView = (NSHippyListView)this.hippyListViewWeakRef.get();
      if (localNSHippyListView != null) {
        return localNSHippyListView;
      }
    }
    NSHippyListView localNSHippyListView = rFindHippyListView(findHippyRootLayout());
    this.hippyListViewWeakRef = new WeakReference(localNSHippyListView);
    return localNSHippyListView;
  }
  
  private HippyRootLayout findHippyRootLayout()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof HippyRootLayout)) {
        return (HippyRootLayout)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private int getScrollDirecton(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    return 1;
  }
  
  private NestedScrollingParentHelper getScrollingParentHelper()
  {
    if (this.parentHelper == null) {
      this.parentHelper = new NestedScrollingParentHelper(this);
    }
    return this.parentHelper;
  }
  
  private void hideHeaderAndFooter()
  {
    if (this.hasHideHippyHeaderAndFooter) {}
    while (findHippyListView() == null) {
      return;
    }
    this.hasHideHippyHeaderAndFooter = true;
    removeFooter();
  }
  
  private boolean isLastChildEntireVisible()
  {
    int i = getChildCount();
    if (i <= 0) {}
    View localView;
    do
    {
      return true;
      localView = getChildAt(i - 1);
      i = localView.getTop();
    } while (localView.getHeight() + i <= getHeight());
    return false;
  }
  
  private boolean isPointInHippyArea(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    NSHippyListView localNSHippyListView = findHippyListView();
    if ((localNSHippyListView == null) || (!localNSHippyListView.isShown())) {
      bool = false;
    }
    float f;
    int i;
    int j;
    do
    {
      return bool;
      localNSHippyListView.getLocationOnScreen(this.mReusableIntPair);
      f = paramMotionEvent.getRawY();
      i = this.mReusableIntPair[1];
      j = localNSHippyListView.getHeight();
    } while ((i < f) && (f < j + i));
    return false;
  }
  
  private NSHippyListView rFindHippyListView(View paramView)
  {
    if ((paramView instanceof NSHippyListView)) {
      return (NSHippyListView)paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        NSHippyListView localNSHippyListView = rFindHippyListView(paramView.getChildAt(i));
        if (localNSHippyListView != null) {
          return localNSHippyListView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void scrollHippyListToFirstPositionIfNeed()
  {
    NSHippyListView localNSHippyListView = findHippyListView();
    if ((localNSHippyListView == null) || (localNSHippyListView.isShown())) {
      return;
    }
    localNSHippyListView.scrollBy(0, -localNSHippyListView.getOffsetY());
  }
  
  private boolean shouldForbidOverScroll()
  {
    NSHippyListView localNSHippyListView = findHippyListView();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localNSHippyListView != null) {
      if (!isLastChildEntireVisible())
      {
        bool1 = bool2;
        if (!localNSHippyListView.isFling()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void stopHippyListViewFling()
  {
    NSHippyListView localNSHippyListView = findHippyListView();
    if (localNSHippyListView == null) {}
    while (!localNSHippyListView.isFling()) {
      return;
    }
    localNSHippyListView.stopFling();
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    boolean bool = super.canScrollVertically(paramInt);
    if ((paramInt == 1) && (!bool)) {
      return !isLastChildEntireVisible();
    }
    return bool;
  }
  
  public int getDefaultChildHeightSpec(View paramView, int paramInt)
  {
    if ((paramView instanceof HippyRootLayout)) {
      return View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), -2147483648);
    }
    return super.getDefaultChildHeightSpec(paramView, paramInt);
  }
  
  public int getNestedScrollAxes()
  {
    return getScrollingParentHelper().getNestedScrollAxes();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      stopHippyListViewFling();
      scrollHippyListToFirstPositionIfNeed();
      if ((this.mTouchMode != -1) && (isPointInHippyArea(paramMotionEvent))) {
        this.mTouchMode = -1;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    hideHeaderAndFooter();
  }
  
  public boolean onNestedFling(@NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if ((getScrollDirecton(paramInt2) == 1) && (canScrollVertically(1)))
    {
      trackMotionScroll(-paramInt2, -paramInt2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  @Deprecated
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt4 != 0)
    {
      if (getScrollDirecton(paramInt4) != -1) {
        break label41;
      }
      if (canScrollVertically(-1))
      {
        trackMotionScroll(-paramInt4, -paramInt4);
        paramArrayOfInt[1] = paramInt4;
      }
    }
    label41:
    while (!canScrollVertically(1)) {
      return;
    }
    trackMotionScroll(-paramInt4, -paramInt4);
    paramArrayOfInt[1] = paramInt4;
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    getScrollingParentHelper().onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
  }
  
  public int onNestedScrolling(int paramInt)
  {
    int i = 0;
    NSHippyListView localNSHippyListView = findHippyListView();
    if (localNSHippyListView != null)
    {
      localNSHippyListView.setOverScrollEnabled(false, false);
      localNSHippyListView.scrollBy(0, -paramInt, this.mReusableIntPair);
      i = -this.mReusableIntPair[1];
    }
    return i;
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
    getScrollingParentHelper().onStopNestedScroll(paramView, paramInt);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (shouldForbidOverScroll()) {
      return false;
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void setForbidScroll(boolean paramBoolean)
  {
    this.forbidScroll = paramBoolean;
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    super.setSelectionFromTop(paramInt1, paramInt2);
    abordFling();
    NSHippyListView localNSHippyListView = findHippyListView();
    if (localNSHippyListView == null) {
      return;
    }
    localNSHippyListView.stopFling();
  }
  
  public boolean startScrollIfNeeded(int paramInt)
  {
    if (this.forbidScroll) {
      return false;
    }
    return super.startScrollIfNeeded(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.view.NSRIJCommentListView
 * JD-Core Version:    0.7.0.1
 */