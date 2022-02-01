package com.tencent.biz.qqcircle.widgets;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

class QCircleTroopTagListView$RecommendLabelAdapter
  extends RecyclerView.Adapter<QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder>
{
  public List<Long> a = new ArrayList();
  
  private QCircleTroopTagListView$RecommendLabelAdapter(QCircleTroopTagListView paramQCircleTroopTagListView) {}
  
  public QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626818, paramViewGroup, false));
  }
  
  public void a(QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder paramTagViewHolder, int paramInt)
  {
    paramTagViewHolder.a(((Long)this.a.get(paramInt)).longValue(), paramInt);
  }
  
  public void a(List<Long> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView.RecommendLabelAdapter
 * JD-Core Version:    0.7.0.1
 */