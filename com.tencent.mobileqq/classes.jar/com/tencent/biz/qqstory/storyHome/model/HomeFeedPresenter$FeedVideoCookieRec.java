package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class HomeFeedPresenter$FeedVideoCookieRec
  extends UIBaseEventReceiver<HomeFeedPresenter, FeedVideoManager.FeedVideoInfoUpdate>
{
  public HomeFeedPresenter$FeedVideoCookieRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate)
  {
    if (paramFeedVideoInfoUpdate.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramHomeFeedPresenter.a(paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof GeneralHomeFeed))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (GeneralHomeFeed)localObject;
    FeedVideoInfo localFeedVideoInfo = ((FeedVideoManager)SuperManager.a(12)).a(paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((GeneralHomeFeed)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((GeneralHomeFeed)localObject).a).mVideoPullType) });
      return;
    }
    ((GeneralHomeFeed)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((GeneralHomeFeed)localObject).a).updateVideoInfo(localFeedVideoInfo);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralHomeFeed)localObject).a().size()));
    HomeFeedPresenter.a(paramHomeFeedPresenter).a((VideoListHomeFeed)localObject);
  }
  
  public Class acceptEventClass()
  {
    return FeedVideoManager.FeedVideoInfoUpdate.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.FeedVideoCookieRec
 * JD-Core Version:    0.7.0.1
 */