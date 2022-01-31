package com.tencent.biz.qqstory.playmode;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler.GetVidPollInfoEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class VideoPlayModeBase$GetPollInfoReceiver
  extends QQUIEventReceiver
{
  public VideoPlayModeBase$GetPollInfoReceiver(@NonNull VideoPlayModeBase paramVideoPlayModeBase)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(@NonNull VideoPlayModeBase paramVideoPlayModeBase, @NonNull GetVidPollInfoHandler.GetVidPollInfoEvent paramGetVidPollInfoEvent)
  {
    SLog.b("VideoPlayModeBase." + this.TAG, "onEvent: GetVidPollInfoEvent");
    int i = paramVideoPlayModeBase.b;
    paramGetVidPollInfoEvent = paramVideoPlayModeBase.a(i);
    if (paramGetVidPollInfoEvent == null) {}
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
    do
    {
      return;
      localVideoViewHolder = paramVideoPlayModeBase.a(i);
      if (paramGetVidPollInfoEvent.isPollVideo())
      {
        PlayModePollViewUtils.c(paramVideoPlayModeBase, localVideoViewHolder, paramGetVidPollInfoEvent);
        return;
      }
    } while (!paramGetVidPollInfoEvent.isInteractVideo());
    PlayModeInteractViewUtils.c(paramVideoPlayModeBase, localVideoViewHolder, paramGetVidPollInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetVidPollInfoHandler.GetVidPollInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.GetPollInfoReceiver
 * JD-Core Version:    0.7.0.1
 */