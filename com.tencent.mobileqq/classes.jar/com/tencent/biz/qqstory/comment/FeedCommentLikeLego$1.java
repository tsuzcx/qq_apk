package com.tencent.biz.qqstory.comment;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.BannerWebShareMode;
import com.tencent.biz.qqstory.newshare.mode.FeedDetailShareMode;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FeedCommentLikeLego$1
  extends LegoEvenHandler
{
  FeedCommentLikeLego$1(FeedCommentLikeLego paramFeedCommentLikeLego) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    label672:
    label812:
    Object localObject2;
    label1158:
    List localList;
    Object localObject4;
    Object localObject3;
    switch (paramView.getId())
    {
    default: 
    case 2131371812: 
    case 2131371810: 
    case 2131374985: 
    case 2131365062: 
    case 2131371813: 
      int i;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704427), 0).a();
        }
        else
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
          {
            if (ShareGroupUtil.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
              QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131704447), 1).a();
            }
          }
          else if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed != null) && (ShareGroupUtil.b()))
          {
            i = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().type;
            if ((i == 3) || (i == 5))
            {
              QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131704418), 1).a();
              continue;
            }
          }
          this.a.e();
          continue;
          if (!NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704441), 0).a();
          }
          else if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
          {
            QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704425), 0).a();
          }
          else
          {
            if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
            {
              if (ShareGroupUtil.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
                QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131704432), 1).a();
              }
            }
            else if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed != null) && (ShareGroupUtil.b()))
            {
              i = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().type;
              if ((i == 3) || (i == 5))
              {
                QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131704442), 1).a();
                continue;
              }
            }
            i = StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
            if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
            for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
            {
              StoryReportor.a("home_page", "clk_reply", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
              if (this.a.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback == null) {
                break;
              }
              localObject1 = (FeedCommentLego)this.a.a("commentLego");
              this.a.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback.a((FeedCommentLego)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
              break;
            }
            if (FeedCommentLikeLego.a(this.a) != null)
            {
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
              {
                localObject1 = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
                FeedCommentLikeLego.a(this.a).a(Long.parseLong(((QQUserUIItem)localObject1).qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              }
            }
            else
            {
              i = StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
                break label812;
              }
            }
            for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
            {
              StoryReportor.a("home_page", "clk_play", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
              break;
              FeedCommentLikeLego.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              break label672;
            }
            if (this.a.jdField_a_of_type_Int == 11) {
              i = 211;
            }
            for (;;)
            {
              StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
              StoryReportor.a("home_page", "clk_reply_mini", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), StoryReportor.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
              break;
              if (this.a.jdField_a_of_type_Int == 12) {
                i = 222;
              } else {
                i = 210;
              }
            }
            if (!NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704426), 0).a();
            }
            else if (!UIUtils.b())
            {
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
              for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
              {
                StoryReportor.a("home_page", "clk_share", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", StoryReportor.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
                if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
                  break label1158;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
                break;
              }
              if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed == null) {
                break;
              }
              if (FeedCommentLikeLego.a(this.a) == null) {
                FeedCommentLikeLego.a(this.a, StoryShare.a(this.a.jdField_a_of_type_AndroidAppActivity));
              }
              FeedCommentLikeLego.a(this.a).a(this.a.jdField_a_of_type_AndroidContentContext.getString(2131719311)).a(new FeedCommentLikeLego.1.1(this)).a(new BannerWebShareMode((BannerFeedItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed.a())).b();
            }
          }
        }
      }
      localObject2 = null;
      localObject1 = null;
      localList = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a();
      if (!localList.isEmpty())
      {
        Iterator localIterator = localList.iterator();
        label1409:
        label1426:
        label1441:
        label1448:
        if (localIterator.hasNext())
        {
          localObject4 = (StoryVideoItem)localIterator.next();
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject4).mVid)) {
            break label1986;
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            if (!DateUtils.c(((StoryVideoItem)localObject4).mCreateTime)) {
              break label1448;
            }
            i = localList.size() - 1;
            label1359:
            if (i < 0) {
              break label1983;
            }
            localObject3 = (StoryVideoItem)localList.get(i);
            if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
              break label1441;
            }
            localObject1 = localObject3;
          }
          label1391:
          for (localObject3 = localObject1;; localObject3 = localObject4)
          {
            if (localObject2 != null) {
              break label1976;
            }
            localObject1 = new ArrayList();
            ((List)localObject1).add(((StoryVideoItem)localObject4).mVid);
            localObject2 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            i -= 1;
            break label1359;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FeedCommentLikeLego", 2, "can't share, video list empty");
        }
        QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704455), 0).a();
        break;
      }
      if (localObject1 == null) {
        break;
      }
      boolean bool1 = StoryVideoItem.hasPollVideo(localList);
      boolean bool2 = StoryVideoItem.hasInteractVideo(localList);
      boolean bool3 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe();
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.allowStrangerVisitAndPost == 1))
      {
        if (FeedCommentLikeLego.a(this.a) == null) {
          FeedCommentLikeLego.a(this.a, StoryShare.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        localObject4 = FeedCommentLikeLego.a(this.a);
        if (bool3)
        {
          localObject3 = HardCodeUtil.a(2131704452);
          label1605:
          localObject2 = ((StoryShare)localObject4).a((String)localObject3).a(new FeedCommentLikeLego.1.2(this)).a(ShareGroupOneDayStoryShareMode.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, (StoryVideoItem)localObject1, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((StoryVideoItem)localObject1).mCreateTime, ((List)localObject2).size()));
          if (!bool1) {
            break label1755;
          }
          localObject1 = "1";
          label1671:
          localObject2 = ((StoryShare)localObject2).a("vote", (String)localObject1);
          if (!bool2) {
            break label1763;
          }
        }
        label1755:
        label1763:
        for (localObject1 = "1";; localObject1 = "0")
        {
          ((StoryShare)localObject2).a("grade", (String)localObject1).b();
          StoryReportor.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          break;
          localObject3 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131719311);
          break label1605;
          localObject1 = "0";
          break label1671;
        }
      }
      if (FeedCommentLikeLego.a(this.a) == null) {
        FeedCommentLikeLego.a(this.a, StoryShare.a(this.a.jdField_a_of_type_AndroidAppActivity));
      }
      localObject4 = FeedCommentLikeLego.a(this.a);
      if (bool3)
      {
        localObject3 = HardCodeUtil.a(2131704436);
        label1821:
        localObject2 = ((StoryShare)localObject4).a((String)localObject3).a(new FeedCommentLikeLego.1.3(this)).a(new FeedDetailShareMode((StoryVideoItem)localObject1, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject2).size()));
        if (!bool1) {
          break label1935;
        }
        localObject1 = "1";
        label1879:
        localObject2 = ((StoryShare)localObject2).a("vote", (String)localObject1);
        if (!bool2) {
          break label1943;
        }
      }
      label1935:
      label1943:
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((StoryShare)localObject2).a("grade", (String)localObject1).b();
        break;
        localObject3 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131719311);
        break label1821;
        localObject1 = "0";
        break label1879;
      }
      QQStoryWatcherListActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
      break;
      label1976:
      localObject1 = localObject2;
      break label1409;
      label1983:
      break label1391;
      label1986:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label1426;
      localObject2 = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego.1
 * JD-Core Version:    0.7.0.1
 */