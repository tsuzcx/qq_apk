package com.tencent.biz.qqstory.storyHome.memory.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class StoryQQ2UidConverter$1
  implements Runnable
{
  StoryQQ2UidConverter$1(StoryQQ2UidConverter paramStoryQQ2UidConverter, long paramLong) {}
  
  public void run()
  {
    String str = this.this$0.b(this.a);
    SLog.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from cache. qq = %d, uid = %s.", Long.valueOf(this.a), str);
    ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.1
 * JD-Core Version:    0.7.0.1
 */