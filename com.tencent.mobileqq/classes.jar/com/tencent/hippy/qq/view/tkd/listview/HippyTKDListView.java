package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.doublescrollview.HippyTKDDoubleScrollView;
import com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import com.tencent.widget.immersive.ImmersiveUtils;

public class HippyTKDListView
  extends HippyListView
  implements IDoubleScroll, HippyTKDRefreshHeader.RefreshableCallback
{
  public static final int DEFAULT_REFRESH_TYPE = 1;
  public static final int HippyNoPicModeChange = 1002;
  public static final int HippySkinChange = 1001;
  private boolean isFirstFrame = false;
  boolean mEnableFooter = true;
  boolean mEnableRefresh = false;
  private boolean mEnableScrollToContentOffset = false;
  private boolean mHasInitialListEventDone = false;
  private int mInitialContentOffset = 0;
  private int mInitialListSize = 0;
  private boolean mIsResponseToDoubleScroll = false;
  protected IHippyTKDRefreshHeader mQBRefreshHeader;
  HippyArray mRefreshColors = null;
  private boolean mScrollEnabled = true;
  
  public HippyTKDListView(Context paramContext)
  {
    super(paramContext);
    if ((getAdapter() instanceof HippyTKDListViewAdapter))
    {
      ((HippyTKDListViewAdapter)getAdapter()).setLoadingStatus(1);
      addOnListScrollListener(((HippyTKDListViewAdapter)getAdapter()).getOnListScrollListener());
    }
  }
  
  private HippyTKDDoubleScrollView findDoubleScrollHandleView(View paramView)
  {
    while (((paramView instanceof View)) && (paramView.getParent() != null))
    {
      if ((paramView.getParent() instanceof HippyRootView)) {
        return null;
      }
      if ((paramView.getParent() instanceof HippyTKDDoubleScrollView)) {
        return (HippyTKDDoubleScrollView)paramView.getParent();
      }
      if (!(paramView.getParent() instanceof View)) {
        break;
      }
      paramView = (View)paramView.getParent();
    }
    return null;
  }
  
  public static boolean isKingCardMobileNetWork()
  {
    return CUKingCardHelper.a() == 1;
  }
  
  private void traversalChildViewForNoPicChange(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < j)
      {
        traversalChildViewForNoPicChange(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
  }
  
  private void traversalChildViewForSkinChange(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < j)
      {
        traversalChildViewForSkinChange(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
  }
  
  public void cancelTouch()
  {
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.onCancelTouch();
    }
    super.cancelTouch();
  }
  
  public boolean changeUpOverScrollEnableOnComputeDxDy(int paramInt1, int paramInt2, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = paramBoolean3;
    if (!paramBoolean3)
    {
      bool = paramBoolean3;
      if (this.mQBRefreshHeader != null)
      {
        bool = paramBoolean3;
        if (!paramBoolean2)
        {
          bool = paramBoolean3;
          if (!paramBoolean1) {
            bool = true;
          }
        }
      }
    }
    return bool;
  }
  
  public void checkExposureForReport(int paramInt1, int paramInt2)
  {
    if (getAdapter() != null) {
      ((HippyTKDListViewAdapter)getAdapter()).checkExposureForReport(paramInt1, paramInt2);
    }
  }
  
  protected boolean checkNeedToReport(float paramFloat, int paramInt)
  {
    return true;
  }
  
  public void checkNotifyFooterAppearWithFewChild(int paramInt) {}
  
  public void checkRefreshHeadOnFlingRun()
  {
    if ((this.mQBRefreshHeader != null) && ((this.mOffsetY <= 0) || (!this.optimizeHeaderRefresh))) {
      invalidate();
    }
  }
  
  public boolean checkShouldStopScroll()
  {
    return (this.mQBRefreshHeader != null) && (this.mEnableRefresh) && (!this.mQBRefreshHeader.onScrolled());
  }
  
  public void completeRefresh(int paramInt)
  {
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.completeRefresh(paramInt);
    }
  }
  
  public void completeRefresh(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, boolean paramBoolean, long paramLong, int paramInt6, Promise paramPromise, int paramInt7)
  {
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.completeRefresh(paramInt1, paramString1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramBoolean, paramLong, paramPromise, paramInt7);
    }
  }
  
  public HippyListAdapter createAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    return new HippyTKDListView.1(this, paramRecyclerView, paramHippyEngineContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.onDraw(paramCanvas);
    }
  }
  
  protected boolean enableOnSrollReport()
  {
    return true;
  }
  
  public int getAutoScrollVelocity()
  {
    return ImmersiveUtils.dpToPx(3.0F);
  }
  
  protected HippyTKDListView.ExposureForReport getExposureForReport(int paramInt1, int paramInt2)
  {
    if ((getAdapter() instanceof HippyTKDListViewAdapter)) {
      return ((HippyTKDListViewAdapter)getAdapter()).getExposureForReportInner(paramInt1, paramInt2);
    }
    return null;
  }
  
  protected HippyTKDListView.OuterScroll getExposureForScroll(int paramInt1, int paramInt2)
  {
    if ((getAdapter() instanceof HippyTKDListViewAdapter)) {
      return ((HippyTKDListViewAdapter)getAdapter()).getExposureForReportScrollInner(paramInt1, paramInt2);
    }
    return null;
  }
  
  public int getLayoutHeight()
  {
    return getHeight();
  }
  
  public int getNestViewScrollY()
  {
    return getOffsetY();
  }
  
  public int getRealHeight()
  {
    int i = getHeight();
    if (getAdapter() != null) {
      i = getAdapter().getListTotalHeight();
    }
    int j = i;
    if (i < getHeight()) {
      j = getHeight();
    }
    return j;
  }
  
  public int getSpringBackMaxDistance()
  {
    return ImmersiveUtils.dpToPx(40.0F);
  }
  
  public HippyMap getVisibleItems()
  {
    return ((HippyTKDListViewAdapter)getAdapter()).getVisibleItems();
  }
  
  public void handleDoubleScrollResponseChange(boolean paramBoolean)
  {
    this.mIsResponseToDoubleScroll = paramBoolean;
    HippyTKDDoubleScrollView localHippyTKDDoubleScrollView = findDoubleScrollHandleView(this);
    if (localHippyTKDDoubleScrollView != null) {
      localHippyTKDDoubleScrollView.setDoubleScrollRespondView(this, paramBoolean);
    }
  }
  
  public void handleInTraversal(int paramInt1, int paramInt2, View paramView)
  {
    if (paramInt1 == 1001) {
      traversalChildViewForSkinChange(paramView);
    }
    while (paramInt1 != 1002) {
      return;
    }
    traversalChildViewForNoPicChange(paramView);
  }
  
  public void handleNoPicModeChange()
  {
    traversal(1002);
  }
  
  public void invalidateRefreshHeader()
  {
    if ((this.mQBRefreshHeader != null) && ((this.mOffsetY <= 0) || (!this.optimizeHeaderRefresh))) {
      invalidate();
    }
  }
  
  public boolean isRefreshing()
  {
    return (this.mQBRefreshHeader != null) && (this.mQBRefreshHeader.isRefreshing());
  }
  
  public boolean isTouchStopWhenFastFling()
  {
    return false;
  }
  
  public void notifyNestViewToFling(int paramInt1, int paramInt2)
  {
    fling(0, paramInt2);
  }
  
  public void onAboutToRefresh()
  {
    if (isKingCardMobileNetWork())
    {
      setRefreshWithTargetType(3);
      return;
    }
    setRefreshWithTargetType(-1);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.restoreRefresh();
    }
    if (this.mIsResponseToDoubleScroll) {
      handleDoubleScrollResponseChange(this.mIsResponseToDoubleScroll);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if ((this.mQBRefreshHeader == null) || (!this.mQBRefreshHeader.isRefreshHeaderShowing())) {
      stopScroll();
    }
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.stopRefresh();
    }
    if ((getAdapter() != null) && ((getAdapter() instanceof HippyTKDListViewAdapter))) {
      ((HippyTKDListViewAdapter)getAdapter()).cancelAllPreFetchTask();
    }
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onInitialListReady() {}
  
  public void onRefresh()
  {
    if (this.mAdapter != null) {
      this.mAdapter.startRefreshData();
    }
  }
  
  public void onScrollStateChanged(int paramInt1, int paramInt2)
  {
    super.onScrollStateChanged(paramInt1, paramInt2);
    if (getAdapter() != null)
    {
      ((HippyTKDListViewAdapter)getAdapter()).checkScrollForReport();
      ((HippyTKDListViewAdapter)getAdapter()).checkOnScrollEvent();
      checkExposureForReport(paramInt1, paramInt2);
    }
  }
  
  public void onShowToast() {}
  
  public void postDelayedDelegate(Runnable paramRunnable, long paramLong)
  {
    postDelayed(paramRunnable, paramLong);
  }
  
  public void removeCallbacksDelegate(Runnable paramRunnable)
  {
    removeCallbacks(paramRunnable);
  }
  
  public void removeOnScrollFinishListener()
  {
    this.mViewFlinger.mScrollFinishListener = null;
    this.mViewFlinger.mTargetPosition = 2147483647;
  }
  
  public void scrollBack(int paramInt1, RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener, int paramInt2)
  {
    int i;
    if ((hasNoItem()) && (this.mQBRefreshHeader != null) && (this.mQBRefreshHeader.checkRefreshState(2)))
    {
      this.mOffsetY = 0;
      this.mViewFlinger.postOnAnimation();
      i = 0;
    }
    for (;;)
    {
      this.mViewFlinger.mScrollFinishListener = paramOnScrollFinishListener;
      this.mViewFlinger.mTargetPosition = i;
      return;
      i = paramInt1;
      if (paramInt2 != 0)
      {
        i = paramInt1;
        if (this.mRecyclerViewAdapter != null)
        {
          int j = 0;
          for (;;)
          {
            i = paramInt1;
            if (j >= paramInt2) {
              break;
            }
            paramInt1 += this.mRecyclerViewAdapter.getItemHeight(j);
            j += 1;
          }
        }
      }
      smoothScrollBy(0, i, false, true);
    }
  }
  
  public void scrollNestViewBy(int paramInt1, int paramInt2)
  {
    scrollBy(0, paramInt2);
    paramInt1 = getAdapter().getListTotalHeight();
    if ((paramInt2 <= 0) || (getOffsetY() + paramInt2 < paramInt1 - getHeight()) || (!this.needNotifyFooter) || ((shouldPrebindItem()) && (this.mOffsetY + getHeight() != paramInt1))) {
      return;
    }
    this.needNotifyFooter = false;
    this.checkNotifyFooterOnRelease = false;
    getAdapter().notifyLastFooterAppeared();
  }
  
  public void scrollNestViewTo(int paramInt1, int paramInt2)
  {
    scrollBy(0, paramInt2 - getOffsetY());
  }
  
  public void scrollToPosition(int paramInt)
  {
    super.scrollToPosition(paramInt);
    checkExposureForReport(2, 0);
  }
  
  public void scrollToShowHeader(int paramInt, RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener)
  {
    smoothScrollBy(0, -paramInt - this.mOffsetY, false, true);
    this.mViewFlinger.mScrollFinishListener = paramOnScrollFinishListener;
    this.mViewFlinger.mTargetPosition = (-paramInt - this.mOffsetY);
  }
  
  public void scrollToShowHeaderAtOnce(int paramInt)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (this.mAdapter != null) {}
    for (int i = -this.mAdapter.getHeaderViewCount();; i = 0)
    {
      localLayoutManager.scrollToPositionWithOffset(i, paramInt);
      this.mLayout.mPreventFixGap = true;
      return;
    }
  }
  
  public void scrollToShowHeaderSmooth(int paramInt)
  {
    smoothScrollBy(0, -paramInt - this.mOffsetY, false, true);
  }
  
  public void scrollToTop(RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener, int paramInt)
  {
    if (this.mEnableScrollToContentOffset)
    {
      this.mEnableScrollToContentOffset = false;
      return;
    }
    scrollBack(-this.mOffsetY, paramOnScrollFinishListener, paramInt);
  }
  
  public void scrollToTopAtOnce()
  {
    super.scrollToTopAtOnce();
    checkExposureForReport(2, 0);
  }
  
  public void scrollToTopRightAway()
  {
    scrollToPosition(0, 0);
    post(new HippyTKDListView.2(this));
  }
  
  public void sendOnScrollEvent() {}
  
  public void setCustomHippyRefreshView(View paramView)
  {
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.setCustomHippyRefreshView(paramView);
    }
  }
  
  public void setCustomRefreshColor(int paramInt1, int paramInt2, int paramInt3)
  {
    setRefreshEnabled(true);
    this.mQBRefreshHeader.setCustomRefreshBallColor(paramInt1, paramInt2, paramInt3);
  }
  
  public void setEnableExposureReport(boolean paramBoolean)
  {
    if (getAdapter() != null) {
      ((HippyTKDListViewAdapter)getAdapter()).setEnableExposureReport(paramBoolean);
    }
  }
  
  public void setEnableScrollForReport(boolean paramBoolean)
  {
    if (getAdapter() != null) {
      ((HippyTKDListViewAdapter)getAdapter()).setEnableScrollForReport(paramBoolean);
    }
  }
  
  public void setEnableScrollToContentOffset(boolean paramBoolean)
  {
    this.mEnableScrollToContentOffset = paramBoolean;
  }
  
  public void setFastScrollerEnabled(boolean paramBoolean) {}
  
  public void setInitialContentOffset(int paramInt)
  {
    this.mInitialContentOffset = paramInt;
    this.mEnableScrollToContentOffset = false;
  }
  
  public void setLiftEnabled(boolean paramBoolean) {}
  
  public void setListData()
  {
    if (getAdapter() != null) {
      ((HippyTKDListViewAdapter)getAdapter()).setPreloadItemNum(getAdapter().getPreloadThresholdInItemNumber());
    }
    if ((this.mInitialContentOffset > 0) && (this.mEnableScrollToContentOffset)) {
      scrollToPosition(0, -this.mInitialContentOffset);
    }
    for (;;)
    {
      super.setListData();
      return;
      this.mEnableScrollToContentOffset = false;
    }
  }
  
  protected void setLoadingStatus(int paramInt, String paramString)
  {
    ((HippyTKDListViewAdapter)getAdapter()).setLoadingStatus(paramInt, paramString);
  }
  
  public void setPlaceHolderDrawableEnabled(boolean paramBoolean) {}
  
  protected void setPreloadItemNumber(int paramInt)
  {
    if (getAdapter() != null) {
      ((HippyTKDListViewAdapter)getAdapter()).setPreloadItemNum(paramInt);
    }
  }
  
  public void setRefreshColors(HippyArray paramHippyArray)
  {
    this.mRefreshColors = paramHippyArray;
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    if (this.mEnableRefresh != paramBoolean)
    {
      this.mEnableRefresh = paramBoolean;
      if (paramBoolean) {
        this.mQBRefreshHeader = new HippyTKDRefreshHeader(this);
      }
    }
    else
    {
      return;
    }
    this.mQBRefreshHeader = null;
  }
  
  public void setRefreshPromptInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mQBRefreshHeader != null) {
      this.mQBRefreshHeader.setRefreshPromptInfo(paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setRefreshWithTargetType(int paramInt)
  {
    if (this.mEnableRefresh) {
      this.mQBRefreshHeader.setRefreshWithTargetType(paramInt);
    }
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }
  
  public void setScrollEventThrottle(int paramInt)
  {
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if ((localAdapter instanceof HippyTKDListViewAdapter)) {
      ((HippyTKDListViewAdapter)localAdapter).setScrollEventThrottle(paramInt);
    }
  }
  
  public void setScrollForReportThrottle(int paramInt)
  {
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if ((localAdapter instanceof HippyTKDListViewAdapter)) {
      ((HippyTKDListViewAdapter)localAdapter).setScrollForReportThrottle(paramInt);
    }
  }
  
  public void setScrollbarEnabled(boolean paramBoolean) {}
  
  public boolean shouldStopOnInterceptTouchEvent(MotionEvent paramMotionEvent, int paramInt, boolean paramBoolean)
  {
    return ((this.mOffsetY < 0) || (getHeight() > paramInt)) && (this.mQBRefreshHeader != null) && (this.mEnableRefresh) && (this.mQBRefreshHeader.isRefreshHeaderShowing()) && (!paramBoolean);
  }
  
  public boolean shouldStopOnTouchEvent(MotionEvent paramMotionEvent, int paramInt, boolean paramBoolean)
  {
    return ((this.mOffsetY < 0) || (getHeight() > paramInt)) && (this.mQBRefreshHeader != null) && (this.mEnableRefresh) && (this.mQBRefreshHeader.isRefreshHeaderShowing()) && (!paramBoolean);
  }
  
  public boolean shouldStopReleaseGlows(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mQBRefreshHeader != null) && (this.mEnableRefresh))
    {
      Scroller localScroller = this.mViewFlinger.getScroller();
      paramBoolean2 = paramBoolean1;
      if (localScroller.isFinished())
      {
        paramBoolean2 = paramBoolean1;
        if (localScroller.isFling())
        {
          paramBoolean2 = paramBoolean1;
          if (getOffsetY() < HippyTKDRefreshHeader.CONTENT_HEIGHT) {
            paramBoolean2 = true;
          }
        }
      }
      if (this.mQBRefreshHeader.onUpAction(paramBoolean2)) {
        return true;
      }
    }
    return false;
  }
  
  public void startLoadMore()
  {
    if ((getAdapter() instanceof HippyTKDListViewAdapter)) {
      ((HippyTKDListViewAdapter)getAdapter()).startLoadMore();
    }
  }
  
  public void startRefresh(int paramInt)
  {
    if ((this.mEnableRefresh) && (this.mQBRefreshHeader != null) && (this.mQBRefreshHeader.checkRefreshState(0)))
    {
      if ((getAdapter() instanceof HippyTKDListViewAdapter)) {
        ((HippyTKDListViewAdapter)getAdapter()).setLoadingStatus(2, "");
      }
      scrollToTopRightAway();
      if (paramInt == 1)
      {
        setRefreshWithTargetType(-1);
        startRefresh(true);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 3)
    {
      setRefreshWithTargetType(paramInt);
      startRefresh(true);
      return;
    }
    setRefreshWithTargetType(-1);
    startRefreshWithType(true);
  }
  
  public void startRefresh(boolean paramBoolean)
  {
    if (this.mEnableRefresh) {
      this.mQBRefreshHeader.startRefresh(paramBoolean);
    }
  }
  
  public void startRefreshWithOnlyAnimation(boolean paramBoolean)
  {
    if (this.mEnableRefresh) {
      this.mQBRefreshHeader.startRefreshOnlyWithAimation(paramBoolean);
    }
  }
  
  public void startRefreshWithType(boolean paramBoolean)
  {
    if (this.mEnableRefresh) {
      this.mQBRefreshHeader.startRefreshWithType(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView
 * JD-Core Version:    0.7.0.1
 */