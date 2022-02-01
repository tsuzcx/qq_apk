package com.tencent.biz.qqcircle.publish.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.widgets.QCircleAssociateTagWidget;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class QCircleAssociateLabelAdapter
  extends QCircleBaseMultiViewBlock<FeedCloudMeta.StTagInfo>
{
  private RecyclerView a;
  
  public QCircleAssociateLabelAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.a.post(new QCircleAssociateLabelAdapter.1(this));
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.a = paramRecyclerView;
  }
  
  public void a(List<FeedCloudMeta.StTagInfo> paramList)
  {
    if (paramList != null)
    {
      this.mDataList.clear();
      a();
      this.mDataList.addAll(paramList);
      a();
    }
  }
  
  public void b(List<FeedCloudMeta.StTagInfo> paramList)
  {
    this.mDataList.addAll(this.mDataList.size(), paramList);
    a();
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a();
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  protected String getLogTag()
  {
    return "QCircleAssociateLabelAdapter";
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList.size() > paramInt) && ((paramViewHolder instanceof QCircleAssociateLabelAdapter.QCircleAssociateTagVH))) {
      ((QCircleAssociateLabelAdapter.QCircleAssociateTagVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCircleAssociateLabelAdapter.QCircleAssociateTagVH(this, new QCircleAssociateTagWidget(getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.adapter.QCircleAssociateLabelAdapter
 * JD-Core Version:    0.7.0.1
 */