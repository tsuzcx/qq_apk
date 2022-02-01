package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.GetFeedItemEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class MoreVideoInfoWidget$GetFeedItemReceiver
  extends QQUIEventReceiver<MoreVideoInfoWidget, FeedManager.GetFeedItemEvent>
{
  public MoreVideoInfoWidget$GetFeedItemReceiver(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull FeedManager.GetFeedItemEvent paramGetFeedItemEvent)
  {
    if ((paramGetFeedItemEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetFeedItemEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramMoreVideoInfoWidget.a != null) && (TextUtils.equals(paramGetFeedItemEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramMoreVideoInfoWidget.a.b)))
    {
      SLog.a(paramMoreVideoInfoWidget.b, "refresh feed item , feed id :%s", paramMoreVideoInfoWidget.a.b);
      paramMoreVideoInfoWidget.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedManager.GetFeedItemEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.GetFeedItemReceiver
 * JD-Core Version:    0.7.0.1
 */