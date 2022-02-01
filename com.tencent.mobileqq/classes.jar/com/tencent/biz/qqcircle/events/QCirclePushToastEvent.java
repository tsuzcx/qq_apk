package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;

public class QCirclePushToastEvent
  extends SimpleBaseEvent
{
  public FeedCloudToastshowsvr.StGetToastDetailRsp mData;
  
  public QCirclePushToastEvent(FeedCloudToastshowsvr.StGetToastDetailRsp paramStGetToastDetailRsp)
  {
    this.mData = paramStGetToastDetailRsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePushToastEvent
 * JD-Core Version:    0.7.0.1
 */