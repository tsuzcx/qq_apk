package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class FeedSegment$17
  implements Runnable
{
  FeedSegment$17(FeedSegment paramFeedSegment, List paramList, VideoListLayout paramVideoListLayout, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    if (this.a.size() == 1)
    {
      localObject1 = this.b.getSingleVideoView();
      SLog.a("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.c);
      StoryDispatcher.a().dispatch(new StoryPlayerActivity.ClosePlayerAnimationInfoEvent(new AnimationParam((View)localObject1), this.c));
      return;
    }
    if (this.a.size() == 2)
    {
      localObject1 = this.b.getVideoListView();
      int i = 0;
      while (i < ((StoryHomeHorizontalListView)localObject1).getChildCount())
      {
        View localView = ((StoryHomeHorizontalListView)localObject1).getChildAt(i);
        Object localObject2 = localView.getTag();
        if ((localObject2 instanceof BaseViewHolder))
        {
          localObject2 = (BaseViewHolder)localObject2;
          if (((BaseViewHolder)localObject2).f < this.a.size())
          {
            localObject2 = (StoryVideoItem)this.a.get(((BaseViewHolder)localObject2).f);
            if (TextUtils.equals(this.c, ((StoryVideoItem)localObject2).mVid))
            {
              SLog.a("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.c);
              StoryDispatcher.a().dispatch(new StoryPlayerActivity.ClosePlayerAnimationInfoEvent(new AnimationParam(localView), this.c));
              return;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.17
 * JD-Core Version:    0.7.0.1
 */