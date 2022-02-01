package com.tencent.biz.qqcircle.immersive.utils;

import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Iterator;
import java.util.List;

public class QFSJsUrlUtils
{
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return "";
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.next();
        if (localEntry.key.get().equals(paramString)) {
          return localEntry.value.get();
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSJsUrlUtils
 * JD-Core Version:    0.7.0.1
 */