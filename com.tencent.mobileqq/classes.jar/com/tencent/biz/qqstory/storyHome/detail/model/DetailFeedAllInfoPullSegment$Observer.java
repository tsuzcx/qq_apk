package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.parallel.SimpleParallelObserver;
import mqq.os.MqqHandler;

class DetailFeedAllInfoPullSegment$Observer
  extends SimpleParallelObserver
{
  DetailFeedAllInfoPullSegment$Observer(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment) {}
  
  public void onAllFunctionComplete(boolean paramBoolean)
  {
    super.onAllFunctionComplete(paramBoolean);
    ThreadManager.getUIHandler().post(new DetailFeedAllInfoPullSegment.Observer.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer
 * JD-Core Version:    0.7.0.1
 */