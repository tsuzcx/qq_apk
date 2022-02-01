package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleColdBootPreloadTask$2
  implements Runnable
{
  QCircleColdBootPreloadTask$2(QCircleColdBootPreloadTask paramQCircleColdBootPreloadTask, QCircleColdBootPreloadTask.InitListener paramInitListener) {}
  
  public void run()
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = this.this$0.b();
    boolean bool;
    if ((localStGetFeedListRsp != null) && (localStGetFeedListRsp.has()))
    {
      QLog.d("QCircleColdBootPreloadTask", 1, "init: load cache data from sp");
      QCircleColdBootPreloadTask.a(this.this$0, localStGetFeedListRsp);
      bool = this.this$0.hasPreloadData() ^ true;
    }
    else
    {
      bool = true;
    }
    QCircleColdBootPreloadTask.a(this.this$0, true);
    this.a.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadTask.2
 * JD-Core Version:    0.7.0.1
 */