package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class QFSPersonalInfo$1
  implements Runnable
{
  QFSPersonalInfo$1(QFSPersonalInfo paramQFSPersonalInfo, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp) {}
  
  public void run()
  {
    QFSPersonalInfo.a(this.this$0, this.a.busiRspData.get().toByteArray());
    QFSPersonalInfo localQFSPersonalInfo = this.this$0;
    QFSPersonalInfo.b(localQFSPersonalInfo, localQFSPersonalInfo.a.busiData.get().toByteArray());
    QFSPersonalInfo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo.1
 * JD-Core Version:    0.7.0.1
 */