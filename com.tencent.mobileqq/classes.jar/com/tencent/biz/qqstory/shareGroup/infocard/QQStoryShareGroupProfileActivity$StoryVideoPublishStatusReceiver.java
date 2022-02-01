package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  public QQStoryShareGroupProfileActivity$StoryVideoPublishStatusReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.a;
    if (paramStoryVideoPublishStatusEvent == null) {
      return;
    }
    if (StoryListUtils.a(paramStoryVideoPublishStatusEvent.mUploadStatus) == 3) {
      paramQQStoryShareGroupProfileActivity.b = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */