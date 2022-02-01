package com.tencent.biz.pubaccount.weishi_new.comment;

class WsCommentBusiness$CommentResponse
{
  public boolean a;
  public String b;
  public boolean c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentResponse{hasMore=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", attachInfo='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasResponse='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.CommentResponse
 * JD-Core Version:    0.7.0.1
 */