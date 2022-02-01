package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone.CommentLikeCount;
import java.util.ArrayList;
import java.util.List;

public class GetCommentLikeCountHandler$GetCommentLikeCountEvent
  extends BaseEvent
{
  public List<GetCommentLikeCountRespone.CommentLikeCount> a;
  
  public GetCommentLikeCountHandler$GetCommentLikeCountEvent(ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
  }
  
  public String toString()
  {
    return "GetCommentLikeCountEvent{, commentLikeCountList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetCommentLikeCountHandler.GetCommentLikeCountEvent
 * JD-Core Version:    0.7.0.1
 */