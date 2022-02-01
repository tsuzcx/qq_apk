package com.tencent.biz.qqstory.playvideo;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class StoryPlayerActivity$ClosePlayerAnimationInfoEventReceiver
  extends QQUIEventReceiver<StoryPlayerActivity, StoryPlayerActivity.ClosePlayerAnimationInfoEvent>
{
  public StoryPlayerActivity$ClosePlayerAnimationInfoEventReceiver(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull StoryPlayerActivity.ClosePlayerAnimationInfoEvent paramClosePlayerAnimationInfoEvent)
  {
    paramStoryPlayerActivity.e = paramClosePlayerAnimationInfoEvent.a;
  }
  
  public Class acceptEventClass()
  {
    return StoryPlayerActivity.ClosePlayerAnimationInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */