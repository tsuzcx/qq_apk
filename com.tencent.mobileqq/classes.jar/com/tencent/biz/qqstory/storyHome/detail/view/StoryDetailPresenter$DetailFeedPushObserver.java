package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.support.logging.SLog;

public class StoryDetailPresenter$DetailFeedPushObserver
  extends QQStoryObserver
{
  public String a;
  private StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback b;
  
  public StoryDetailPresenter$DetailFeedPushObserver(String paramString, @NonNull StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback paramOnPushCallback)
  {
    this.a = paramString;
    this.b = paramOnPushCallback;
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (!TextUtils.equals(this.a, paramStoryPushMsg.f))
    {
      SLog.a("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.f, this.a);
      return;
    }
    if ((paramStoryPushMsg.a != 15) && (paramStoryPushMsg.a != 19))
    {
      if ((paramStoryPushMsg.a != 14) && (paramStoryPushMsg.a != 16) && (paramStoryPushMsg.a != 18))
      {
        this.b.a(0);
        return;
      }
      SLog.a("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
      this.b.a(2);
      return;
    }
    SLog.a("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
    this.b.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.DetailFeedPushObserver
 * JD-Core Version:    0.7.0.1
 */