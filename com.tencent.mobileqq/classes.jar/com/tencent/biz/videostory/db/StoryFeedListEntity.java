package com.tencent.biz.videostory.db;

import NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListRsp;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class StoryFeedListEntity
  extends Entity
{
  public byte[] storyFeedList = null;
  @unique
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.db.StoryFeedListEntity
 * JD-Core Version:    0.7.0.1
 */