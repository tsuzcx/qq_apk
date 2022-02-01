package com.tencent.biz.subscribe.comment;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBStringField;

class CommentBusiness$CommentResponse
{
  public boolean a;
  public COMM.StCommonExt b;
  public boolean c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentResponse{hasMore=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", attachInfo='");
    localStringBuilder.append(this.b.attachInfo.get());
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasResponse='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.CommentResponse
 * JD-Core Version:    0.7.0.1
 */