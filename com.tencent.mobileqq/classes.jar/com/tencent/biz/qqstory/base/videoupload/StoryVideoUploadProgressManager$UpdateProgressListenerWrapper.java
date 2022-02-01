package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class StoryVideoUploadProgressManager$UpdateProgressListenerWrapper
{
  private WeakReference<StoryVideoUploadProgressManager.UpdateProgressListener> a;
  
  public StoryVideoUploadProgressManager$UpdateProgressListenerWrapper(StoryVideoUploadProgressManager.UpdateProgressListener paramUpdateProgressListener)
  {
    this.a = new WeakReference(paramUpdateProgressListener);
  }
  
  @Nullable
  public StoryVideoUploadProgressManager.UpdateProgressListener a()
  {
    return (StoryVideoUploadProgressManager.UpdateProgressListener)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.UpdateProgressListenerWrapper
 * JD-Core Version:    0.7.0.1
 */