package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FeedSegment$3
  extends ChildViewClickListener
{
  FeedSegment$3(FeedSegment paramFeedSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (UIUtils.b()) {}
    Object localObject;
    label549:
    label555:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131362158: 
          case 2131374960: 
            for (;;)
            {
              paramObject = (StoryHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
              if (paramObject == FeedSegment.a(this.a))
              {
                FeedSegment.a(this.a, null);
                FeedSegment.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof GeneralHomeFeed)) {
                break;
              }
              paramView = (GeneralHomeFeed)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt) instanceof GeneralHomeFeed)) {
                StoryReportor.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt) instanceof ShareGroupHomeFeed)) {
                StoryReportor.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof ShareGroupHomeFeed))
            {
              paramView = ((ShareGroupFeedItem)((ShareGroupHomeFeed)paramObject).a()).getOwner();
              FeedSegment.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof GeneralRecommendHomeFeed));
        if (!NetworkUtils.a(FeedSegment.a(this.a)))
        {
          QQToast.a(FeedSegment.a(this.a), 1, HardCodeUtil.a(2131704487), 0).a();
          return;
        }
        paramObject = (GeneralRecommendHomeFeed)paramObject;
        localObject = paramObject.a().getOwner();
        ((QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramBaseViewHolder.a(2131374986)).setVisibility(8);
        StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramBaseViewHolder = ((StoryHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt)).a();
        localObject = paramBaseViewHolder.getOwner();
        paramInt = StoryReportor.a(paramBaseViewHolder);
        i = StoryReportor.b(paramBaseViewHolder);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label549;
          }
        }
        for (paramObject = ((IFeedOwner)localObject).getUnionId();; paramObject = "")
        {
          StoryReportor.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramBaseViewHolder.feedId, paramObject });
          if (!((IFeedOwner)localObject).isMe()) {
            break label555;
          }
          StoryApi.a(FeedSegment.a(this.a), 4, paramBaseViewHolder.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((IFeedOwner)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramBaseViewHolder instanceof GeneralFeedItem)) || ((paramBaseViewHolder instanceof GeneralRecommendFeedItem)))
          {
            StoryApi.a(FeedSegment.a(this.a), 4, ((IFeedOwner)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramBaseViewHolder instanceof ShareGroupFeedItem));
      paramView = ((IFeedOwner)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        SLog.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramBaseViewHolder.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(FeedSegment.a(this.a), 2, paramView, null, paramInt, 74);
        return;
      }
      for (;;)
      {
        try
        {
          if (!(localObject instanceof ShareGroupItem)) {
            break;
          }
          if (this.a.jdField_a_of_type_Int != 10) {
            break label777;
          }
          paramInt = 1;
          if (this.a.jdField_a_of_type_Int != 10) {
            break label783;
          }
          i = 88;
          QQStoryShareGroupProfileActivity.a(FeedSegment.a(this.a), 1, ((IFeedOwner)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
          return;
        }
        catch (NumberFormatException paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.qqstory.home:FeedSegment", 2, "troopId error ", paramView);
        return;
        paramInt = 9;
        continue;
        i = 76;
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a() == null) || (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size() <= paramInt) || (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt) instanceof VideoListHomeFeed));
    label777:
    label783:
    paramView = (VideoListHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    paramObject = new ArrayList();
    paramBaseViewHolder = paramView.a().iterator();
    paramInt = 0;
    label904:
    if (paramBaseViewHolder.hasNext())
    {
      localObject = (StoryVideoItem)paramBaseViewHolder.next();
      if (!((StoryVideoItem)localObject).isUploadFail()) {
        break label1062;
      }
      paramObject.add(localObject);
      paramInt += 1;
    }
    label1062:
    for (;;)
    {
      break label904;
      if (paramObject.size() > 0) {
        StoryVideoUploadManager.a(paramObject, FeedSegment.a(this.a));
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size() <= 0) {
        break;
      }
      StoryReportor.a("home_page", "clk_retry", StoryReportor.a(paramView.a()), 0, new String[] { "1", StoryReportor.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      SLog.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      FeedSegment.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.3
 * JD-Core Version:    0.7.0.1
 */