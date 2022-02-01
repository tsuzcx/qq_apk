package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.response.RecentTabHaloResponse;

public class RecentTabHaloBatchLoader$RecentTabHaloEvent
  extends BaseEvent
{
  public boolean a;
  private RecentTabHaloResponse b;
  
  public RecentTabHaloBatchLoader$RecentTabHaloEvent(ErrorMessage paramErrorMessage)
  {
    this.g = paramErrorMessage;
  }
  
  public RecentTabHaloBatchLoader$RecentTabHaloEvent(boolean paramBoolean)
  {
    this(new ErrorMessage());
    this.a = paramBoolean;
  }
  
  public RecentTabHaloResponse b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader.RecentTabHaloEvent
 * JD-Core Version:    0.7.0.1
 */