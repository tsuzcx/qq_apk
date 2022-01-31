package com.tencent.biz.qqstory.takevideo2;

import wxe;
import xpk;

public class StoryPublishLauncher$1
  implements Runnable
{
  public StoryPublishLauncher$1(xpk paramxpk, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = xpk.b();
    wxe.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(this.a), Boolean.valueOf(bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1
 * JD-Core Version:    0.7.0.1
 */