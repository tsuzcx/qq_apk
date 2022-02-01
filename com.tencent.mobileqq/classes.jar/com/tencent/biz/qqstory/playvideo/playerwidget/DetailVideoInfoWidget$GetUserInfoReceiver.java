package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class DetailVideoInfoWidget$GetUserInfoReceiver
  extends QQUIEventReceiver<DetailVideoInfoWidget, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public DetailVideoInfoWidget$GetUserInfoReceiver(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget)
  {
    super(paramDetailVideoInfoWidget);
  }
  
  public void a(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (paramUpdateUserInfoEvent.a.isSuccess())
    {
      SLog.a(paramDetailVideoInfoWidget.b, "receive user info event. %s.", paramUpdateUserInfoEvent.toString());
      paramDetailVideoInfoWidget.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.GetUserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */