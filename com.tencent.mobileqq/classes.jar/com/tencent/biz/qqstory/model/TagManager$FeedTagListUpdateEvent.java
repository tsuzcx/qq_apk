package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.FeedTagInfoList;
import java.util.HashMap;
import java.util.Map;

public class TagManager$FeedTagListUpdateEvent
  extends BaseEvent
{
  public Map<String, GetFeedTagInfoListRequest.FeedTagInfoList> a = new HashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TagManager.FeedTagListUpdateEvent
 * JD-Core Version:    0.7.0.1
 */