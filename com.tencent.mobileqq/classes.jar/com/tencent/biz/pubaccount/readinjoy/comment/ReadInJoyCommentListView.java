package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;

public class ReadInJoyCommentListView
  extends XListView
{
  public static final int STATUS_IDLE = 0;
  public static final int STATUS_LOADING = 1;
  public static final String TAG = "ReadInJoyCommentListView";
  boolean isScrollingDown;
  int lastFirstVisibleItem;
  protected int mCurrentStatus = 0;
  private ReadInJoyCommentListView.MultiScrollListener mDefaultScrollListener = new ReadInJoyCommentListView.1(this);
  protected ProgressBar mFooterProgressBar;
  protected TextView mFooterTextView;
  protected RelativeLayout mFooterView;
  public boolean mHasMoreData = false;
  public ReadInJoyCommentListView.RefreshCallback mRefreshCallback;
  private ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener mScrollYListener;
  int preloadCount = 3;
  
  public ReadInJoyCommentListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private BaseAdapter getBaseAdapter()
  {
    if ((getAdapter() instanceof HeaderViewListAdapter))
    {
      HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)getAdapter();
      if (localHeaderViewListAdapter != null) {
        return (BaseAdapter)localHeaderViewListAdapter.getWrappedAdapter();
      }
    }
    else if ((getAdapter() instanceof BaseAdapter))
    {
      return (BaseAdapter)getAdapter();
    }
    return null;
  }
  
  private void init()
  {
    setOnScrollListener(this.mDefaultScrollListener);
  }
  
  private boolean isShowFooterView()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void loadingMore()
  {
    if ((isShowFooterView()) && (this.mRefreshCallback != null))
    {
      QLog.d("ReadInJoyCommentListView", 2, "loadingMore| hasMore " + this.mHasMoreData);
      showLoadingFooter();
      this.mCurrentStatus = 1;
      this.mRefreshCallback.a(this);
    }
  }
  
  private void notifyDataChanged()
  {
    Object localObject = getAdapter();
    if ((localObject instanceof HeaderViewListAdapter))
    {
      localObject = (HeaderViewListAdapter)localObject;
      if ((((HeaderViewListAdapter)localObject).getWrappedAdapter() instanceof BaseAdapter)) {
        ((BaseAdapter)((HeaderViewListAdapter)localObject).getWrappedAdapter()).notifyDataSetChanged();
      }
    }
    while (!(localObject instanceof BaseAdapter)) {
      return;
    }
    ((BaseAdapter)localObject).notifyDataSetChanged();
  }
  
  private void preLoadingMore()
  {
    if (this.mRefreshCallback != null)
    {
      QLog.d("ReadInJoyCommentListView", 2, "preLoadingMore | hasMore " + this.mHasMoreData);
      showLoadingFooter();
      this.mCurrentStatus = 1;
      this.mRefreshCallback.a(this);
    }
  }
  
  private void showLoadingFooter()
  {
    this.mFooterView.setVisibility(0);
    this.mFooterProgressBar.setVisibility(0);
    this.mFooterTextView.setText(2131689505);
    this.mFooterTextView.setOnClickListener(null);
    this.mFooterTextView.setVisibility(0);
  }
  
  private void showRestCommentCntFooter(long paramLong)
  {
    if (this.mFooterView != null)
    {
      this.mFooterView.setVisibility(0);
      this.mFooterTextView.setText(paramLong + HardCodeUtil.a(2131712889));
      this.mFooterTextView.setVisibility(0);
      this.mFooterProgressBar.setVisibility(8);
      this.mCurrentStatus = 0;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    BaseAdapter localBaseAdapter = getBaseAdapter();
    if (localBaseAdapter == null) {
      return -1;
    }
    return localBaseAdapter.getItemViewType(paramInt);
  }
  
  public void hideFooterView()
  {
    if ((this.mFooterView != null) && (getFooterViewsCount() > 0)) {
      this.mFooterView.setVisibility(8);
    }
    QLog.d("ReadInJoyCommentListView", 2, "hideFooterView hasMoreData false");
    this.mHasMoreData = false;
  }
  
  public void hideLoadingFooter()
  {
    if ((this.mFooterView != null) && (getFooterViewsCount() > 0))
    {
      QLog.d("ReadInJoyCommentListView", 2, "hideLoadingFooter");
      this.mFooterView.setVisibility(8);
    }
  }
  
  public void initFooterView()
  {
    this.mFooterView = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560108, this, false));
    this.mFooterProgressBar = ((ProgressBar)this.mFooterView.findViewById(2131373701));
    this.mFooterTextView = ((TextView)this.mFooterView.findViewById(2131373702));
    this.mFooterTextView.setTextColor(Color.parseColor("#A6A6A6"));
    this.mFooterTextView.setTextSize(2, 14.0F);
    this.mFooterProgressBar.setVisibility(8);
    addFooterView(this.mFooterView, null, false);
    setFooterDividersEnabled(false);
  }
  
  public void loadMoreFail()
  {
    if (this.mFooterView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "loadMoreFail");
      }
      this.mFooterView.setVisibility(0);
      this.mFooterTextView.setText(HardCodeUtil.a(2131712741));
      this.mFooterTextView.setVisibility(0);
      this.mFooterTextView.setOnClickListener(new ReadInJoyCommentListView.2(this));
      this.mFooterProgressBar.setVisibility(8);
      this.mCurrentStatus = 0;
    }
  }
  
  public void loadingMoreComplete(boolean paramBoolean)
  {
    if (this.mFooterView == null) {
      initFooterView();
    }
    QLog.d("ReadInJoyCommentListView", 2, "loadingMoreComplete | hasNextPage " + paramBoolean);
    this.mHasMoreData = paramBoolean;
    if (!paramBoolean) {
      removeFooter();
    }
    this.mCurrentStatus = 0;
    notifyDataChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > this.lastFirstVisibleItem) {
      this.isScrollingDown = true;
    }
    for (;;)
    {
      this.lastFirstVisibleItem = paramInt1;
      return;
      if (paramInt1 < this.lastFirstVisibleItem) {
        this.isScrollingDown = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      VideoReport.traverseExposure();
      DropFrameMonitor.a().a("list_comment_kandian", false);
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.mHasMoreData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentListView", 2, "on the bottom ");
        }
        if (this.mCurrentStatus == 1) {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentListView", 2, "network request ing");
          }
        }
      }
      do
      {
        do
        {
          return;
          QLog.d("ReadInJoyCommentListView", 2, "loadmore comment by scroll");
          loadingMore();
          return;
        } while ((paramAbsListView.getCount() - paramAbsListView.getLastVisiblePosition() >= this.preloadCount) || (!this.mHasMoreData) || (!this.isScrollingDown));
        if (this.mCurrentStatus != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyCommentListView", 2, "network request ing");
      return;
      QLog.d("ReadInJoyCommentListView", 2, "preLoadingmore comment");
      preLoadingMore();
      return;
    }
    DropFrameMonitor.a().a("list_comment_kandian");
  }
  
  public void removeFooter()
  {
    this.mFooterProgressBar.setVisibility(8);
    this.mFooterView.setVisibility(8);
    this.mFooterTextView.setVisibility(8);
    removeFooterView(this.mFooterView);
  }
  
  public void removeScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.mDefaultScrollListener != null) {
      this.mDefaultScrollListener.b(paramOnScrollListener);
    }
  }
  
  public void resetFooterView()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetFooterView");
    if (getFooterViewsCount() <= 0)
    {
      if (this.mFooterView != null) {
        addFooterView(this.mFooterView, null, false);
      }
    }
    else {
      return;
    }
    initFooterView();
  }
  
  public void resetState()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetState hasMoreData false");
    resetFooterView();
    this.mHasMoreData = false;
    this.mCurrentStatus = 0;
    setEmptyView(null);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((paramOnScrollListener instanceof ReadInJoyCommentListView.MultiScrollListener)) {
      super.setOnScrollListener(this.mDefaultScrollListener);
    }
    while (this.mDefaultScrollListener == null) {
      return;
    }
    this.mDefaultScrollListener.a(paramOnScrollListener);
  }
  
  public void setOnScrollOffsetYListener(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    this.mScrollYListener = paramOnScrollYOffsetListener;
  }
  
  public void setRefreshCallback(ReadInJoyCommentListView.RefreshCallback paramRefreshCallback)
  {
    this.mRefreshCallback = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView
 * JD-Core Version:    0.7.0.1
 */