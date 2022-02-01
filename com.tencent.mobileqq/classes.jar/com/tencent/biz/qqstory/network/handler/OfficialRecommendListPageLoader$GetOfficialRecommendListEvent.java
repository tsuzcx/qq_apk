package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.RecommendItem;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.List;

public class OfficialRecommendListPageLoader$GetOfficialRecommendListEvent
  extends BasePageLoaderEvent
{
  public List<RecommendItem> e;
  
  public OfficialRecommendListPageLoader$GetOfficialRecommendListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetOfficialRecommendListEvent{recommendItemList=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader.GetOfficialRecommendListEvent
 * JD-Core Version:    0.7.0.1
 */