package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.response.RecentTabHaloResponse;

public class RecentTabHaloBatchLoader$RecentTabHaloEvent
  extends BaseEvent
{
  private RecentTabHaloResponse a;
  public boolean a;
  
  public RecentTabHaloBatchLoader$RecentTabHaloEvent(ErrorMessage paramErrorMessage)
  {
    this.errorInfo = paramErrorMessage;
  }
  
  public RecentTabHaloBatchLoader$RecentTabHaloEvent(boolean paramBoolean)
  {
    this(new ErrorMessage());
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public RecentTabHaloResponse a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseRecentTabHaloResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader.RecentTabHaloEvent
 * JD-Core Version:    0.7.0.1
 */