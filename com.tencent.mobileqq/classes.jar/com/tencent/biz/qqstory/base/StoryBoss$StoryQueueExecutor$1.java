package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class StoryBoss$StoryQueueExecutor$1
  implements ThreadExcutor.IThreadListener
{
  StoryBoss$StoryQueueExecutor$1(StoryBoss.StoryQueueExecutor paramStoryQueueExecutor, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    StoryBoss.StoryQueueExecutor.a(this.b).decrementAndGet();
    String str = StoryBoss.StoryQueueExecutor.b(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("threshold after running current task is ");
    localStringBuilder.append(StoryBoss.StoryQueueExecutor.a(this.b).get());
    SLog.b(str, localStringBuilder.toString());
    if (this.a != null)
    {
      str = StoryBoss.StoryQueueExecutor.b(this.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("threshold after running current task is:");
      localStringBuilder.append(this.a.hashCode());
      SLog.b(str, localStringBuilder.toString());
    }
  }
  
  public void onPreRun()
  {
    StoryBoss.StoryQueueExecutor.a(this.b).incrementAndGet();
    SLog.a(StoryBoss.StoryQueueExecutor.b(this.b), "execute %s", this.a);
    if (this.a != null)
    {
      String str = StoryBoss.StoryQueueExecutor.b(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("execute hashcode:");
      localStringBuilder.append(this.a.hashCode());
      SLog.b(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss.StoryQueueExecutor.1
 * JD-Core Version:    0.7.0.1
 */