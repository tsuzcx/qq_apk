package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.ArrayList;
import java.util.List;

public class BatchGetFeedCommentRequest$FeedCommentInfo
{
  public int a;
  public String a;
  public List<CommentEntry> a;
  public int b;
  public String b;
  
  public BatchGetFeedCommentRequest$FeedCommentInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FeedCommentInfo)paramObject;
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        return str.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
      return paramObject.jdField_a_of_type_JavaLangString == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.FeedCommentInfo
 * JD-Core Version:    0.7.0.1
 */