package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class LinkVideoInfoController$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver<LinkVideoInfoController, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  public LinkVideoInfoController$StoryVideoPublishStatusReceiver(@NonNull LinkVideoInfoController paramLinkVideoInfoController)
  {
    super(paramLinkVideoInfoController);
  }
  
  public void a(@NonNull LinkVideoInfoController paramLinkVideoInfoController, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((LinkVideoInfoController.a(paramLinkVideoInfoController) == null) || (paramStoryVideoPublishStatusEvent.a == null) || (!TextUtils.equals(LinkVideoInfoController.a(paramLinkVideoInfoController).a, paramStoryVideoPublishStatusEvent.a.mVid))) {
      return;
    }
    paramLinkVideoInfoController.a.i();
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.LinkVideoInfoController.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */