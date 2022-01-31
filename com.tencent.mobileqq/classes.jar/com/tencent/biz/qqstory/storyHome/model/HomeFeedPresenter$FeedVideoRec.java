package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class HomeFeedPresenter$FeedVideoRec
  extends UIBaseEventReceiver
{
  public HomeFeedPresenter$FeedVideoRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    Object localObject = paramHomeFeedPresenter.a(paramGetVideoListEvent.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramGetVideoListEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof VideoListHomeFeed))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramGetVideoListEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (VideoListHomeFeed)localObject;
    if (paramGetVideoListEvent.errorInfo.isSuccess())
    {
      ((VideoListHomeFeed)localObject).c(paramGetVideoListEvent.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((VideoListHomeFeed)localObject).a).updateVideoInfo(paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramGetVideoListEvent.jdField_a_of_type_JavaLangString, Integer.valueOf(((VideoListHomeFeed)localObject).a().size()));
    }
    HomeFeedPresenter.a(paramHomeFeedPresenter).a((VideoListHomeFeed)localObject);
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.FeedVideoRec
 * JD-Core Version:    0.7.0.1
 */