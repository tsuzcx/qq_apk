package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tribe.async.dispatch.Dispatcher.Event;

public class StoryPlayerActivity$ClosePlayerAnimationInfoEvent
  implements Dispatcher.Event
{
  public final AnimationParam a;
  public final String a;
  
  public StoryPlayerActivity$ClosePlayerAnimationInfoEvent(AnimationParam paramAnimationParam, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = paramAnimationParam;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEvent
 * JD-Core Version:    0.7.0.1
 */