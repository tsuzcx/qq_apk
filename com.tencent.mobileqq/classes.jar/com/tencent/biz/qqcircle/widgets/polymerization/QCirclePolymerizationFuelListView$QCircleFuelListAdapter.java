package com.tencent.biz.qqcircle.widgets.polymerization;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTagPageData;
import qqcircle.QQCircleRankinglist.RankingItem;

class QCirclePolymerizationFuelListView$QCircleFuelListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private QCirclePolymerizationFuelListView$QCircleFuelListAdapter(QCirclePolymerizationFuelListView paramQCirclePolymerizationFuelListView) {}
  
  public int getItemCount()
  {
    if (QCirclePolymerizationFuelListView.c(this.a) == null) {
      return 0;
    }
    return QCirclePolymerizationFuelListView.c(this.a).fuelCircleRankItem.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (QCirclePolymerizationFuelListView.c(this.a) != null)
    {
      if (QCirclePolymerizationFuelListView.c(this.a).fuelCircleRankItem.size() < paramInt) {
        return;
      }
      ((QCirclePolymerizationFuelListView.FuelListItemVH)paramViewHolder).a((QQCircleRankinglist.RankingItem)QCirclePolymerizationFuelListView.c(this.a).fuelCircleRankItem.get().get(paramInt), paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCirclePolymerizationFuelListItemView(QCirclePolymerizationFuelListView.a(this.a).getContext());
    paramViewGroup.setReportBean(this.a.b());
    paramViewGroup.setInitBean(QCirclePolymerizationFuelListView.b(this.a));
    paramViewGroup.a(paramInt);
    return new QCirclePolymerizationFuelListView.FuelListItemVH(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePolymerizationFuelListView.QCircleFuelListAdapter
 * JD-Core Version:    0.7.0.1
 */