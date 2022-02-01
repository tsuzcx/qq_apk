package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import feedcloud.FeedCloudMeta.StFeedMusic;

class QFSFeedChildPicPresenter$1
  implements ISuperPlayer.OnErrorListener
{
  QFSFeedChildPicPresenter$1(QFSFeedChildPicPresenter paramQFSFeedChildPicPresenter, FeedCloudMeta.StFeedMusic paramStFeedMusic, int paramInt) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QFSFeedChildPicPresenter.a(this.c) != null)
    {
      QFSFeedChildPicPresenter.a(this.c, this.a.MID.get(), this.b);
      QFSFeedChildPicPresenter.a(this.c).getSuperPlayer().setOnErrorListener(null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter.1
 * JD-Core Version:    0.7.0.1
 */