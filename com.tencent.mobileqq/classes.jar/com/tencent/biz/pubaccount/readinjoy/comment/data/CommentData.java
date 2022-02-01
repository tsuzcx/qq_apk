package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.util.List;

public class CommentData
  extends BaseCommentData
{
  public static final int EXPOSURE_SUB_COMMENT_COUNT = 2;
  public List<SubCommentData> subCommentList;
  public int subCommentNum;
  
  public String toString()
  {
    return "CommentData{'subCommentNum=" + this.subCommentNum + '\'' + ", subCommentList=" + this.subCommentList + '\'' + super.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData
 * JD-Core Version:    0.7.0.1
 */