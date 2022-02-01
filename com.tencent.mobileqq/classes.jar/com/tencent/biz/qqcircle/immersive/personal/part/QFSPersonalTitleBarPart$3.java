package com.tencent.biz.qqcircle.immersive.personal.part;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QFSPersonalTitleBarPart$3
  implements Observer<FeedCloudMeta.StFeed>
{
  QFSPersonalTitleBarPart$3(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart) {}
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QFSPersonalTitleBarPart localQFSPersonalTitleBarPart = this.a;
    if (paramStFeed == null) {
      localObject = "";
    } else {
      localObject = paramStFeed.id.get();
    }
    QFSPersonalTitleBarPart.a(localQFSPersonalTitleBarPart, (String)localObject);
    Object localObject = this.a;
    if (paramStFeed == null) {
      paramStFeed = null;
    } else {
      paramStFeed = paramStFeed.busiReport.get().toByteArray();
    }
    QFSPersonalTitleBarPart.a((QFSPersonalTitleBarPart)localObject, paramStFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.3
 * JD-Core Version:    0.7.0.1
 */