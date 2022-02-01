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
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
    switch (paramInt)
    {
    default: 
      StoryReportor.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)
        {
          StoryApi.a((Context)localObject, 4, paramView);
          StoryReportor.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!NetworkUtil.g(FeedSegment.f(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment)))
        {
          QQToast.a(FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment), 1, HardCodeUtil.a(2131704477), 0).a();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (i != 1) {
          break label256;
        }
        paramInt = 1;
        label221:
        paramView.a(1, (String)localObject, paramInt, 1);
        if (i != 1) {
          break label261;
        }
      }
      label256:
      label261:
      for (paramInt = 3;; paramInt = 2)
      {
        StoryReportor.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        paramInt = 0;
        break label221;
      }
    }
    if (!NetworkUtil.g(FeedSegment.g(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment)))
    {
      QQToast.a(FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment), 1, HardCodeUtil.a(2131704480), 0).a();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    ProtoUtils.a(PlayModeUtils.a(), new FeedSegment.13.1(this), paramView.toByteArray(), StoryApi.a("StorySvc.multi_rcmd_dis_like"));
    StoryReportor.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.13
 * JD-Core Version:    0.7.0.1
 */