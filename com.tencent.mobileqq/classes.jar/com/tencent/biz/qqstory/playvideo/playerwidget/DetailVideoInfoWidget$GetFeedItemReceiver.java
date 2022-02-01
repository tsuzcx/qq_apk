package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.GetFeedItemEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class DetailVideoInfoWidget$GetFeedItemReceiver
  extends QQUIEventReceiver<DetailVideoInfoWidget, FeedManager.GetFeedItemEvent>
{
  public DetailVideoInfoWidget$GetFeedItemReceiver(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget)
  {
    super(paramDetailVideoInfoWidget);
  }
  
  public void a(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget, @NonNull FeedManager.GetFeedItemEvent paramGetFeedItemEvent)
  {
    if ((paramGetFeedItemEvent.g.isSuccess()) && (paramGetFeedItemEvent.a != null) && (paramDetailVideoInfoWidget.p != null) && (TextUtils.equals(paramGetFeedItemEvent.a.feedId, paramDetailVideoInfoWidget.p.c))) {
      paramDetailVideoInfoWidget.x();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedManager.GetFeedItemEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.GetFeedItemReceiver
 * JD-Core Version:    0.7.0.1
 */