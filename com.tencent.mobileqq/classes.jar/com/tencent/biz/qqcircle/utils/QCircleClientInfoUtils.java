package com.tencent.biz.qqcircle.utils;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StClientInfo;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;

public class QCircleClientInfoUtils
{
  public static String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return "";
    }
    paramStFeed = paramStFeed.clientInfo.clientMap.get().iterator();
    while (paramStFeed.hasNext())
    {
      FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramStFeed.next();
      if ("key_polymerize_recommend_info".equals(localEntry.key.get())) {
        return localEntry.value.get();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleClientInfoUtils
 * JD-Core Version:    0.7.0.1
 */