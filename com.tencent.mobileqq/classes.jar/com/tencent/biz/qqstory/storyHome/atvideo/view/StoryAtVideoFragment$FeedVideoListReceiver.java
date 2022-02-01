package com.tencent.biz.qqstory.storyHome.atvideo.view;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class StoryAtVideoFragment$FeedVideoListReceiver
  extends UIBaseEventReceiver<StoryAtVideoFragment, VideoListPageLoader.GetVideoListEvent>
{
  StoryAtVideoFragment$FeedVideoListReceiver(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if ((paramGetVideoListEvent.e.equals(paramStoryAtVideoFragment.q)) && (!paramGetVideoListEvent.g.isFail()) && (paramStoryAtVideoFragment.s != null))
    {
      if (!paramStoryAtVideoFragment.s.e())
      {
        SLog.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramGetVideoListEvent.toString() });
        return;
      }
      SLog.a(this.TAG, "receive comment list event. %s.", paramGetVideoListEvent.toString());
      paramStoryAtVideoFragment.s.a(paramGetVideoListEvent.h, paramGetVideoListEvent.c);
      paramStoryAtVideoFragment.s.f().updateVideoInfo(paramGetVideoListEvent.i);
      if (paramStoryAtVideoFragment.s.a().size() < 1)
      {
        paramStoryAtVideoFragment.f.setVisibility(0);
        paramStoryAtVideoFragment.a.setVisibility(8);
        paramStoryAtVideoFragment.b.setVisibility(8);
        return;
      }
      paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.s);
      return;
    }
    SLog.b(this.TAG, "ignore this comment list event. %s.", paramGetVideoListEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment.FeedVideoListReceiver
 * JD-Core Version:    0.7.0.1
 */