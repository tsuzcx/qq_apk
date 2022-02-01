package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class HomeFeedPresenter$FeedVideoRec
  extends UIBaseEventReceiver<HomeFeedPresenter, VideoListPageLoader.GetVideoListEvent>
{
  public HomeFeedPresenter$FeedVideoRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    Object localObject = paramHomeFeedPresenter.a(paramGetVideoListEvent.e);
    if (localObject == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramGetVideoListEvent.e });
      return;
    }
    if (!(localObject instanceof VideoListHomeFeed))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramGetVideoListEvent.e });
      return;
    }
    localObject = (VideoListHomeFeed)localObject;
    if (paramGetVideoListEvent.g.isSuccess())
    {
      ((VideoListHomeFeed)localObject).c(paramGetVideoListEvent.h, false);
      ((VideoListFeedItem)((VideoListHomeFeed)localObject).f).updateVideoInfo(paramGetVideoListEvent.i);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramGetVideoListEvent.e, Integer.valueOf(((VideoListHomeFeed)localObject).a().size()));
    }
    HomeFeedPresenter.c(paramHomeFeedPresenter).a((VideoListHomeFeed)localObject);
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.FeedVideoRec
 * JD-Core Version:    0.7.0.1
 */