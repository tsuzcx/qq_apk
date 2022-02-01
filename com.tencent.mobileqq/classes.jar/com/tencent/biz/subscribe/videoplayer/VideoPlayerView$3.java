package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.FollowChangeListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;

class VideoPlayerView$3
  implements FollowTextView.FollowChangeListener
{
  VideoPlayerView$3(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (VideoPlayerView.a(this.a) != null)
    {
      VSReporter.a(VideoPlayerView.a(this.a).poster.id.get(), "auth_video", "half_follow", 0, 0, new String[] { "", "", VideoPlayerView.a(this.a).id.get(), VideoPlayerView.a(this.a).title.get() });
      VideoPlayerView.a(this.a).poster.followState.set(1);
      VideoPlayerView.a(this.a).put(VideoPlayerView.a(this.a).poster.id.get(), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.3
 * JD-Core Version:    0.7.0.1
 */