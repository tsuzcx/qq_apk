package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.View;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FeedSegment$13
  implements ActionSheet.OnButtonClickListener
{
  FeedSegment$13(FeedSegment paramFeedSegment, ActionSheet paramActionSheet, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.superDismiss();
    Object localObject;
    if (paramInt != 0)
    {
      int i = 2;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          StoryReportor.a("home_page", "multi_press_clk", 0, 5, new String[0]);
          return;
        }
        if (!NetworkUtil.isNetworkAvailable(FeedSegment.o(this.e)))
        {
          QQToast.makeText(FeedSegment.b(this.e), 1, HardCodeUtil.a(2131902477), 0).show();
          return;
        }
        paramView = new qqstory_service.ReqMultiRcmdDisLike();
        paramView.vid.set(this.c.mVid);
        ProtoUtils.a(PlayModeUtils.b(), new FeedSegment.13.1(this), paramView.toByteArray(), StoryApi.a("StorySvc.multi_rcmd_dis_like"));
        StoryReportor.a("home_page", "multi_press_clk", 0, 4, new String[0]);
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(FeedSegment.n(this.e)))
      {
        QQToast.makeText(FeedSegment.b(this.e), 1, HardCodeUtil.a(2131902475), 0).show();
        return;
      }
      paramView = this.b;
      if (paramView != null)
      {
        int j = paramView.isSubscribe;
        paramView = this.b;
        paramView.isSubscribe = (paramView.isSubscribe() ^ true);
        FeedSegment.a(this.e, this.d.feedId);
        paramView = (QQStoryHandler)PlayModeUtils.b().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
        localObject = this.b.uid;
        if (j == 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        paramView.a(1, (String)localObject, paramInt, 1);
        paramInt = i;
        if (j == 1) {
          paramInt = 3;
        }
        StoryReportor.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
      }
    }
    else
    {
      localObject = FeedSegment.b(this.e);
      paramView = this.b;
      if (paramView != null) {
        paramView = paramView.uid;
      } else {
        paramView = this.c.mOwnerUid;
      }
      StoryApi.a((Context)localObject, 4, paramView);
      StoryReportor.a("home_page", "multi_press_clk", 0, 1, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.13
 * JD-Core Version:    0.7.0.1
 */