package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.troop.model.TroopStorySingleVideoSynchronizer;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.ArrayList;
import nlx;

public class TroopStorySinglePlayMode
  extends TroopStoryPlayModeBase
{
  public int j;
  
  public TroopStorySinglePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.j = paramBundle.getInt("extra_play_video_from", 1004);
    b(1);
  }
  
  public int a()
  {
    return this.j;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("extra_video_id");
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new TroopStorySingleVideoSynchronizer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
  }
  
  public void b(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (paramPlayerVideoListEvent.a != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(paramPlayerVideoListEvent.a);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(paramPlayerVideoListEvent.a);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nlx(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TroopStorySinglePlayMode
 * JD-Core Version:    0.7.0.1
 */