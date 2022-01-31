package com.tencent.biz.qqstory.network.request;

import java.util.ArrayList;
import java.util.List;

public class BatchGetFeedCommentRequest$FeedCommentInfo
{
  public int a;
  public String a;
  public List a;
  public int b;
  public String b;
  
  public BatchGetFeedCommentRequest$FeedCommentInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FeedCommentInfo)paramObject;
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    } while (paramObject.jdField_a_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.FeedCommentInfo
 * JD-Core Version:    0.7.0.1
 */