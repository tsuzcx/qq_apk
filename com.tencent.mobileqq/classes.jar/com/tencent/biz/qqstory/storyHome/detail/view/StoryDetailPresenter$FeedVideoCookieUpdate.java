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
    if ((paramFeedVideoInfoUpdate.jdField_a_of_type_Int == 2) || (!paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString.equals(StoryDetailPresenter.a(paramStoryDetailPresenter))) || (StoryDetailPresenter.a(paramStoryDetailPresenter) == null))
    {
      SLog.b(this.TAG, "ignore this video cookie change event. %s.", paramFeedVideoInfoUpdate.toString());
      return;
    }
    if (!StoryDetailPresenter.a(paramStoryDetailPresenter).c())
    {
      SLog.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { paramFeedVideoInfoUpdate.toString() });
      return;
    }
    paramFeedVideoInfoUpdate = StoryDetailPresenter.a(paramStoryDetailPresenter).a(StoryDetailPresenter.a(paramStoryDetailPresenter), StoryDetailPresenter.a(paramStoryDetailPresenter).a().mVideoPullType);
    if (paramFeedVideoInfoUpdate == null)
    {
      SLog.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { StoryDetailPresenter.a(paramStoryDetailPresenter), Integer.valueOf(StoryDetailPresenter.a(paramStoryDetailPresenter).a().mVideoPullType) });
      return;
    }
    SLog.a(this.TAG, "receive video cookie change event. %s.", paramFeedVideoInfoUpdate.toString());
    StoryDetailPresenter.a(paramStoryDetailPresenter).a().updateVideoInfo(paramFeedVideoInfoUpdate);
    StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramFeedVideoInfoUpdate.mVideoItemList, true);
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) != null) {
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramFeedVideoInfoUpdate.mVideoPullType, paramFeedVideoInfoUpdate.mVideoNextCookie, paramFeedVideoInfoUpdate.mVideoSeq);
    }
    StoryDetailPresenter.a(paramStoryDetailPresenter).c();
  }
  
  public Class acceptEventClass()
  {
    return FeedVideoManager.FeedVideoInfoUpdate.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.FeedVideoCookieUpdate
 * JD-Core Version:    0.7.0.1
 */