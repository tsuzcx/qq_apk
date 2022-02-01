package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class WeishiTagVideoInfoWidget$GetUserInfoReceiver
  extends QQUIEventReceiver<WeishiTagVideoInfoWidget, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public WeishiTagVideoInfoWidget$GetUserInfoReceiver(@NonNull WeishiTagVideoInfoWidget paramWeishiTagVideoInfoWidget)
  {
    super(paramWeishiTagVideoInfoWidget);
  }
  
  public void a(@NonNull WeishiTagVideoInfoWidget paramWeishiTagVideoInfoWidget, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (paramUpdateUserInfoEvent.g.isSuccess())
    {
      SLog.a(this.TAG, "receive user info event. %s.", paramUpdateUserInfoEvent.toString());
      paramWeishiTagVideoInfoWidget.x();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeishiTagVideoInfoWidget.GetUserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */