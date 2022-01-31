package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class MySingleSharePlayMode
  extends CommentPlayMode
{
  public MySingleSharePlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.a.a.setVisibility(8);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 17;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MySingleSharePlayMode
 * JD-Core Version:    0.7.0.1
 */