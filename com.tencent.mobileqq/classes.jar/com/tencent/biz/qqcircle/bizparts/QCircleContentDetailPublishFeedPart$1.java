package com.tencent.biz.qqcircle.bizparts;

import feedcloud.FeedCloudMeta.StTagInfo;
import mqq.app.QQPermissionCallback;

class QCircleContentDetailPublishFeedPart$1
  implements QQPermissionCallback
{
  QCircleContentDetailPublishFeedPart$1(QCircleContentDetailPublishFeedPart paramQCircleContentDetailPublishFeedPart, FeedCloudMeta.StTagInfo paramStTagInfo) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QCircleContentDetailPublishFeedPart.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleContentDetailPublishFeedPart.1
 * JD-Core Version:    0.7.0.1
 */