package com.tencent.biz.qqcircle.publish.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.widgets.QCircleAssociateTagWidget;

public class QCircleAssociateLabelAdapter$QCircleAssociateTagVH
  extends RecyclerView.ViewHolder
{
  public QCircleAssociateLabelAdapter$QCircleAssociateTagVH(QCircleAssociateLabelAdapter paramQCircleAssociateLabelAdapter, View paramView)
  {
    super(paramView);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((this.itemView instanceof QCircleAssociateTagWidget)) {
      ((QCircleAssociateTagWidget)this.itemView).setData(paramObject, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.adapter.QCircleAssociateLabelAdapter.QCircleAssociateTagVH
 * JD-Core Version:    0.7.0.1
 */