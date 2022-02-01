package com.tencent.biz.qqstory.storyHome;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class StoryTransitionActivity$1
  extends SimpleJob<Void>
{
  StoryTransitionActivity$1(StoryTransitionActivity paramStoryTransitionActivity, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    SLog.d("StoryTransitionActivity", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(StoryVideoUploadManager.a()) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryTransitionActivity.1
 * JD-Core Version:    0.7.0.1
 */