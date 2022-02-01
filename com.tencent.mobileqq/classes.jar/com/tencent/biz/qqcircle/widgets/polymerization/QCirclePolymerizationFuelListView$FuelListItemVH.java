package com.tencent.biz.qqcircle.widgets.polymerization;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import qqcircle.QQCircleRankinglist.RankingItem;

class QCirclePolymerizationFuelListView$FuelListItemVH
  extends RecyclerView.ViewHolder
{
  public QCirclePolymerizationFuelListView$FuelListItemVH(View paramView)
  {
    super(paramView);
  }
  
  public void a(QQCircleRankinglist.RankingItem paramRankingItem, int paramInt)
  {
    if ((this.itemView instanceof QCircleBaseWidgetView))
    {
      this.itemView.setTag(this);
      ((QCircleBaseWidgetView)this.itemView).setData(paramRankingItem, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePolymerizationFuelListView.FuelListItemVH
 * JD-Core Version:    0.7.0.1
 */