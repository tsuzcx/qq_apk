package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import feedcloud.FeedCloudMeta.StUser;

class QFSPersonalInfo$2
  implements Runnable
{
  QFSPersonalInfo$2(QFSPersonalInfo paramQFSPersonalInfo, FeedCloudMeta.StUser paramStUser) {}
  
  public void run()
  {
    QFSPersonalInfo.b(this.this$0, this.a.busiData.get().toByteArray());
    QFSPersonalInfo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo.2
 * JD-Core Version:    0.7.0.1
 */