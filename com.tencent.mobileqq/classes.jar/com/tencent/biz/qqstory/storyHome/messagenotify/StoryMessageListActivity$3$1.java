package com.tencent.biz.qqstory.storyHome.messagenotify;

import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;

class StoryMessageListActivity$3$1
  implements Runnable
{
  StoryMessageListActivity$3$1(StoryMessageListActivity.3 param3, ArrayList paramArrayList, qqstory_710_message.RspStoryMessageList paramRspStoryMessageList) {}
  
  public void run()
  {
    StoryMessageListActivity localStoryMessageListActivity = this.c.d;
    ArrayList localArrayList = this.a;
    boolean bool1 = this.b.is_end.has();
    boolean bool2 = false;
    if ((bool1) && (this.b.is_end.get() == 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((!this.b.has_read_msg.has()) || (this.b.has_read_msg.get() != 0)) {
      bool2 = true;
    }
    localStoryMessageListActivity.a(localArrayList, bool1, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */