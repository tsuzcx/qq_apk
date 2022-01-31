package com.tencent.biz.qqstory.storyHome.memory.model;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wna;
import wxe;

public class StoryQQ2UidConverter$1
  implements Runnable
{
  public StoryQQ2UidConverter$1(wna paramwna, long paramLong) {}
  
  public void run()
  {
    String str = this.this$0.a(this.a);
    wxe.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from cache. qq = %d, uid = %s.", Long.valueOf(this.a), str);
    ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1
 * JD-Core Version:    0.7.0.1
 */