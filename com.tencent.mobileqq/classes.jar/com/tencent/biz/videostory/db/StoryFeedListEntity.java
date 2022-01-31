package com.tencent.biz.videostory.db;

import NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListRsp;
import aukm;
import auma;

public class StoryFeedListEntity
  extends aukm
{
  public byte[] storyFeedList;
  @auma
  public String uin;
  
  public void updateStoryFeedListEntity(String paramString, CLIENT.StGetStoryFeedListRsp paramStGetStoryFeedListRsp)
  {
    if (paramStGetStoryFeedListRsp == null) {
      return;
    }
    this.uin = paramString;
    this.storyFeedList = paramStGetStoryFeedListRsp.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.db.StoryFeedListEntity
 * JD-Core Version:    0.7.0.1
 */