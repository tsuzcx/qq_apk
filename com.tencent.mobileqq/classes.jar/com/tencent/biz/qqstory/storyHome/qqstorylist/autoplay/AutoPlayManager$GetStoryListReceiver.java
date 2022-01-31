package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class AutoPlayManager$GetStoryListReceiver
  extends QQUIEventReceiver
{
  public AutoPlayManager$GetStoryListReceiver(AutoPlayManager paramAutoPlayManager1, @NonNull AutoPlayManager paramAutoPlayManager2)
  {
    super(paramAutoPlayManager2);
  }
  
  public void a(@NonNull AutoPlayManager paramAutoPlayManager, @NonNull DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.StoryPlayVideoActivity", 2, "GetStoryListReceiver");
    }
    paramAutoPlayManager.b(paramPlayerVideoListEvent.a);
  }
  
  public Class acceptEventClass()
  {
    return DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager.GetStoryListReceiver
 * JD-Core Version:    0.7.0.1
 */