package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

public class BaseListBlock$BaseListVH
  extends RecyclerView.ViewHolder
{
  public BaseListBlock$BaseListVH(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(Object paramObject, int paramInt, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramQCircleExtraTypeInfo);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH
 * JD-Core Version:    0.7.0.1
 */