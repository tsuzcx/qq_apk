package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.OnPreloaderListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class MsgTabStoryNodeDelegate$2
  implements MsgTabStoryVideoPreloader.OnPreloaderListener
{
  private long jdField_a_of_type_Long;
  
  MsgTabStoryNodeDelegate$2(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate) {}
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      StoryReportor.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.2
 * JD-Core Version:    0.7.0.1
 */