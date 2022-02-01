package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.GetFeedFeatureEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class MoreVideoInfoWidget$GetFeedFeatureReceiver
  extends QQUIEventReceiver<MoreVideoInfoWidget, GetFeedFeatureHandler.GetFeedFeatureEvent>
{
  public MoreVideoInfoWidget$GetFeedFeatureReceiver(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull GetFeedFeatureHandler.GetFeedFeatureEvent paramGetFeedFeatureEvent)
  {
    if ((paramGetFeedFeatureEvent.g.isSuccess()) && (paramGetFeedFeatureEvent.a != null) && (paramMoreVideoInfoWidget.p != null))
    {
      paramGetFeedFeatureEvent = paramGetFeedFeatureEvent.a.iterator();
      while (paramGetFeedFeatureEvent.hasNext())
      {
        FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)paramGetFeedFeatureEvent.next();
        if (TextUtils.equals(paramMoreVideoInfoWidget.p.c, localFeedFeatureItem.a)) {
          paramMoreVideoInfoWidget.x();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetFeedFeatureHandler.GetFeedFeatureEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.GetFeedFeatureReceiver
 * JD-Core Version:    0.7.0.1
 */