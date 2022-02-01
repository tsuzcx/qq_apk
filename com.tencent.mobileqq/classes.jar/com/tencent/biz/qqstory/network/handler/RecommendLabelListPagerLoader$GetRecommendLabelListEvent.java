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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetRecommendLabelListEvent{mKeyword='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommendList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecommendLabelListPagerLoader.GetRecommendLabelListEvent
 * JD-Core Version:    0.7.0.1
 */