package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.ArrayList;
import java.util.List;

public class BatchGetFeedCommentRequest$FeedCommentInfo
{
  public String a;
  public int b;
  public int c;
  public String d;
  public List<CommentEntry> e = new ArrayList();
  
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
      paramObject = (FeedCommentInfo)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.FeedCommentInfo
 * JD-Core Version:    0.7.0.1
 */