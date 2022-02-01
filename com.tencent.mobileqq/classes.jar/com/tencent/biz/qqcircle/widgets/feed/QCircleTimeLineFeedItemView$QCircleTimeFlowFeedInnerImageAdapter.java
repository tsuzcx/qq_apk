package com.tencent.biz.qqcircle.widgets.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class QCircleTimeLineFeedItemView$QCircleTimeFlowFeedInnerImageAdapter
  extends RecyclerView.Adapter<QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder>
{
  private List<QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean> mDatas = new ArrayList();
  private FeedCloudMeta.StFeed mParentFeed;
  private int mParentPos;
  private RecyclerView mRecycleView;
  private WeakReference<QCircleTimeLineFeedItemView> mTimelineFeedItemWeak;
  
  public QCircleTimeLineFeedItemView$QCircleTimeFlowFeedInnerImageAdapter(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView)
  {
    this.mTimelineFeedItemWeak = new WeakReference(paramQCircleTimeLineFeedItemView);
  }
  
  private void safeNotify()
  {
    RecyclerView localRecyclerView = this.mRecycleView;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.mRecycleView.postDelayed(new QCircleTimeLineFeedItemView.QCircleTimeFlowFeedInnerImageAdapter.1(this), 500L);
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    return this.mDatas.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void onBindViewHolder(QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder paramQCircleInnerPicItemViewHolder, int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      paramQCircleInnerPicItemViewHolder.setParentData(this.mParentFeed);
      paramQCircleInnerPicItemViewHolder.setData(this.mDatas.get(paramInt), paramInt);
    }
  }
  
  public QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626819, paramViewGroup, false);
    return new QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder((QCircleTimeLineFeedItemView)this.mTimelineFeedItemWeak.get(), paramViewGroup);
  }
  
  public void setDatas(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean> paramList)
  {
    this.mParentFeed = paramStFeed;
    this.mParentPos = paramInt;
    paramStFeed = this.mDatas;
    if (paramStFeed != null)
    {
      paramStFeed.clear();
      this.mDatas.addAll(paramList);
      safeNotify();
    }
  }
  
  public void setRecycleView(RecyclerView paramRecyclerView)
  {
    this.mRecycleView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.QCircleTimeFlowFeedInnerImageAdapter
 * JD-Core Version:    0.7.0.1
 */