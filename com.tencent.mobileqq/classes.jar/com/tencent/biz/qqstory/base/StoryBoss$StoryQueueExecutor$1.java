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
    SLog.b(StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor), "threshold after running current task is " + StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      SLog.b(StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor).incrementAndGet();
    SLog.a(StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      SLog.b(StoryBoss.StoryQueueExecutor.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryBoss$StoryQueueExecutor), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss.StoryQueueExecutor.1
 * JD-Core Version:    0.7.0.1
 */