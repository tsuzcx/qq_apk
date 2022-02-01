package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.GetFeedItemEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class BottomVideoInfoWidget$GetFeedItemReceiver
  extends QQUIEventReceiver<BottomVideoInfoWidget, FeedManager.GetFeedItemEvent>
{
  public BottomVideoInfoWidget$GetFeedItemReceiver(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget)
  {
    super(paramBottomVideoInfoWidget);
  }
  
  public void a(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget, @NonNull FeedManager.GetFeedItemEvent paramGetFeedItemEvent)
  {
    if ((paramGetFeedItemEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetFeedItemEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramBottomVideoInfoWidget.a != null) && (TextUtils.equals(paramGetFeedItemEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramBottomVideoInfoWidget.a.b)))
    {
      SLog.a(paramBottomVideoInfoWidget.b, "refresh feed item , feed id :%s", paramBottomVideoInfoWidget.a.b);
      paramBottomVideoInfoWidget.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedManager.GetFeedItemEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.GetFeedItemReceiver
 * JD-Core Version:    0.7.0.1
 */