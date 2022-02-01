package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MoreVideoInfoWidget$GetUserInfoReceiver
  extends QQUIEventReceiver<MoreVideoInfoWidget, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public MoreVideoInfoWidget$GetUserInfoReceiver(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (paramUpdateUserInfoEvent.a.isSuccess())
    {
      SLog.a(paramMoreVideoInfoWidget.b, "receive user info event. %s.", paramUpdateUserInfoEvent.toString());
      paramMoreVideoInfoWidget.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.GetUserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */