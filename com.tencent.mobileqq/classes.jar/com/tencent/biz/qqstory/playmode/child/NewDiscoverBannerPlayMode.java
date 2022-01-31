package com.tencent.biz.qqstory.playmode.child;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.BigVContentShareMode;
import com.tencent.biz.qqstory.newshare.mode.MyContentStoryShareMode;
import com.tencent.biz.qqstory.newshare.mode.OpenStoryShareMode;
import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider.DataObserver;
import com.tencent.biz.qqstory.playmode.util.NewDiscoverBannerDataProvider;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.VideoData;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;
import nkb;
import nkc;
import nke;
import nkf;
import nkg;
import nkh;

public class NewDiscoverBannerPlayMode
  extends NewFriendsPlayMode
  implements MultiGroupVideoDataProvider.DataObserver
{
  public NewDiscoverBannerDataProvider a;
  
  public NewDiscoverBannerPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    b(0);
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.jdField_a_of_type_JavaUtilList.size()))
    {
      String str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.jdField_a_of_type_JavaUtilList.get(paramInt);
      return (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(str);
    }
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    paramBundle = paramBundle.getString("extra_discover_banner_id");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider = new NewDiscoverBannerDataProvider(paramBundle);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.a(this);
      ThreadManager.post(new nkb(this), 8, null, true);
    }
  }
  
  public void a(VideoData paramVideoData)
  {
    if (paramVideoData.b != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewDiscoverBannerPlayMode", 2, "event.errorInfo.isFail()");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.isEmpty())
      {
        if (paramVideoData.b != 880001) {
          break label155;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NewDiscoverBannerPlayMode", 2, "event.errorInfo.isFail(): ERROR_NO_NETWORK");
        }
      }
    }
    label155:
    do
    {
      for (;;)
      {
        StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.b = paramVideoData.b;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nkc(this));
        return;
        if (QLog.isColorLevel()) {
          QLog.i("NewDiscoverBannerPlayMode", 2, "event.errorInfo.isFail(): errorCode:" + paramVideoData.b);
        }
      }
      if (!paramVideoData.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NewDiscoverBannerPlayMode", 2, "videoData.mVideoList.isEmpty()");
    return;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.isEmpty()) && (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1)))) {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.remove(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(paramVideoData.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(this.b);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a);
      paramVideoData = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.jdField_a_of_type_Int <= 0) {
        break label509;
      }
    }
    label509:
    for (int i = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.jdField_a_of_type_Int;; i = 1)
    {
      paramVideoData.a(i);
      this.e = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nke(this));
      return;
      if (!PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(paramVideoData.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.add(PlayModeUtils.a());
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1, paramVideoData.jdField_a_of_type_JavaUtilList);
      break;
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    paramStoryVideoItem = (ImageView)paramVideoViewHolder.a.get(2131372140);
    paramVideoViewHolder = (TextView)paramVideoViewHolder.a.get(2131372139);
    paramStoryVideoItem.setVisibility(8);
    paramVideoViewHolder.setVisibility(8);
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    paramActionSheet.b(2131434737);
    if (!PlayModeUtils.a(paramStoryVideoItem)) {
      paramActionSheet.b(2131435116);
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt == this.b) && (this.b == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1) && (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewDiscoverBannerPlayMode", 2, "going to fetch next page");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.a(false);
    }
    return super.a(paramInt);
  }
  
  protected boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    paramView = paramView.getContext().getApplicationContext().getResources();
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    boolean bool;
    VideoListFeedItem localVideoListFeedItem;
    label74:
    int i;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      bool = true;
      localVideoListFeedItem = a(this.b);
      if (!paramString.equals(paramView.getString(2131434737))) {
        break label366;
      }
      if (localVideoListFeedItem != null) {
        break label218;
      }
      paramView = null;
      if (!paramStoryVideoItem.isMine()) {
        break label227;
      }
      a().a(2131433100).a(new nkf(this, this, localVideoListFeedItem, paramView, paramStoryVideoItem)).a(new MyContentStoryShareMode(paramStoryVideoItem, false, paramView)).a();
      if (!bool) {
        break label351;
      }
      i = 1;
      label132:
      StoryReportor.a("play_video", "more_share", i, 0, new String[0]);
      i = a();
      paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b);
      if (localVideoListFeedItem != null) {
        break label357;
      }
    }
    label218:
    label227:
    label357:
    for (paramView = "";; paramView = localVideoListFeedItem.feedId)
    {
      StoryReportor.a("story_grp", "clk_one", i, 0, new String[] { "9", paramString, "", paramView });
      return true;
      bool = false;
      break;
      paramView = localVideoListFeedItem.feedId;
      break label74;
      if (bool)
      {
        paramString = new BigVContentShareMode(paramStoryVideoItem, paramView);
        label242:
        a().a(2131433100).a(new nkg(this, this, bool, localVideoListFeedItem, paramView, paramStoryVideoItem)).a(paramString).a();
        if (!bool) {
          break label345;
        }
      }
      for (i = 1;; i = 2)
      {
        StoryReportor.a("play_video", "guest_share", i, 0, new String[] { "", String.valueOf(StoryReportor.a(localVideoListFeedItem)), paramView, paramStoryVideoItem.mVid });
        break;
        paramString = new OpenStoryShareMode(paramStoryVideoItem, paramView);
        break label242;
      }
      i = 2;
      break label132;
    }
    label345:
    label351:
    label366:
    if (paramString.equals(paramView.getString(2131435116)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver = new FeedsPlayModeBase.ReportVideoReceiver(this);
        a("", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver);
      }
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, new nkh(this));
      if (bool)
      {
        i = 1;
        if (localQQUserUIItem != null) {
          break label542;
        }
        paramView = "4";
        StoryReportor.a("play_video", "more_report", i, 0, new String[] { "", paramView });
        i = a();
        paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b);
        if (localVideoListFeedItem != null) {
          break label554;
        }
      }
      for (paramView = "";; paramView = localVideoListFeedItem.feedId)
      {
        StoryReportor.a("story_grp", "clk_one", i, 0, new String[] { "7", paramString, "", paramView });
        return true;
        i = 2;
        break;
        paramView = String.valueOf(StoryReportor.a(localQQUserUIItem));
        break label446;
      }
    }
    label446:
    return false;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.NewDiscoverBannerPlayMode
 * JD-Core Version:    0.7.0.1
 */