package com.tencent.biz.qqstory.base;

import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class StoryBoss$1
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  StoryBoss$1(StoryBoss paramStoryBoss, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    StoryDispatcher.a().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss.1
 * JD-Core Version:    0.7.0.1
 */