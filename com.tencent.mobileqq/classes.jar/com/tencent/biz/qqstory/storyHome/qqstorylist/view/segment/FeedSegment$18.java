package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class FeedSegment$18
  implements Runnable
{
  FeedSegment$18(FeedSegment paramFeedSegment, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, List paramList, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.getChildCount())
    {
      View localView = this.a.getChildAt(i);
      Object localObject = localView.getTag();
      if ((localObject instanceof BaseViewHolder))
      {
        localObject = (BaseViewHolder)localObject;
        if (((BaseViewHolder)localObject).f < this.b.size())
        {
          localObject = (StoryVideoItem)this.b.get(((BaseViewHolder)localObject).f);
          if (TextUtils.equals(this.c, ((StoryVideoItem)localObject).mVid))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.18
 * JD-Core Version:    0.7.0.1
 */