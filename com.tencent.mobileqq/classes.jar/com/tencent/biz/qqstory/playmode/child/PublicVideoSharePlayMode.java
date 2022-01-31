package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;

public class PublicVideoSharePlayMode
  extends CommentPlayMode
{
  public PublicVideoSharePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
  }
  
  public int a()
  {
    if (this.f != 0) {
      return this.f;
    }
    return 57;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.PublicVideoSharePlayMode
 * JD-Core Version:    0.7.0.1
 */