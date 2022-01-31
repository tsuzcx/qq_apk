package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tencent.biz.qqstory.playmode.PlayPanelController;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SingleVideoPlayMode
  extends NewFriendsPlayMode
{
  protected SingleVideoPlayMode.GetVideoBasicInfoListReceiver a;
  protected SingleVideoPlayMode.StoryVideoPublishStatusReceiver a;
  protected List a;
  private boolean g;
  private boolean h;
  
  public SingleVideoPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSingleVideoPlayMode$GetVideoBasicInfoListReceiver = new SingleVideoPlayMode.GetVideoBasicInfoListReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSingleVideoPlayMode$StoryVideoPublishStatusReceiver = new SingleVideoPlayMode.StoryVideoPublishStatusReceiver(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSingleVideoPlayMode$GetVideoBasicInfoListReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSingleVideoPlayMode$StoryVideoPublishStatusReceiver);
    b(1);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
  }
  
  private void w()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = new ArrayList();
      localObject2 = (StoryManager)SuperManager.a(5);
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        StoryVideoItem localStoryVideoItem = ((StoryManager)localObject2).a(str);
        if (localStoryVideoItem != null)
        {
          if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
            localStoryVideoItem.mOwnerUid = this.jdField_b_of_type_JavaLangString;
          }
          ((List)localObject1).add(localStoryVideoItem);
          if (!StoryVideoItem.isFakeVid(str))
          {
            SLog.e("Q.qqstory.player.NewFriendsPlayMode", "SingleVideoPlayMode initialize video query return StoryVideoItem but videoUrl is null!");
            new VidToBasicInfoHandler(this.jdField_a_of_type_JavaUtilList).a();
            if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
              GetFeedFeatureHandler.a(Collections.singletonList(this.jdField_g_of_type_JavaLangString));
            }
          }
        }
        else
        {
          localStoryVideoItem = new StoryVideoItem();
          localStoryVideoItem.mVid = str;
          localStoryVideoItem.mOwnerUid = this.jdField_b_of_type_JavaLangString;
          ((List)localObject1).add(localStoryVideoItem);
          SLog.e("Q.qqstory.player.NewFriendsPlayMode", "SingleVideoPlayMode initialize video query return null!");
          new VidToBasicInfoHandler(this.jdField_a_of_type_JavaUtilList).a();
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a((List)localObject1);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(1);
      }
      this.jdField_a_of_type_Boolean = true;
      this.e = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.e = false;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_b_of_type_Int, false);
      localObject1 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
        break label341;
      }
    }
    label341:
    do
    {
      return;
      localObject2 = a(this.jdField_b_of_type_Int);
    } while (localObject2 == null);
    Object localObject3 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, (VideoPlayerPagerAdapter.VideoViewHolder)localObject1, (VideoListFeedItem)localObject2, (StoryVideoItem)localObject3);
  }
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_JavaUtilList = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    w();
    paramBundle = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!StoryVideoItem.isFakeVid(str)) {
        paramBundle.add(str);
      }
    }
    a(paramBundle);
  }
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    super.a(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
    PlayPanelController.e(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
  }
  
  public void a(View paramView)
  {
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_c_of_type_Int);
    String str = ((StoryVideoItem)localObject).mVid;
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
    if (!PlayModeUtils.a((StoryVideoItem)localObject, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity)) {
      StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[0]);
    }
    for (;;)
    {
      StoryReportor.a("play_video", "clk_pub_fail", 0, 0, new String[] { b() });
      return;
      this.h = true;
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    d(paramVideoViewHolder, paramStoryVideoItem);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public String b()
  {
    switch (this.f)
    {
    default: 
      return "2";
    case 1: 
      return "1";
    case 74: 
      return "2";
    }
    return "3";
  }
  
  public void d(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail())
    {
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371959)).setVisibility(0);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371961)).setVisibility(8);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371960)).setVisibility(0);
      ((TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371962)).setText(2131432077);
      paramVideoViewHolder.d.setVisibility(0);
      paramVideoViewHolder.b.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.h)
      {
        this.h = false;
        StoryReportor.a("play_video", "retrypub_fail", 0, 0, new String[0]);
      }
    }
    do
    {
      return;
      if (!paramStoryVideoItem.isUploading()) {
        break;
      }
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371959)).setVisibility(0);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371961)).setVisibility(0);
      ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371960)).setVisibility(8);
      ((TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371962)).setText("上传中，请稍候");
      paramVideoViewHolder.d.setVisibility(0);
      paramVideoViewHolder.b.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (this.jdField_g_of_type_Boolean);
    StoryReportor.a("play_video", "exp_pub_fail", 0, 0, new String[] { b() });
    this.jdField_g_of_type_Boolean = true;
    return;
    ((View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371959)).setVisibility(8);
    paramVideoViewHolder.d.setVisibility(0);
    paramStoryVideoItem = paramVideoViewHolder.b;
    if (PlayModeUtils.a(this.k)) {}
    for (int i = 0;; i = 8)
    {
      paramStoryVideoItem.setVisibility(i);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!this.h) {
        break;
      }
      this.h = false;
      StoryReportor.a("play_video", "retrypub_suc", 0, 0, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.SingleVideoPlayMode
 * JD-Core Version:    0.7.0.1
 */