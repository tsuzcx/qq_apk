package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager.FeedVideoInfoUpdate;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

public class StoryDetailPresenter$FeedVideoCookieUpdate
  extends UIBaseEventReceiver<StoryDetailPresenter, FeedVideoManager.FeedVideoInfoUpdate>
{
  public StoryDetailPresenter$FeedVideoCookieUpdate(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate)
  {
    if ((paramFeedVideoInfoUpdate.b != 2) && (paramFeedVideoInfoUpdate.a.equals(StoryDetailPresenter.f(paramStoryDetailPresenter))) && (StoryDetailPresenter.a(paramStoryDetailPresenter) != null))
    {
      if (!StoryDetailPresenter.a(paramStoryDetailPresenter).e())
      {
        SLog.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramFeedVideoInfoUpdate.toString() });
        return;
      }
      paramFeedVideoInfoUpdate = StoryDetailPresenter.h(paramStoryDetailPresenter).a(StoryDetailPresenter.f(paramStoryDetailPresenter), StoryDetailPresenter.a(paramStoryDetailPresenter).f().mVideoPullType);
      if (paramFeedVideoInfoUpdate == null)
      {
        SLog.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { StoryDetailPresenter.f(paramStoryDetailPresenter), Integer.valueOf(StoryDetailPresenter.a(paramStoryDetailPresenter).f().mVideoPullType) });
        return;
      }
      SLog.a(this.TAG, "receive video cookie change event. %s.", paramFeedVideoInfoUpdate.toString());
      StoryDetailPresenter.a(paramStoryDetailPresenter).f().updateVideoInfo(paramFeedVideoInfoUpdate);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramFeedVideoInfoUpdate.mVideoItemList, true);
      if (StoryDetailPresenter.i(paramStoryDetailPresenter) != null) {
        StoryDetailPresenter.i(paramStoryDetailPresenter).a(paramFeedVideoInfoUpdate.mVideoPullType, paramFeedVideoInfoUpdate.mVideoNextCookie, paramFeedVideoInfoUpdate.mVideoSeq);
      }
      StoryDetailPresenter.e(paramStoryDetailPresenter).c();
      return;
    }
    SLog.b(this.TAG, "ignore this video cookie change event. %s.", paramFeedVideoInfoUpdate.toString());
  }
  
  public Class acceptEventClass()
  {
    return FeedVideoManager.FeedVideoInfoUpdate.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.FeedVideoCookieUpdate
 * JD-Core Version:    0.7.0.1
 */