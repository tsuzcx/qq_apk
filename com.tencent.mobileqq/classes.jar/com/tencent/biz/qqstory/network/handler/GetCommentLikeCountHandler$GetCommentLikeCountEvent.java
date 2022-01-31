package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class GetCommentLikeCountHandler$GetCommentLikeCountEvent
  extends BaseEvent
{
  public List a = new ArrayList();
  
  public GetCommentLikeCountHandler$GetCommentLikeCountEvent(ErrorMessage paramErrorMessage)
  {
    this.errorInfo = paramErrorMessage;
  }
  
  public String toString()
  {
    return "GetCommentLikeCountEvent{, commentLikeCountList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetCommentLikeCountHandler.GetCommentLikeCountEvent
 * JD-Core Version:    0.7.0.1
 */