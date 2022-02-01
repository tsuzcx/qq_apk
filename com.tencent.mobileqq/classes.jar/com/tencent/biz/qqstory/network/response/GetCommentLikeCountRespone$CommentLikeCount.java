package com.tencent.biz.qqstory.network.response;

import java.util.ArrayList;
import java.util.List;

public class GetCommentLikeCountRespone$CommentLikeCount
{
  public String a;
  public int b;
  public int c;
  public boolean d;
  public List<Long> e = new ArrayList();
  
  public GetCommentLikeCountRespone$CommentLikeCount(GetCommentLikeCountRespone paramGetCommentLikeCountRespone) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentLikeCount{storyId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", likeCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", commentCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isHasLike=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", newlyThreeLikes=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone.CommentLikeCount
 * JD-Core Version:    0.7.0.1
 */