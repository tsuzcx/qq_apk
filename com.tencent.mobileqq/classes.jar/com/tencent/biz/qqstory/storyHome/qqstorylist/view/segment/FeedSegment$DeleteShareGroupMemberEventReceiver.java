package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DeleteShareGroupMemberEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedSegment$DeleteShareGroupMemberEventReceiver
  extends QQUIEventReceiver<FeedSegment, DeleteShareGroupMemberEvent>
{
  public FeedSegment$DeleteShareGroupMemberEventReceiver(@NonNull FeedSegment paramFeedSegment)
  {
    super(paramFeedSegment);
  }
  
  public void a(@NonNull FeedSegment paramFeedSegment, @NonNull DeleteShareGroupMemberEvent paramDeleteShareGroupMemberEvent)
  {
    if (paramDeleteShareGroupMemberEvent.a) {
      FeedSegment.d(paramFeedSegment);
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteShareGroupMemberEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.DeleteShareGroupMemberEventReceiver
 * JD-Core Version:    0.7.0.1
 */