package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;

public class MoreVideoInfoWidget$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<MoreVideoInfoWidget, FeedInfoChangeEvent>
{
  public MoreVideoInfoWidget$FeedInfoUpdateReceiver(MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramMoreVideoInfoWidget.a != null) && (TextUtils.equals(paramMoreVideoInfoWidget.a.b, paramFeedInfoChangeEvent.a)))
    {
      SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      paramMoreVideoInfoWidget.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */