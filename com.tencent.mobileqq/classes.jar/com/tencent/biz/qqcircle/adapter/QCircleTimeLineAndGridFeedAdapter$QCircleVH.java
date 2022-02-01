package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.animation.QCircleTimeLineAndGridAnimationProxy;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceHolderAnimationInterface;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.ChangeInfo;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.MoveInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleTimeLineAndGridFeedAdapter$QCircleVH
  extends RecyclerView.ViewHolder
  implements EnhanceHolderAnimationInterface
{
  private FeedCloudMeta.StFeed a = new FeedCloudMeta.StFeed();
  private QCircleTimeLineAndGridAnimationProxy b = new QCircleTimeLineAndGridAnimationProxy(this);
  
  public QCircleTimeLineAndGridFeedAdapter$QCircleVH(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder paramViewHolder)
  {
    return this.b.a(paramViewHolder);
  }
  
  public ViewPropertyAnimatorCompat a(EnhanceItemAnimator.ChangeInfo paramChangeInfo, long paramLong, boolean paramBoolean)
  {
    return this.b.a(paramChangeInfo, paramLong, paramBoolean);
  }
  
  public ViewPropertyAnimatorCompat a(EnhanceItemAnimator.MoveInfo paramMoveInfo, long paramLong)
  {
    return this.b.a(paramMoveInfo, paramLong);
  }
  
  public void a(Object paramObject, int paramInt, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, QCircleInteractor paramQCircleInteractor)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setInteractor(paramQCircleInteractor);
      ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramQCircleExtraTypeInfo);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
    }
  }
  
  public boolean a(EnhanceItemAnimator.ChangeInfo paramChangeInfo)
  {
    return this.b.a(paramChangeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTimeLineAndGridFeedAdapter.QCircleVH
 * JD-Core Version:    0.7.0.1
 */