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
    if ((paramGetFeedItemEvent.g.isSuccess()) && (paramGetFeedItemEvent.a != null) && (paramBottomVideoInfoWidget.p != null) && (TextUtils.equals(paramGetFeedItemEvent.a.feedId, paramBottomVideoInfoWidget.p.c)))
    {
      SLog.a(paramBottomVideoInfoWidget.i, "refresh feed item , feed id :%s", paramBottomVideoInfoWidget.p.c);
      paramBottomVideoInfoWidget.x();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedManager.GetFeedItemEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.GetFeedItemReceiver
 * JD-Core Version:    0.7.0.1
 */