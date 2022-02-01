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
    StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor).decrementAndGet();
    String str = StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("threshold after running current task is ");
    localStringBuilder.append(StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor).get());
    SLog.b(str, localStringBuilder.toString());
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      str = StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("threshold after running current task is:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangRunnable.hashCode());
      SLog.b(str, localStringBuilder.toString());
    }
  }
  
  public void onPreRun()
  {
    StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor).incrementAndGet();
    SLog.a(StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      String str = StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("execute hashcode:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangRunnable.hashCode());
      SLog.b(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss.StoryQueueExecutor.1
 * JD-Core Version:    0.7.0.1
 */