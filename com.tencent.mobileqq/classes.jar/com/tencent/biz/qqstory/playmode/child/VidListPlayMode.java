package com.tencent.biz.qqstory.playmode.child;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.VideoInfoListEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import nko;
import nkp;
import nkq;
import nks;
import nkt;

public class VidListPlayMode
  extends NewFriendsPlayMode
{
  protected HashSet a;
  protected ConcurrentHashMap a;
  protected IPlayVideoStatusChangeListener b;
  public BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback b;
  protected ArrayList e;
  protected ArrayList f;
  private final String h;
  
  public VidListPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback = new nkq(this);
    this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener = new nkt(this);
    this.jdField_e_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_f_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("extra_feedid_list");
    b(0);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler = new BatchGetVideoInfoHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaUtilArrayList, 1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback);
    a(this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener);
    if (a() == 63) {}
    for (paramStoryVideoPlayer = "1";; paramStoryVideoPlayer = "2")
    {
      this.h = paramStoryVideoPlayer;
      return;
    }
  }
  
  public int a()
  {
    if (this.jdField_f_of_type_Int != 0) {
      return this.jdField_f_of_type_Int;
    }
    return 63;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int > 0) {
      i = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int + paramInt - 1;
    }
    if ((this.jdField_f_of_type_JavaUtilArrayList == null) || (i < 0) || (i >= this.jdField_f_of_type_JavaUtilArrayList.size()))
    {
      if (QLog.isColorLevel())
      {
        if (this.jdField_f_of_type_JavaUtilArrayList == null) {
          break label107;
        }
        if (QLog.isColorLevel()) {
          QLog.e("DiscoverPlayMode", 2, "position < 0 || position >= mFeedIdList.size(), position:" + i + ", mFeedIdList.size():" + this.jdField_f_of_type_JavaUtilArrayList.size());
        }
      }
      for (;;)
      {
        return null;
        label107:
        QLog.e("DiscoverPlayMode", 2, "mFeedIdList is null");
      }
    }
    String str = (String)this.jdField_f_of_type_JavaUtilArrayList.get(i);
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DiscoverPlayMode", 2, "getVideoListFeedItem: feedid == null");
      }
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      return (VideoListFeedItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(str);
    if (localVideoListFeedItem == null) {
      if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) && (!TextUtils.isEmpty(str)))
      {
        GetFeedFeatureHandler.a(Collections.singletonList(str));
        this.jdField_a_of_type_JavaUtilHashSet.add(str);
      }
    }
    for (;;)
    {
      return localVideoListFeedItem;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localVideoListFeedItem);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a(this.jdField_b_of_type_Int);
  }
  
  public void a(BatchGetVideoInfoHandler.VideoInfoListEvent paramVideoInfoListEvent)
  {
    this.m = false;
    if (paramVideoInfoListEvent.c == -100)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = paramVideoInfoListEvent.c;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nko(this));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    int i = 0;
    while (i < paramVideoInfoListEvent.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(localStoryManager.a(((StoryVideoItem)paramVideoInfoListEvent.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid));
      i += 1;
    }
    if (!this.l)
    {
      this.l = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    }
    this.j = paramVideoInfoListEvent.jdField_b_of_type_Boolean;
    this.k = paramVideoInfoListEvent.jdField_a_of_type_Boolean;
    switch (paramVideoInfoListEvent.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nkp(this));
      return;
      this.jdField_b_of_type_Int = paramVideoInfoListEvent.jdField_b_of_type_Int;
      if (!this.k)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(PlayModeUtils.a());
        this.jdField_b_of_type_Int += 1;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      if (!this.j)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(PlayModeUtils.a());
        continue;
        this.jdField_b_of_type_Int += localArrayList.size();
        if (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(0)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(1, localArrayList);
          if (this.k)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.remove(0);
            if (this.jdField_b_of_type_Int > 0) {
              this.jdField_b_of_type_Int -= 1;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(0, localArrayList);
          continue;
          if (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1, localArrayList);
            if (this.j) {
              this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          }
        }
      }
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    paramVideoViewHolder.b.setVisibility(8);
    paramVideoViewHolder.c.setVisibility(8);
    ((View)paramVideoViewHolder.a.get(2131371949)).setVisibility(8);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(paramString1);
    if (i < 0) {
      return;
    }
    if (i == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nks(this, bool));
      return;
    }
  }
  
  @TargetApi(14)
  public boolean a(int paramInt)
  {
    boolean bool = super.a(paramInt);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (bool)
    {
      VidListPlayMode.PlayVideoEvent localPlayVideoEvent = new VidListPlayMode.PlayVideoEvent();
      localPlayVideoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryVideoItem;
      localPlayVideoEvent.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int > 0) {
        localPlayVideoEvent.jdField_a_of_type_Int -= 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DiscoverPlayMode", 2, "startPlayVideo: startIndex " + this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.jdField_a_of_type_Int + " CurrentIndex " + this.jdField_b_of_type_Int + " event.index " + localPlayVideoEvent.jdField_a_of_type_Int + " arg.index " + paramInt);
      }
      Dispatchers.get().dispatch(localPlayVideoEvent);
    }
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public void c()
  {
    b(this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener);
    super.c();
  }
  
  public void t()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.VidListPlayMode
 * JD-Core Version:    0.7.0.1
 */