package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.OnDoubleClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleContentHorizontalAdapter$3
  implements QCircleDoubleClickLayout.OnDoubleClickListener
{
  QCircleContentHorizontalAdapter$3(QCircleContentHorizontalAdapter paramQCircleContentHorizontalAdapter) {}
  
  public void onDoubleClick()
  {
    if (QCircleContentHorizontalAdapter.a(this.a) != null)
    {
      String str = QCircleContentHorizontalAdapter.a(this.a).b().id.get();
      int i = this.a.e();
      SimpleEventBus.getInstance().dispatchEvent(new QCircleDoublePraiseAnimationEvent(str, i, QCircleContentHorizontalAdapter.b(this.a)));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchEvent id:");
      localStringBuilder.append(str);
      localStringBuilder.append(" pageType:");
      localStringBuilder.append(i);
      QLog.d("QCircleContentHorizontalAdapter", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter.3
 * JD-Core Version:    0.7.0.1
 */