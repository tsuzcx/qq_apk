package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.FollowChangeListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class VideoPlayerView$16
  implements FollowTextView.FollowChangeListener
{
  VideoPlayerView$16(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    VSReporter.a(VideoPlayerView.a(this.a).poster.id.get(), "auth_video", "finish_follow", 0, 0, new String[] { "", "", VideoPlayerView.a(this.a).id.get(), VideoPlayerView.a(this.a).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.16
 * JD-Core Version:    0.7.0.1
 */