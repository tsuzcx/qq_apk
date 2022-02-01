package com.tencent.hippy.qq.view.tkd.listview;

import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListAdapter.OnEndReachedEvent;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import com.tencent.widget.immersive.ImmersiveUtils;

public class HippyTKDListViewAdapter
  extends HippyListAdapter
{
  private int[] fixedEndEdge = new int[2];
  private HippyTKDListViewAdapter.IContainerPositionGetter mContainerPositionGetter;
  private boolean mEnableExposureReport;
  private boolean mEnableScrollForReport;
  private HippyMap mExposureReportResultMap;
  private boolean mHasExposureReport = false;
  private boolean mHasLoadMore = false;
  private boolean mHasOnFooterAppeared = false;
  private boolean mHasOnRefresh = false;
  private boolean mHasOnScroll = false;
  private boolean mHasOnScrollForReport = false;
  private boolean mHasPreload = false;
  private long mLastScrollEventTimeStamp = -1L;
  private long mLastScrollForReportTimeStamp = -1L;
  private HippyTKDListViewAdapter.OnFooterAppearedEvent mOnFooterAppearedEvent;
  private HippyTKDListViewAdapter.OnScrollEvent mOnListScrollEvent;
  private RecyclerView.OnListScrollListener mOnListScrollListener;
  private boolean mOnPreloadCalled;
  private HippyTKDListViewAdapter.OnRefreshEvent mOnRefreshEvent;
  private HippyMap mOnScrollDataMap;
  private HippyTKDListViewAdapter.OnScrollForReportEvent mOnScrollForReportEvent;
  private HippyArray mOnScrollVisibleItemArray;
  private int mPreloadDistanceWithItemNumber;
  private int mPreloadItemNum;
  int mScrollEventThrottle = 200;
  int mScrollForReportThrottle = 200;
  private HippyMap mScrollReportResultMap;
  private boolean mShouldUpdatePreloadDistance;
  
  public HippyTKDListViewAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    super(paramRecyclerView, paramHippyEngineContext);
    this.mDefaultLoadingView = new HippyTKDDefaultFooter(paramRecyclerView.getContext());
  }
  
  private int[] fixEndEdge(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    int m;
    if (this.mContainerPositionGetter != null)
    {
      HippyTKDListViewAdapter.ContainerPosition localContainerPosition = this.mContainerPositionGetter.getContainerPosition();
      if ((localContainerPosition != null) && (localContainerPosition.mode == 1))
      {
        float f = PixelUtil.dp2px(paramInt1);
        paramInt1 = localContainerPosition.top;
        i = localContainerPosition.marginTop;
        j = (int)PixelUtil.px2dp(f - (localContainerPosition.offset + (paramInt1 - i)));
        i = 1;
        k = paramInt2;
        if (i != 0)
        {
          m = (int)PixelUtil.dp2px(j);
          paramInt1 = 0;
          i = 0;
        }
      }
    }
    for (;;)
    {
      k = paramInt2;
      if (paramInt1 <= paramInt2)
      {
        i += getItemHeight(paramInt1);
        if ((i > 0) && (i > m)) {
          k = paramInt1;
        }
      }
      else
      {
        this.fixedEndEdge[0] = j;
        this.fixedEndEdge[1] = k;
        return this.fixedEndEdge;
        i = 0;
        j = paramInt1;
        break;
        i = 0;
        j = paramInt1;
        break;
      }
      paramInt1 += 1;
    }
  }
  
  private HippyTKDListViewAdapter.OnFooterAppearedEvent getOnFooterAppearedEvent()
  {
    if (this.mOnFooterAppearedEvent == null) {
      this.mOnFooterAppearedEvent = new HippyTKDListViewAdapter.OnFooterAppearedEvent(this, "onFooterAppeared");
    }
    return this.mOnFooterAppearedEvent;
  }
  
  private HippyTKDListViewAdapter.OnRefreshEvent getOnRefreshEvent()
  {
    if (this.mOnRefreshEvent == null) {
      this.mOnRefreshEvent = new HippyTKDListViewAdapter.OnRefreshEvent(this, "onRefresh");
    }
    return this.mOnRefreshEvent;
  }
  
  private HippyTKDListViewAdapter.OnScrollEvent getOnScrollEvent()
  {
    if (this.mOnListScrollEvent == null) {
      this.mOnListScrollEvent = new HippyTKDListViewAdapter.OnScrollEvent(this);
    }
    return this.mOnListScrollEvent;
  }
  
  private HippyTKDListViewAdapter.OnScrollForReportEvent getOnScrollForReportEvent()
  {
    if (this.mOnScrollForReportEvent == null) {
      this.mOnScrollForReportEvent = new HippyTKDListViewAdapter.OnScrollForReportEvent(this, "onScrollForReport");
    }
    return this.mOnScrollForReportEvent;
  }
  
  private void preLoadImageRecursive(RenderNode paramRenderNode)
  {
    if (paramRenderNode != null)
    {
      if (paramRenderNode.getClassName().equals("Image"))
      {
        HippyMap localHippyMap = paramRenderNode.getProps();
        localHippyMap.getString("src");
        localHippyMap.getBoolean("gifEnabled");
        paramRenderNode.getWidth();
        paramRenderNode.getHeight();
      }
      int i = 0;
      while (i < paramRenderNode.getChildCount())
      {
        preLoadImageRecursive(paramRenderNode.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public int calcPreloadThresholdWithItemNumber()
  {
    if (this.mShouldUpdatePreloadDistance)
    {
      int j = getItemCount() - 1;
      int k = getItemCount() - this.mPreloadItemNum;
      int i = k;
      if (k < 0) {
        i = 0;
      }
      this.mPreloadDistanceWithItemNumber = 0;
      while (j >= i)
      {
        this.mPreloadDistanceWithItemNumber += getItemHeight(j);
        j -= 1;
      }
      this.mShouldUpdatePreloadDistance = false;
    }
    return this.mPreloadDistanceWithItemNumber;
  }
  
  public void cancelAllPreFetchTask() {}
  
  protected void checkExposureForReport(int paramInt1, int paramInt2)
  {
    if (!this.mEnableExposureReport) {}
    HippyTKDListView.ExposureForReport localExposureForReport;
    do
    {
      return;
      localExposureForReport = getExposureForReportInner(paramInt1, paramInt2);
    } while ((localExposureForReport == null) || (!checkNeedToReport(localExposureForReport.mVelocity, paramInt2)));
    if (this.mExposureReportResultMap == null) {
      this.mExposureReportResultMap = new HippyMap();
    }
    this.mExposureReportResultMap.clear();
    int[] arrayOfInt = fixEndEdge(localExposureForReport.mEndEdgePos, localExposureForReport.mLastVisibleRowIndex);
    this.mExposureReportResultMap.pushInt("startEdgePos", localExposureForReport.mStartEdgePos);
    this.mExposureReportResultMap.pushInt("endEdgePos", arrayOfInt[0]);
    this.mExposureReportResultMap.pushInt("firstVisibleRowIndex", localExposureForReport.mFirstVisibleRowIndex);
    this.mExposureReportResultMap.pushInt("lastVisibleRowIndex", arrayOfInt[1]);
    this.mExposureReportResultMap.pushInt("scrollState", localExposureForReport.mScrollState);
    this.mExposureReportResultMap.pushArray("visibleRowFrames", localExposureForReport.mVisibleRowFrames);
    localExposureForReport.send(this.mParentRecyclerView, this.mExposureReportResultMap);
  }
  
  protected boolean checkNeedToReport(float paramFloat, int paramInt)
  {
    return true;
  }
  
  protected void checkOnScrollEvent()
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {}
    HippyMap localHippyMap;
    do
    {
      return;
      this.mLastScrollEventTimeStamp = l;
      localHippyMap = getOnScrollDataMap();
    } while (localHippyMap == null);
    this.mHasOnScroll = true;
    getOnScrollEvent().send(this.mParentRecyclerView, localHippyMap);
  }
  
  protected void checkScrollForReport()
  {
    if (!this.mEnableScrollForReport) {}
    int n;
    int i1;
    int m;
    int j;
    float f;
    int i2;
    HippyArray localHippyArray;
    do
    {
      return;
      n = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
      i1 = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
      m = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int i = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      j = i;
      if (i >= 1)
      {
        j = i;
        if ((this.mParentRecyclerView.getLayoutManager().findViewByPosition(i) instanceof HippyTKDDefaultFooter)) {
          j = i - 1;
        }
      }
      f = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
      i2 = this.mParentRecyclerView.getScrollState();
      localHippyArray = new HippyArray();
      int k = 0;
      int i3;
      int i4;
      int i5;
      for (i = 0; k < m; i = i5 + (i + i3 + i4))
      {
        i3 = getItemHeight(k);
        i4 = getItemMaigin(1, k);
        i5 = getItemMaigin(3, k);
        k += 1;
      }
      k = i;
      i = m;
      while (i <= j)
      {
        localObject = new HippyMap();
        ((HippyMap)localObject).pushInt("x", 0);
        ((HippyMap)localObject).pushInt("y", (int)PixelUtil.px2dp(k));
        k += getItemHeight(i);
        ((HippyMap)localObject).pushInt("width", (int)PixelUtil.px2dp(getItemWidth(i)));
        ((HippyMap)localObject).pushInt("height", (int)PixelUtil.px2dp(getItemHeight(i)));
        localHippyArray.pushMap((HippyMap)localObject);
        i += 1;
      }
      if ((i2 == 0) && (checkNeedToReport(0.0F, i2)))
      {
        this.mHasOnScrollForReport = true;
        if (this.mScrollReportResultMap == null) {
          this.mScrollReportResultMap = new HippyMap();
        }
        this.mScrollReportResultMap.clear();
        localObject = fixEndEdge(i1, j);
        this.mScrollReportResultMap.pushInt("startEdgePos", n);
        this.mScrollReportResultMap.pushInt("endEdgePos", localObject[0]);
        this.mScrollReportResultMap.pushInt("firstVisibleRowIndex", m);
        this.mScrollReportResultMap.pushInt("lastVisibleRowIndex", localObject[1]);
        this.mScrollReportResultMap.pushInt("scrollState", i2);
        this.mScrollReportResultMap.pushArray("visibleRowFrames", localHippyArray);
        getOnScrollForReportEvent().send(this.mParentRecyclerView, this.mScrollReportResultMap);
        return;
      }
    } while ((f >= this.mParentRecyclerView.getHeight() * 2) || (!checkNeedToReport(f, i2)));
    this.mHasOnScrollForReport = true;
    if (this.mScrollReportResultMap == null) {
      this.mScrollReportResultMap = new HippyMap();
    }
    this.mScrollReportResultMap.clear();
    Object localObject = fixEndEdge(i1, j);
    this.mScrollReportResultMap.pushInt("startEdgePos", n);
    this.mScrollReportResultMap.pushInt("endEdgePos", localObject[0]);
    this.mScrollReportResultMap.pushInt("firstVisibleRowIndex", m);
    this.mScrollReportResultMap.pushInt("lastVisibleRowIndex", localObject[1]);
    this.mScrollReportResultMap.pushInt("scrollState", i2);
    this.mScrollReportResultMap.pushArray("visibleRowFrames", localHippyArray);
    getOnScrollForReportEvent().send(this.mParentRecyclerView, this.mScrollReportResultMap);
  }
  
  public int getDefaultFooterHeight()
  {
    return ImmersiveUtils.dpToPx(36.0F);
  }
  
  protected HippyTKDListView.ExposureForReport getExposureForReportInner(int paramInt1, int paramInt2)
  {
    if (!this.mEnableExposureReport) {
      return null;
    }
    this.mHasExposureReport = true;
    int m = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
    int n = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
    int k = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    paramInt1 = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = paramInt1;
    if (paramInt1 >= 1)
    {
      i = paramInt1;
      if ((this.mParentRecyclerView.getLayoutManager().findViewByPosition(paramInt1) instanceof HippyTKDDefaultFooter)) {
        i = paramInt1 - 1;
      }
    }
    HippyArray localHippyArray = new HippyArray();
    int j = 0;
    int i1;
    int i2;
    int i3;
    for (paramInt1 = 0; j < k; paramInt1 = i3 + (paramInt1 + i1 + i2))
    {
      i1 = getItemHeight(j);
      i2 = getItemMaigin(1, j);
      i3 = getItemMaigin(3, j);
      j += 1;
    }
    j = paramInt1;
    paramInt1 = k;
    while (paramInt1 <= i)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("x", 0);
      localHippyMap.pushInt("y", (int)PixelUtil.px2dp(j));
      j += getItemHeight(paramInt1);
      localHippyMap.pushInt("width", (int)PixelUtil.px2dp(getItemWidth(paramInt1)));
      localHippyMap.pushInt("height", (int)PixelUtil.px2dp(getItemHeight(paramInt1)));
      localHippyArray.pushMap(localHippyMap);
      paramInt1 += 1;
    }
    float f = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    return new HippyTKDListView.ExposureForReport(this.mParentRecyclerView.getId(), m, n, k, i, (int)f, paramInt2, localHippyArray);
  }
  
  protected HippyTKDListView.OuterScroll getExposureForReportScrollInner(int paramInt1, int paramInt2)
  {
    if (!this.mEnableExposureReport) {
      return null;
    }
    int m = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
    int n = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
    int k = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    paramInt1 = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = paramInt1;
    if (paramInt1 >= 1)
    {
      i = paramInt1;
      if ((this.mParentRecyclerView.getLayoutManager().findViewByPosition(paramInt1) instanceof HippyTKDDefaultFooter)) {
        i = paramInt1 - 1;
      }
    }
    HippyArray localHippyArray = new HippyArray();
    int j = 0;
    int i1;
    int i2;
    int i3;
    for (paramInt1 = 0; j < k; paramInt1 = i3 + (paramInt1 + i1 + i2))
    {
      i1 = getItemHeight(j);
      i2 = getItemMaigin(1, j);
      i3 = getItemMaigin(3, j);
      j += 1;
    }
    j = paramInt1;
    paramInt1 = k;
    while (paramInt1 <= i)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("x", 0);
      localHippyMap.pushInt("y", (int)PixelUtil.px2dp(j));
      i1 = getItemWidth(paramInt1);
      i2 = getItemHeight(paramInt1);
      j += i2;
      localHippyMap.pushInt("width", (int)PixelUtil.px2dp(i1));
      localHippyMap.pushInt("height", (int)PixelUtil.px2dp(i2));
      localHippyArray.pushMap(localHippyMap);
      paramInt1 += 1;
    }
    float f = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    return new HippyTKDListView.OuterScroll(this.mParentRecyclerView.getId(), m, n, k, i, (int)f, paramInt2, localHippyArray);
  }
  
  public RecyclerView.OnListScrollListener getOnListScrollListener()
  {
    if (this.mOnListScrollListener == null) {
      this.mOnListScrollListener = new HippyTKDListViewAdapter.1(this);
    }
    return this.mOnListScrollListener;
  }
  
  protected HippyMap getOnScrollDataMap()
  {
    if (this.mParentRecyclerView == null) {
      return null;
    }
    int n = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
    int i1 = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
    int m = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int i = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int j = i;
    if (i >= 1)
    {
      j = i;
      if ((this.mParentRecyclerView.getLayoutManager().findViewByPosition(i) instanceof HippyTKDDefaultFooter)) {
        j = i - 1;
      }
    }
    int i2 = this.mParentRecyclerView.getScrollState();
    if (this.mOnScrollVisibleItemArray == null) {
      this.mOnScrollVisibleItemArray = new HippyArray();
    }
    this.mOnScrollVisibleItemArray.clear();
    int k = 0;
    int i3;
    int i4;
    int i5;
    for (i = 0; k < m; i = i5 + (i + i3 + i4))
    {
      i3 = getItemHeight(k);
      i4 = getItemMaigin(1, k);
      i5 = getItemMaigin(3, k);
      k += 1;
    }
    k = i;
    i = m;
    while (i <= j)
    {
      localObject = new HippyMap();
      ((HippyMap)localObject).pushInt("x", 0);
      ((HippyMap)localObject).pushInt("y", (int)PixelUtil.px2dp(k));
      k += getItemHeight(i);
      ((HippyMap)localObject).pushInt("width", (int)PixelUtil.px2dp(getItemWidth(i)));
      ((HippyMap)localObject).pushInt("height", (int)PixelUtil.px2dp(getItemHeight(i)));
      this.mOnScrollVisibleItemArray.pushMap((HippyMap)localObject);
      i += 1;
    }
    if (this.mOnScrollDataMap == null) {
      this.mOnScrollDataMap = new HippyMap();
    }
    this.mOnScrollDataMap.clear();
    Object localObject = fixEndEdge(i1, j);
    this.mOnScrollDataMap.pushInt("startEdgePos", n);
    this.mOnScrollDataMap.pushInt("endEdgePos", localObject[0]);
    this.mOnScrollDataMap.pushInt("firstVisibleRowIndex", m);
    this.mOnScrollDataMap.pushInt("lastVisibleRowIndex", localObject[1]);
    this.mOnScrollDataMap.pushInt("scrollState", i2);
    this.mOnScrollDataMap.pushArray("visibleRowFrames", this.mOnScrollVisibleItemArray);
    return this.mOnScrollDataMap;
  }
  
  public int getPreloadThresholdInItemNumber()
  {
    return this.mPreloadItemNum;
  }
  
  public HippyMap getVisibleItems()
  {
    return getOnScrollDataMap();
  }
  
  public void notifyDataSetChanged()
  {
    Log.d("HippyQBListViewAdapter", "notifyDataSetChanged ");
    super.notifyDataSetChanged();
  }
  
  public void notifyEndReached()
  {
    if ((!this.mOnPreloadCalled) && (getItemCount() > 0)) {
      super.notifyEndReached();
    }
  }
  
  public void notifyLastFooterAppeared()
  {
    super.notifyLastFooterAppeared();
    if ((this.mLoadingStatus != 1) && (this.mLoadingStatus != 100) && (this.mLoadingStatus != 6)) {
      setLoadingStatus(1);
    }
    this.mHasOnFooterAppeared = true;
    getOnFooterAppearedEvent().send(this.mParentRecyclerView, null);
  }
  
  public void onBindContentView(ContentHolder paramContentHolder, int paramInt1, int paramInt2)
  {
    super.onBindContentView(paramContentHolder, paramInt1, paramInt2);
    paramContentHolder = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((paramContentHolder != null) && (paramInt1 + 1 < paramContentHolder.getChildCount())) {
      preLoadImageRecursive(paramContentHolder.getChildAt(paramInt1 + 1));
    }
  }
  
  public void onClickBackward()
  {
    if ((this.mParentRecyclerView instanceof HippyTKDListView)) {
      ((HippyTKDListView)this.mParentRecyclerView).scrollToTopRightAway();
    }
  }
  
  public void onClickRetry()
  {
    startLoadMore();
  }
  
  public void onPreload()
  {
    this.mHasPreload = true;
    this.mOnPreloadCalled = true;
    getOnEndReachedEvent().send(this.mParentRecyclerView, null);
  }
  
  public void onSuddenStop()
  {
    checkScrollForReport();
    checkOnScrollEvent();
  }
  
  public void setContainerPositionGetter(HippyTKDListViewAdapter.IContainerPositionGetter paramIContainerPositionGetter)
  {
    this.mContainerPositionGetter = paramIContainerPositionGetter;
  }
  
  protected void setEnableExposureReport(boolean paramBoolean)
  {
    this.mEnableExposureReport = paramBoolean;
  }
  
  protected void setEnableScrollForReport(boolean paramBoolean)
  {
    this.mEnableScrollForReport = paramBoolean;
  }
  
  public void setLoadingStatus(int paramInt)
  {
    if (!((HippyTKDListView)this.mParentRecyclerView).mEnableFooter) {
      return;
    }
    super.setLoadingStatus(paramInt);
  }
  
  protected void setLoadingStatus(int paramInt, String paramString)
  {
    if (!((HippyTKDListView)this.mParentRecyclerView).mEnableFooter) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 100)
      {
        setLoadingStatus(paramInt);
        if ((this.mDefaultLoadingView != null) && ((this.mDefaultLoadingView instanceof HippyTKDDefaultFooter))) {
          ((HippyTKDDefaultFooter)this.mDefaultLoadingView).setText(paramString);
        }
      }
      for (;;)
      {
        if (this.mDefaultLoadingView != null)
        {
          this.mDefaultLoadingView.measure(View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getHeight(), 1073741824));
          this.mDefaultLoadingView.layout(this.mDefaultLoadingView.getLeft(), this.mDefaultLoadingView.getTop(), this.mDefaultLoadingView.getRight(), this.mDefaultLoadingView.getBottom());
          this.mDefaultLoadingView.invalidate();
        }
        this.mOnPreloadCalled = false;
        return;
        if ((this.mDefaultLoadingView != null) && ((this.mDefaultLoadingView instanceof HippyTKDDefaultFooter))) {
          ((HippyTKDDefaultFooter)this.mDefaultLoadingView).setLoadingStatus(100, paramString);
        }
        setLoadingStatus(paramInt);
      }
    }
    setLoadingStatus(paramInt);
  }
  
  protected void setPreloadItemNum(int paramInt)
  {
    this.mPreloadItemNum = paramInt;
    this.mShouldUpdatePreloadDistance = true;
  }
  
  public void setScrollEventThrottle(int paramInt)
  {
    this.mScrollEventThrottle = paramInt;
  }
  
  public void setScrollForReportThrottle(int paramInt)
  {
    this.mScrollForReportThrottle = paramInt;
  }
  
  protected void startLoadMore()
  {
    this.mHasLoadMore = true;
    getOnEndReachedEvent().send(this.mParentRecyclerView, null);
    setLoadingStatus(1);
  }
  
  public void startRefreshData()
  {
    this.mHasOnRefresh = true;
    getOnRefreshEvent().send(this.mParentRecyclerView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter
 * JD-Core Version:    0.7.0.1
 */