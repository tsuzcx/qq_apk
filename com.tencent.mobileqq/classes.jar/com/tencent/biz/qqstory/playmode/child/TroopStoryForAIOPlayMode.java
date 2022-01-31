package com.tencent.biz.qqstory.playmode.child;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.troop.model.TroopStorySingleVideoSynchronizer;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import nkj;
import nkk;

public class TroopStoryForAIOPlayMode
  extends TroopStoryPlayModeBase
{
  GetStoryPlayerTagInfoHandler a;
  protected TroopStoryForAIOPlayMode.StoryVideoTagUpdateReceiver a;
  boolean g = false;
  String h;
  public int j = -1;
  
  public TroopStoryForAIOPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildTroopStoryForAIOPlayMode$StoryVideoTagUpdateReceiver = new TroopStoryForAIOPlayMode.StoryVideoTagUpdateReceiver(this);
    a(new nkk(this));
    b(1);
  }
  
  public int a()
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.b);
    if (localStoryVideoItem == null) {
      return 0;
    }
    if (a(localStoryVideoItem)) {
      return 1003;
    }
    return 1007;
  }
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_h_of_type_JavaLangString = paramBundle.getString("extra_vid");
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(1);
    long l = paramBundle.getLong("extra_msg_seq");
    ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207)).a(this.jdField_h_of_type_JavaLangString, l);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new TroopStorySingleVideoSynchronizer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
    this.jdField_a_of_type_Boolean = true;
    if (!StoryVideoItem.isFakeVid(this.jdField_h_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryPlayerTagInfoHandler = new GetStoryPlayerTagInfoHandler();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryPlayerTagInfoHandler.a(Arrays.asList(new String[] { this.jdField_h_of_type_JavaLangString }));
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.b);
    if (localObject == null) {
      return;
    }
    localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).c);
    switch (paramView.getId())
    {
    default: 
      super.a(paramView);
      return;
    }
    StoryTagUtil.a(paramView.getContext(), ((StoryVideoItem)localObject).mTagInfoBase);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    if (PlayModeUtils.a(paramVideoViewHolder, paramStoryVideoItem.mTagInfoBase))
    {
      paramVideoViewHolder = "";
      if (paramStoryVideoItem.mTagInfoBase != null) {
        paramVideoViewHolder = String.valueOf(paramStoryVideoItem.mTagInfoBase.a);
      }
      StoryReportor.a("video_edit", "exp_tag_play", 1, 0, new String[] { "", paramVideoViewHolder, "", paramStoryVideoItem.mVid });
    }
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    if (a(paramStoryVideoItem))
    {
      paramActionSheet.b(2131435854);
      paramActionSheet.b(2131437366);
      paramActionSheet.b(2131435878);
      paramActionSheet.b(2131435858);
      paramActionSheet.b(2131435865);
    }
    do
    {
      return;
      paramActionSheet.b(2131435854);
      paramActionSheet.b(2131435878);
    } while (PlayModeUtils.a(paramStoryVideoItem));
    paramActionSheet.b(2131435099);
  }
  
  protected boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    Object localObject1 = paramView.getContext();
    Object localObject3 = ((Context)localObject1).getApplicationContext().getResources();
    Object localObject2 = TroopStoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStoryVideoItem.mVid);
    if ((localObject2 instanceof MessageForShortVideo))
    {
      localObject2 = (MessageForShortVideo)localObject2;
      if (paramString.equals(((Resources)localObject3).getString(2131435854)))
      {
        StoryReportor.a("story_grp", "clk_one", a(), 0, new String[] { "1", PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b), "", "" });
        paramView = AIOImageProviderService.a((MessageForShortVideo)localObject2);
        if (paramView != null)
        {
          paramView.putExtra("NeedReportForwardShortVideo", true);
          ForwardBaseOption.a((Context)localObject1, paramView);
        }
      }
    }
    for (;;)
    {
      return false;
      if (paramString.equals(((Resources)localObject3).getString(2131435858)))
      {
        StoryReportor.a("story_grp", "clk_one", a(), 0, new String[] { "5", PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b), "", "" });
        paramView = AIOImageProviderService.a((MessageForShortVideo)localObject2);
        if (paramView != null)
        {
          QfavBuilder.a(paramView).a((Activity)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        }
      }
      else if (paramString.equals(((Resources)localObject3).getString(2131435865)))
      {
        paramView = TroopStoryUtil.a(paramStoryVideoItem.mVid);
        paramString = new Bundle();
        paramString.putString("extra.GROUP_UIN", paramView);
        paramStoryVideoItem = ((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningAppProcesses().iterator();
        while (paramStoryVideoItem.hasNext())
        {
          localObject3 = (ActivityManager.RunningAppProcessInfo)paramStoryVideoItem.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith("mobileqq")) {
            paramString.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject3).pid);
          }
        }
        paramString.putInt("forward_source_uin_type", 1);
        paramString.putString("uin", paramView);
        PeakUtils.b((Context)localObject1, paramString, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramView, 1, (ChatMessage)localObject2), AIOGalleryUtils.a((MessageForShortVideo)localObject2), -1);
        StoryReportor.a("story_grp", "clk_one", a(), 0, new String[] { "4", PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b), "", "" });
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity.finish();
      }
      else
      {
        super.a(paramView, paramString, paramStoryVideoItem);
        continue;
        if ((localObject2 instanceof MessageForTroopStory))
        {
          localObject1 = (MessageForTroopStory)localObject2;
          if (paramString.equals(((Resources)localObject3).getString(2131435854)))
          {
            StoryReportor.a("story_grp", "clk_one", a(), 0, new String[] { "1", PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b), "", "" });
            if (QLog.isColorLevel()) {
              QLog.w("Q.qqstory.troopstory.share", 2, "start forward from player");
            }
            paramView = new Bundle();
            TroopStoryUtil.a((MessageForTroopStory)localObject1, paramView);
            paramString = new Intent();
            paramString.putExtras(paramView);
            ForwardBaseOption.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramString, 21);
          }
          else
          {
            super.a(paramView, paramString, paramStoryVideoItem);
          }
        }
        else
        {
          super.a(paramView, paramString, paramStoryVideoItem);
        }
      }
    }
  }
  
  public boolean a(StoryVideoItem paramStoryVideoItem)
  {
    return TroopStoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStoryVideoItem.mVid) instanceof MessageForShortVideo;
  }
  
  public void b(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    boolean bool = true;
    int i;
    int k;
    if (paramPlayerVideoListEvent.a != null)
    {
      int m = this.b;
      ArrayList localArrayList;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (PlayModeUtils.b((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(0))))
      {
        i = 1;
        localArrayList = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList;
        if (i == 0) {
          break label149;
        }
      }
      label149:
      for (k = 1;; k = 0)
      {
        localArrayList.addAll(k, paramPlayerVideoListEvent.a);
        if (this.g) {
          break label449;
        }
        this.b = -1;
        k = 0;
        while (k < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (TextUtils.equals(((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(k)).mVid, this.jdField_h_of_type_JavaLangString)) {
            this.b = k;
          }
          k += 1;
        }
        i = 0;
        break;
      }
      if (this.b != -1) {
        break label441;
      }
      if (!paramPlayerVideoListEvent.jdField_b_of_type_Boolean) {
        break label414;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FeedsPlayModeBase", 2, "can't find enter vid");
      }
      this.b = (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      if (!paramPlayerVideoListEvent.jdField_b_of_type_Boolean) {
        break label470;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.remove(0);
        this.b -= 1;
        if (this.b < 0) {
          this.b = 0;
        }
      }
      label246:
      if (QLog.isColorLevel()) {
        QLog.d("FeedsPlayModeBase", 2, "onData updateSize=" + paramPlayerVideoListEvent.a.size() + ", totalSize=" + this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() + ", end=" + paramPlayerVideoListEvent.jdField_b_of_type_Boolean + ", oldIndex=" + m + ", currentIndex=" + this.b);
      }
      if (paramPlayerVideoListEvent.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.b(paramPlayerVideoListEvent.jdField_b_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
      if ((i == 0) || (m != 0)) {
        break label501;
      }
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nkj(this));
      return;
      label414:
      if (i != 0) {}
      for (k = 0;; k = -1)
      {
        this.b = k;
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a(0);
        break;
      }
      label441:
      this.g = true;
      break;
      label449:
      this.b += paramPlayerVideoListEvent.a.size();
      break;
      label470:
      if (i != 0) {
        break label246;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.add(0, PlayModeUtils.a());
      this.b += 1;
      break label246;
      label501:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TroopStoryForAIOPlayMode
 * JD-Core Version:    0.7.0.1
 */