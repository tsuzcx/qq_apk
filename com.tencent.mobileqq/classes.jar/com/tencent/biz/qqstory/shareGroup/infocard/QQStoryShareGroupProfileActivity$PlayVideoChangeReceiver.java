package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader.MemoriesFeedGroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$PlayVideoChangeReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, PlayVideoChangeEvent>
{
  public QQStoryShareGroupProfileActivity$PlayVideoChangeReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull PlayVideoChangeEvent paramPlayVideoChangeEvent)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramPlayVideoChangeEvent.a)) && ((paramPlayVideoChangeEvent.b instanceof MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)))
    {
      paramPlayVideoChangeEvent = ((MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)paramPlayVideoChangeEvent.b).a;
      if (paramPlayVideoChangeEvent != null) {
        paramQQStoryShareGroupProfileActivity.a(paramPlayVideoChangeEvent.a);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.PlayVideoChangeReceiver
 * JD-Core Version:    0.7.0.1
 */