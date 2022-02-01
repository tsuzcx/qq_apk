package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import java.util.List;

public class GetStoryPlayerTagInfoHandler$GetStoryPlayerTagInfoEvent
  extends BaseEvent
{
  public List<String> a;
  public List<GetStoryPlayerTagInfoRequest.TagInfoBaseVidList> b;
  
  public String toString()
  {
    return "GetStoryPlayerTagInfoEvent{requestVidList=" + this.a + ", tagVidList=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent
 * JD-Core Version:    0.7.0.1
 */