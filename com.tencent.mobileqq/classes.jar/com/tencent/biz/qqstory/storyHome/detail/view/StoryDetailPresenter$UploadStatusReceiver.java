package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class StoryDetailPresenter$UploadStatusReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  public StoryDetailPresenter$UploadStatusReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  private void c(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((StoryDetailPresenter.a(paramStoryDetailPresenter) != null) && (StoryDetailPresenter.a(paramStoryDetailPresenter).a.date.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      SLog.a(this.TAG, "receive upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
      int i = 0;
      while (i < StoryDetailPresenter.a(paramStoryDetailPresenter).a().size())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)StoryDetailPresenter.a(paramStoryDetailPresenter).a().get(i);
        if (localStoryVideoItem.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem))
        {
          if (paramStoryVideoPublishStatusEvent.b == null)
          {
            localStoryVideoItem.copy(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          }
          else
          {
            StoryDetailPresenter.a(paramStoryDetailPresenter).a(localStoryVideoItem);
            StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramStoryVideoPublishStatusEvent.b, i);
          }
          paramStoryDetailPresenter.a();
          break;
        }
        i += 1;
      }
      SLog.d(this.TAG, "can't find the video whose state has been changed.");
      return;
    }
    SLog.b(this.TAG, "ignore this upload status event. %s.", paramStoryVideoPublishStatusEvent.toString());
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.a())
    {
      SLog.b(this.TAG, "ignore this upload status event, because it's a troop video.");
      return;
    }
    if (paramStoryVideoPublishStatusEvent.c())
    {
      SLog.a(this.TAG, "receive share group video upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
      return;
    }
    if (paramStoryVideoPublishStatusEvent.b())
    {
      SLog.a(this.TAG, "receive personal video upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
      c(paramStoryDetailPresenter, paramStoryVideoPublishStatusEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.UploadStatusReceiver
 * JD-Core Version:    0.7.0.1
 */