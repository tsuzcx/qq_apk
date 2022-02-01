package com.tencent.biz.qqcircle.immersive.personal.widget;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QFSPersonalInfoWidget$2
  implements Observer<FeedCloudMeta.StFeed>
{
  QFSPersonalInfoWidget$2(QFSPersonalInfoWidget paramQFSPersonalInfoWidget) {}
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QFSPersonalInfoWidget localQFSPersonalInfoWidget = this.a;
    Object localObject2 = null;
    if (paramStFeed == null) {
      localObject1 = null;
    } else {
      localObject1 = paramStFeed.id.get();
    }
    QFSPersonalInfoWidget.a(localQFSPersonalInfoWidget, (String)localObject1);
    Object localObject1 = this.a;
    if (paramStFeed == null) {
      paramStFeed = localObject2;
    } else {
      paramStFeed = paramStFeed.busiReport.get().toByteArray();
    }
    QFSPersonalInfoWidget.a((QFSPersonalInfoWidget)localObject1, paramStFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget.2
 * JD-Core Version:    0.7.0.1
 */