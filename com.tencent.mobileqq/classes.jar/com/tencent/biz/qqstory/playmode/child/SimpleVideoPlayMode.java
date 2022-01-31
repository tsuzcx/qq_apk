package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;

public class SimpleVideoPlayMode
  extends SingleVideoPlayMode
{
  public SimpleVideoPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    b(0);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    paramVideoViewHolder.b.setVisibility(8);
    paramVideoViewHolder.c.setVisibility(8);
    paramVideoViewHolder.a.setVisibility(8);
    paramVideoViewHolder.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.SimpleVideoPlayMode
 * JD-Core Version:    0.7.0.1
 */