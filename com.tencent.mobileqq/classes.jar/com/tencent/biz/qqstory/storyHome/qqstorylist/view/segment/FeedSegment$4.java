package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FeedSegment$4
  extends ChildViewClickListener
{
  FeedSegment$4(FeedSegment paramFeedSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (UIUtils.d()) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
    case 2131442791: 
      paramView = ((StoryHomeFeed)this.a.b.i().get(paramInt)).g();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = (TagFeedItem)paramView;
        if (!TextUtils.isEmpty(paramView.schema))
        {
          paramObject = new Intent(FeedSegment.e(this.a), QQBrowserActivity.class);
          paramObject.putExtra("url", paramView.schema);
          FeedSegment.f(this.a).startActivity(paramObject);
        }
        else
        {
          SLog.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
        }
        StoryReportor.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
      }
      break;
    case 2131442786: 
      paramView = ((StoryHomeFeed)this.a.b.i().get(paramInt)).g();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView != null)
        {
          paramObject = new Intent(FeedSegment.g(this.a), StoryTransitionActivity.class);
          paramObject.putExtra("jump_action", 1);
          paramObject.putExtra("video_tag", paramView);
          FeedSegment.h(this.a).startActivity(paramObject);
        }
        else
        {
          SLog.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
        }
      }
      StoryReportor.a("home_page", "tag_clk_join", 0, 0, new String[0]);
      return;
    case 2131442686: 
      FeedSegment.a(this.a, paramInt);
      return;
    case 2131442675: 
      paramView = ((StoryHomeFeed)this.a.b.i().get(paramInt)).g();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        StoryTagUtil.a(FeedSegment.b(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      SLog.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
    case 2131442673: 
      if ((this.a.b.i() != null) && (this.a.b.i().size() > paramInt) && (this.a.b.i().get(paramInt) != null))
      {
        if (!(this.a.b.i().get(paramInt) instanceof VideoListHomeFeed)) {
          return;
        }
        paramView = (VideoListHomeFeed)this.a.b.i().get(paramInt);
        paramObject = new ArrayList();
        paramBaseViewHolder = paramView.a().iterator();
        paramInt = 0;
        while (paramBaseViewHolder.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramBaseViewHolder.next();
          if (localStoryVideoItem.isUploadFail())
          {
            paramObject.add(localStoryVideoItem);
            paramInt += 1;
          }
        }
        if (paramObject.size() > 0) {
          StoryVideoUploadManager.a(paramObject, FeedSegment.b(this.a));
        }
        if (this.a.b.i().size() > 0) {
          StoryReportor.a("home_page", "clk_retry", StoryReportor.a(paramView.i()), 0, new String[] { "1", StoryReportor.b(this.a.a), String.valueOf(paramInt), paramView.i().feedId });
        }
      }
      else
      {
        SLog.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.4
 * JD-Core Version:    0.7.0.1
 */