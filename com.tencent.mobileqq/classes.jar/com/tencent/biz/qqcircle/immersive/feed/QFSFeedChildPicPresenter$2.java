package com.tencent.biz.qqcircle.immersive.feed;

import android.os.Bundle;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic.SongInfo;

class QFSFeedChildPicPresenter$2
  implements Call.OnRspCallBack<QCircleBaseRequest>
{
  QFSFeedChildPicPresenter$2(QFSFeedChildPicPresenter paramQFSFeedChildPicPresenter, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, Bundle paramBundle)
  {
    if (QFSFeedChildPicPresenter.a(this.b) != null)
    {
      if (!(paramObject instanceof QQCircleSmartMatchMusic.MusicInfoRsp)) {
        return;
      }
      paramString = (QQCircleSmartMatchMusic.MusicInfoRsp)paramObject;
      if (paramString.musicListInfo.isEmpty())
      {
        QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[requestMusicInfo] musicListInfo is null");
        return;
      }
      paramString = (QQCircleSmartMatchMusic.MusicInfo)paramString.musicListInfo.get().get(0);
      if (paramString.songInfo == null)
      {
        QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[requestMusicInfo] songInfo is null");
        return;
      }
      paramString = (QQCircleSmartMatchMusic.SongInfo)paramString.songInfo.get();
      QFSFeedChildPicPresenter.a(this.b).setVideoPath(null, paramString.PlayUrl.get(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter.2
 * JD-Core Version:    0.7.0.1
 */