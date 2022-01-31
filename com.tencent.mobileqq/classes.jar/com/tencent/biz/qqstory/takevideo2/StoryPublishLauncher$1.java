package com.tencent.biz.qqstory.takevideo2;

import wsv;
import xlb;

public class StoryPublishLauncher$1
  implements Runnable
{
  public StoryPublishLauncher$1(xlb paramxlb, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = xlb.b();
    wsv.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(this.a), Boolean.valueOf(bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1
 * JD-Core Version:    0.7.0.1
 */