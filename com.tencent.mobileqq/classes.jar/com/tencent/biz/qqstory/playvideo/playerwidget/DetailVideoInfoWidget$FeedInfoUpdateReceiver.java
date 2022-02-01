package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;

public class DetailVideoInfoWidget$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<DetailVideoInfoWidget, FeedInfoChangeEvent>
{
  public DetailVideoInfoWidget$FeedInfoUpdateReceiver(DetailVideoInfoWidget paramDetailVideoInfoWidget)
  {
    super(paramDetailVideoInfoWidget);
  }
  
  public void a(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramDetailVideoInfoWidget.p != null) && (TextUtils.equals(paramDetailVideoInfoWidget.p.c, paramFeedInfoChangeEvent.b)))
    {
      SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      paramDetailVideoInfoWidget.x();
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */