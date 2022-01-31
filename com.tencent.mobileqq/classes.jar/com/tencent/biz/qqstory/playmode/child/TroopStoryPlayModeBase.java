package com.tencent.biz.qqstory.playmode.child;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import nlv;
import nlw;

public abstract class TroopStoryPlayModeBase
  extends FeedsPlayModeBase
{
  protected FeedsPlayModeBase.ReportVideoReceiver a;
  protected QQUIEventReceiver a;
  protected QQUIEventReceiver b;
  public boolean h;
  protected String i;
  
  public TroopStoryPlayModeBase(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_ComTribeAsyncDispatchQQUIEventReceiver = new TroopStoryPlayModeBase.DownloadStatusUpdateReceiver(this);
    this.jdField_b_of_type_ComTribeAsyncDispatchQQUIEventReceiver = new FeedsPlayModeBase.TroopNickNameUpdateEventReceiver(this);
    a(this.jdField_a_of_type_ComTribeAsyncDispatchQQUIEventReceiver);
    a(this.jdField_b_of_type_ComTribeAsyncDispatchQQUIEventReceiver);
    this.i = paramBundle.getString("extra_troop_uin");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001)
    {
      if (paramInt2 == -1) {
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, 2131437360, 0).a();
      }
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    int j = 8;
    if (!PlayModeUtils.b(paramStoryVideoItem))
    {
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      super.a(paramVideoViewHolder, paramStoryVideoItem);
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramVideoViewHolder, paramStoryVideoItem, this.i);
      if (b(paramVideoViewHolder.jdField_c_of_type_Int))
      {
        PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramVideoViewHolder, a(paramVideoViewHolder.jdField_c_of_type_Int), paramStoryVideoItem);
        paramStoryVideoItem = paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (PlayModeUtils.a(this.k)) {
          j = 0;
        }
        paramStoryVideoItem.setVisibility(j);
        paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramVideoViewHolder, paramStoryVideoItem);
    super.b(paramVideoViewHolder, paramStoryVideoItem);
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = PlayModeUtils.a(paramStoryVideoItem);
    paramActionSheet.b(2131434558);
    if (!bool) {
      paramActionSheet.b(2131435116);
    }
  }
  
  protected boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    Context localContext = paramView.getContext();
    Resources localResources = localContext.getApplicationContext().getResources();
    boolean bool = PlayModeUtils.a(paramStoryVideoItem);
    paramView = a(this.jdField_b_of_type_Int);
    int j;
    if (paramString.equals(localResources.getString(2131437383)))
    {
      paramString = new File(paramStoryVideoItem.mLocalVideoPath);
      if (paramString.exists())
      {
        paramStoryVideoItem = QZoneHelper.UserInfo.a();
        paramStoryVideoItem.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        QZoneHelper.b((Activity)localContext, paramStoryVideoItem, paramString.getAbsolutePath(), 10001);
        ReportController.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
      }
      j = a();
      paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_b_of_type_Int);
      if (paramView == null)
      {
        paramView = "";
        StoryReportor.a("story_grp", "clk_one", j, 0, new String[] { "2", paramString, "", paramView });
      }
    }
    label236:
    do
    {
      for (;;)
      {
        return false;
        paramView = paramView.feedId;
        break;
        if ((!paramString.equals(localResources.getString(2131435895))) && (!paramString.equals(localResources.getString(2131434558)))) {
          break label236;
        }
        ThreadManager.post(new nlv(this, paramStoryVideoItem, paramStoryVideoItem, paramView, bool), 5, null, false);
      }
    } while (!paramString.equals(localResources.getString(2131435116)));
    paramString = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((paramString != null) && (paramString.isVip))
    {
      j = 1;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver = new FeedsPlayModeBase.ReportVideoReceiver(this);
        a("", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver);
      }
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramStoryVideoItem, new nlw(this));
      if (j == 0) {
        break label417;
      }
      j = 1;
      label335:
      StoryReportor.a("play_video", "more_report", j, 0, new String[0]);
      j = a();
      paramString = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_b_of_type_Int);
      if (paramView != null) {
        break label423;
      }
    }
    label417:
    label423:
    for (paramView = "";; paramView = paramView.feedId)
    {
      StoryReportor.a("story_grp", "clk_one", j, 0, new String[] { "7", paramString, "", paramView });
      return true;
      j = 0;
      break;
      j = 2;
      break label335;
    }
  }
  
  public boolean b()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TroopStoryPlayModeBase
 * JD-Core Version:    0.7.0.1
 */