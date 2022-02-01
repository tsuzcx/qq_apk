package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

class QCircleColdBootPreloadTask$4
  implements Runnable
{
  QCircleColdBootPreloadTask$4(QCircleColdBootPreloadTask paramQCircleColdBootPreloadTask, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp) {}
  
  public void run()
  {
    if (this.a.busiRspData.has())
    {
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(this.a.busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (localStFeedListBusiRspData.rspExpireAt.has()) {
        QCircleColdBootPreloadTask.a(this.this$0, System.currentTimeMillis() + localStFeedListBusiRspData.rspExpireAt.get() * 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadTask.4
 * JD-Core Version:    0.7.0.1
 */