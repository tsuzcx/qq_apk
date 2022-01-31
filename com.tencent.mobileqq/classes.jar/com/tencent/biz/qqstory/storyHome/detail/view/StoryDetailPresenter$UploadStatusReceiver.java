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
  extends UIBaseEventReceiver
{
  public StoryDetailPresenter$UploadStatusReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  private void c(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((StoryDetailPresenter.a(paramStoryDetailPresenter) == null) || (!StoryDetailPresenter.a(paramStoryDetailPresenter).a.date.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      SLog.b(this.TAG, "ignore this upload status event. %s.", paramStoryVideoPublishStatusEvent.toString());
      return;
    }
    SLog.a(this.TAG, "receive upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < StoryDetailPresenter.a(paramStoryDetailPresenter).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)StoryDetailPresenter.a(paramStoryDetailPresenter).a().get(i);
        if (!localStoryVideoItem.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramStoryVideoPublishStatusEvent.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramStoryDetailPresenter.a();
        SLog.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        StoryDetailPresenter.a(paramStoryDetailPresenter).a(localStoryVideoItem);
        StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramStoryVideoPublishStatusEvent.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.a()) {
      SLog.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramStoryVideoPublishStatusEvent.c())
      {
        SLog.a(this.TAG, "receive share group video upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
        return;
      }
    } while (!paramStoryVideoPublishStatusEvent.b());
    SLog.a(this.TAG, "receive personal video upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
    c(paramStoryDetailPresenter, paramStoryVideoPublishStatusEvent);
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.UploadStatusReceiver
 * JD-Core Version:    0.7.0.1
 */