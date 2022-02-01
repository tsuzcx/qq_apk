package com.tencent.biz.qqstory.network.response;

import java.util.ArrayList;
import java.util.List;

public class GetCommentLikeCountRespone$CommentLikeCount
{
  public int a;
  public String a;
  public List<Long> a;
  public boolean a;
  public int b;
  
  public GetCommentLikeCountRespone$CommentLikeCount(GetCommentLikeCountRespone paramGetCommentLikeCountRespone)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentLikeCount{storyId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", likeCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", commentCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isHasLike=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", newlyThreeLikes=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone.CommentLikeCount
 * JD-Core Version:    0.7.0.1
 */