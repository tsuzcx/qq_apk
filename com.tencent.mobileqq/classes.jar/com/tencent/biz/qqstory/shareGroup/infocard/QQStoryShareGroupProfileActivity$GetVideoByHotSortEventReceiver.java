package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$GetVideoByHotSortEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, GetHotSortVideoHandler.GetVideoByHotSortEvent>
{
  public QQStoryShareGroupProfileActivity$GetVideoByHotSortEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull GetHotSortVideoHandler.GetVideoByHotSortEvent paramGetVideoByHotSortEvent)
  {
    if (!paramQQStoryShareGroupProfileActivity.G) {
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramGetVideoByHotSortEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetHotSortVideoHandler.GetVideoByHotSortEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.GetVideoByHotSortEventReceiver
 * JD-Core Version:    0.7.0.1
 */