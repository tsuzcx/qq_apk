package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone.CommentLikeCount;
import java.util.ArrayList;
import java.util.List;

public class GetCommentLikeCountHandler$GetCommentLikeCountEvent
  extends BaseEvent
{
  public List<GetCommentLikeCountRespone.CommentLikeCount> a = new ArrayList();
  
  public GetCommentLikeCountHandler$GetCommentLikeCountEvent(ErrorMessage paramErrorMessage)
  {
    this.g = paramErrorMessage;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetCommentLikeCountEvent{, commentLikeCountList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetCommentLikeCountHandler.GetCommentLikeCountEvent
 * JD-Core Version:    0.7.0.1
 */