package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.support.logging.SLog;

class HomeFeedPresenter$6
  extends QQStoryObserver
{
  HomeFeedPresenter$6(HomeFeedPresenter paramHomeFeedPresenter) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((paramStoryPushMsg.a != 15) && (paramStoryPushMsg.a != 19))
    {
      if ((paramStoryPushMsg.a != 14) && (paramStoryPushMsg.a != 18))
      {
        if (paramStoryPushMsg.a == 17)
        {
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete comment push: %s", new Object[] { paramStoryPushMsg });
          ((CommentManager)SuperManager.a(17)).a(paramStoryPushMsg.d, paramStoryPushMsg.c);
          return;
        }
        if (paramStoryPushMsg.a == 16)
        {
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete like push: %s", new Object[] { paramStoryPushMsg });
          this.a.b(paramStoryPushMsg.d);
        }
      }
      else
      {
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new like push: %s", new Object[] { paramStoryPushMsg });
        this.a.b(paramStoryPushMsg.d);
      }
    }
    else
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new comment push: %s", new Object[] { paramStoryPushMsg });
      this.a.a(paramStoryPushMsg.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.6
 * JD-Core Version:    0.7.0.1
 */