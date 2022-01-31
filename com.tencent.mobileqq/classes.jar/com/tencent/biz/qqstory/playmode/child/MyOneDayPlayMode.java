package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;

public class MyOneDayPlayMode
  extends CommentPlayMode
{
  protected String h;
  protected int l;
  
  public MyOneDayPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.h = paramBundle.getString("extra_share_time");
    this.l = paramBundle.getInt("extra_share_time_zone");
    b(2);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 18;
    }
    return this.f;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new MyVideoSharePlayingListSync(this.jdField_a_of_type_JavaLangString, this.b, this.h, this.l);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MyOneDayPlayMode
 * JD-Core Version:    0.7.0.1
 */