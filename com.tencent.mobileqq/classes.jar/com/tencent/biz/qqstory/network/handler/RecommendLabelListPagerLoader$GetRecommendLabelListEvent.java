package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.List;

public class RecommendLabelListPagerLoader$GetRecommendLabelListEvent
  extends BasePageLoaderEvent
{
  public String a;
  public List<String> a;
  
  public RecommendLabelListPagerLoader$GetRecommendLabelListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String toString()
  {
    return "GetRecommendLabelListEvent{mKeyword='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommendList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecommendLabelListPagerLoader.GetRecommendLabelListEvent
 * JD-Core Version:    0.7.0.1
 */