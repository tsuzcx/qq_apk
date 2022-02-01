package com.tencent.biz.subscribe.comment;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBStringField;

class CommentBusiness$CommentResponse
{
  public COMM.StCommonExt a;
  public boolean a;
  public boolean b;
  
  public String toString()
  {
    return "CommentResponse{hasMore=" + this.jdField_a_of_type_Boolean + ", attachInfo='" + this.jdField_a_of_type_NS_COMMCOMM$StCommonExt.attachInfo.get() + '\'' + ", hasResponse='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.CommentResponse
 * JD-Core Version:    0.7.0.1
 */