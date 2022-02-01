package com.tencent.biz.qqstory.takevideo2;

import com.tencent.biz.qqstory.support.logging.SLog;

class StoryPublishLauncher$1
  implements Runnable
{
  StoryPublishLauncher$1(StoryPublishLauncher paramStoryPublishLauncher, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = StoryPublishLauncher.b();
    SLog.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(this.a), Boolean.valueOf(bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1
 * JD-Core Version:    0.7.0.1
 */