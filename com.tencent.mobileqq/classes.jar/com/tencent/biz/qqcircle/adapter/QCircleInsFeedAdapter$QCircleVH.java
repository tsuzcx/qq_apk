package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

public class QCircleInsFeedAdapter$QCircleVH
  extends RecyclerView.ViewHolder
{
  public QCircleInsFeedAdapter$QCircleVH(View paramView)
  {
    super(paramView);
  }
  
  public void a(Object paramObject, int paramInt, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, QCircleInteractor paramQCircleInteractor)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setInteractor(paramQCircleInteractor);
      ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramQCircleExtraTypeInfo);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
      ((BaseWidgetView)this.itemView).setDataPosInList(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter.QCircleVH
 * JD-Core Version:    0.7.0.1
 */