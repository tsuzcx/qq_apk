package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;

class GameCenterVideoView$VideoViewWrapper$1
  implements ISuperPlayer.OnInfoListener
{
  GameCenterVideoView$VideoViewWrapper$1(GameCenterVideoView.VideoViewWrapper paramVideoViewWrapper, ISuperPlayer paramISuperPlayer) {}
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if ((paramInt == 107) && (GameCenterVideoView.access$404(this.this$1.this$0) >= GameCenterVideoView.access$2100(this.this$1.this$0)) && (GameCenterVideoView.access$2100(this.this$1.this$0) > 1)) {
      this.val$player.setLoopback(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */