package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class SendVideoToFriendHelper$2
  implements Runnable
{
  SendVideoToFriendHelper$2(SendVideoToFriendHelper paramSendVideoToFriendHelper, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    ((StoryManager)SuperManager.a(5)).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.2
 * JD-Core Version:    0.7.0.1
 */