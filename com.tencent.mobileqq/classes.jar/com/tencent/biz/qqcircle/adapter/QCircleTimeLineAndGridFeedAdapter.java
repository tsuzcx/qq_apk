package com.tencent.biz.qqcircle.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedBaseScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedVideoPreloadScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleTimeLineAndGridScroller;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QCircleTimeLineAndGridFeedAdapter
  extends QCircleFakeAdapter
{
  public static final boolean f = ;
  private static String g = "QCircleTimeLineAndGridFeedAdapter";
  private QCircleTimeLineAndGridScroller h;
  private QCircleFeedPlayerScroller i;
  private int j;
  private int k = Calendar.getInstance().get(1);
  
  public QCircleTimeLineAndGridFeedAdapter(Bundle paramBundle, int paramInt)
  {
    super(paramBundle);
    this.j = paramInt;
    paramBundle = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleTimeLineAndGridFeedAdapter spanCount:");
    localStringBuilder.append(paramInt);
    QLog.d(paramBundle, 1, localStringBuilder.toString());
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool4 = paramRecyclerView instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (bool4)
    {
      if ((paramInt1 + 1) % paramInt2 == 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool3;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() == 1)
      {
        bool1 = bool2;
        if ((paramInt1 + 1) % paramInt2 == 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool4 = paramRecyclerView instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (bool4)
    {
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool3;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() == 1)
      {
        bool1 = bool2;
        if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if ((paramInt1 + 1) % paramInt2 == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public QCircleTimeLineAndGridFeedAdapter.QCircleVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 2001)
    {
      switch (paramInt)
      {
      default: 
        return new QCircleTimeLineAndGridFeedAdapter.QCircleVH(new QCircleDefaultFeedItemView(getContext(), paramInt));
      }
      paramViewGroup = new QCircleTimeLineFeedItemView(getContext(), paramInt);
      paramViewGroup.setReportBean(getReportBean());
      return new QCircleTimeLineAndGridFeedAdapter.QCircleVH(paramViewGroup);
    }
    paramViewGroup = new QCircleGridFeedItemView(getContext(), paramInt);
    paramViewGroup.setTag(2131444770, Boolean.valueOf(true));
    paramViewGroup.setReportBean(getReportBean());
    return new QCircleTimeLineAndGridFeedAdapter.QCircleVH(paramViewGroup);
  }
  
  protected List<QCircleFeedBaseScroller> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (f)
    {
      this.i = new QCircleFeedPlayerScroller(getPageId());
      this.i.a(false, true);
      localArrayList.add(this.i);
      localArrayList.add(new QCircleFeedVideoPreloadScroller());
    }
    this.h = new QCircleTimeLineAndGridScroller();
    localArrayList.add(this.h);
    return localArrayList;
  }
  
  public void b(boolean paramBoolean)
  {
    String str = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTimeLineVideoPlayState canPlay:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    if (this.i == null)
    {
      QLog.e(g, 1, "playerHelper is null");
      return;
    }
    RFThreadManager.getUIHandler().postDelayed(new QCircleTimeLineAndGridFeedAdapter.1(this, paramBoolean), 500L);
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int m = this.j;
    int n = paramRecyclerView.getAdapter().getItemCount();
    int i1 = paramRecyclerView.getChildLayoutPosition(paramView);
    if ((i1 == 0) && (m == 1))
    {
      paramRect.set(0, ViewUtils.a(24.0F), 0, ViewUtils.a(1.0F));
      return;
    }
    if (b(paramRecyclerView, i1, m, n))
    {
      paramRect.set(0, 0, ViewUtils.a(1.0F), 0);
      return;
    }
    if (a(paramRecyclerView, i1, m, n))
    {
      paramRect.set(0, 0, 0, ViewUtils.a(1.0F));
      return;
    }
    paramRect.set(0, 0, ViewUtils.a(1.0F), ViewUtils.a(1.0F));
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      int m = this.j;
      if (m == 1)
      {
        Object localObject = ((FeedBlockData)this.mDataList.get(paramInt)).b();
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(((FeedCloudMeta.StFeed)localObject).createTime.get() * 1000L);
        localObject = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Date:");
        localStringBuilder.append(localCalendar.get(1));
        localStringBuilder.append(localCalendar.get(2));
        localStringBuilder.append(localCalendar.get(5));
        QLog.i((String)localObject, 1, localStringBuilder.toString());
        m = localCalendar.get(1);
        int n = localCalendar.get(6);
        if (paramInt > 0)
        {
          localCalendar.setTimeInMillis(((FeedBlockData)this.mDataList.get(paramInt - 1)).b().createTime.get() * 1000L);
          paramInt = localCalendar.get(1);
          int i1 = localCalendar.get(6);
          if ((this.k != m) && (paramInt != m)) {
            return 1001;
          }
          if (n != i1) {
            return 1002;
          }
          return 1003;
        }
        if (this.k != m) {
          return 1001;
        }
        return 1002;
      }
      if (m == 3) {
        return 2001;
      }
    }
    QLog.e(g, 2, "getItemViewType()  return 0");
    return 0;
  }
  
  protected String getLogTag()
  {
    return g;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && ((paramViewHolder instanceof QCircleTimeLineAndGridFeedAdapter.QCircleVH)))
    {
      localObject = (QCircleTimeLineAndGridFeedAdapter.QCircleVH)paramViewHolder;
      this.mDataList.get(paramInt);
      ((QCircleTimeLineAndGridFeedAdapter.QCircleVH)localObject).a(this.mDataList.get(paramInt), paramInt, this.a, (QCircleInteractor)this.mInteractor);
    }
    Object localObject = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindViewHolder:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramViewHolder);
    localStringBuilder.append("  ");
    localStringBuilder.append(this);
    QLog.d((String)localObject, 4, localStringBuilder.toString());
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTimeLineAndGridFeedAdapter
 * JD-Core Version:    0.7.0.1
 */