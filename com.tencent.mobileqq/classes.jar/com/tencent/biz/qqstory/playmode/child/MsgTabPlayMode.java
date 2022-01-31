package com.tencent.biz.qqstory.playmode.child;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.PlayPanelController;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider.MsgTabVideoDataEvent;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider.OnRequestVideoListListener;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.ViewPagerScroller;
import com.tencent.biz.qqstory.playvideo.CustomViewPager;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.ThreeDTransformer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import njs;
import njt;
import nju;

public class MsgTabPlayMode
  extends NewFriendsPlayMode
  implements MsgTabVideoDataProvider.OnRequestVideoListListener
{
  public StoryVideoItem a;
  public MsgTabNodeInfo a;
  public MsgTabVideoDataProvider a;
  private ThreeDTransformer a;
  public HashMap a;
  public List a;
  public Set a;
  public StoryVideoItem b;
  public MsgTabNodeInfo b;
  private ViewPagerScroller jdField_b_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller;
  private ThreeDTransformer jdField_b_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer;
  public HashMap b;
  public Set b;
  public StoryVideoItem c;
  public MsgTabNodeInfo c;
  private ThreeDTransformer c;
  private ThreeDTransformer d;
  public boolean g;
  public boolean h;
  public boolean i;
  public int j;
  public boolean j;
  public int l = 1;
  public int m;
  public int n = 1;
  public int o;
  
  public MsgTabPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_j_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    a(new MsgTabPlayMode.StoryVideoPublishStatusReceiver(this));
    this.f = true;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = PlayModeUtils.a("1");
    this.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = PlayModeUtils.a("2");
    this.jdField_c_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer = new ThreeDTransformer(true, true);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer = new ThreeDTransformer(false, true);
    this.jdField_b_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer = new ThreeDTransformer(true, false);
    this.jdField_d_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer = new ThreeDTransformer(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageTransformer(true, this.jdField_d_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer);
    this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller = new ViewPagerScroller(a());
    this.i = paramBundle.getBoolean("extra_msgtab_from_halo", false);
    paramVideoPlayerPagerAdapter = paramBundle.getString("extra_msgtab_click_node");
    if (!TextUtils.isEmpty(paramVideoPlayerPagerAdapter))
    {
      if (!this.i) {
        break label311;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = ((StoryHaloManager)PlayModeUtils.a().getManager(196)).a(paramVideoPlayerPagerAdapter);
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.e = 1;
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
      }
    }
    else
    {
      return;
    }
    AssertUtils.a("Halo msg node not found! UnionId:%s", new Object[] { paramVideoPlayerPagerAdapter });
    paramStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity.finish();
    return;
    label311:
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = MsgTabStoryUtil.a(((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a().a(), this.jdField_a_of_type_JavaUtilList, paramVideoPlayerPagerAdapter);
  }
  
  private void b(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if ((paramMsgTabNodeInfo != null) && (this.jdField_a_of_type_JavaUtilSet.add(paramMsgTabNodeInfo.a)))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("switch and request ");
        if (!paramBoolean) {
          break label178;
        }
        localObject1 = "Next";
        QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { (String)localObject1 + " node video list. nodeId=", paramMsgTabNodeInfo.a });
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider;
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      if (!paramBoolean) {
        break label186;
      }
    }
    label178:
    label186:
    for (int k = 2;; k = 1)
    {
      ((MsgTabVideoDataProvider)localObject1).a(paramMsgTabNodeInfo, (MsgTabNodeInfo)localObject2, k);
      this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller.a(250);
      this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageTransformer(true, this.jdField_d_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer);
      SLog.b("Q.qqstory.msgTab.MsgTabPlayMode", "setPageTransformer: NO3D | " + this.jdField_b_of_type_Int);
      return;
      localObject1 = "Pre";
      break;
    }
  }
  
  private void c(MsgTabVideoDataProvider.MsgTabVideoDataEvent paramMsgTabVideoDataEvent)
  {
    int i1;
    int k;
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
    if (paramMsgTabVideoDataEvent.jdField_b_of_type_Int == 3)
    {
      i1 = 1;
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handlePlayListFail. index=", Integer.valueOf(k), ", retryType=", Integer.valueOf(i1), ", nodeId=", paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a });
      }
      localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(k);
      if (localVideoViewHolder != null)
      {
        if (paramMsgTabVideoDataEvent.jdField_a_of_type_Boolean) {
          break label253;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handlePlayListFail: not success. nodeId=", paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a });
        }
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        localVideoViewHolder.jdField_a_of_type_Int = paramMsgTabVideoDataEvent.jdField_c_of_type_Int;
        StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new njt(this, paramMsgTabVideoDataEvent, i1, localVideoViewHolder));
      }
    }
    label253:
    while (!paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      return;
      if (paramMsgTabVideoDataEvent.jdField_b_of_type_Int == 4)
      {
        k = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i1 = 2;
        break;
      }
      k = paramMsgTabVideoDataEvent.jdField_a_of_type_Int;
      i1 = 0;
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handlePlayListFail: videoList empty. nodeId=", paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a });
    }
    localVideoViewHolder.jdField_a_of_type_Int = 2;
    localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
    localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setTipsText(StoryApi.a(2131432097));
    localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabPlayMode", 2, "transformProgressbar, pos=" + paramInt);
    }
    int k = paramInt;
    while (k <= paramInt + 1)
    {
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(k);
      if ((localVideoViewHolder != null) && (localVideoViewHolder.jdField_c_of_type_Int < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        SplitedProgressBar localSplitedProgressBar = (SplitedProgressBar)localVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131364810);
        if (((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(localVideoViewHolder.jdField_c_of_type_Int)).mVid.equals(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a())) {
          localSplitedProgressBar.setProgress(Math.min(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b(), 0), localSplitedProgressBar.a() - 1), this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.c());
        }
        localSplitedProgressBar.setVisibility(0);
      }
      k += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.f();
  }
  
  private void x()
  {
    int i1 = Math.min(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabPlayMode", 2, "restoreProgressbar");
    }
    Object localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(i1);
    if (!((StoryVideoItem)localObject).mVid.equals(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a()))
    {
      k = b(i1);
      i1 = a(i1);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(Math.max(k, 1));
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b(Math.min(i1, k - 1), 0L);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(((StoryVideoItem)localObject).mVid);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.e();
    i1 = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.size();
    int k = 0;
    if (k < i1)
    {
      localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localObject == null) {}
      for (;;)
      {
        k += 1;
        break;
        ((View)((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_AndroidUtilSparseArray.get(2131364810)).setVisibility(4);
      }
    }
  }
  
  protected int a(int paramInt)
  {
    int k;
    if ((paramInt == 0) && (!this.g)) {
      k = this.m;
    }
    do
    {
      return k;
      if ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (!this.jdField_a_of_type_Boolean)) {
        return this.o;
      }
      k = paramInt;
    } while (this.g);
    return Math.max(paramInt - 1, 0);
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    String str;
    if ((paramInt == 0) && (!this.g)) {
      str = this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
    }
    while (!TextUtils.isEmpty(str))
    {
      Object localObject = (List)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a.get(str);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      str = ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).mVid;
      localObject = ((List)localObject).iterator();
      MsgTabVideoData localMsgTabVideoData;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localMsgTabVideoData = (MsgTabVideoData)((Iterator)localObject).next();
      } while (!TextUtils.equals(localMsgTabVideoData.b, str));
      return (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(localMsgTabVideoData.a);
      if ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (!this.jdField_a_of_type_Boolean)) {
        str = this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
      } else {
        str = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
      }
    }
    return null;
  }
  
  protected String a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider = new MsgTabVideoDataProvider(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, 0);
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    super.a(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
    PlayPanelController.e(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
    PlayPanelController.g(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
  }
  
  public void a(View paramView)
  {
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_c_of_type_Int);
    switch (paramView.getId())
    {
    default: 
      super.a(paramView);
      return;
    }
    switch (((StoryVideoItem)localObject).mUploadStatus)
    {
    case 4: 
    case 5: 
    default: 
      return;
    }
    if (!PlayModeUtils.a((StoryVideoItem)localObject, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity))
    {
      StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[0]);
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(((StoryVideoItem)localObject).mVid, Boolean.valueOf(true));
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    paramStoryVideoItem = new ReadStoryVideoEvent(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a, paramStoryVideoItem);
    Dispatchers.get().dispatch(paramStoryVideoItem);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a, ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).mVid);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean)
  {
    Object localObject;
    MsgTabNodeInfo localMsgTabNodeInfo;
    if ((paramMsgTabNodeInfo != null) && (this.jdField_a_of_type_JavaUtilSet.add(paramMsgTabNodeInfo.a)))
    {
      if (QLog.isColorLevel())
      {
        if (!paramBoolean) {
          break label97;
        }
        localObject = "next";
        QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "fetch ", localObject, " node video list after current node. nodeId=", paramMsgTabNodeInfo.a });
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider;
      localMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      if (!paramBoolean) {
        break label105;
      }
    }
    label97:
    label105:
    for (int k = 4;; k = 3)
    {
      ((MsgTabVideoDataProvider)localObject).a(paramMsgTabNodeInfo, localMsgTabNodeInfo, k);
      return;
      localObject = "previous";
      break;
    }
  }
  
  public void a(MsgTabVideoDataProvider.MsgTabVideoDataEvent paramMsgTabVideoDataEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handlePlayList event type=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_b_of_type_Int), ", playIndex=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_a_of_type_Int) });
    }
    this.jdField_a_of_type_JavaUtilSet.remove(paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.equals(paramMsgTabVideoDataEvent.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    Object localObject3;
    if ((paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList != null) && (!paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject2 = paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject2).next();
        if (!StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
          ((List)localObject1).add(((StoryVideoItem)localObject3).mVid);
        }
      }
    }
    a((List)localObject1);
    if ((!paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.isEmpty()) && (!this.jdField_b_of_type_JavaUtilSet.containsAll(paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList)))
    {
      int i1;
      for (int k = 0; k < paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.size(); k = i1 + 1)
      {
        i1 = k;
        if (!this.jdField_b_of_type_JavaUtilSet.add(paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.get(k)))
        {
          paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.remove(k);
          i1 = k - 1;
        }
      }
      if (!paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.isEmpty()) {
        GetFeedFeatureHandler.a(paramMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList);
      }
    }
    if ((paramMsgTabVideoDataEvent.jdField_b_of_type_Int == 0) || (paramMsgTabVideoDataEvent.jdField_b_of_type_Int == 2) || (paramMsgTabVideoDataEvent.jdField_b_of_type_Int == 1))
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.equals(paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo))
      {
        a(paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a);
        if (!this.jdField_h_of_type_Boolean) {
          this.jdField_h_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
      this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
      if (this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo == null)
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        if (this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null) {
          break label908;
        }
        bool1 = true;
        label437:
        this.g = bool1;
        if (QLog.isColorLevel())
        {
          localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
          bool1 = this.g;
          if (this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null) {
            break label914;
          }
          localObject1 = "null";
          label476:
          bool2 = this.jdField_a_of_type_Boolean;
          if (this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null) {
            break label926;
          }
          localObject2 = "null";
          label494:
          QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "request node video list back. current nodeId=", localObject3, ", isPreviousEnd=", String.valueOf(bool1), ", previous nodeId=", localObject1, ", isVideoListEnd=", String.valueOf(bool2), ", next nodeId=", localObject2 });
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.clear();
        if (!this.g)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          paramMsgTabVideoDataEvent.jdField_a_of_type_Int += 1;
        }
        if ((paramMsgTabVideoDataEvent.jdField_a_of_type_Boolean) && (!paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty())) {
          break label938;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "request video list error. request type=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_b_of_type_Int) });
          if (this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
            this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = PlayModeUtils.a();
          }
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        }
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        }
        this.jdField_j_of_type_Int = Math.max(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.size(), 1);
        this.l = 1;
        this.n = 1;
        this.m = 0;
        this.o = 0;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(this.jdField_j_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handle current node video list. size=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.size()) });
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "current node play index=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_a_of_type_Int) });
        }
        this.jdField_b_of_type_Int = paramMsgTabVideoDataEvent.jdField_a_of_type_Int;
        this.e = true;
        if (QLog.isColorLevel()) {
          QLog.d("wyx", 2, "before current notifyDataSetChanged");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidOsHandler.post(new njs(this, paramMsgTabVideoDataEvent));
        return;
        bool1 = false;
        break;
        label908:
        bool1 = false;
        break label437;
        label914:
        localObject1 = this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
        break label476;
        label926:
        localObject2 = this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a;
        break label494;
        label938:
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList);
      }
    }
    if (paramMsgTabVideoDataEvent.jdField_b_of_type_Int == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handle next node video list. nodeId=", this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a, ", video size=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.size()) });
      }
      this.n = Math.max(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.size(), 1);
      this.o = paramMsgTabVideoDataEvent.jdField_a_of_type_Int;
      if (!paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject1 = (StoryVideoItem)paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.get(paramMsgTabVideoDataEvent.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.set(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1, localObject1);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_b_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          break label1196;
        }
        label1130:
        this.e = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("wyx", 2, "before next notifyDataSetChanged");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      }
    }
    label1196:
    do
    {
      do
      {
        this.e = false;
        if ((paramMsgTabVideoDataEvent.jdField_a_of_type_Boolean) && ((paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList == null) || (!paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty()))) {
          break;
        }
        c(paramMsgTabVideoDataEvent);
        return;
        bool1 = false;
        break label1130;
      } while (paramMsgTabVideoDataEvent.jdField_b_of_type_Int != 3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabPlayMode", 2, new Object[] { "handle previous node video list. nodeId=", this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a, ", video size=", Integer.valueOf(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.size()) });
      }
      this.l = Math.max(paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.size(), 1);
      this.m = paramMsgTabVideoDataEvent.jdField_a_of_type_Int;
    } while (paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty());
    localObject1 = (StoryVideoItem)paramMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.get(paramMsgTabVideoDataEvent.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.set(0, localObject1);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_b_of_type_Int == 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.e = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("wyx", 2, "before previous notifyDataSetChanged");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      break;
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    int k = 0;
    if (PlayModeUtils.b(paramStoryVideoItem))
    {
      paramVideoViewHolder.d.setVisibility(8);
      paramVideoViewHolder.b.setVisibility(8);
      b(paramVideoViewHolder, paramStoryVideoItem);
      d(paramVideoViewHolder, paramStoryVideoItem);
      paramStoryVideoItem = (SplitedProgressBar)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131364810);
      int i1 = b(paramVideoViewHolder.jdField_c_of_type_Int);
      int i2 = a(paramVideoViewHolder.jdField_c_of_type_Int);
      paramStoryVideoItem.setTotalCount(Math.max(i1, 1));
      paramStoryVideoItem.setProgress(Math.min(Math.max(i2, 0), i1 - 1), 0);
      if (!this.jdField_j_of_type_Boolean) {
        break label123;
      }
    }
    for (;;)
    {
      paramStoryVideoItem.setVisibility(k);
      return;
      super.a(paramVideoViewHolder, paramStoryVideoItem);
      break;
      label123:
      k = 4;
    }
  }
  
  public void a(String paramString)
  {
    MsgTabPlayMode.PlayModeSwitchNodeEvent localPlayModeSwitchNodeEvent = new MsgTabPlayMode.PlayModeSwitchNodeEvent();
    localPlayModeSwitchNodeEvent.a = paramString;
    Dispatchers.get().dispatch(localPlayModeSwitchNodeEvent);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a(paramString1, paramString2, paramString3);
    int k = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(paramString1);
    if (k < 0) {
      return;
    }
    if (k == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nju(this, bool, paramString3, paramString2));
      return;
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 0) && (paramInt2 == 1) && (!this.g)) || ((paramInt1 == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 2) && (paramInt2 == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (!this.jdField_a_of_type_Boolean));
  }
  
  protected int b(int paramInt)
  {
    if ((paramInt == 0) && (!this.g)) {
      return this.l;
    }
    if ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (!this.jdField_a_of_type_Boolean)) {
      return this.n;
    }
    return Math.max(this.jdField_j_of_type_Int, 1);
  }
  
  public void b(MsgTabVideoDataProvider.MsgTabVideoDataEvent paramMsgTabVideoDataEvent)
  {
    a(paramMsgTabVideoDataEvent);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a();
    }
    super.c();
  }
  
  public void d(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail())
    {
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372132)).setVisibility(0);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372134)).setVisibility(8);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372133)).setVisibility(0);
      ((TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372135)).setText(2131432094);
      paramVideoViewHolder.d.setVisibility(0);
      paramVideoViewHolder.b.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (Boolean.TRUE.equals(this.jdField_b_of_type_JavaUtilHashMap.get(paramStoryVideoItem.mVid)))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, Boolean.valueOf(false));
        StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[0]);
      }
    }
    do
    {
      return;
      if (!paramStoryVideoItem.isUploading()) {
        break;
      }
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372132)).setVisibility(0);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372134)).setVisibility(0);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372133)).setVisibility(8);
      ((TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372135)).setText("上传中，请稍候");
      paramVideoViewHolder.d.setVisibility(0);
      paramVideoViewHolder.b.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (Boolean.TRUE.equals(this.jdField_a_of_type_JavaUtilHashMap.get(paramStoryVideoItem.mVid)));
    this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, Boolean.valueOf(true));
    return;
    ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372132)).setVisibility(8);
    paramVideoViewHolder.d.setVisibility(0);
    LinearLayout localLinearLayout = paramVideoViewHolder.b;
    if (PlayModeUtils.a(this.k)) {}
    for (int k = 0;; k = 8)
    {
      localLinearLayout.setVisibility(k);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!Boolean.TRUE.equals(this.jdField_b_of_type_JavaUtilHashMap.get(paramStoryVideoItem.mVid))) {
        break;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, Boolean.valueOf(false));
      StoryReportor.a("play_video", "retrypub_suc", 0, 0, new String[0]);
      return;
    }
  }
  
  public boolean d()
  {
    return !this.g;
  }
  
  public void e(int paramInt)
  {
    Object localObject;
    label160:
    int k;
    if (paramInt == this.jdField_b_of_type_Int)
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (((paramInt == 0) && (!this.g)) || ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (!this.jdField_a_of_type_Boolean)))
      {
        localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localObject != null) {
          ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
        }
        if ((this.jdField_h_of_type_Int == 0) || (this.jdField_h_of_type_Int == -1))
        {
          if ((paramInt != 0) || (this.g)) {
            break label310;
          }
          localObject = this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
          b((MsgTabNodeInfo)localObject, true);
        }
      }
      if ((PlayModeUtils.b(localStoryVideoItem)) || (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid))) {
        break label319;
      }
      if (this.jdField_d_of_type_Int != 1) {
        c(1);
      }
      if (!localStoryVideoItem.mVid.equals(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a()))
      {
        k = b(paramInt);
        int i1 = a(paramInt);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(Math.max(k, 1));
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b(Math.min(i1, k - 1), 0L);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(localStoryVideoItem.mVid);
      }
      k = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 2;
      if ((paramInt != 1) || (paramInt != k) || (this.g) || (this.jdField_a_of_type_Boolean)) {
        break label334;
      }
      this.jdField_c_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageTransformer(true, this.jdField_c_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer);
      SLog.b("Q.qqstory.msgTab.MsgTabPlayMode", "setPageTransformer: Both 3D");
    }
    label310:
    label319:
    label334:
    do
    {
      return;
      localObject = this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      break;
      if (this.jdField_d_of_type_Int == 0) {
        break label160;
      }
      c(0);
      break label160;
      if ((paramInt == k) && (!this.jdField_a_of_type_Boolean) && ((this.g) || (paramInt != 1)))
      {
        this.jdField_c_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageTransformer(true, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer);
        SLog.b("Q.qqstory.msgTab.MsgTabPlayMode", "setPageTransformer: Right 3D");
        return;
      }
      if ((paramInt == 1) && (!this.g) && ((this.jdField_a_of_type_Boolean) || (paramInt != k)))
      {
        this.jdField_c_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageTransformer(true, this.jdField_b_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer);
        SLog.b("Q.qqstory.msgTab.MsgTabPlayMode", "setPageTransformer: Left 3D");
        return;
      }
    } while (((paramInt == 0) && (!this.g)) || ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (!this.jdField_a_of_type_Boolean)));
    this.jdField_c_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageTransformer(true, this.jdField_d_of_type_ComTencentBizQqstoryVideoplayerThreeDTransformer);
    SLog.b("Q.qqstory.msgTab.MsgTabPlayMode", "setPageTransformer: No 3D");
  }
  
  public boolean e()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void f()
  {
    w();
  }
  
  public void g()
  {
    w();
    super.g();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!this.jdField_j_of_type_Boolean);
    this.jdField_j_of_type_Boolean = false;
    x();
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (!this.jdField_j_of_type_Boolean) {
      if ((paramInt1 == 0) && (paramFloat != 0.0F) && (!this.g))
      {
        this.jdField_j_of_type_Boolean = true;
        f(0);
      }
    }
    while (((paramInt1 == 0) && (!this.g)) || ((paramInt1 >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 2) && (!this.jdField_a_of_type_Boolean)))
    {
      do
      {
        return;
      } while ((paramInt1 != this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 2) || (paramFloat == 0.0F) || (this.jdField_a_of_type_Boolean));
      this.jdField_j_of_type_Boolean = true;
      f(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 2);
      return;
    }
    this.jdField_j_of_type_Boolean = false;
    x();
  }
  
  public void q()
  {
    if ((this.jdField_b_of_type_Int == 0) && (!this.g)) {
      b(this.jdField_c_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, false);
    }
    while ((this.jdField_b_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    b(this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, true);
  }
  
  public void w()
  {
    MsgTabStoryManager localMsgTabStoryManager;
    StoryPlayVideoActivity localStoryPlayVideoActivity;
    if ((MsgTabStoryUtil.a()) && (this.jdField_h_of_type_Boolean))
    {
      localMsgTabStoryManager = (MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
      localStoryPlayVideoActivity = (StoryPlayVideoActivity)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity;
      if (localMsgTabStoryManager.jdField_a_of_type_Int != 0) {
        break label83;
      }
      k = localStoryPlayVideoActivity.g;
      localStoryPlayVideoActivity.g = k;
      if (localMsgTabStoryManager.jdField_b_of_type_Int != 0) {
        break label91;
      }
    }
    label83:
    label91:
    for (int k = localStoryPlayVideoActivity.jdField_h_of_type_Int;; k = localMsgTabStoryManager.jdField_b_of_type_Int)
    {
      localStoryPlayVideoActivity.jdField_h_of_type_Int = k;
      localMsgTabStoryManager.jdField_a_of_type_Int = 0;
      localMsgTabStoryManager.jdField_b_of_type_Int = 0;
      return;
      k = localMsgTabStoryManager.jdField_a_of_type_Int;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode
 * JD-Core Version:    0.7.0.1
 */