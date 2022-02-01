package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleLightInteractListPart$QCircleLightInteractVH
  extends RecyclerView.ViewHolder
{
  public QCircleLightInteractListPart$QCircleLightInteractVH(QCircleLightInteractListPart paramQCircleLightInteractListPart, View paramView)
  {
    super(paramView);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((this.itemView instanceof QCircleBaseLightInteractWidget))
    {
      ((QCircleBaseLightInteractWidget)this.itemView).a(paramStFeed, paramQCircleExtraTypeInfo, paramInt2);
      ((QCircleBaseLightInteractWidget)this.itemView).setData(paramObject, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.QCircleLightInteractVH
 * JD-Core Version:    0.7.0.1
 */