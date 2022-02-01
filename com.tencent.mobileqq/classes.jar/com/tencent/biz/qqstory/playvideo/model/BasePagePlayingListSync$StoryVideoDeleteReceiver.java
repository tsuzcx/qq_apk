package com.tencent.biz.qqstory.playvideo.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class BasePagePlayingListSync$StoryVideoDeleteReceiver
  extends QQUIEventReceiver<BasePagePlayingListSync, DeleteStoryVideoEvent>
{
  public void a(@NonNull BasePagePlayingListSync paramBasePagePlayingListSync, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    Iterator localIterator = paramBasePagePlayingListSync.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (paramDeleteStoryVideoEvent.a.equals(localStoryVideoItem.mVid))
      {
        paramBasePagePlayingListSync.a.remove(i);
        SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "remove vid:%s", localStoryVideoItem.mVid);
        return;
      }
      i += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BasePagePlayingListSync.StoryVideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */