package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class VidToBasicInfoHandler$GetVideoBasicInfoListEvent
  extends BaseEvent
{
  public List<StoryVideoItem> a;
  
  public String toString()
  {
    return "GetVideoBasicInfoListEvent{, mVideoList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent
 * JD-Core Version:    0.7.0.1
 */