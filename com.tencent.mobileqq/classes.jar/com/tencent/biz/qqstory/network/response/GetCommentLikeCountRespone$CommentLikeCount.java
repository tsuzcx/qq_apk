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
    return "CommentLikeCount{storyId='" + this.jdField_a_of_type_JavaLangString + ", likeCount=" + this.jdField_a_of_type_Int + ", commentCount=" + this.b + ", isHasLike=" + this.jdField_a_of_type_Boolean + ", newlyThreeLikes=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone.CommentLikeCount
 * JD-Core Version:    0.7.0.1
 */