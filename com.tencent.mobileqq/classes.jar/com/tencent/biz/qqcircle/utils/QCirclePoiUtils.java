package com.tencent.biz.qqcircle.utils;

import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;

public class QCirclePoiUtils
{
  public static String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return "";
    }
    return a(paramStFeed.poiInfo);
  }
  
  public static String a(FeedCloudMeta.StPoiInfoV2 paramStPoiInfoV2)
  {
    if (paramStPoiInfoV2 == null) {
      return "";
    }
    return paramStPoiInfoV2.displayName.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCirclePoiUtils
 * JD-Core Version:    0.7.0.1
 */