package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler.SendVidRateDataResultEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class InteractWidgetVideoHolder$SendVidRateDataResultReceiver
  extends QQUIEventReceiver<InteractWidgetVideoHolder, SendVidRateDataHandler.SendVidRateDataResultEvent>
{
  public InteractWidgetVideoHolder$SendVidRateDataResultReceiver(@NonNull InteractWidgetVideoHolder paramInteractWidgetVideoHolder)
  {
    super(paramInteractWidgetVideoHolder);
  }
  
  public void a(@NonNull InteractWidgetVideoHolder paramInteractWidgetVideoHolder, @NonNull SendVidRateDataHandler.SendVidRateDataResultEvent paramSendVidRateDataResultEvent)
  {
    SLog.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramInteractWidgetVideoHolder.d()) {
      paramInteractWidgetVideoHolder.a(paramInteractWidgetVideoHolder.jdField_a_of_type_Int, paramInteractWidgetVideoHolder.b, paramInteractWidgetVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData, paramInteractWidgetVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return SendVidRateDataHandler.SendVidRateDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InteractWidgetVideoHolder.SendVidRateDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */