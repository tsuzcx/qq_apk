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
    if (UIUtils.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131374971: 
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a() == null) || (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size() <= paramInt) || (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt) instanceof VideoListHomeFeed));
    paramView = (VideoListHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    paramObject = new ArrayList();
    paramBaseViewHolder = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramBaseViewHolder.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramBaseViewHolder.next();
      if (!localStoryVideoItem.isUploadFail()) {
        break label645;
      }
      paramObject.add(localStoryVideoItem);
      paramInt += 1;
    }
    label645:
    for (;;)
    {
      break label175;
      paramView = ((StoryHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        StoryTagUtil.a(FeedSegment.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      SLog.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        StoryVideoUploadManager.a(paramObject, FeedSegment.a(this.a));
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size() <= 0) {
        break;
      }
      StoryReportor.a("home_page", "clk_retry", StoryReportor.a(paramView.a()), 0, new String[] { "1", StoryReportor.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      SLog.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((StoryHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(FeedSegment.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        FeedSegment.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        StoryReportor.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        SLog.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      FeedSegment.a(this.a, paramInt);
      return;
      paramView = ((StoryHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(FeedSegment.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        FeedSegment.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        StoryReportor.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        SLog.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.4
 * JD-Core Version:    0.7.0.1
 */