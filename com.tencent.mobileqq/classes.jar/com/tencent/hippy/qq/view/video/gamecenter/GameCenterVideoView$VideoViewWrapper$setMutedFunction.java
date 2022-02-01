package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;

class GameCenterVideoView$VideoViewWrapper$setMutedFunction
  implements GameCenterVideoView.FunctionExecutor
{
  private GameCenterVideoView$VideoViewWrapper$setMutedFunction(GameCenterVideoView.VideoViewWrapper paramVideoViewWrapper) {}
  
  public void execute(HippyArray paramHippyArray, Promise paramPromise)
  {
    if (GameCenterVideoView.VideoViewWrapper.access$1800(this.this$1)) {
      return;
    }
    this.this$1.setMute(paramHippyArray.getBoolean(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.setMutedFunction
 * JD-Core Version:    0.7.0.1
 */