package com.tencent.biz.qqstory.playmode;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class VideoPlayModeBase$GetStoryListReceiver
  extends QQUIEventReceiver
{
  public VideoPlayModeBase$GetStoryListReceiver(VideoPlayModeBase paramVideoPlayModeBase1, @NonNull VideoPlayModeBase paramVideoPlayModeBase2)
  {
    super(paramVideoPlayModeBase2);
  }
  
  public void a(@NonNull VideoPlayModeBase paramVideoPlayModeBase, @NonNull DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.StoryPlayVideoActivity", 2, "GetStoryListReceiver");
    }
    paramVideoPlayModeBase.a(paramPlayerVideoListEvent);
  }
  
  public Class acceptEventClass()
  {
    return DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.GetStoryListReceiver
 * JD-Core Version:    0.7.0.1
 */