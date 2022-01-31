package com.tencent.biz.qqstory.playmode.child;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.ShareGroupVideoDataProvider;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import nqc;

public class TroopProfileVideoPlayMode
  extends MyMemoryPlayMode
{
  protected ArrayList e;
  
  public TroopProfileVideoPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 88;
    }
    return this.f;
  }
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("extra_collection_key_index", 0);
    this.e = paramBundle.getStringArrayList("extra_feedid_list");
    this.k = paramBundle.getInt("extra_memory_from", 1);
    boolean bool = paramBundle.getBoolean("extra_memory_key_list_is_end", true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider = new ShareGroupVideoDataProvider(this.c, 2, this.e, i, this.b, bool);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a();
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = PlayModeUtils.a(paramStoryVideoItem);
    paramActionSheet.b(2131434574);
    if (!bool) {
      paramActionSheet.b(2131435132);
    }
    int i;
    if (paramStoryVideoItem.mStoryType == 2)
    {
      paramStoryVideoItem = ((ShareGroupManager)SuperManager.a(7)).a(this.c);
      paramStoryVideoItem = ((TroopManager)PlayModeUtils.a().getManager(51)).b(String.valueOf(paramStoryVideoItem.groupUin));
      String str = PlayModeUtils.a().getCurrentAccountUin();
      if ((paramStoryVideoItem != null) && ((paramStoryVideoItem.isTroopAdmin(str)) || (paramStoryVideoItem.isTroopOwner(str)))) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((bool) || (i != 0)) {
        paramActionSheet.b(2131434755);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  protected boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    Resources localResources = paramView.getContext().getApplicationContext().getResources();
    String str = a(this.b);
    if (paramString.equals(localResources.getString(2131435132)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver = new FeedsPlayModeBase.ReportVideoReceiver(this);
        a("", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$ReportVideoReceiver);
      }
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramStoryVideoItem, new nqc(this));
      StoryReportor.a("story_grp", "clk_one", a(), 0, new String[] { "7", PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.b), "", str });
      return true;
    }
    if (paramString.equals(localResources.getString(2131434755)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TroopProfileVideoPlayMode
 * JD-Core Version:    0.7.0.1
 */