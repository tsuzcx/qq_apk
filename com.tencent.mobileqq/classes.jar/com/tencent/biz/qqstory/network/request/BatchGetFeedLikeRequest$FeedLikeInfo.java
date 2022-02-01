package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.List;

public class BatchGetFeedLikeRequest$FeedLikeInfo
{
  public int a;
  public String a;
  public List<LikeEntry> a;
  public int b;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FeedLikeInfo)paramObject;
      String str = this.a;
      if (str != null) {
        return str.equals(paramObject.a);
      }
      return paramObject.a == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.FeedLikeInfo
 * JD-Core Version:    0.7.0.1
 */