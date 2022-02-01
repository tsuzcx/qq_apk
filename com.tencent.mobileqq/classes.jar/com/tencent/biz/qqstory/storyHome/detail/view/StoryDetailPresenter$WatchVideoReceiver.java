package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class StoryDetailPresenter$WatchVideoReceiver
  extends QQUIEventReceiver<StoryDetailPresenter, WatchVideoHandler.WatchVideoEvent>
{
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull WatchVideoHandler.WatchVideoEvent paramWatchVideoEvent)
  {
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) == null) {
      SLog.b(this.TAG, "ignore this watch video event. %s.", paramWatchVideoEvent.toString());
    }
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext())
      {
        SLog.a(this.TAG, "receive watch video event. %s.", paramWatchVideoEvent.toString());
        localIterator = StoryDetailPresenter.a(paramStoryDetailPresenter).a().iterator();
      }
    } while (!((StoryVideoItem)localIterator.next()).mVid.equals(paramWatchVideoEvent.a));
    StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramWatchVideoEvent.a);
    SLog.a(this.TAG, "find watched video. vid = %s.", paramWatchVideoEvent.a);
  }
  
  public Class acceptEventClass()
  {
    return WatchVideoHandler.WatchVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.WatchVideoReceiver
 * JD-Core Version:    0.7.0.1
 */