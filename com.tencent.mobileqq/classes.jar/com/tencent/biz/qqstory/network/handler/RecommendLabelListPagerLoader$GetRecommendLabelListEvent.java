package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.List;

public class RecommendLabelListPagerLoader$GetRecommendLabelListEvent
  extends BasePageLoaderEvent
{
  public List<String> e;
  public String f;
  
  public RecommendLabelListPagerLoader$GetRecommendLabelListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetRecommendLabelListEvent{mKeyword='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommendList=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecommendLabelListPagerLoader.GetRecommendLabelListEvent
 * JD-Core Version:    0.7.0.1
 */