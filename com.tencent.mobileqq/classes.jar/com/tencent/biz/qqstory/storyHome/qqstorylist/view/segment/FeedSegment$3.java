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
    if (UIUtils.d()) {
      return;
    }
    int i = paramView.getId();
    paramObject = "1";
    Object localObject;
    switch (i)
    {
    default: 
      return;
    case 2131442686: 
      FeedSegment.a(this.a, paramInt);
      return;
    case 2131442674: 
    case 2131442675: 
      paramBaseViewHolder = ((StoryHomeFeed)this.a.b.i().get(paramInt)).g();
      localObject = paramBaseViewHolder.getOwner();
      paramInt = StoryReportor.a(paramBaseViewHolder);
      i = StoryReportor.b(paramBaseViewHolder);
      paramView = paramObject;
      if (this.a.a == 11) {
        paramView = "3";
      }
      if ((localObject instanceof ShareGroupItem)) {
        paramObject = ((IFeedOwner)localObject).getUnionId();
      } else {
        paramObject = "";
      }
      StoryReportor.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramBaseViewHolder.feedId, paramObject });
      if (((IFeedOwner)localObject).isMe())
      {
        StoryApi.a(FeedSegment.b(this.a), 4, paramBaseViewHolder.getOwner().getUnionId());
        return;
      }
      paramInt = ((IFeedOwner)localObject).getRelationType();
      if ((paramInt != 0) && (paramInt != 1)) {
        if (paramInt != 2) {
          return;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!(localObject instanceof ShareGroupItem)) {
          return;
        }
        if (this.a.a != 10) {
          break label1050;
        }
        paramInt = 1;
        if (this.a.a != 10) {
          break label1056;
        }
        i = 88;
        QQStoryShareGroupProfileActivity.a(FeedSegment.d(this.a), 1, ((IFeedOwner)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
        return;
      }
      catch (NumberFormatException paramView)
      {
        if (!QLog.isColorLevel()) {
          break label1049;
        }
      }
      QLog.w("Q.qqstory.home:FeedSegment", 2, "troopId error ", paramView);
      return;
      if ((!(paramBaseViewHolder instanceof GeneralFeedItem)) && (!(paramBaseViewHolder instanceof GeneralRecommendFeedItem)))
      {
        if ((paramBaseViewHolder instanceof ShareGroupFeedItem))
        {
          paramView = ((IFeedOwner)localObject).getUnionId();
          if (TextUtils.isEmpty(paramView))
          {
            SLog.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
            return;
          }
          if (paramBaseViewHolder.type == 2) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
          QQStoryShareGroupProfileActivity.a(FeedSegment.b(this.a), 2, paramView, null, paramInt, 74);
        }
      }
      else
      {
        StoryApi.a(FeedSegment.b(this.a), 4, ((IFeedOwner)localObject).getUnionId());
        return;
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
            localObject = (StoryVideoItem)paramBaseViewHolder.next();
            if (((StoryVideoItem)localObject).isUploadFail())
            {
              paramObject.add(localObject);
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
          return;
          if ((this.a.b.i().get(paramInt) instanceof GeneralHomeFeed)) {
            StoryReportor.a("share_story", "clk_guide", 1, 0, new String[0]);
          } else if ((this.a.b.i().get(paramInt) instanceof ShareGroupHomeFeed)) {
            StoryReportor.a("share_story", "clk_guide", 2, 0, new String[0]);
          }
          paramObject = (StoryHomeFeed)this.a.b.i().get(paramInt);
          if (paramObject == FeedSegment.c(this.a))
          {
            FeedSegment.a(this.a, null);
            FeedSegment.a(this.a, false);
            this.a.e(true);
          }
          if ((paramObject instanceof GeneralHomeFeed))
          {
            paramView = (GeneralHomeFeed)paramObject;
            paramView.e = false;
            paramView.a();
            return;
          }
          if ((paramObject instanceof ShareGroupHomeFeed))
          {
            paramView = ((ShareGroupFeedItem)((ShareGroupHomeFeed)paramObject).i()).getOwner();
            FeedSegment.a(this.a, paramObject, paramView);
            return;
          }
          if ((paramObject instanceof GeneralRecommendHomeFeed))
          {
            if (!NetworkUtils.a(FeedSegment.b(this.a)))
            {
              QQToast.makeText(FeedSegment.b(this.a), 1, HardCodeUtil.a(2131902484), 0).show();
              return;
            }
            paramObject = (GeneralRecommendHomeFeed)paramObject;
            localObject = paramObject.h().getOwner();
            ((QQStoryHandler)PlayModeUtils.b().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
            paramView.setVisibility(8);
            ((RelativeLayout)paramBaseViewHolder.a(2131442687)).setVisibility(8);
            StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.h().feedId });
          }
        }
      }
      label1049:
      return;
      label1050:
      paramInt = 9;
      continue;
      label1056:
      i = 76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.3
 * JD-Core Version:    0.7.0.1
 */