package com.tencent.biz.qqstory.playmode.child;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends.InviteCode;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.MyContentStoryShareMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.VideoInfoListEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import nos;
import nou;
import now;
import noy;
import noz;
import npa;
import npb;
import npc;
import npe;
import npf;
import npi;

public class NewFriendsPlayMode
  extends FeedsPlayModeBase
{
  protected QQStoryHandler a;
  protected QQStoryObserver a;
  protected GetStoryPlayerTagInfoHandler a;
  protected StoryShare a;
  protected FeedsPlayModeBase.ReportVideoReceiver a;
  protected NewFriendsPlayMode.DownloadStatusUpdateReceiver a;
  protected NewFriendsPlayMode.GenShareThumbReceiver a;
  protected NewFriendsPlayMode.StoryVideoTagUpdateReceiver a;
  public BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback a;
  public BatchGetVideoInfoHandler a;
  public VideoListPageLoader a;
  protected QQUIEventReceiver a;
  protected npi a;
  protected ArrayList d = new ArrayList();
  protected String i = "NewFriendsPlayMode" + System.currentTimeMillis();
  protected String j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  protected boolean o;
  public int p;
  
  public NewFriendsPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_Npi = new npi(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$DownloadStatusUpdateReceiver = new NewFriendsPlayMode.DownloadStatusUpdateReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$GenShareThumbReceiver = new NewFriendsPlayMode.GenShareThumbReceiver(this);
    this.jdField_a_of_type_ComTribeAsyncDispatchQQUIEventReceiver = new FeedsPlayModeBase.TroopNickNameUpdateEventReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$StoryVideoTagUpdateReceiver = new NewFriendsPlayMode.StoryVideoTagUpdateReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback = new now(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new nou(this);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 400L, "NewFriendsPlayMode create");
    b(0);
    a(this.i, this.jdField_a_of_type_Npi);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$GenShareThumbReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$DownloadStatusUpdateReceiver);
    a(this.jdField_a_of_type_ComTribeAsyncDispatchQQUIEventReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$StoryVideoTagUpdateReceiver);
    PlayModeUtils.a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.p = paramBundle.getInt("extra_pull_type");
    this.j = paramBundle.getString("extra_vid");
    this.jdField_e_of_type_Int = paramBundle.getInt("extra_story_type", -1);
    this.o = paramBundle.getBoolean("extra_is_use_cache_videolist", true);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)PlayModeUtils.a().a(98));
  }
  
  public int a()
  {
    return this.f;
  }
  
  protected int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int + this.jdField_b_of_type_Int - 1;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      int i1 = 0;
      while (i1 < this.d.size())
      {
        if (((String)this.d.get(i1)).equals(paramString)) {
          return i1;
        }
        i1 += 1;
      }
    }
  }
  
  public StoryShare a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    return (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.g);
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == hashCode()) && (paramInt2 == -1)) {
      SendVideoToFriendHelper.a().a(paramIntent.getExtras());
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager.a(this.g, this.p);
    ArrayList localArrayList = new ArrayList();
    if ((paramBundle != null) && (paramBundle.mIsVideoEnd) && (this.o))
    {
      StoryReportor.b("play_video", "use_cache_vid_list", 0, 0, new String[0]);
      int i1 = 0;
      while (i1 < paramBundle.mVideoItemList.size())
      {
        if (!StoryVideoItem.isFakeVid(((StoryVideoItem)paramBundle.mVideoItemList.get(i1)).mVid))
        {
          String str = ((StoryVideoItem)paramBundle.mVideoItemList.get(i1)).mVid;
          this.d.add(str);
          localArrayList.add(str);
        }
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler = new BatchGetVideoInfoHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.d, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback);
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "getFirstInfoList : initialize %s", new Object[] { this.j });
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(a(this.j));
      GetVidPollInfoHandler.a(localArrayList);
      if ((!TextUtils.isEmpty(this.g)) && (f())) {
        GetFeedFeatureHandler.a(Collections.singletonList(this.g));
      }
      return;
    }
    StoryReportor.b("play_video", "use_cache_vid_list", 0, 1, new String[0]);
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.NewFriendsPlayMode", 2, "feedVideoInfo is null. no videoseq.");
      }
    }
    for (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(1, this.g, this.p, -1);; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(1, this.g, this.p, paramBundle.mVideoSeq))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.b(this.i);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
      break;
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_c_of_type_Int);
        QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(((StoryVideoItem)localObject).mOwnerUid);
        switch (paramView.getId())
        {
        default: 
          super.a(paramView);
          return;
        case 2131371693: 
          if (localQQUserUIItem != null)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(1, localQQUserUIItem.uid, 0, 1);
            if (localQQUserUIItem.isVip) {}
            for (int i1 = 1;; i1 = 2)
            {
              StoryReportor.a("play_video", "follow_bigv", i1, 0, new String[] { "1" });
              return;
            }
          }
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqstory.player.NewFriendsPlayMode", 2, "onPagerItemClick, R.id.subscribe_button, userItem is null");
      return;
      a(((StoryVideoItem)localObject).mVid, ((StoryVideoItem)localObject).mBanType, ((StoryVideoItem)localObject).mVideoSpreadGroupList);
      return;
      StoryTagUtil.a(paramView.getContext(), ((StoryVideoItem)localObject).mTagInfoBase);
    } while (((StoryVideoItem)localObject).mTagInfoBase == null);
    if (((StoryVideoItem)localObject).mTagInfoBase.jdField_a_of_type_Int == 0) {}
    for (paramView = "1";; paramView = "2")
    {
      StoryReportor.a("play_video", "clk_tag", 0, 0, new String[] { "", paramView, String.valueOf(((StoryVideoItem)localObject).mTagInfoBase.jdField_a_of_type_Long), ((StoryVideoItem)localObject).mVid });
      return;
    }
  }
  
  public void a(BatchGetVideoInfoHandler.VideoInfoListEvent paramVideoInfoListEvent)
  {
    this.n = false;
    SLog.d("Q.qqstory.player.NewFriendsPlayMode", "onGetDataOnUIThread, result=%s, requestType=%d, playIndex=%d", new Object[] { Integer.valueOf(paramVideoInfoListEvent.jdField_c_of_type_Int), Integer.valueOf(paramVideoInfoListEvent.jdField_a_of_type_Int), Integer.valueOf(paramVideoInfoListEvent.jdField_b_of_type_Int) });
    if (paramVideoInfoListEvent.jdField_c_of_type_Int == -100)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = paramVideoInfoListEvent.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new noz(this));
    }
    do
    {
      return;
      Object localObject1 = new ArrayList();
      Object localObject2 = (StoryManager)SuperManager.a(5);
      int i1 = 0;
      while (i1 < paramVideoInfoListEvent.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((ArrayList)localObject1).add(((StoryManager)localObject2).a(((StoryVideoItem)paramVideoInfoListEvent.jdField_a_of_type_JavaUtilArrayList.get(i1)).mVid));
        i1 += 1;
      }
      if (!this.m)
      {
        this.m = true;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        if (this.d.size() > 0) {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(this.d.size());
        }
      }
      this.k = paramVideoInfoListEvent.jdField_b_of_type_Boolean;
      this.jdField_l_of_type_Boolean = paramVideoInfoListEvent.jdField_a_of_type_Boolean;
      switch (paramVideoInfoListEvent.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_b_of_type_Int, false);
        paramVideoInfoListEvent = new ArrayList();
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
          if (!StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {
            paramVideoInfoListEvent.add(((StoryVideoItem)localObject2).mVid);
          }
        }
        this.jdField_b_of_type_Int = paramVideoInfoListEvent.jdField_b_of_type_Int;
        if (!this.jdField_l_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(PlayModeUtils.a("first"));
          this.jdField_b_of_type_Int += 1;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        if (!this.k)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(PlayModeUtils.a("last"));
          continue;
          this.jdField_b_of_type_Int += ((ArrayList)localObject1).size();
          if (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(0)))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(1, (Collection)localObject1);
            if (this.jdField_l_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.remove(0);
              if (this.jdField_b_of_type_Int > 0) {
                this.jdField_b_of_type_Int -= 1;
              }
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(0, (Collection)localObject1);
            continue;
            i1 = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size();
            if (QLog.isColorLevel()) {
              QLog.e("Q.qqstory.player.NewFriendsPlayMode", 2, new Object[] { "TYPE_NEXT_DATA storyVideoItemList size=", Integer.valueOf(i1) });
            }
            if (i1 > 0) {
              if (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)))
              {
                this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1, (Collection)localObject1);
                if (this.k) {
                  this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1);
                }
              }
              else
              {
                this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
              }
            }
          }
        }
      }
    } while (paramVideoInfoListEvent.isEmpty());
    a(paramVideoInfoListEvent);
  }
  
  public void a(VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = paramGetVideoListEvent.errorInfo.errorCode;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new noy(this));
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (!PlayModeUtils.b(paramStoryVideoItem))
    {
      Object localObject = paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (PlayModeUtils.a(this.jdField_l_of_type_Int)) {}
      for (int i1 = 0;; i1 = 8)
      {
        ((LinearLayout)localObject).setVisibility(i1);
        paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (PlayModeUtils.a(paramVideoViewHolder, paramStoryVideoItem.mTagInfoBase))
        {
          localObject = "";
          if (paramStoryVideoItem.mTagInfoBase != null) {
            localObject = String.valueOf(paramStoryVideoItem.mTagInfoBase.jdField_a_of_type_Long);
          }
          str = paramStoryVideoItem.mVid;
          StoryReportor.a("video_edit", "exp_tag_play", 1, 0, new String[] { "", localObject, this.g, str });
        }
        if (paramStoryVideoItem.mStoryType != 2) {
          break;
        }
        String str = paramStoryVideoItem.mGroupId;
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break label195;
        }
        ThreadManager.post(new nos(this, paramVideoViewHolder, paramStoryVideoItem), 8, null, true);
        return;
      }
      localObject = null;
      label195:
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramVideoViewHolder, paramStoryVideoItem, (String)localObject);
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramVideoViewHolder, a(paramVideoViewHolder.jdField_c_of_type_Int), paramStoryVideoItem);
    }
    for (;;)
    {
      b(paramVideoViewHolder, paramStoryVideoItem);
      return;
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramVideoViewHolder, paramStoryVideoItem);
    }
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    int i2 = 1;
    int i3 = 0;
    Object localObject = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    boolean bool;
    if ((localObject != null) && (((QQUserUIItem)localObject).relationType == 0))
    {
      i1 = 1;
      bool = PlayModeUtils.a(paramStoryVideoItem);
      if (paramStoryVideoItem.mStoryType != 2) {
        break label194;
      }
      paramActionSheet.b(2131434574);
      if (!bool) {
        break label179;
      }
      label63:
      i1 = i3;
      if (!TextUtils.isEmpty(a()))
      {
        paramStoryVideoItem = ((ShareGroupManager)SuperManager.a(7)).a(a());
        i1 = i3;
        if (paramStoryVideoItem != null)
        {
          paramStoryVideoItem = ((TroopManager)PlayModeUtils.a().getManager(51)).b(String.valueOf(paramStoryVideoItem.groupUin));
          localObject = PlayModeUtils.a().getCurrentAccountUin();
          if (paramStoryVideoItem == null) {
            break label189;
          }
          i1 = i2;
          if (!paramStoryVideoItem.isTroopAdmin((String)localObject)) {
            if (!paramStoryVideoItem.isTroopOwner((String)localObject)) {
              break label189;
            }
          }
        }
      }
    }
    label179:
    label189:
    for (int i1 = i2;; i1 = 0)
    {
      if ((bool) || (i1 != 0)) {
        paramActionSheet.b(2131434755);
      }
      return;
      i1 = 0;
      break;
      paramActionSheet.b(2131435132);
      break label63;
    }
    label194:
    if ((paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading()))
    {
      paramActionSheet.b(2131434755);
      return;
    }
    if (bool)
    {
      paramActionSheet.b(2131434753);
      paramActionSheet.b(2131434574);
      paramActionSheet.b(2131434755);
      return;
    }
    if (i1 != 0)
    {
      paramActionSheet.b(2131434752);
      paramActionSheet.b(2131434574);
      paramActionSheet.b(2131435132);
      return;
    }
    paramActionSheet.b(2131434753);
    paramActionSheet.b(2131435132);
  }
  
  protected void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryPlayerTagInfoHandler == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryPlayerTagInfoHandler = new GetStoryPlayerTagInfoHandler();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryPlayerTagInfoHandler.a(paramList);
  }
  
  @TargetApi(14)
  public boolean a(int paramInt)
  {
    boolean bool = super.a(paramInt);
    e(paramInt);
    return bool;
  }
  
  protected boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    paramView = paramView.getContext().getApplicationContext().getResources();
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    boolean bool1;
    boolean bool2;
    VideoListFeedItem localVideoListFeedItem;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      bool1 = true;
      bool2 = PlayModeUtils.a(paramStoryVideoItem);
      localVideoListFeedItem = a(this.jdField_b_of_type_Int);
      if (!paramString.equals(paramView.getString(2131434574))) {
        break label128;
      }
      if (!SendVideoToFriendHelper.a().a()) {
        break label105;
      }
      QQToast.a(a(), 0, "请稍候，你有视频正在发送中", 0).a();
    }
    label105:
    label239:
    int i1;
    label128:
    label279:
    label325:
    label333:
    label462:
    do
    {
      for (;;)
      {
        return false;
        bool1 = false;
        break;
        ThreadManager.post(new npa(this, paramStoryVideoItem, paramStoryVideoItem, localVideoListFeedItem, bool2), 5, null, false);
        continue;
        if (!paramString.equals(paramView.getString(2131434752))) {
          break label239;
        }
        if (SendVideoToFriendHelper.a().a())
        {
          QQToast.a(a(), 0, "请稍候，你有视频正在发送中", 0).a();
        }
        else if (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath))
        {
          QQToast.a(a(), 1, "发送失败，请稍后重试", 0).a();
          SLog.e("Q.qqstory.player.NewFriendsPlayMode", "send video to friend failed because videoLocalPath is empty.");
        }
        else
        {
          c(1);
          a("", true, 300L);
          SendVideoToFriendHelper.a().a(paramStoryVideoItem, String.valueOf(hashCode()));
        }
      }
      if (paramString.equals(paramView.getString(2131434753)))
      {
        if (localVideoListFeedItem == null)
        {
          paramView = null;
          if (!paramStoryVideoItem.isMine()) {
            break label429;
          }
          if (this.jdField_l_of_type_Int != 12) {
            break label423;
          }
          bool2 = true;
          a().a(2131433114).a(new MyContentStoryShareMode(paramStoryVideoItem, bool2, paramView)).a(new npb(this, this, bool2, localVideoListFeedItem, paramView, paramStoryVideoItem)).a();
          if (!bool1) {
            break label456;
          }
          i1 = 1;
          StoryReportor.a("play_video", "more_share", i1, 0, new String[0]);
          i1 = a();
          paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_b_of_type_Int);
          if (localVideoListFeedItem != null) {
            break label462;
          }
        }
        for (paramView = "";; paramView = localVideoListFeedItem.feedId)
        {
          StoryReportor.a("story_grp", "clk_one", i1, 0, new String[] { "9", paramString, "", paramView });
          return true;
          paramView = localVideoListFeedItem.feedId;
          break;
          bool2 = false;
          break label279;
          StoryDepends.InviteCode.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext(), new npc(this, bool1, paramStoryVideoItem, paramView, localVideoListFeedItem));
          break label325;
          i1 = 2;
          break label333;
        }
      }
      if (paramString.equals(paramView.getString(2131435132)))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver = new FeedsPlayModeBase.ReportVideoReceiver(this);
          a("", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver);
        }
        PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, new npe(this));
        if (bool1)
        {
          i1 = 1;
          if (localQQUserUIItem != null) {
            break label648;
          }
          paramView = "4";
          StoryReportor.a("play_video", "more_report", i1, 0, new String[] { "", paramView });
          i1 = a();
          paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_b_of_type_Int);
          if (localVideoListFeedItem != null) {
            break label660;
          }
        }
        for (paramView = "";; paramView = localVideoListFeedItem.feedId)
        {
          StoryReportor.a("story_grp", "clk_one", i1, 0, new String[] { "7", paramString, "", paramView });
          return true;
          i1 = 2;
          break;
          paramView = String.valueOf(StoryReportor.a(localQQUserUIItem));
          break label551;
        }
      }
    } while (!paramView.getString(2131434755).equals(paramString));
    label423:
    label429:
    label456:
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    label551:
    if ((paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading()))
    {
      StoryVideoUploadManager.a(paramStoryVideoItem.mVid);
      g();
      label748:
      i1 = a();
      paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_b_of_type_Int);
      if (localVideoListFeedItem != null) {
        break label822;
      }
    }
    label648:
    label660:
    label822:
    for (paramView = "";; paramView = localVideoListFeedItem.feedId)
    {
      StoryReportor.a("story_grp", "clk_one", i1, 0, new String[] { "8", paramString, "", paramView });
      break;
      c(paramStoryVideoItem);
      break label748;
    }
  }
  
  public void b(VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if (paramGetVideoListEvent.jdField_a_of_type_JavaUtilList != null)
    {
      int i1 = 0;
      while (i1 < paramGetVideoListEvent.jdField_a_of_type_JavaUtilList.size())
      {
        this.d.add(((StoryVideoItem)paramGetVideoListEvent.jdField_a_of_type_JavaUtilList.get(i1)).mVid);
        i1 += 1;
      }
    }
    if (paramGetVideoListEvent.jdField_a_of_type_Boolean)
    {
      if (this.d.size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler = new BatchGetVideoInfoHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.d, this.jdField_e_of_type_Int);
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback);
        SLog.d("Q.qqstory.player.NewFriendsPlayMode", "getFirstInfoList : onGetDataSuccess %s", new Object[] { this.j });
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(a(this.j));
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setTipsText(StoryApi.a(2131432108));
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
  }
  
  public void c()
  {
    PlayModeUtils.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.c();
  }
  
  void c(StoryVideoItem paramStoryVideoItem)
  {
    c(1);
    paramStoryVideoItem = new npf(this, paramStoryVideoItem);
    paramStoryVideoItem = DialogUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext(), 230, 2130968855, "确认删除该视频？", null, "取消", "删除", paramStoryVideoItem, paramStoryVideoItem);
    paramStoryVideoItem.setCancelable(false);
    paramStoryVideoItem.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramStoryVideoItem.show();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void e(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      if ((this.jdField_b_of_type_Int != 0) || (!PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(0)))) {
        break label104;
      }
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "trigger getPreviousInfoList, currentIndex=%d, listSize=%d, mIsGettingData=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()), Boolean.valueOf(this.n) });
      if (!this.n)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a();
        this.n = true;
      }
    }
    label104:
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) || (!PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1)))) {
            break;
          }
          SLog.d("Q.qqstory.player.NewFriendsPlayMode", "trigger getNextInfoList, currentIndex=%d, listSize=%d, mIsGettingData=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()), Boolean.valueOf(this.n) });
        } while (this.n);
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.c();
        this.n = true;
        return;
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size();
      } while ((!PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1))) || (this.jdField_b_of_type_Int <= paramInt - 3));
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "trigger getNextInfoList, currentIndex=%d, listSize=%d, mIsGettingData=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt), Boolean.valueOf(this.n) });
    } while (this.n);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.c();
    this.n = true;
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode
 * JD-Core Version:    0.7.0.1
 */