package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;

public class StoryDetailPresenter$VideoDeleteReceiver
  extends UIBaseEventReceiver
{
  public StoryDetailPresenter$VideoDeleteReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) == null) {
      SLog.b(this.TAG, "ignore this video delete event. %s.", paramDeleteStoryVideoEvent.toString());
    }
    for (;;)
    {
      return;
      SLog.a(this.TAG, "receive video delete event. %s.", paramDeleteStoryVideoEvent.toString());
      Iterator localIterator = StoryDetailPresenter.a(paramStoryDetailPresenter).a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramDeleteStoryVideoEvent.a));
      StoryDetailPresenter.a(paramStoryDetailPresenter).a().remove(localStoryVideoItem);
      SLog.a(this.TAG, "video list's size is %d after delete video.", Integer.valueOf(StoryDetailPresenter.a(paramStoryDetailPresenter).a().size()));
      if (StoryDetailPresenter.a(paramStoryDetailPresenter).a().size() == 0) {
        StoryDetailPresenter.a(paramStoryDetailPresenter).b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        StoryDetailPresenter.c(paramStoryDetailPresenter);
        return;
        paramStoryDetailPresenter.a();
      }
    }
    SLog.d(this.TAG, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(StoryDetailPresenter.a(paramStoryDetailPresenter).a().size()) });
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.VideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */