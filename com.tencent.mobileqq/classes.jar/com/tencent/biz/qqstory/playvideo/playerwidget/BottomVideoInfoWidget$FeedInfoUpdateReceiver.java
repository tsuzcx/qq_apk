package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;

public class BottomVideoInfoWidget$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<BottomVideoInfoWidget, FeedInfoChangeEvent>
{
  public BottomVideoInfoWidget$FeedInfoUpdateReceiver(BottomVideoInfoWidget paramBottomVideoInfoWidget)
  {
    super(paramBottomVideoInfoWidget);
  }
  
  public void a(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramBottomVideoInfoWidget.p != null) && (TextUtils.equals(paramBottomVideoInfoWidget.p.c, paramFeedInfoChangeEvent.b)))
    {
      SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      paramBottomVideoInfoWidget.x();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */