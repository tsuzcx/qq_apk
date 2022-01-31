package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;

public class MyMemorySharePlayMode
  extends CommentPlayMode
{
  public String h;
  public int l;
  
  public MyMemorySharePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.h = paramBundle.getString("extra_collection_key");
    this.l = paramBundle.getInt("extra_share_time_zone", -1);
    b(2);
    this.e = 1;
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 28;
    }
    return this.f;
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.e == 1)
    {
      paramBundle = this.b;
      if (!TextUtils.isEmpty(this.g)) {
        break label59;
      }
    }
    label59:
    for (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = MemorySharePlayingListSync.a(paramBundle, this.jdField_a_of_type_JavaLangString, this.h, this.l);; this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = MemorySharePlayingListSync.b(paramBundle, this.jdField_a_of_type_JavaLangString, this.g, this.j))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
      return;
      paramBundle = this.c;
      break;
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (!PlayModeUtils.b(paramStoryVideoItem))
    {
      super.a(paramVideoViewHolder, paramStoryVideoItem);
      if (PlayModeUtils.a(paramVideoViewHolder, paramStoryVideoItem.mTagInfoBase))
      {
        paramVideoViewHolder = "";
        if (paramStoryVideoItem.mTagInfoBase != null) {
          paramVideoViewHolder = String.valueOf(paramStoryVideoItem.mTagInfoBase.a);
        }
        paramStoryVideoItem = paramStoryVideoItem.mVid;
        StoryReportor.a("video_edit", "exp_tag_play", 1, 0, new String[] { "", paramVideoViewHolder, this.g, paramStoryVideoItem });
      }
      return;
    }
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramVideoViewHolder, paramStoryVideoItem);
    b(paramVideoViewHolder, paramStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MyMemorySharePlayMode
 * JD-Core Version:    0.7.0.1
 */