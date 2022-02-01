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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class HippyTKDListViewAdapter
  extends HippyListAdapter
{
  private final int[] fixedEndEdge = new int[2];
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
  
  private int[] fixEndEdgeAndLastVisiblePosition(int paramInt1, int paramInt2)
  {
    int j = getFixedLastPositionYByDp(paramInt1);
    int i = paramInt2;
    if (j != paramInt1) {
      i = getFixedLastPosition(paramInt2, j);
    }
    int[] arrayOfInt = this.fixedEndEdge;
    arrayOfInt[0] = j;
    arrayOfInt[1] = i;
    return arrayOfInt;
  }
  
  private int getFixedLastPosition(int paramInt1, int paramInt2)
  {
    int j = (int)PixelUtil.dp2px(paramInt2);
    paramInt2 = 0;
    int i = 0;
    while (paramInt2 <= paramInt1)
    {
      i += getItemHeight(paramInt2);
      if ((i > 0) && (i > j)) {
        return paramInt2;
      }
      paramInt2 += 1;
    }
    return paramInt1;
  }
  
  private int getFixedLastPositionYByDp(int paramInt)
  {
    Object localObject = this.mContainerPositionGetter;
    int i = paramInt;
    if (localObject != null)
    {
      localObject = ((HippyTKDListViewAdapter.IContainerPositionGetter)localObject).getContainerPosition();
      i = paramInt;
      if (localObject != null) {
        i = (int)PixelUtil.px2dp(PixelUtil.dp2px(paramInt) - (((HippyTKDListViewAdapter.ContainerPosition)localObject).top - ((HippyTKDListViewAdapter.ContainerPosition)localObject).marginTop + ((HippyTKDListViewAdapter.ContainerPosition)localObject).offset));
      }
    }
    return i;
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
    if (!this.mEnableExposureReport) {
      return;
    }
    HippyTKDListView.ExposureForReport localExposureForReport = getExposureForReportInner(paramInt1, paramInt2);
    if (localExposureForReport == null) {
      return;
    }
    if (checkNeedToReport(localExposureForReport.mVelocity, paramInt2))
    {
      if (this.mExposureReportResultMap == null) {
        this.mExposureReportResultMap = new HippyMap();
      }
      this.mExposureReportResultMap.clear();
      int[] arrayOfInt = fixEndEdgeAndLastVisiblePosition(localExposureForReport.mEndEdgePos, localExposureForReport.mLastVisibleRowIndex);
      this.mExposureReportResultMap.pushInt("startEdgePos", localExposureForReport.mStartEdgePos);
      this.mExposureReportResultMap.pushInt("endEdgePos", arrayOfInt[0]);
      this.mExposureReportResultMap.pushInt("firstVisibleRowIndex", localExposureForReport.mFirstVisibleRowIndex);
      this.mExposureReportResultMap.pushInt("lastVisibleRowIndex", arrayOfInt[1]);
      this.mExposureReportResultMap.pushInt("scrollState", localExposureForReport.mScrollState);
      this.mExposureReportResultMap.pushArray("visibleRowFrames", localExposureForReport.mVisibleRowFrames);
      localExposureForReport.send(this.mParentRecyclerView, this.mExposureReportResultMap);
    }
  }
  
  protected boolean checkNeedToReport(float paramFloat, int paramInt)
  {
    return true;
  }
  
  protected void checkOnScrollEvent()
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {
      return;
    }
    this.mLastScrollEventTimeStamp = l;
    HippyMap localHippyMap = getOnScrollDataMap();
    if (localHippyMap != null)
    {
      this.mHasOnScroll = true;
      getOnScrollEvent().send(this.mParentRecyclerView, localHippyMap);
    }
  }
  
  protected void checkScrollForReport()
  {
    if (!this.mEnableScrollForReport) {
      return;
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
    float f = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    int i2 = this.mParentRecyclerView.getScrollState();
    HippyArray localHippyArray = new HippyArray();
    int k = 0;
    i = 0;
    while (k < m)
    {
      i = i + getItemHeight(k) + getItemMaigin(1, k) + getItemMaigin(3, k);
      k += 1;
    }
    k = m;
    Object localObject;
    while (k <= j)
    {
      localObject = new HippyMap();
      ((HippyMap)localObject).pushInt("x", 0);
      ((HippyMap)localObject).pushInt("y", (int)PixelUtil.px2dp(i));
      i += getItemHeight(k);
      ((HippyMap)localObject).pushInt("width", (int)PixelUtil.px2dp(getItemWidth(k)));
      ((HippyMap)localObject).pushInt("height", (int)PixelUtil.px2dp(getItemHeight(k)));
      localHippyArray.pushMap((HippyMap)localObject);
      k += 1;
    }
    if ((i2 == 0) && (checkNeedToReport(0.0F, i2)))
    {
      this.mHasOnScrollForReport = true;
      if (this.mScrollReportResultMap == null) {
        this.mScrollReportResultMap = new HippyMap();
      }
      this.mScrollReportResultMap.clear();
      localObject = fixEndEdgeAndLastVisiblePosition(i1, j);
      this.mScrollReportResultMap.pushInt("startEdgePos", n);
      this.mScrollReportResultMap.pushInt("endEdgePos", localObject[0]);
      this.mScrollReportResultMap.pushInt("firstVisibleRowIndex", m);
      this.mScrollReportResultMap.pushInt("lastVisibleRowIndex", localObject[1]);
      this.mScrollReportResultMap.pushInt("scrollState", i2);
      this.mScrollReportResultMap.pushArray("visibleRowFrames", localHippyArray);
      getOnScrollForReportEvent().send(this.mParentRecyclerView, this.mScrollReportResultMap);
      return;
    }
    if ((f < this.mParentRecyclerView.getHeight() * 2) && (checkNeedToReport(f, i2)))
    {
      this.mHasOnScrollForReport = true;
      if (this.mScrollReportResultMap == null) {
        this.mScrollReportResultMap = new HippyMap();
      }
      this.mScrollReportResultMap.clear();
      localObject = fixEndEdgeAndLastVisiblePosition(i1, j);
      this.mScrollReportResultMap.pushInt("startEdgePos", n);
      this.mScrollReportResultMap.pushInt("endEdgePos", localObject[0]);
      this.mScrollReportResultMap.pushInt("firstVisibleRowIndex", m);
      this.mScrollReportResultMap.pushInt("lastVisibleRowIndex", localObject[1]);
      this.mScrollReportResultMap.pushInt("scrollState", i2);
      this.mScrollReportResultMap.pushArray("visibleRowFrames", localHippyArray);
      getOnScrollForReportEvent().send(this.mParentRecyclerView, this.mScrollReportResultMap);
    }
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
    paramInt1 = 0;
    while (j < k)
    {
      paramInt1 = paramInt1 + getItemHeight(j) + getItemMaigin(1, j) + getItemMaigin(3, j);
      j += 1;
    }
    j = k;
    while (j <= i)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("x", 0);
      localHippyMap.pushInt("y", (int)PixelUtil.px2dp(paramInt1));
      paramInt1 += getItemHeight(j);
      localHippyMap.pushInt("width", (int)PixelUtil.px2dp(getItemWidth(j)));
      localHippyMap.pushInt("height", (int)PixelUtil.px2dp(getItemHeight(j)));
      localHippyArray.pushMap(localHippyMap);
      j += 1;
    }
    float f = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    return new HippyTKDListView.ExposureForReport(this.mParentRecyclerView.getId(), m, n, k, i, (int)f, paramInt2, localHippyArray);
  }
  
  protected HippyTKDListView.OuterScroll getExposureForReportScrollInner(int paramInt1, int paramInt2)
  {
    if (!this.mEnableExposureReport) {
      return null;
    }
    int n = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
    int i1 = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
    int m = ((LinearLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
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
    paramInt1 = 0;
    while (j < m)
    {
      paramInt1 = paramInt1 + getItemHeight(j) + getItemMaigin(1, j) + getItemMaigin(3, j);
      j += 1;
    }
    int k = m;
    j = paramInt1;
    paramInt1 = k;
    while (paramInt1 <= i)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("x", 0);
      localHippyMap.pushInt("y", (int)PixelUtil.px2dp(j));
      k = getItemWidth(paramInt1);
      int i2 = getItemHeight(paramInt1);
      j += i2;
      localHippyMap.pushInt("width", (int)PixelUtil.px2dp(k));
      localHippyMap.pushInt("height", (int)PixelUtil.px2dp(i2));
      localHippyArray.pushMap(localHippyMap);
      paramInt1 += 1;
    }
    float f = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    return new HippyTKDListView.OuterScroll(this.mParentRecyclerView.getId(), n, i1, m, i, (int)f, paramInt2, localHippyArray);
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
    i = 0;
    while (k < m)
    {
      i = i + getItemHeight(k) + getItemMaigin(1, k) + getItemMaigin(3, k);
      k += 1;
    }
    k = m;
    while (k <= j)
    {
      localObject = new HippyMap();
      ((HippyMap)localObject).pushInt("x", 0);
      ((HippyMap)localObject).pushInt("y", (int)PixelUtil.px2dp(i));
      i += getItemHeight(k);
      ((HippyMap)localObject).pushInt("width", (int)PixelUtil.px2dp(getItemWidth(k)));
      ((HippyMap)localObject).pushInt("height", (int)PixelUtil.px2dp(getItemHeight(k)));
      this.mOnScrollVisibleItemArray.pushMap((HippyMap)localObject);
      k += 1;
    }
    if (this.mOnScrollDataMap == null) {
      this.mOnScrollDataMap = new HippyMap();
    }
    this.mOnScrollDataMap.clear();
    Object localObject = fixEndEdgeAndLastVisiblePosition(i1, j);
    this.mOnScrollDataMap.pushInt("startEdgePos", n);
    this.mOnScrollDataMap.pushInt("endEdgePos", localObject[0]);
    this.mOnScrollDataMap.pushInt("firstVisibleRowIndex", m);
    this.mOnScrollDataMap.pushInt("lastVisibleRowIndex", localObject[1]);
    this.mOnScrollDataMap.pushInt("scrollState", i2);
    this.mOnScrollDataMap.pushArray("visibleRowFrames", this.mOnScrollVisibleItemArray);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstPosition=");
    localStringBuilder.append(m);
    localStringBuilder.append(", lastPosition=");
    localStringBuilder.append(localObject[1]);
    QLog.d("HippyTKDListViewAdapter", 4, localStringBuilder.toString());
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
    if (paramContentHolder != null)
    {
      paramInt2 = paramContentHolder.getChildCount();
      paramInt1 += 1;
      if (paramInt1 < paramInt2) {
        preLoadImageRecursive(paramContentHolder.getChildAt(paramInt1));
      }
    }
  }
  
  protected void onClickBackward()
  {
    if ((this.mParentRecyclerView instanceof HippyTKDListView)) {
      ((HippyTKDListView)this.mParentRecyclerView).scrollToTopRightAway();
    }
  }
  
  protected void onClickRetry()
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
      else
      {
        if ((this.mDefaultLoadingView != null) && ((this.mDefaultLoadingView instanceof HippyTKDDefaultFooter))) {
          ((HippyTKDDefaultFooter)this.mDefaultLoadingView).setLoadingStatus(100, paramString);
        }
        setLoadingStatus(paramInt);
      }
      if (this.mDefaultLoadingView != null)
      {
        this.mDefaultLoadingView.measure(View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getHeight(), 1073741824));
        this.mDefaultLoadingView.layout(this.mDefaultLoadingView.getLeft(), this.mDefaultLoadingView.getTop(), this.mDefaultLoadingView.getRight(), this.mDefaultLoadingView.getBottom());
        this.mDefaultLoadingView.invalidate();
      }
      this.mOnPreloadCalled = false;
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter
 * JD-Core Version:    0.7.0.1
 */