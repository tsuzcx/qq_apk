package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler.GetVidPollInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class InteractWidgetVideoHolder$GetPollInfoReceiver
  extends QQUIEventReceiver<InteractWidgetVideoHolder, GetVidPollInfoHandler.GetVidPollInfoEvent>
{
  public InteractWidgetVideoHolder$GetPollInfoReceiver(@NonNull InteractWidgetVideoHolder paramInteractWidgetVideoHolder)
  {
    super(paramInteractWidgetVideoHolder);
  }
  
  public void a(@NonNull InteractWidgetVideoHolder paramInteractWidgetVideoHolder, @NonNull GetVidPollInfoHandler.GetVidPollInfoEvent paramGetVidPollInfoEvent)
  {
    SLog.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramInteractWidgetVideoHolder.d()) {
      paramInteractWidgetVideoHolder.a(paramInteractWidgetVideoHolder.jdField_a_of_type_Int, paramInteractWidgetVideoHolder.b, paramInteractWidgetVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData, paramInteractWidgetVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return GetVidPollInfoHandler.GetVidPollInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InteractWidgetVideoHolder.GetPollInfoReceiver
 * JD-Core Version:    0.7.0.1
 */