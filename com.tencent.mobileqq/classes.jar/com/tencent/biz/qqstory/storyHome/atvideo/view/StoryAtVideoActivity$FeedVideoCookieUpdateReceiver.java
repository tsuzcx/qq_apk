package com.tencent.biz.qqstory.storyHome.atvideo.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager.FeedVideoInfoUpdate;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

public class StoryAtVideoActivity$FeedVideoCookieUpdateReceiver
  extends UIBaseEventReceiver
{
  public StoryAtVideoActivity$FeedVideoCookieUpdateReceiver(StoryAtVideoActivity paramStoryAtVideoActivity)
  {
    super(paramStoryAtVideoActivity);
  }
  
  public void a(@NonNull StoryAtVideoActivity paramStoryAtVideoActivity, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate)
  {
    if ((paramFeedVideoInfoUpdate.jdField_a_of_type_Int == 2) || (!paramFeedVideoInfoUpdate.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoActivity.jdField_a_of_type_JavaLangString)) || (paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null))
    {
      SLog.b(this.TAG, "ignore this video cookie change event. %s.", paramFeedVideoInfoUpdate.toString());
      return;
    }
    if (!paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c())
    {
      SLog.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramFeedVideoInfoUpdate.toString() });
      return;
    }
    paramFeedVideoInfoUpdate = paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager.a(paramStoryAtVideoActivity.jdField_a_of_type_JavaLangString, paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoPullType);
    if (paramFeedVideoInfoUpdate == null)
    {
      SLog.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoActivity.jdField_a_of_type_JavaLangString, Integer.valueOf(paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoPullType) });
      return;
    }
    SLog.a(this.TAG, "receive video cookie change event. %s.", paramFeedVideoInfoUpdate.toString());
    paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().updateVideoInfo(paramFeedVideoInfoUpdate);
    paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(paramFeedVideoInfoUpdate.mVideoItemList, true);
    if (paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader != null) {
      paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.a(paramFeedVideoInfoUpdate.mVideoPullType, paramFeedVideoInfoUpdate.mVideoNextCookie, paramFeedVideoInfoUpdate.mVideoSeq);
    }
    paramStoryAtVideoActivity.a(paramStoryAtVideoActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem);
  }
  
  public Class acceptEventClass()
  {
    return FeedVideoManager.FeedVideoInfoUpdate.class;
  }
  
  public void b(@NonNull StoryAtVideoActivity paramStoryAtVideoActivity, @NonNull FeedVideoManager.FeedVideoInfoUpdate paramFeedVideoInfoUpdate) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoActivity.FeedVideoCookieUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */