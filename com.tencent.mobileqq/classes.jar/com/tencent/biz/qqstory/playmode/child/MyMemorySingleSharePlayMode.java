package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;

public class MyMemorySingleSharePlayMode
  extends CommentPlayMode
{
  public MyMemorySingleSharePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 30;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MyMemorySingleSharePlayMode
 * JD-Core Version:    0.7.0.1
 */