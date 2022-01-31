package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.List;

public class OfficialRecommendListPageLoader$GetOfficialRecommendListEvent
  extends BasePageLoaderEvent
{
  public List a;
  
  public OfficialRecommendListPageLoader$GetOfficialRecommendListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String toString()
  {
    return "GetOfficialRecommendListEvent{recommendItemList=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader.GetOfficialRecommendListEvent
 * JD-Core Version:    0.7.0.1
 */