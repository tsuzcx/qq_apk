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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentResponse{hasMore=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", attachInfo='");
    localStringBuilder.append(this.jdField_a_of_type_NS_COMMCOMM$StCommonExt.attachInfo.get());
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasResponse='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.CommentResponse
 * JD-Core Version:    0.7.0.1
 */