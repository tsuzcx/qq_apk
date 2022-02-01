package com.tencent.biz.pubaccount.weishi_new.comment;

class WsCommentBusiness$CommentResponse
{
  public String a;
  public boolean a;
  public boolean b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentResponse{hasMore=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", attachInfo='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasResponse='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.CommentResponse
 * JD-Core Version:    0.7.0.1
 */