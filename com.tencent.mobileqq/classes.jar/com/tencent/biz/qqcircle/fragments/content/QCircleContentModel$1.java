package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleContentModel$1
  implements OnTaskListener
{
  QCircleContentModel$1(QCircleContentModel paramQCircleContentModel) {}
  
  public void onComplete(Object[] paramArrayOfObject)
  {
    QCircleContentModel.a(this.a, ((Boolean)paramArrayOfObject[0]).booleanValue(), ((Long)paramArrayOfObject[1]).longValue(), (String)paramArrayOfObject[2], (FeedCloudRead.StGetFeedListRsp)paramArrayOfObject[3], false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentModel.1
 * JD-Core Version:    0.7.0.1
 */