package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tribe.async.dispatch.Dispatcher.Event;

public class StoryPlayerActivity$ClosePlayerAnimationInfoEvent
  implements Dispatcher.Event
{
  public final AnimationParam a;
  public final String b;
  
  public StoryPlayerActivity$ClosePlayerAnimationInfoEvent(AnimationParam paramAnimationParam, String paramString)
  {
    this.a = paramAnimationParam;
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEvent
 * JD-Core Version:    0.7.0.1
 */