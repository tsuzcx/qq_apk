package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.CreateFakeVideoEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MystoryListView$FakeVideoCreateRec
  extends QQUIEventReceiver<MystoryListView, StoryVideoUploadManager.CreateFakeVideoEvent>
{
  public MystoryListView$FakeVideoCreateRec(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull StoryVideoUploadManager.CreateFakeVideoEvent paramCreateFakeVideoEvent)
  {
    paramMystoryListView.s();
    paramCreateFakeVideoEvent = (FeedSegment)paramMystoryListView.b("FeedSegment");
    if (paramCreateFakeVideoEvent != null) {
      paramCreateFakeVideoEvent.n();
    }
    paramMystoryListView = (NewMyStorySegment)paramMystoryListView.b("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.CreateFakeVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.FakeVideoCreateRec
 * JD-Core Version:    0.7.0.1
 */