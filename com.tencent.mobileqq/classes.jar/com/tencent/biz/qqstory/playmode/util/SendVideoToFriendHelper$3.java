package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class SendVideoToFriendHelper$3
  implements Runnable
{
  SendVideoToFriendHelper$3(SendVideoToFriendHelper paramSendVideoToFriendHelper, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = this.a;
    PlayModeUtils.b(localStoryVideoItem, localStoryVideoItem.mStoryType, "SendVideoToFriendHelper");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.3
 * JD-Core Version:    0.7.0.1
 */