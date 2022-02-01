package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class UploadStatusVideoInfoWidget$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver<UploadStatusVideoInfoWidget, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  public UploadStatusVideoInfoWidget$StoryVideoPublishStatusReceiver(@NonNull UploadStatusVideoInfoWidget paramUploadStatusVideoInfoWidget)
  {
    super(paramUploadStatusVideoInfoWidget);
  }
  
  public void a(@NonNull UploadStatusVideoInfoWidget paramUploadStatusVideoInfoWidget, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((paramUploadStatusVideoInfoWidget.a != null) && (paramStoryVideoPublishStatusEvent.a != null))
    {
      if (!TextUtils.equals(paramUploadStatusVideoInfoWidget.a.a, paramStoryVideoPublishStatusEvent.a.mVid)) {
        return;
      }
      paramUploadStatusVideoInfoWidget.i();
      paramUploadStatusVideoInfoWidget = (VideoCoverListGroupHolder)paramUploadStatusVideoInfoWidget.a(VideoCoverListGroupHolder.class);
      if (paramUploadStatusVideoInfoWidget != null) {
        paramUploadStatusVideoInfoWidget.d();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.UploadStatusVideoInfoWidget.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */