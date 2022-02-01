package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class StoryVideoUploadManager$VideoCompositeRec
  extends QQUIEventReceiver<StoryVideoUploadManager, VideoCompositeManager.CompositeVideoEvent>
{
  public StoryVideoUploadManager$VideoCompositeRec(@NonNull StoryVideoUploadManager paramStoryVideoUploadManager)
  {
    super(paramStoryVideoUploadManager);
  }
  
  public void a(@NonNull StoryVideoUploadManager paramStoryVideoUploadManager, @NonNull VideoCompositeManager.CompositeVideoEvent paramCompositeVideoEvent)
  {
    if (paramCompositeVideoEvent.g.isSuccess())
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramCompositeVideoEvent.a, paramCompositeVideoEvent.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramStoryVideoUploadManager, paramCompositeVideoEvent), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return VideoCompositeManager.CompositeVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec
 * JD-Core Version:    0.7.0.1
 */