package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;

class GameCenterVideoView$VideoViewWrapper$SeekFunction
  implements GameCenterVideoView.FunctionExecutor
{
  private GameCenterVideoView$VideoViewWrapper$SeekFunction(GameCenterVideoView.VideoViewWrapper paramVideoViewWrapper) {}
  
  public void execute(HippyArray paramHippyArray, Promise paramPromise)
  {
    if (GameCenterVideoView.VideoViewWrapper.access$1800(this.this$1)) {
      return;
    }
    this.this$1.seekTo(paramHippyArray.getInt(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.SeekFunction
 * JD-Core Version:    0.7.0.1
 */