package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class FeedSegment$2
  extends ChildViewClickListener
{
  FeedSegment$2(FeedSegment paramFeedSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView.getVisibility() != 0) {
      return;
    }
    if (UIUtils.b()) {
      return;
    }
    BannerHomeFeed localBannerHomeFeed = (BannerHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)localBannerHomeFeed.a();
    int i = paramView.getId();
    paramBaseViewHolder = "3";
    paramObject = "1";
    switch (i)
    {
    default: 
      return;
    case 2131374516: 
      FeedSegment.a(this.a, paramInt);
      return;
    case 2131374505: 
      StoryApi.a(FeedSegment.a(this.a), 4, localBannerFeedItem.getOwner().getUnionId());
      paramInt = StoryReportor.a(localBannerFeedItem);
      i = StoryReportor.b(localBannerFeedItem);
      if (this.a.jdField_a_of_type_Int == 11) {
        paramView = paramBaseViewHolder;
      } else {
        paramView = "1";
      }
      StoryReportor.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, localBannerFeedItem.feedId, "" });
      return;
    case 2131374467: 
    case 2131374475: 
      paramBaseViewHolder = localBannerFeedItem.getOwner().getUnionId();
      String str = localBannerFeedItem.feedId;
      if (paramView.getId() == 2131374467) {
        paramView = paramObject;
      } else {
        paramView = "2";
      }
      StoryReportor.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", paramBaseViewHolder, str });
      if (TextUtils.isEmpty(localBannerFeedItem.schema))
      {
        SLog.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      SLog.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", localBannerFeedItem.schema);
      if (((BannerFeedItem)localBannerHomeFeed.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        JumpParser.a((QQAppInterface)QQStoryContext.a(), FeedSegment.a(this.a), localBannerFeedItem.schema).a();
        return;
      }
      if (!NetworkUtils.a(FeedSegment.a(this.a)))
      {
        QQToast.a(FeedSegment.a(this.a), 1, HardCodeUtil.a(2131704585), 0).a();
        return;
      }
      paramView = new Intent(FeedSegment.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", localBannerFeedItem.schema);
      FeedSegment.a(this.a).startActivity(paramView);
      return;
    }
    if (!NetworkUtils.a(FeedSegment.a(this.a)))
    {
      QQToast.a(FeedSegment.a(this.a), 1, HardCodeUtil.a(2131704591), 0).a();
      return;
    }
    paramObject = ((BannerFeedItem)localBannerHomeFeed.a()).getOwner();
    ((QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, paramObject.getUnionId(), 0, 12);
    paramView.setVisibility(8);
    StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)localBannerHomeFeed.a()).feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.2
 * JD-Core Version:    0.7.0.1
 */