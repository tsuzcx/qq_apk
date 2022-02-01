package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.TroopNickNameManager.TroopNickNameUpdateEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedSegment$TroopNickNameUpdateEventReceiver
  extends QQUIEventReceiver<FeedSegment, TroopNickNameManager.TroopNickNameUpdateEvent>
{
  public FeedSegment$TroopNickNameUpdateEventReceiver(@NonNull FeedSegment paramFeedSegment)
  {
    super(paramFeedSegment);
  }
  
  public void a(@NonNull FeedSegment paramFeedSegment, @NonNull TroopNickNameManager.TroopNickNameUpdateEvent paramTroopNickNameUpdateEvent)
  {
    paramFeedSegment.i();
  }
  
  public Class acceptEventClass()
  {
    return TroopNickNameManager.TroopNickNameUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.TroopNickNameUpdateEventReceiver
 * JD-Core Version:    0.7.0.1
 */