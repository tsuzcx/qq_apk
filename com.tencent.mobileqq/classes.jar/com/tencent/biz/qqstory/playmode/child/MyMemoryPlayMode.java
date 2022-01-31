package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.util.MemoryVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider.DataObserver;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import noi;
import noj;

public class MyMemoryPlayMode
  extends NewFriendsPlayMode
  implements MultiGroupVideoDataProvider.DataObserver
{
  public UserManager a;
  protected MyMemoryPlayMode.GetVideoBasicListReceiver a;
  protected MultiGroupVideoDataProvider a;
  protected HashSet a;
  public ConcurrentHashMap b;
  public int k;
  
  public MyMemoryPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMyMemoryPlayMode$GetVideoBasicListReceiver = new MyMemoryPlayMode.GetVideoBasicListReceiver(this);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMyMemoryPlayMode$GetVideoBasicListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
  }
  
  public int a()
  {
    if (this.k == 7) {
      return 47;
    }
    if (this.k == 6) {
      return 46;
    }
    if (this.k == 4) {
      return 48;
    }
    if (this.k == 5) {
      return 51;
    }
    if (this.k == 2) {
      return 52;
    }
    if (this.k == 8) {
      return 53;
    }
    if (this.k == 1) {
      return 27;
    }
    return 65;
  }
  
  protected int a(int paramInt)
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    return ((MyMemoryPlayMode.VideoIndexInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localStoryVideoItem.mVid)).jdField_b_of_type_Int;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    String str = a(paramInt);
    Object localObject;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MyMemoryPlayMode", 2, "getVideoListFeedItem: feedid == null");
      }
      localObject = null;
    }
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      do
      {
        do
        {
          return localObject;
          localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(str);
          localObject = localVideoListFeedItem;
        } while (!b(paramInt));
        localObject = localVideoListFeedItem;
      } while (this.jdField_a_of_type_JavaUtilHashSet.contains(str));
      localObject = localVideoListFeedItem;
    } while (TextUtils.isEmpty(str));
    GetFeedFeatureHandler.a(Collections.singletonList(str));
    this.jdField_a_of_type_JavaUtilHashSet.add(str);
    return localVideoListFeedItem;
  }
  
  protected String a(int paramInt)
  {
    Object localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    localObject = (MyMemoryPlayMode.VideoIndexInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(((StoryVideoItem)localObject).mVid);
    if (localObject == null) {
      return "";
    }
    return ((MyMemoryPlayMode.VideoIndexInfo)localObject).jdField_a_of_type_JavaLangString;
  }
  
  public void a(Bundle paramBundle)
  {
    ArrayList localArrayList1 = paramBundle.getStringArrayList("extra_collection_key_list");
    int i = paramBundle.getInt("extra_collection_key_index", 0);
    ArrayList localArrayList2 = paramBundle.getStringArrayList("extra_feedid_list");
    this.k = paramBundle.getInt("extra_memory_from", 1);
    boolean bool = paramBundle.getBoolean("extra_memory_key_list_is_end", true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider = new MemoryVideoDataProvider(this.jdField_b_of_type_JavaLangString, localArrayList1, localArrayList2, i, this.jdField_b_of_type_Int, bool);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a();
  }
  
  public void a(VideoData paramVideoData)
  {
    if (paramVideoData == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MyMemoryPlayMode", 2, "onDataEvent: videoData null.");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MyMemoryPlayMode", 2, "onDataEvent:" + paramVideoData.toString());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      if (paramVideoData.jdField_b_of_type_Int != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MyMemoryPlayMode", 2, "event.errorInfo.isFail()");
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() > 0)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        if (paramVideoData.jdField_b_of_type_Int == 880001)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MyMemoryPlayMode", 2, "event.errorInfo.isFail(): ERROR_NO_NETWORK");
          }
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
          StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = 880001;
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new noi(this));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("MyMemoryPlayMode", 2, "event.errorInfo.isFail(): errorCode:" + paramVideoData.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = paramVideoData.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        return;
      }
      if (!paramVideoData.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MyMemoryPlayMode", 2, "videoData.mVideoList.isEmpty()");
    return;
    int i = 0;
    Object localObject1;
    Object localObject2;
    while (i < paramVideoData.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (StoryVideoItem)paramVideoData.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = new MyMemoryPlayMode.VideoIndexInfo();
      ((MyMemoryPlayMode.VideoIndexInfo)localObject2).jdField_b_of_type_Int = i;
      ((MyMemoryPlayMode.VideoIndexInfo)localObject2).jdField_a_of_type_Int = paramVideoData.jdField_a_of_type_JavaUtilList.size();
      ((MyMemoryPlayMode.VideoIndexInfo)localObject2).jdField_a_of_type_JavaLangString = paramVideoData.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((StoryVideoItem)localObject1).mVid, localObject2);
      i += 1;
    }
    switch (paramVideoData.jdField_a_of_type_Int)
    {
    default: 
      label460:
      if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())
      {
        if (QLog.isColorLevel()) {
          QLog.e("MyMemoryPlayMode", 2, "mCurrentIndex >= mAdapter.mStoryVideoItemList.size(), mCurrentIndex:" + this.jdField_b_of_type_Int + ", mAdapter.mStoryVideoItemList.size():" + this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() + ", getVideoSource():" + a() + ", videoData.mType:" + paramVideoData.jdField_a_of_type_Int);
        }
        this.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(b(this.jdField_b_of_type_Int));
      this.e = true;
      i = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new noj(this, i));
      if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.isEmpty()) {
        break;
      }
      paramVideoData = new ArrayList();
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
        if (!StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {
          paramVideoData.add(((StoryVideoItem)localObject2).mVid);
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(paramVideoData.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_Int = paramVideoData.d;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.e())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.add(0, PlayModeUtils.a());
        this.jdField_b_of_type_Int += 1;
      }
      localObject1 = new MyMemoryPlayMode.VideoIndexInfo();
      ((MyMemoryPlayMode.VideoIndexInfo)localObject1).jdField_b_of_type_Int = 0;
      ((MyMemoryPlayMode.VideoIndexInfo)localObject1).jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(PlayModeUtils.a().mVid, localObject1);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.d())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.add(PlayModeUtils.a());
        break label460;
      }
      this.jdField_a_of_type_Boolean = true;
      break label460;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1, paramVideoData.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.d()) {
        break label460;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.remove(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1);
      this.jdField_a_of_type_Boolean = true;
      break label460;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(1, paramVideoData.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_Int += paramVideoData.jdField_a_of_type_JavaUtilList.size();
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.e()) {
        break label460;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.remove(0);
      this.jdField_b_of_type_Int -= 1;
      break label460;
      if (this.jdField_b_of_type_Int < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MyMemoryPlayMode", 2, "mCurrentIndex < 0, getVideoSource():" + a());
        }
        this.jdField_b_of_type_Int = 0;
      }
    }
    a(paramVideoData);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    int i = 8;
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    if (b(paramVideoViewHolder.jdField_c_of_type_Int))
    {
      paramStoryVideoItem = paramVideoViewHolder.b;
      if (PlayModeUtils.a(this.l)) {
        i = 0;
      }
      paramStoryVideoItem.setVisibility(i);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    paramVideoViewHolder.b.setVisibility(8);
    paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.isEmpty()) {}
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(paramString1);
    } while (i < 0);
    if (i == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size()) {}
    int m;
    for (int i = 1;; i = 0)
    {
      paramString1 = (MyMemoryPlayMode.VideoIndexInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      m = this.jdField_b_of_type_Int - paramString1.jdField_b_of_type_Int;
      if (m >= 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      return;
    }
    int n = Math.min(paramString1.jdField_a_of_type_Int + m - 1, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size());
    int j = 0;
    while (m < n)
    {
      paramString1 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(m);
      paramString1 = (MyMemoryPlayMode.VideoIndexInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1.mVid);
      paramString1.jdField_b_of_type_Int = j;
      paramString1.jdField_a_of_type_Int -= 1;
      m += 1;
      j += 1;
    }
    this.e = true;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
    this.e = false;
    if (i != 0)
    {
      g();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(b(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_b_of_type_Int, false);
  }
  
  protected int b(int paramInt)
  {
    Object localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    localObject = (MyMemoryPlayMode.VideoIndexInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(((StoryVideoItem)localObject).mVid);
    if (((MyMemoryPlayMode.VideoIndexInfo)localObject).jdField_a_of_type_Int > 0) {
      return ((MyMemoryPlayMode.VideoIndexInfo)localObject).jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public boolean b(int paramInt)
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    if (localStoryVideoItem.mStoryType == 1)
    {
      QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_b_of_type_JavaLangString);
      if ((localQQUserUIItem != null) && (!localQQUserUIItem.isFriend()) && (!localQQUserUIItem.isMe())) {
        return (localStoryVideoItem.mBanType == 1000) || (localQQUserUIItem.isVip());
      }
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a();
    }
    super.c();
  }
  
  public void e(int paramInt)
  {
    StoryVideoItem localStoryVideoItem;
    if (paramInt == this.jdField_b_of_type_Int)
    {
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
      if ((paramInt != 0) || (!this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.e())) {
        break label94;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(b(paramInt));
      if (!PlayModeUtils.b(localStoryVideoItem)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.d();
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b(a(paramInt), 0L);
      return;
      label94:
      if ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.d())) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.b();
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b(a(paramInt), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MyMemoryPlayMode
 * JD-Core Version:    0.7.0.1
 */