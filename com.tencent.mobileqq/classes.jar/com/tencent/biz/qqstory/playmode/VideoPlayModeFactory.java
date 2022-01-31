package com.tencent.biz.qqstory.playmode;

import android.os.Bundle;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.playmode.child.CommentPlayMode;
import com.tencent.biz.qqstory.playmode.child.DiscoverPlayMode;
import com.tencent.biz.qqstory.playmode.child.HotRecommendPlayMode;
import com.tencent.biz.qqstory.playmode.child.MemorySelectVideosPlayMode;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode;
import com.tencent.biz.qqstory.playmode.child.MyMemoryPlayMode;
import com.tencent.biz.qqstory.playmode.child.MyMemorySharePlayMode;
import com.tencent.biz.qqstory.playmode.child.MyMemorySingleSharePlayMode;
import com.tencent.biz.qqstory.playmode.child.MyOneDayPlayMode;
import com.tencent.biz.qqstory.playmode.child.MySingleSharePlayMode;
import com.tencent.biz.qqstory.playmode.child.MyVideoFromMessageNotifyPlayMode;
import com.tencent.biz.qqstory.playmode.child.NewDiscoverBannerPlayMode;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.playmode.child.OutSingleSharePlayMode;
import com.tencent.biz.qqstory.playmode.child.PublicVideoSharePlayMode;
import com.tencent.biz.qqstory.playmode.child.QimMemoryPlayModeDelegate;
import com.tencent.biz.qqstory.playmode.child.SelectVideosPlayMode;
import com.tencent.biz.qqstory.playmode.child.ShareGroupHotSortPlayMode;
import com.tencent.biz.qqstory.playmode.child.ShareGroupMultiSharePlayMode;
import com.tencent.biz.qqstory.playmode.child.ShareGroupSingleSharePlayMode;
import com.tencent.biz.qqstory.playmode.child.SimpleVideoPlayMode;
import com.tencent.biz.qqstory.playmode.child.SingleVideoPlayMode;
import com.tencent.biz.qqstory.playmode.child.TagStoryPlayMode;
import com.tencent.biz.qqstory.playmode.child.TagStoryVidListPlayMode;
import com.tencent.biz.qqstory.playmode.child.TroopProfileVideoPlayMode;
import com.tencent.biz.qqstory.playmode.child.TroopStoryForAIOPlayMode;
import com.tencent.biz.qqstory.playmode.child.TroopStorySinglePlayMode;
import com.tencent.biz.qqstory.playmode.child.VidListPlayMode;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;

public class VideoPlayModeFactory
{
  public static VideoPlayModeBase a(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 14: 
    case 17: 
    case 19: 
    case 20: 
    case 22: 
    case 24: 
    case 25: 
    case 30: 
    case 31: 
    case 39: 
    case 40: 
    case 42: 
    case 43: 
    case 50: 
    default: 
      return new NewFriendsPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 2: 
      return new SingleVideoPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 5: 
      return new CommentPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 12: 
      return new OutSingleSharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 11: 
      return new MySingleSharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 13: 
      return new MyOneDayPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 15: 
    case 33: 
      return new MyMemorySharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 16: 
      return new MyMemorySingleSharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 18: 
      return new MyVideoFromMessageNotifyPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 21: 
      return new MyMemoryPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 27: 
      return (VideoPlayModeBase)StoryApi.a(QimMemoryPlayModeDelegate.class, new Object[] { Integer.valueOf(paramInt), paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle });
    case 23: 
      return new TroopStoryForAIOPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 26: 
      return new TroopStorySinglePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 28: 
      return new VidListPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 29: 
      return new PublicVideoSharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 32: 
      return new NewFriendsPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 34: 
      return new DiscoverPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 35: 
      return new ShareGroupSingleSharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 36: 
      return new ShareGroupMultiSharePlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 37: 
      return new SelectVideosPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 38: 
      return new MemorySelectVideosPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 41: 
      return new NewDiscoverBannerPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 44: 
      return new ShareGroupHotSortPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 45: 
      return new TroopProfileVideoPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 46: 
      return new MsgTabPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 47: 
      return new TagStoryPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 48: 
      return new TagStoryVidListPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    case 49: 
      return new SimpleVideoPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    }
    return new HotRecommendPlayMode(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeFactory
 * JD-Core Version:    0.7.0.1
 */