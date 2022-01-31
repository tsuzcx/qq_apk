package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;

public class QCircleTopTagListEvent
  extends SimpleBaseEvent
{
  public List<FeedCloudMeta.StTagInfo> stTagInfos;
  
  public QCircleTopTagListEvent(List<FeedCloudMeta.StTagInfo> paramList)
  {
    this.stTagInfos = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleTopTagListEvent
 * JD-Core Version:    0.7.0.1
 */