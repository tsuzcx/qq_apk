package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.widgets.multitouchimg.OnDoubleTapListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleContentImage$1
  implements OnDoubleTapListener
{
  QCircleContentImage$1(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
      SimpleEventBus.getInstance().dispatchEvent(new QCircleDoublePraiseAnimationEvent((String)localObject, QCircleContentImage.a(this.b), QCircleContentImage.b(this.b)));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchEvent id:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" pageType:");
      localStringBuilder.append(QCircleContentImage.c(this.b));
      QLog.d("Stick-PIC-QCircleContentImage", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage.1
 * JD-Core Version:    0.7.0.1
 */