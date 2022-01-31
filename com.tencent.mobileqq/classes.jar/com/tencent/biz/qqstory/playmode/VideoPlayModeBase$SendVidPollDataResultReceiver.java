package com.tencent.biz.qqstory.playmode;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.SendVidPollDataHandler.SendVidPollDataResultEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class VideoPlayModeBase$SendVidPollDataResultReceiver
  extends QQUIEventReceiver
{
  public VideoPlayModeBase$SendVidPollDataResultReceiver(@NonNull VideoPlayModeBase paramVideoPlayModeBase)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(@NonNull VideoPlayModeBase paramVideoPlayModeBase, @NonNull SendVidPollDataHandler.SendVidPollDataResultEvent paramSendVidPollDataResultEvent)
  {
    SLog.b("VideoPlayModeBase." + this.TAG, "onEvent: SendVidPollDataResultEvent");
    int i = paramVideoPlayModeBase.b;
    paramSendVidPollDataResultEvent = paramVideoPlayModeBase.a(i);
    PlayModePollViewUtils.c(paramVideoPlayModeBase, paramVideoPlayModeBase.a(i), paramSendVidPollDataResultEvent);
  }
  
  public Class acceptEventClass()
  {
    return SendVidPollDataHandler.SendVidPollDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.SendVidPollDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */