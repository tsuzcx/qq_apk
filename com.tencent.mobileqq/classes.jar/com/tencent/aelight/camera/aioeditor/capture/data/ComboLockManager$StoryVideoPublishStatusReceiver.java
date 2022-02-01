package com.tencent.aelight.camera.aioeditor.capture.data;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ComboLockManager$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver<ComboLockManager, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  boolean a = false;
  
  public ComboLockManager$StoryVideoPublishStatusReceiver(@NonNull ComboLockManager paramComboLockManager)
  {
    super(paramComboLockManager);
  }
  
  public void a(@NonNull ComboLockManager paramComboLockManager, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (!this.a)
    {
      paramComboLockManager.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */