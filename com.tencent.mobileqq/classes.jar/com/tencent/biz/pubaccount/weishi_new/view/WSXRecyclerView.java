package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class WSXRecyclerView
  extends XRecyclerView
{
  private boolean a = true;
  private boolean b = false;
  
  public WSXRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSXRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WSXRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    LoadingMoreHelper localLoadingMoreHelper = getLoadMoreLayoutHelper();
    Object localObject = getRecyclerView();
    int j = ((RecyclerViewWithHeaderFooter)localObject).getChildCount();
    if ((((RecyclerViewWithHeaderFooter)localObject).getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      localObject = (StaggeredGridLayoutManager)((RecyclerViewWithHeaderFooter)localObject).getLayoutManager();
      int k = ((StaggeredGridLayoutManager)localObject).getItemCount();
      int i;
      try
      {
        i = localObject.findFirstVisibleItemPositions(null)[0];
      }
      catch (Exception localException)
      {
        QLog.e("WSXRecyclerView", 2, localException, new Object[0]);
        i = 0;
      }
      int m = localLoadingMoreHelper.getProLoaderCount();
      boolean bool;
      if (k - j <= i + m) {
        bool = true;
      } else {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("totalItemCount=");
      localStringBuilder.append(k);
      localStringBuilder.append(", visibleItemCount=");
      localStringBuilder.append(j);
      localStringBuilder.append(", firstVisibleItem=");
      localStringBuilder.append(i);
      localStringBuilder.append(", visibleThreshold=");
      localStringBuilder.append(m);
      localStringBuilder.append(", isCloseToTheEnd=");
      localStringBuilder.append(bool);
      WSLog.b("WSXRecyclerView", localStringBuilder.toString());
      if (bool)
      {
        localLoadingMoreHelper.setLoadMore(true);
        return true;
      }
    }
    return false;
  }
  
  protected boolean isScroll2Top()
  {
    if (!this.a) {
      return false;
    }
    return super.isScroll2Top();
  }
  
  protected void rebound()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSXRecyclerView.java][rebound] mAutoScroller:");
    localStringBuilder.append(this.b);
    WSLog.e("WSXRecyclerView", localStringBuilder.toString());
    if (!this.b) {
      super.rebound();
    }
  }
  
  public void setIsAutoScrolling(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setRefreshEnable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView
 * JD-Core Version:    0.7.0.1
 */