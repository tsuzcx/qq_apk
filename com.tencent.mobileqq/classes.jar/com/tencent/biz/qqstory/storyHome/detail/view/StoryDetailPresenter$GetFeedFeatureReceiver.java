package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.GetFeedFeatureEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class StoryDetailPresenter$GetFeedFeatureReceiver
  extends QQUIEventReceiver<StoryDetailPresenter, GetFeedFeatureHandler.GetFeedFeatureEvent>
{
  public StoryDetailPresenter$GetFeedFeatureReceiver(@NonNull StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull GetFeedFeatureHandler.GetFeedFeatureEvent paramGetFeedFeatureEvent)
  {
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) == null)
    {
      SLog.b(this.TAG, "ignore this feature event. %s.", paramGetFeedFeatureEvent.toString());
      return;
    }
    SLog.a(this.TAG, "receive feature event. %s.", paramGetFeedFeatureEvent.toString());
    if (paramGetFeedFeatureEvent.a != null)
    {
      paramGetFeedFeatureEvent = paramGetFeedFeatureEvent.a.iterator();
      while (paramGetFeedFeatureEvent.hasNext())
      {
        FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)paramGetFeedFeatureEvent.next();
        if (localFeedFeatureItem.a.equals(StoryDetailPresenter.a(paramStoryDetailPresenter)))
        {
          SLog.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(StoryDetailPresenter.a(paramStoryDetailPresenter).a.mViewTotalTime), Integer.valueOf(localFeedFeatureItem.c));
          StoryDetailPresenter.a(paramStoryDetailPresenter).a.mViewTotalTime = localFeedFeatureItem.c;
          paramStoryDetailPresenter.a();
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
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.GetFeedFeatureReceiver
 * JD-Core Version:    0.7.0.1
 */