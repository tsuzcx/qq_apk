package com.tencent.biz.qqstory.playmode.child;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupSingleStoryShareMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import njw;
import nkb;
import nkc;

public class ShareGroupHotSortPlayMode
  extends NewFriendsPlayMode
{
  protected HashSet a;
  protected ArrayList e;
  
  public ShareGroupHotSortPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 89;
    }
    return this.f;
  }
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    String str = (String)this.e.get(paramInt);
    Object localObject;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.NewFriendsPlayMode", 2, "getVideoListFeedItem: feedid == null");
      }
      localObject = null;
    }
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      do
      {
        return localObject;
        localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(str);
        localObject = localVideoListFeedItem;
      } while (this.jdField_a_of_type_JavaUtilHashSet.contains(str));
      localObject = localVideoListFeedItem;
    } while (TextUtils.isEmpty(str));
    GetFeedFeatureHandler.a(Collections.singletonList(str));
    this.jdField_a_of_type_JavaUtilHashSet.add(str);
    return localVideoListFeedItem;
  }
  
  public void a(Bundle paramBundle)
  {
    this.e = paramBundle.getStringArrayList("extra_feedid_list");
    this.d = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    if (this.d != null)
    {
      localBatchGetVideoInfo = new BatchGetVideoInfo(this.d);
      localBatchGetVideoInfo.a(new njw(this, localBatchGetVideoInfo, paramBundle));
      localBatchGetVideoInfo.b();
    }
    while (!QLog.isColorLevel())
    {
      BatchGetVideoInfo localBatchGetVideoInfo;
      return;
    }
    QLog.i("Q.qqstory.player.NewFriendsPlayMode", 2, "SelectVideosPlayMode - initialize, vidList is Empty.");
    QQToast.a(a(), "SelectVideosPlayMode - initialize, vidList is Empty.", 0).a();
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    int j = 0;
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(this.c);
    boolean bool = PlayModeUtils.a(paramStoryVideoItem);
    int i = j;
    if (paramStoryVideoItem.mStoryType == 2)
    {
      i = j;
      if (localShareGroupItem != null)
      {
        TroopInfo localTroopInfo = ((TroopManager)PlayModeUtils.a().getManager(51)).b(String.valueOf(localShareGroupItem.groupUin));
        String str = PlayModeUtils.a().getCurrentAccountUin();
        if ((localTroopInfo == null) || ((!localTroopInfo.isTroopAdmin(str)) && (!localTroopInfo.isTroopOwner(str)))) {
          break label171;
        }
        i = 1;
      }
    }
    if ((localShareGroupItem != null) && (localShareGroupItem.isPublic())) {
      paramActionSheet.b(2131434719);
    }
    for (;;)
    {
      if ((!bool) || (paramStoryVideoItem.mStoryType == 2)) {
        paramActionSheet.b(2131435099);
      }
      if ((bool) || ((localShareGroupItem != null) && (localShareGroupItem.isOwner())) || (i != 0)) {
        paramActionSheet.b(2131434722);
      }
      return;
      label171:
      i = 0;
      break;
      paramActionSheet.b(2131434541);
    }
  }
  
  protected boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    Resources localResources = paramView.getContext().getApplicationContext().getResources();
    if ((this.b >= 0) && (this.b < this.e.size())) {}
    for (String str = (String)this.e.get(this.b);; str = "")
    {
      if (paramString.equals(localResources.getString(2131434719)))
      {
        paramView = ((ShareGroupManager)SuperManager.a(7)).a(this.c);
        a().a(2131433083).a(ShareGroupSingleStoryShareMode.a(paramView, paramStoryVideoItem, str)).a(new nkb(this, this, paramView)).a();
        StoryReportor.a("share_story", "share_single", 0, 0, new String[] { paramView.getReportUserType() });
        return true;
      }
      if (paramString.equals(localResources.getString(2131435099)))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver = new FeedsPlayModeBase.ReportVideoReceiver(this);
          a("", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver);
        }
        PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, new nkc(this));
        StoryReportor.a("story_grp", "clk_one", a(), 0, new String[] { "7", PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b), "", str });
        return true;
      }
      if (paramString.equals(localResources.getString(2131434722)))
      {
        StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
        if ((paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading()))
        {
          StoryVideoUploadManager.a(paramStoryVideoItem.mVid);
          g();
        }
        for (;;)
        {
          return false;
          c(paramStoryVideoItem);
        }
      }
      return super.a(paramView, paramString, paramStoryVideoItem);
    }
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.ShareGroupHotSortPlayMode
 * JD-Core Version:    0.7.0.1
 */