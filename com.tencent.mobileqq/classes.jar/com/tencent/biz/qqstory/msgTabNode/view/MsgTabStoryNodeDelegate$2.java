package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.OnPreloaderListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class MsgTabStoryNodeDelegate$2
  implements MsgTabStoryVideoPreloader.OnPreloaderListener
{
  private long b;
  
  MsgTabStoryNodeDelegate$2(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate) {}
  
  public void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.b != 0L) {
      StoryReportor.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.b), 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.2
 * JD-Core Version:    0.7.0.1
 */