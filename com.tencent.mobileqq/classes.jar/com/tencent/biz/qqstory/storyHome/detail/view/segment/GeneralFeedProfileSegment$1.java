package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.List;
import java.util.Map;

class GeneralFeedProfileSegment$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  GeneralFeedProfileSegment$1(GeneralFeedProfileSegment paramGeneralFeedProfileSegment, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, FeedItemThumbAdapter paramFeedItemThumbAdapter) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.a.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      Map localMap = GeneralFeedProfileSegment.a(this.c).g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("2_");
      localStringBuilder.append(this.c.a.a.feedId);
      localMap.put(localStringBuilder.toString(), ((StoryVideoItem)this.b.b.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment.1
 * JD-Core Version:    0.7.0.1
 */